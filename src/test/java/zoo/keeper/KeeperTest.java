package zoo.keeper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zoo.keeper.events.AnimalBehaviour;

import java.util.Collection;

import static java.util.Collections.emptySet;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeeperTest {

	@Autowired
	private Keeper service;

	@Test
	public void shouldNotHaveAnyAnimalObservationsOnStartup() {
		Assert.assertThat(service.getAnimalBehaviours(), is(emptyCollectionOf(AnimalBehaviour.class)));
	}
}
