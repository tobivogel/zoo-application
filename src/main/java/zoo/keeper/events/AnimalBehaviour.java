package zoo.keeper.events;

import java.time.Instant;

import static java.lang.String.format;

public class AnimalBehaviour {
	private String animal;
	private Instant createdAt;
	private String observedBehaviour;

	public AnimalBehaviour(String animal, Instant createdAt, String observedBehaviour) {
		this.animal = animal;
		this.createdAt = createdAt;
		this.observedBehaviour = observedBehaviour;
	}

	public String animal() {
		return animal;
	}

	public Instant createdAt() {
		return createdAt;
	}

	public String observedBehaviour() {
		return observedBehaviour;
	}

	@Override
	public String toString() {
		return format("%s: Looks like %s is %s", createdAt(), animal(), observedBehaviour());
	}
}
