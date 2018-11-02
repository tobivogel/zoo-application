package zoo.keeper;

import org.springframework.stereotype.Service;
import zoo.keeper.events.AnimalBehaviour;

import java.util.*;

@Service
public class Keeper {

	private Map<String, AnimalBehaviour> animalBehaviours = new HashMap<>();

	public Collection<AnimalBehaviour> getAnimalBehaviours() {
		return animalBehaviours.values();
	}

	public void rememberAnimalObservation(AnimalBehaviour behaviour) {
		animalBehaviours.put(behaviour.animal(), behaviour);
	}
}
