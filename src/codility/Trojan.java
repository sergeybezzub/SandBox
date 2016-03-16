package codility;

import java.util.Set;
import java.util.TreeSet;

public class Trojan {
	private final static String SNAPSHOT ="<snapshot>";
	private final static String FOLDER ="<folder>";
	private final static String FILEID ="fileId";
	private final static String SEARCH_TEMPLATE = "<file fileId=\"{infectedFileId}\"/>";
	private final static String PLACE_HOLDER = "{infectedFileId}";
	
	public static int countCompromised(String xml, String infectedFileId) {
    	
		String templateValue = SEARCH_TEMPLATE.replace(PLACE_HOLDER, infectedFileId);

		String[] snapshots = xml.split(SNAPSHOT);
		Set<String> ids = new TreeSet<String>();
		
		for(int i=1; i<snapshots.length; i++)
		{
			String[] folders = snapshots[i].split(FOLDER);
			
			for(int j=0; j < folders.length; j++)
			{
				if(!folders[j].isEmpty())
				{
					if( folders[j].contains(templateValue))
					{
						String[] parts = folders[j].split(FILEID);
						
						for(int c=0; c<parts.length; c++)
						{
							if(parts[c].startsWith("="))
							{
								String[] items= parts[c].split("/>");
								ids.add(items[0]);
							}
						}					
					}
				}
			}
		}
		
		return ids.size()-1;
    }

    public static void main(String[] args) {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "   <snapshot>" +
                "      <folder>" +
                "         <file fileId=\"1\"/>" +
                "         <file fileId=\"2\"/>" +
                "         <folder>" +
                "            <file fileId=\"3\"/>" +
                "            <file fileId=\"4\"/>" +
                "         </folder>" +
                "      </folder>" +
                "   </snapshot>" +
                "   <snapshot>" +
                "      <file fileId=\"1\"/>" +
                "      <file fileId=\"3\"/>" +
                "      <folder>" +
                "         <file fileId=\"2\"/>" +
                "         <file fileId=\"4\"/>" +
                "         <folder>" +
                "            <file fileId=\"3\"/>" +
                "            <file fileId=\"4\"/>" +
                "         </folder>" +
                "      </folder>" +
                "   </snapshot>" +
                "</root>";

        System.out.println(Trojan.countCompromised(xml, "3"));
    }
}