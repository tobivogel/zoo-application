package zoo.turtle;

import org.springframework.stereotype.Service;
import zoo.turtle.events.TurtleEventProducer;

@Service
public class Turtle {

	private static final int TURTLE_EATING_SPEED = 3;

	private TurtleEventProducer turtleEventProducer;

	public Turtle(TurtleEventProducer turtleEventProducer) {
		this.turtleEventProducer = turtleEventProducer;
	}

	public void eatFood(int foodSize) {
		try {
			turtleEventProducer.emitBehaviour("eating");
			Thread.sleep(foodSize * TURTLE_EATING_SPEED);
			turtleEventProducer.emitBehaviour("snoozing");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
