package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) 
	{
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() throws Exception 
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() throws Exception
	{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() throws Exception
	{
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() throws Exception
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testManyMultipleNumbers() throws Exception
	{
		assertEquals(21, Calculator.add("1,2,3,4,5,6"));
	}

	@Test
	public void testNewLine() throws Exception
	{
		assertEquals(15, Calculator.add("1,2,3,4\n5"));
	}

	@Test
	public void testNegatives() throws Exception
	{
		try
		{
			assertEquals(0, Calculator.add("1,-2"));
		}
		catch (Exception e) 
		{
			assertEquals("Negatives not allowed: -2", e.getMessage());
		}
	}

	@Test
	public void testBigNumbers() throws Exception
	{
		assertEquals(15, Calculator.add("1,2,3,4\n5,1002"));

	}

	@Test
	public void testDelimiter() throws Exception
	{
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
}