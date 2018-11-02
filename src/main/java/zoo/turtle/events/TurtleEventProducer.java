package zoo.turtle.events;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.MapMessage;
import java.time.Clock;

import static zoo.events.DomainEvents.ANIMAL_OBSERVATION_EVENT;

@Component
public class TurtleEventProducer {

	public static final String TURTLE_INDENTIFIER = "Turtle";

	private JmsTemplate jmsTemplate;

	private Clock clock;

	private Destination animalObservationDestination;

	public TurtleEventProducer(JmsTemplate jmsTemplate, Clock clock, @Qualifier(ANIMAL_OBSERVATION_EVENT) Destination animalObservationDestination) {
		this.jmsTemplate = jmsTemplate;
		this.clock = clock;
		this.animalObservationDestination = animalObservationDestination;
	}

	public void emitBehaviour(String behaviour) {
		jmsTemplate.send(animalObservationDestination, s -> {
			MapMessage msg = s.createMapMessage();
			msg.setString("animal", TURTLE_INDENTIFIER);
			msg.setString("created-at", clock.instant().toString());
			msg.setString("observed-behaviour", behaviour);
			return msg;
		});
	}
}
