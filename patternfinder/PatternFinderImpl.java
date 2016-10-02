package patternfinder;


public class PatternFinderImpl implements PatternFinder
{

	@Override
	public int countPattern(int[] numbers, int... pattern)
	{
		int count = 0;
		int patternNumber = 0;
		for (int i = 0; i < pattern.length; i++)
		{
			patternNumber = patternNumber * 10 + pattern[i]; 
		}
		for (int number : numbers)
		{
			if (number == patternNumber || findPatternNumber(number, patternNumber))
			{
				count++;
			}
		}
		return count;
	}
	
	private boolean findPatternNumber(int number, int patternNumber)
	{
		int numberTail = 0;
		while (number != 0)
		{
			int lastDigit = number % 10;
			int aNumber = number / 10;
			if (numberTail == patternNumber || aNumber == patternNumber || lastDigit == patternNumber)
			{
				return true;
			} else
			{
				numberTail = (aNumber % 10) * 10 + lastDigit;
			}
			number = number / 10;
		}
		return false;
	}

}
