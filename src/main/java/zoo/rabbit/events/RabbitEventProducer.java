package zoo.rabbit.events;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.MapMessage;
import java.time.Clock;

import static zoo.events.DomainEvents.ANIMAL_OBSERVATION_EVENT;

@Component
public class RabbitEventProducer {

	public static final String RABBIT_IDENTIFIER = "Rabbit";

	private JmsTemplate jmsTemplate;

	private Clock clock;

	private Destination animalObservationDestination;

	public RabbitEventProducer(JmsTemplate jmsTemplate, Clock clock, @Qualifier(ANIMAL_OBSERVATION_EVENT) Destination animalObservationDestination) {
		this.jmsTemplate = jmsTemplate;
		this.clock = clock;
		this.animalObservationDestination = animalObservationDestination;
	}

	public void emitBehaviour(String behaviour) {
		jmsTemplate.send(animalObservationDestination, s -> {
			MapMessage msg = s.createMapMessage();
			msg.setString("animal", RABBIT_IDENTIFIER);
			msg.setString("created-at", clock.instant().toString());
			msg.setString("observed-behaviour", behaviour);
			return msg;
		});
	}
}
