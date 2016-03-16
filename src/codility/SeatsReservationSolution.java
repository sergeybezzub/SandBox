package codility;

import java.io.File;
import java.sql.PreparedStatement;


class SeatsReservationSolution {

	public int solution(int N, String S) {

		int[] abc  = new int[N];
		int[] defg = new int[N];
		int[] hjk  = new int[N];
		
		if(N < 0) {
			return 0;
		}
		
		//populate info about reserved seats
		if(S != null && S.length() != 0) {
			String[] seats = S.split(" "); 
			for(String seat : seats) {
				if(N < 10 && seat.length() != 2) {
					continue;
				} else if( N > 9 && seat.length() != 3 ) {
					continue;
				} else {
					String row=null;
					String column=null;
					if(seat.length() == 2) {
						row=""+seat.charAt(0);
						column=""+seat.charAt(1);
					} else {
						row=""+seat.charAt(0);
						row+=seat.charAt(1);
						column=""+seat.charAt(2);					
					}
					int rowNumber;
					try {
						rowNumber= Integer.valueOf(row).intValue();
					} catch(NumberFormatException e) {
						//it means we got incorrect input data for row number, so we will ignore that part of S 
						continue;
					}
					
					//check abc
					if("a".equalsIgnoreCase(column) || "b".equalsIgnoreCase(column) || "c".equalsIgnoreCase(column) ) {
						if(rowNumber > 0 && rowNumber <= N) {
							abc[rowNumber-1] =1;
						}
					} else if("d".equalsIgnoreCase(column) || "e".equalsIgnoreCase(column) || "f".equalsIgnoreCase(column) || "g".equalsIgnoreCase(column) ) {
						if(rowNumber > 0 && rowNumber <= N) {
							defg[rowNumber-1]+=column.toLowerCase().charAt(0)-99;
						}
					} else if("h".equalsIgnoreCase(column) || "j".equalsIgnoreCase(column) || "k".equalsIgnoreCase(column) ) {
						if(rowNumber > 0 && rowNumber <= N) {
							hjk[rowNumber-1] =1;
						}
					}
				}
			}
		}
		
		//find free seats
		int count=0;
		
		for(int i=0; i<N; i++) {
			if(abc[i] == 0) {
				count++;
			}
			if(hjk[i] == 0) {
				count++;
			}
			if(defg[i] ==0 || defg[i]==1  || defg[i]==4 ) {
				count++;
			}

		}
		return count;
    }

	public static void main(String[] args) {
		SeatsReservationSolution s = new SeatsReservationSolution();
		System.out.println(s.solution(2, "1A 2F 1C"));
		System.out.println(s.solution(1, ""));
	}

}
