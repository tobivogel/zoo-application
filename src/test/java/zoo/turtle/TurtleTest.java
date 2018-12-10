package zoo.turtle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import zoo.turtle.events.TurtleEventProducer;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class TurtleTest {

	@InjectMocks
	private Turtle service;

	@Mock
	private TurtleEventProducer eventProducer;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void eatFood_shouldEmitTwoMessages() {
		service.eatFood(0);

		verify(eventProducer, times(2)).emitBehaviour(anyString());
	}
}
