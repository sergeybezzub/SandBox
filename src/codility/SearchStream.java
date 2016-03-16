package codility;

import java.io.*;
import java.util.*;

public class SearchStream 
{
	public static List<String> findLines(String keyword, InputStream inStream)
			throws Exception 
	{
		List<String> result = new ArrayList<String>();

		if(inStream == null )
		{
			return result;
		}


		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = inStream.read(data, 0, data.length)) != -1) 
		{
		  buffer.write(data, 0, nRead);
		}

		buffer.flush();

		String s = new String( buffer.toByteArray());
		
		String[] parts = s.split("\n");
		
		for(String part : parts)
		{
			if(part.contains(keyword))
			{
				result.add(part);
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception 
	{
		String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";
		List<String> lines;

		try (InputStream inStream = new ByteArrayInputStream(
				inMessage.getBytes())) 
		{
			lines = SearchStream.findLines("there", inStream);
		}

		for (int i = 0; i < lines.size(); i++) 
		{
			System.out.println(lines.get(i));
		}
	}
}