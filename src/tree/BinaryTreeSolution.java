package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeSolution {

	List<Integer> amplitudes = new ArrayList<Integer>();
	
	public static void main(String[] args) 
	{
		Tree[] tree = new Tree[11];
		
		for(int i=0; i < 11; i++)
		{
			tree[i] = new Tree();
		}
		
		tree[0].l=tree[1];
		tree[0].r=tree[2];
		tree[0].x=5;
		
		tree[1].l=tree[3];
		tree[1].r=tree[4];
		tree[1].x=3;
		
		tree[2].l=tree[5];
		tree[2].r=tree[6];
		tree[2].x=6;
		
		tree[3].l=tree[7];
		tree[3].x=2;

		tree[4].l=tree[8];
		tree[4].r=tree[9];
		tree[4].x=9;
	
		tree[5].r=tree[10];
		tree[5].x=4;

		tree[6].x=8;

		tree[7].x=1;

		tree[8].x=7;

		tree[9].x=10;

		tree[10].x=11;
		
		BinaryTreeSolution solution = new BinaryTreeSolution();
		//Expected value for Tree amplitude is 7
		System.out.println(solution.solution(tree[0]));
	}

	public int solution(Tree tree)
	{
		if(tree == null)
		{
			return 0;
		}
		
		calculateAmplitudes(tree, new ArrayList<Tree>());
		
		return calculateMaxAmplitude(amplitudes);
	}
	
	private void calculateAmplitudes(Tree tree, List<Tree> subTree)
	{
		subTree.add(tree);

		if(tree.r !=null)
		{
			calculateAmplitudes(tree.r, new ArrayList<Tree>(subTree) );
		}

		if(tree.l !=null)
		{
			calculateAmplitudes(tree.l, subTree );
		}

		if(tree.l== null && tree.r==null)
		{
			calculateAmplitude(subTree);
		}
		
	}

	private void calculateAmplitude(List<Tree> subTree) {
		Integer[] buf = new Integer[subTree.size()];
		for(int i=0; i<subTree.size(); i++)
		{
			buf[i]=subTree.get(i).x;
		}
		Arrays.sort(buf);
		int amplitude = buf[buf.length-1].intValue() - buf[0].intValue();
		amplitudes.add(Integer.valueOf(amplitude));
	}

	private int calculateMaxAmplitude(List<Integer> amps) {
		int amplitude=0;
		if( amps != null && amps.size()>1)
		{
			Integer[] buf = amps.toArray(new Integer[amps.size()]);
			Arrays.sort(buf);
			amplitude = buf[buf.length-1].intValue();
		}
		else if(amps != null && amps.size() == 1)
		{
			amplitude=amps.get(0).intValue();
		}
		
		return amplitude;
	}

}
