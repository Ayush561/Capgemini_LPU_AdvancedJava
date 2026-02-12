package Test_Uploading_Data_Through_CsvFileIn_Test_Resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import Uploading_Data_Through_CsvFileIn_Test_Resources.EvenOrOdd;

public class Test_Even_Or_Odd {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/testdata.csv",numLinesToSkip = 1)
	public void testEvenOrOdd(String input,String expectedRes) {
		EvenOrOdd eo = new EvenOrOdd();
		String actualRes=eo.evenOrOdd(Integer.parseInt(input));
		
		assertEquals(expectedRes,actualRes);
		
	}

}
