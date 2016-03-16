package codility;

class ArrayJmpSolution {

	public static void main(String[] args) {
	int[] buf = {2,3,-1,1,3};
	//int[] buf = {1,1,-1,1};

	ArrayJmpSolution so = new ArrayJmpSolution();
	
	System.out.println(so.solution(buf));
	}

	public int solution(int[] A) {
    	
    	int size = A.length;
    	
    	if(A == null || size == 0)
    	{
    		return -1;
    	}
    	
    	if(size == 1 && A[0] == 0)
    	{
    		return -1;
    	}

    	if(size == 1 && A[0] != 0)
    	{
    		return 1;
    	}

    	int i=0;
    	int index=0;
    	int count=0;
    	boolean[] visited = new boolean[size];
    	
    	while(true)
    	{
   			count ++;
   			visited[index]=true;
       		index = index + A[index];
    		if(index >= size || index < 0)
    		{
    			return count;
    		}

       		if(visited[index])
       		{
       			return -1;
       		}
    	}

    }
}