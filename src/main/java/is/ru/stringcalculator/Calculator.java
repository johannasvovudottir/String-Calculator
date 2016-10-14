package is.ru.stringcalculator;

public class Calculator 
{

	public static int add(String text) throws Exception
	{

		if(text.equals(""))
		{
			return 0;
		}
		else if(text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers) throws Exception 
    {
 	    int total = 0;
        for(String number : numbers){
        	int numberInt = Integer.parseInt(number);
        	if(numberInt < 0)
        	{
        		throw new Exception("Negatives not allowed: " + negativeNumbers(numbers));
        	}
        	if(numberInt <= 1000)
		    	total += toInt(number);
		}
		return total;
    }
    private static String negativeNumbers(String[] numbers)
    {
    	String negs = new String();
    	for(String number : numbers)
    	{
    		int numberInt = Integer.parseInt(number);
			if(numberInt < 0)
    			negs += number + ", ";
    	}
		return negs.substring(0, negs.length()-2);
    }
}