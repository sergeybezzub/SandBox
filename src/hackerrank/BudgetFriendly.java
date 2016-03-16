package hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//INPUT
//2 50
//3
//10 7.8
//15 6.4
//12 8.111
//3
//25 7.8
//19 6.4
//50 8.1
//OUTPUT
//15.91

public class BudgetFriendly {

	static class City
	{
		private List<Hotel> hotels = new ArrayList<Hotel>();
		
		public List<Hotel> getHotels()
		{
			return hotels;
		}
		
		public List<Hotel> getUnprocessedHotels()
		{
			List<Hotel> unprocessed = new ArrayList<Hotel>();
			for(Hotel hotel : hotels)
			{
				if(!hotel.processed)
				{
					unprocessed.add(hotel);
				}
			}
			return unprocessed;
		}
		
		public void markProcessed(Hotel processedHotel)
		{
			for(Hotel hotel : hotels )
			{
				if(hotel.equals(processedHotel))
				{
					hotel.processed=true;
					break;
				}
			}
		}
	}
	
	static class Hotel implements Comparable<Hotel>
	{
		private int price;
		private double score;
		private boolean processed;
		
		public final Comparator<Hotel> SCORE_ORDER = new Comparator<Hotel>() 
		{
			@Override
			public int compare(Hotel h1, Hotel h2)
			{
				double res = h1.score - h2.score;
				return res < 0 ? -1 : res > 0 ? 1 : 0;
			}
		};

		public Hotel(int price, double score)
		{
			this.price=price;
			this.score=score;
		}
		
		public boolean equals(Object o) 
		{

			if(o instanceof Hotel)
			{
				Hotel h =(Hotel)o;
				return this.price == h.price && this.score == h.score;
			}
			else
			{
				return false;
			}
		}

		public int hashCode() 
		{

			return (""+this.price+this.score).hashCode();
		}

		@Override
		public int compareTo(Hotel o) {
			double res = this.score - o.score;
			return res < 0 ? -1 : res > 0 ? 1 : 0;
		}
	}
	
    public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

    	// Get input data
		int numberOfCities = in.nextInt();
		City[] cities = new City[numberOfCities];
		int budget = in.nextInt();
		  	
    	for(int j=0; j<numberOfCities; j++)
    	{
        	int numberOfAvailableHotels = in.nextInt();
			cities[j] = new City();

    		for(int i=0; i<numberOfAvailableHotels; i++)
    		{
    			int price = in.nextInt();
    			double score = in.nextDouble();
    			cities[j].getHotels().add(new Hotel(price,score));
    		}
    	}

    	Hotel[] selectedHotels = new Hotel[numberOfCities];
    	
    	// Find result
    	do
    	{
    		//Find hotel with max prace to remove it from our short list
    		Hotel hotel = getHotelWithMaxPrice(selectedHotels);
    		if(hotel != null)
    		{
    			int cityIndex = getCityOfHotelWithMaxPrice(selectedHotels);
    			cities[cityIndex].markProcessed(hotel);
    		}
    		
    		//Create list of max scored hotels in every city
    		for(int j=0; j<numberOfCities; j++)
	    	{
	    		if(cities[j].getUnprocessedHotels().isEmpty())
	    		{
	    			System.out.println("-1");
	    			return;
	    		}
	    		List<Hotel> currentList = cities[j].getUnprocessedHotels();
	    		Collections.sort(currentList, currentList.get(0).SCORE_ORDER );
				selectedHotels[j]=currentList.get(cities[j].getUnprocessedHotels().size()-1);
				
	    	}    	
    	 //We are going to find a next list of hotels if our current list is out of budget
    	}while(totalPrice(selectedHotels) > budget);
    	
    	double resultScore = totalScore(selectedHotels);
    	System.out.format("%6.2f%n", resultScore);
    }

	private static Hotel getHotelWithMaxPrice(Hotel[] selectedHotels) 
	{
		if(selectedHotels == null || selectedHotels.length ==0 || selectedHotels[0] == null )
		{
			return null;
		}
		
		int indexOfMax = getCityOfHotelWithMaxPrice(selectedHotels);
		
		return selectedHotels[indexOfMax];
	}

	private static int getCityOfHotelWithMaxPrice(Hotel[] selectedHotels) 
	{	
		int maxIndex=0;
		
		for( int i=1; i<selectedHotels.length; i++ )
		{
			if(selectedHotels[maxIndex].price < selectedHotels[i].price)
			{
				maxIndex=i;
			}
		}
		
		return maxIndex;
	}
	
	private static int totalPrice(Hotel[] selectedHotels) {
		int totalPrice=0;
    	for( Hotel h : selectedHotels)
    	{
    		totalPrice += h.price;
    	}
		return totalPrice;
	}
    
	private static double totalScore(Hotel[] selectedHotels) {
		double totalScore=0;
    	for( Hotel h : selectedHotels)
    	{
    		totalScore += h.score;
    	}
		return totalScore;
	}

}