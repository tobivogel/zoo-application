package zoo.turtle.events;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import zoo.turtle.Turtle;

import java.util.Map;

import static java.lang.Integer.parseInt;
import static zoo.events.DomainEvents.FEED_ANIMALS_EVENT;

@Component
public class TurtleEventConsumer {

	private Turtle turtle;

	public TurtleEventConsumer(Turtle turtle) {
		this.turtle = turtle;
	}

	@JmsListener(destination = FEED_ANIMALS_EVENT)
	public void feedAnimal(Map<String, String> message) {
		turtle.eatFood(parseInt(message.get("food-size")));
	}
}
