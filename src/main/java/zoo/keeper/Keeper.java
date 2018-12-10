package zoo.keeper;

import org.springframework.stereotype.Service;
import zoo.keeper.events.AnimalBehaviour;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class Keeper {

	// The business layer should be completely stateless,
	// the persistence of data should be pushed out into a Repository layer
	private Map<String, AnimalBehaviour> animalBehaviours = new HashMap<>();

	public Collection<AnimalBehaviour> getAnimalBehaviours() {
		return animalBehaviours.values();
	}

	public void rememberAnimalObservation(AnimalBehaviour behaviour) {
		animalBehaviours.put(behaviour.animal(), behaviour);
	}
}
