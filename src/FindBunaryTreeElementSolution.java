
public class FindBunaryTreeElementSolution {

	static class Node {
		private Node left;
		private Node right;
		int key;
		
		public Node(int key) {
			this.key=key;
		}
	}

	public Node find(Node root, int value) {
		Node nodTmp = root;
		while(nodTmp != null){
			if(nodTmp.key == value) {
				return nodTmp;
			} else if( nodTmp.key > value) {
				nodTmp=nodTmp.left;
			} else {
				nodTmp=nodTmp.right;
			}
		}
		return null;
	}
}
