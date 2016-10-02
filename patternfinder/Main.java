package patternfinder;

import java.util.Arrays;

public class Main
{
	public static void dumpPatternCount(PatternFinder patternFinder)
	{
		int[] numbers = new int[]{1234, 3412, 4123};
		System.out.println(Arrays.toString(numbers));
		System.out.println("Pattern: 12");
		int count = patternFinder.countPattern(numbers, 1,2);
		System.out.println("Pattern found " + count + " times.");
	}

	public static void main(String[] args)
	{
		PatternFinder patternFinder = new PatternFinderImpl();
		Main.dumpPatternCount(patternFinder);
	}

}
