package zoo.rabbit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import zoo.rabbit.events.RabbitEventProducer;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class RabbitTest {

	@InjectMocks
	private Rabbit service;

	@Mock
	private RabbitEventProducer eventProducer;

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
