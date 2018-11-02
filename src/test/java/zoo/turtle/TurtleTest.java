package zoo.turtle;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TurtleTest {

	@Autowired
	private Turtle service;

	@Test
	@Ignore("animalObservations...")
	public void shouldGetInitialState() {
//		Assert.assertSame(service.state(), "snoozing");
	}
//
//	@Test
//	@Ignore("animalObservations...")
//	public void shouldBeBusyEatingOnNewFood() {
//		service.eatFood(10);
//		Assert.assertThat(service.state(), equalTo("some food, yummy"));
//	}
//
//	@Test
//	public void shouldFinishEatingEventually() {
//		service.eatFood(0);
//		Assert.assertThat(service.state(), equalTo("finished eating"));
//	}
}
