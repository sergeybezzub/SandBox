package codility;

class TreeNode {
    private TreeNode leftChild, rightChild;
    
    public TreeNode(TreeNode leftChild, TreeNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public TreeNode getLeftChild() {
    	return this.leftChild;
    }
    
    public TreeNode getRightChild() {
    	return this.rightChild;
    }
}

public class TreeHeight {
    public static int calculateHeight(TreeNode root) {
    	int count =0;
    	TreeNode nodeTmp = root;
		
		count += checkNode(nodeTmp);
		
		return count;

	}

    private static int checkNode(TreeNode node)
    {
    	int count=0;
		while(!isNodeLeaf(node)){

			count+=checkNode(node.getLeftChild());
			count+=checkNode(node.getRightChild());
		}
		
		return count;
    }
    
    private static boolean isNodeLeaf(TreeNode node)
    {
    	return node.getLeftChild() == null && node.getRightChild() == null;
    }
    
    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(null, null);
        TreeNode leaf2 = new TreeNode(null, null);
        TreeNode node = new TreeNode(leaf1, null);
        TreeNode root = new TreeNode(node, leaf2);

        System.out.println(TreeHeight.calculateHeight(root));
    }
}
