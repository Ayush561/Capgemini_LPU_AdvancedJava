package TestStepsToImplementMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import StepsToImplementMockito.Calculator;
import StepsToImplementMockito.MathService;



public class testMathService {
	
	@Test
	public void testDoubleAddition() {
		//Step 1:create Fake Object
		Calculator calmock=mock(Calculator.class);
		
		//Step 2: what mock object should return
		when(calmock.add(5,5)).thenReturn(20);  //In the add method of Calculator we returned -1 as the value but here we can check for any value just to know it is working fine
		
		//Step 3: Inject the fake object reference
		MathService service = new MathService(calmock);
		int res=service.doubleAddition(5, 5);  //Our implementation is totally different, so implementation doesn't matter in Fake object
		
		assertEquals(20, res);
		
		
	}

}
