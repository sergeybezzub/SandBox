import java.util.Scanner;


public class TheTimeInWords {

	private static final String MINUTES = " minutes";
	private static final String MINUTE = " minute";
	private static final String TO = " to ";
	private static final String PAST = " past ";

	private static String[] numbersFrom1To20 = { "midnight", "one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen", "twenty" };	
	private static String[] timeNames = {"o' clock", "quarter","half past"};
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		in.close();

		if (h == 0) {
			System.out.println(numbersFrom1To20[h]);
		} else if (m == 0) {
			System.out.println(numbersFrom1To20[h] + " " + timeNames[0]);
		} else if (m == 1) {
			System.out.println(numbersFrom1To20[m] + MINUTE + PAST
					+ numbersFrom1To20[h]);
		} else if (m == 30) {
			System.out.println(timeNames[2] + " " + numbersFrom1To20[h]);
		} else if (m == 15) {
			System.out.println(timeNames[1] + PAST + numbersFrom1To20[h]);
		} else if (m == 45) {
			if (h != 12) {
				System.out.println(timeNames[1] + TO + numbersFrom1To20[h + 1]);
			} else {
				System.out.println(timeNames[1] + TO + numbersFrom1To20[1]);
			}
		} else if (m < 21) {
			System.out.println(numbersFrom1To20[m] + MINUTES + PAST
					+ numbersFrom1To20[h]);
		} else if (m > 20 && m < 30) {
			System.out.println(numbersFrom1To20[20]+" "+numbersFrom1To20[m-20] + MINUTES + PAST
					+ numbersFrom1To20[h]);
		} else {
			m=60-m;
			if(h == 12)
			{
				h=0;
			}
			
			if (m < 21) {
				System.out.println(numbersFrom1To20[m] + MINUTES + TO
						+ numbersFrom1To20[h+1]);
			} else
				System.out.println(numbersFrom1To20[20]+" "+numbersFrom1To20[m-20] + MINUTES + TO
						+ numbersFrom1To20[h+1]);
			}		
	}

}
