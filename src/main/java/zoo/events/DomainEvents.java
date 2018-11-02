package zoo.events;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

@Configuration
public class DomainEvents {

	public static final String FEED_ANIMALS_EVENT = "feed-animals";
	@Bean(name = FEED_ANIMALS_EVENT)
	public Destination feedAnimalsQueue() {
		return new ActiveMQQueue(FEED_ANIMALS_EVENT);
	}

	public static final String ANIMAL_OBSERVATION_EVENT = "animal-observation";
	@Bean(name = ANIMAL_OBSERVATION_EVENT)
	public Destination getAnimalObservationQueue() {
		return new ActiveMQQueue(ANIMAL_OBSERVATION_EVENT);
	}
}
