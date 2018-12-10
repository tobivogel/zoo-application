package zoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ZooIT {

	@LocalServerPort
	private int port;

	private URL getAnimalObservations;

	private URL postFeedAnimals;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.getAnimalObservations = new URL("http://localhost:" + port + "/animal-observations");
		this.postFeedAnimals = new URL("http://localhost:" + port + "/feed-animals");
	}

	@Test
	public void keeperFeedingAnimalsAndObserving() throws InterruptedException {
		ResponseEntity<String> response = template.getForEntity(getAnimalObservations.toString(), String.class);
		assertThat(response.getBody(), isEmptyOrNullString());

		template.postForLocation(postFeedAnimals.toString(), null);

		// Call twice to simulate a bit of delay.
		// Testing async workflows is not the simplest thing
		response = template.getForEntity(getAnimalObservations.toString(), String.class);
		response = template.getForEntity(getAnimalObservations.toString(), String.class);
		assertThat(response.getBody(), containsString("Looks like Rabbit is snoozing"));
		assertThat(response.getBody(), containsString("Looks like Turtle is snoozing"));
	}
}
