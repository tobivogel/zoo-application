package zoo.rabbit.events;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import zoo.rabbit.Rabbit;

import java.util.Map;

import static java.lang.Integer.parseInt;
import static zoo.events.DomainEvents.FEED_ANIMALS_EVENT;

@Component
public class RabbitEventConsumer {

	private Rabbit rabbit;

	public RabbitEventConsumer(Rabbit rabbit) {
		this.rabbit = rabbit;
	}

	@JmsListener(destination = FEED_ANIMALS_EVENT)
	public void feedAnimal(Map<String, String> message) {
		rabbit.eatFood(parseInt(message.get("food-size")));
	}
}
