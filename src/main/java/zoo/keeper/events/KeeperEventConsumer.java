package zoo.keeper.events;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import zoo.keeper.Keeper;

import java.time.Instant;
import java.util.Map;

import static zoo.events.DomainEvents.ANIMAL_OBSERVATION_EVENT;

@Component
public class KeeperEventConsumer {

	private Keeper keeper;

	public KeeperEventConsumer(Keeper keeper) {
		this.keeper = keeper;
	}

	@JmsListener(destination = ANIMAL_OBSERVATION_EVENT)
	public void animalObservation(Map<String, String> message) {
		keeper.rememberAnimalObservation(
				new AnimalBehaviour(message.get("animal"), Instant.parse(message.get("created-at")), message.get("observed-behaviour")));
	}
}
