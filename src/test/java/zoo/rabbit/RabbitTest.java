package zoo.rabbit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zoo.rabbit.events.RabbitEventProducer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

	@InjectMocks
	@Autowired
	private Rabbit service;

	@Mock
	RabbitEventProducer eventProducer;

	@Test
	@Ignore
	public void eatFood_shouldEmitTwoMessages() {
		service.eatFood(1);

		verify(eventProducer, times(2)).emitBehaviour("some behaviour");
	}
//
//	@Test
//	@Ignore("animalObservations...")
//	public void shouldBeBusyEatingOnNewFood() {
//		service.eatFood(100);
//		Assert.assertThat(service.state(), equalTo("some food, yummy"));
//	}
//
//	@Test
//	public void shouldFinishEatingEventually() {
//		service.eatFood(0);
//		Assert.assertThat(service.state(), equalTo("finished eating"));
//	}
}
