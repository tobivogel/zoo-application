package zoo.keeper.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoo.keeper.Keeper;
import zoo.keeper.events.AnimalBehaviour;

import javax.jms.Destination;
import javax.jms.MapMessage;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static zoo.events.DomainEvents.FEED_ANIMALS_EVENT;

@RestController
public class KeeperController {

	@Autowired
	private Keeper keeper;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier(FEED_ANIMALS_EVENT)
	private Destination feedAnimalDestination;

	@RequestMapping(path = "/animal-observations", method = GET)
	public String animalObservations() {
		return join(", ", keeper.getAnimalBehaviours().stream()
				.map(AnimalBehaviour::toString)
				.collect(Collectors.toSet()));
	}

	@RequestMapping(path = "/feed-animals", method = POST)
	public void feedAnimals() {
		sendFeedAnimalEvent();
		sendFeedAnimalEvent();
	}

	private void sendFeedAnimalEvent() {
		jmsTemplate.send(feedAnimalDestination, s -> {
			MapMessage mapMessage = s.createMapMessage();
			mapMessage.setString("food-size", "10");
			return mapMessage;
		});
	}
}
