package hackerrank;
import java.util.Scanner;


public class TimeConversion {

	private static final String _12_NOON = "12 NOON";
	private static final String EMPTY_REPLACEMENT = "";
	private static final String AM = "AM";
	private static final String PM = "PM";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String time = in.nextLine();
		in.close();
		
		time = time.toUpperCase();
	
		if( time.endsWith(PM) )
		{
			time = time.replace(PM, EMPTY_REPLACEMENT);
			String[] parts = time.split(":");
			int hours = Integer.valueOf(parts[0]);
			if(hours != 12)
			{
				hours+=12;
			}
			System.out.println(EMPTY_REPLACEMENT+hours+":"+parts[1]+":"+parts[2]);			
		}
		else if( time.endsWith(AM) )
		{
			time = time.replace(AM, EMPTY_REPLACEMENT);

			String[] parts = time.split(":");
			int hours = Integer.valueOf(parts[0]);
			if(hours == 12)
			{
				parts[0]="00";
			}

			System.out.println(parts[0]+":"+parts[1]+":"+parts[2]);			
		}
		else if(time.equals(_12_NOON))
		{
			System.out.println("12:00:00");
		}		
		else
		{
			System.out.println(time);
		}

	}

}
