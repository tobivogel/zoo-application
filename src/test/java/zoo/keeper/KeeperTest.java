package zoo.keeper;

import org.junit.Before;
import org.junit.Test;
import zoo.keeper.events.AnimalBehaviour;

import java.time.Instant;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class KeeperTest {

	private Keeper service;

	@Before
	public void setUp() {
		this.service = new Keeper();
	}

	@Test
	public void shouldNotHaveAnyAnimalObservationsOnStartup() {
		assertThat(service.getAnimalBehaviours(), is(emptyCollectionOf(AnimalBehaviour.class)));
	}

	@Test
	// The business layer should be completely stateless,
	// the persistence of data should be pushed out into a Repository layer
	public void shouldRememberAnimalObservations() {
		AnimalBehaviour behaviour = new AnimalBehaviour("lion", Instant.now(), "sleeping");
		service.rememberAnimalObservation(behaviour);

		assertThat(service.getAnimalBehaviours(), contains(behaviour));
	}
}
