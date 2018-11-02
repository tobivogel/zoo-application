package zoo.rabbit;

import org.springframework.stereotype.Service;
import zoo.rabbit.events.RabbitEventProducer;

@Service
public class Rabbit {

	private static final int RABBIT_EATING_SPEED = 1;

	private RabbitEventProducer rabbitEventProducer;

	public Rabbit(RabbitEventProducer rabbitEventProducer) {
		this.rabbitEventProducer = rabbitEventProducer;
	}

	public void eatFood(int foodSize) {
		try {
			rabbitEventProducer.emitBehaviour("eating");
			Thread.sleep(foodSize * RABBIT_EATING_SPEED);
			rabbitEventProducer.emitBehaviour("snoozing");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
