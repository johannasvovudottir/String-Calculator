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
			if(text.startsWith("//"))
			{
				String del = Character.toString(text.charAt(2));
				String[] numbers = text.substring(4, text.length()).split(del);
				return sum(numbers);
			}
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

    private static int sum(String[] numbers) throws Exception 
    {
 	    int total = 0;
        for(String number : numbers)
        {
        	if(Integer.parseInt(number) < 0)
        	{
        		throw new Exception("Negatives not allowed: " + negativeNumbers(numbers));
        	}
        	if(Integer.parseInt(number) <= 1000)
		    	total += toInt(number);
		}
		return total;
    }

	private static String[] splitNumbers(String numbers)
	{
	    return numbers.split(",|\n");
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
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