package hackerrank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class SimilarDestinations {

    private static final String COLON_SEPARATOR = ":";
	private static final String COMMA_SEPARATOR = ",";

	public static void main(String[] args) 
    {
		Scanner in = new Scanner(System.in);

    	// Get input data
		int minNumberOfCommonTags = in.nextInt();
		List<String> destinations = new ArrayList<String>();
		List<String> groups = new ArrayList<String>();
		do
		{
			destinations.add(in.next());

		}while(in.hasNext());
		in.close();

		int size = destinations.size();

		//First iteration - get tags groups
		for(int i=0; i<size; i++)
		{
			for(int j=i+1; j<size; j++)
			{
				String newGroup=buildGroup(destinations.get(i), destinations.get(j), minNumberOfCommonTags);
				if(newGroup !=null)
				{
					groups.add(newGroup);
				}
			}
		}
		
		Collections.sort(groups);
		
		//Second iteration - reduce groups with the same tags 
		List<String> reducedGroups = new ArrayList<String>();

		for(int j=0; j<groups.size(); j++)
		{
			Set<String> destNames = new HashSet<String>();

			String[] parts = groups.get(j).split(COLON_SEPARATOR);
			String[] destparts = parts[0].split(COMMA_SEPARATOR);
			String tmpTags =parts[1];

			destNames.add(destparts[0]);
			destNames.add(destparts[1]);				

			for(int i=j+1; i<groups.size(); i++)
			{
				parts = groups.get(i).split(COLON_SEPARATOR);
				destparts = parts[0].split(COMMA_SEPARATOR);
	
				if(tmpTags.equals(parts[1]))
				{
					destNames.add(destparts[0]);
					destNames.add(destparts[1]);
					
					groups.remove(i);
					i--;
				}
			}
			
			List<String> listOfNames = new ArrayList<String>(destNames);
			Collections.sort(listOfNames);
			
			StringBuilder b = new StringBuilder();
			boolean isCommaRequired=false;
			for(String name : listOfNames)
			{
				if(isCommaRequired)
				{
					b.append(COMMA_SEPARATOR);
				}
				b.append(name);
				isCommaRequired=true;
			}
			b.append(COLON_SEPARATOR);
			b.append(tmpTags);

			reducedGroups.add(b.toString());
		}	

		// Sorting by reducing size asc	
		Collections.sort(reducedGroups, new Comparator<String>()
		{
			@Override
			public int compare(String s1, String s2)
			{
				String[] parts1 = s1.split(COLON_SEPARATOR);
				String[] dest1 = parts1[0].split(COMMA_SEPARATOR);

				String[] parts2 = s2.split(COLON_SEPARATOR);
				String[] dest2 = parts2[0].split(COMMA_SEPARATOR);

				double res = dest1.length - dest2.length;
				return res < 0 ? -1 : res > 0 ? 1 : 0;
			}	
		});
		
		//Outpot results
		for(String group : reducedGroups)
		{
			System.out.println(group);
		}

    }
    
    private static String buildGroup(String dest1, String dest2, int minNumberOfCommonTags )
    {  	
    	String[] parts = dest1.split(COLON_SEPARATOR);
    	String name1 = parts[0];
    	String[] tags1 = parts[1].split(COMMA_SEPARATOR);
    	
    	parts = dest2.split(COLON_SEPARATOR);
    	String name2 = parts[0];
    	String[] tags2 = parts[1].split(COMMA_SEPARATOR);
    	
    	Arrays.sort(tags1);
    	Arrays.sort(tags2);
       	
    	List<String> tagsList1 = Arrays.asList(tags1);
    	List<String> tagsListResult = new ArrayList<String>();
    	
    	int length = tags1.length > tags2.length ? tags2.length : tags1.length;
    	int addedTags=0;

    	for(int i=0; i<length; i++)
    	{
    		if(tagsList1.contains(tags2[i]))
    		{
    			tagsListResult.add(tags2[i]);   			
    			addedTags++;
    		}
    	}
  	
    	if(addedTags < minNumberOfCommonTags)
    	{
    		return null;
    	}
    	else
    	{
    		return createGroup(name1, name2, tagsListResult);
    	}
    }

	private static String createGroup(String name1, String name2,
			List<String> tagsListResult) {
		StringBuilder builder=new StringBuilder();

		builder.append(name1);
		builder.append(COMMA_SEPARATOR);
		builder.append(name2);
		builder.append(COLON_SEPARATOR);

		Collections.sort(tagsListResult);
		for(int i=0; i<tagsListResult.size(); i++)
		{
			if(i>0)
			{
		    	builder.append(COMMA_SEPARATOR);        			
			}
			builder.append(tagsListResult.get(i));
		}
		return builder.toString();
	}
}