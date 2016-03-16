package codility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Schedule {
	public static List<Show> findOptimalSchedule(Collection<Show> shows)
    {
		if( shows == null || shows.size()==0 )
		{
			return new ArrayList<Show>();
		}
		
    	Show[] showsArray =shows.toArray(new Show[shows.size()]);
    	Arrays.sort(showsArray, new Comparator<Show>() {
    	
    		@Override
    	    public int compare(Show sh1, Show sh2) {
                long d1 = sh1.getStartTime().getTime();
                long d2 = sh2.getStartTime().getTime();
                
				if(d1 < d2)
                {
                  return -1;    
                }
                else if(d1 > d2)
                {
                  return 1;    
                }
                else
                {
                    return 0;
                }
    	    }
		});    	
    	List<Show> showList = new ArrayList<Show>();
    	
    	showList.add(showsArray[0]);
    	
    	int size = showsArray.length;

    	for(int i=1, j=0; i<size; i++)
    	{
    		if( showsArray[i].getStartTime().getTime() > showList.get(j).getEndTime().getTime() )
    		{
    			showList.add(showsArray[i]);
    			j++;
    		}
    	}
        
    	return showList;
    }

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

		ArrayList<Show> shows = new ArrayList<Show>();
		shows.add(new Show("Show2", sdf.parse("2013-08-06 19:00"), sdf
				.parse("2013-08-06 22:00")));
		shows.add(new Show("Show3", sdf.parse("2013-08-06 21:00"), sdf
				.parse("2013-08-06 23:00")));
		shows.add(new Show("Show1", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show1", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show4", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show5", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show6", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show7", sdf.parse("2013-08-06 23:06"), sdf
				.parse("2013-08-06 23:07")));
		shows.add(new Show("Show8", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show9", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show10", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show11", sdf.parse("2013-08-06 18:00"), sdf
				.parse("2013-08-06 20:00")));
		shows.add(new Show("Show12", sdf.parse("2013-08-06 23:01"), sdf
				.parse("2013-08-06 23:05")));

		List<Show> list = Schedule.findOptimalSchedule(shows);
		for (Show show : list) {
			System.out.println(show.getName());
		}
	}
}

class Show {
	private String name;
	private Date startTime;
	private Date endTime;

	public Show(String name, Date startTime, Date endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
}
