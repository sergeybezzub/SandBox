package tree;


/**
 * Class represents a binary tree
 * and methods for add, find and delete the tree node 
 * @author sergiy.bezzub
 *
 * @param <T1>
 * @param <T2>
 */
public class BinaryTree<T1 extends Comparable<T1>,T2> {
	static class Node<T1, T2> {
		private Node<T1, T2> left;
		private Node<T1, T2> right;
		private T1 key;
		private T2 value;
		
		public Node(T1 key, T2 value) {
			this.key=key;
			this.value=value;
		}
	}
	
	Node<T1, T2> root;

	
	public Node<T1,T2> find(T1 k) {
		Node<T1, T2> nodTmp = root;
		while(root != null){
			int result = nodTmp.key.compareTo(k);
			if(result == 0) {
				return nodTmp;
			} else if( result <= 0) {
				nodTmp=nodTmp.right;
			} else {
				nodTmp=nodTmp.left;
			}
		}
		return null;
	}
	
	public int add(T1 key,T2 value){
		if(key == null || value == null){
			return -1;
		}
        Node<T1, T2> tmpNode = root;
        Node<T1, T2> parentNode = null;
        Node<T1, T2> newNode = new Node<T1, T2>(key, value);
        while (tmpNode != null) {
                int cmp = key.compareTo(tmpNode.key);
                if (cmp == 0) {
                	tmpNode.value = value;
                    return 0;
                } else {
                	parentNode = tmpNode;
                        if (cmp < 0) {
                        	tmpNode = tmpNode.left;
                        } else {
                        	tmpNode = tmpNode.right;
                        }
                }
        }

        if (parentNode == null) {
                root = newNode;
        } else {
                if (key.compareTo(parentNode.key) < 0) {
                	parentNode.left = newNode;
                } else {
                	parentNode.right = newNode;
                }
        }
        return 1;
	}
	
	public int delete(T1 key){
		if(key == null){
			return -1;
		}
        Node<T1, T2> tmpNode = root;
        Node<T1, T2> parentNode = null;
        Node<T1, T2> leftNode = null;
        while (tmpNode != null) {
        	int cmp = key.compareTo(tmpNode.key);
            if(cmp == 0){
            	break;
            } else{
            	parentNode=tmpNode;
            	if(cmp < 0){
            		tmpNode = tmpNode.left;
            	} else {
            		tmpNode = tmpNode.right;
            	}
            }
        }
        if(tmpNode == null){
        	return 0;
        }
        if(tmpNode.right == null){
        	if(parentNode == null) {
        		root=tmpNode.left;
        	} else if( tmpNode.equals(parentNode.left)){
        		parentNode.left=tmpNode.left;
        	} else {
        		parentNode.right=tmpNode.left;
        	}
        } else {
        	leftNode=tmpNode.right;
        	parentNode=null;
        	while (leftNode.left != null) {
        		parentNode=leftNode;
        		leftNode=leftNode.left;  		
        	}
        	if(parentNode != null) {
        		parentNode.left=leftNode.right;
        	} else {
        		tmpNode.right=leftNode.right;
        	}
        	tmpNode.key=leftNode.key;
        	tmpNode.value=leftNode.value;
        }
        return 1;
	}
	
	public String toString(){
		return nodeToSting(root, "");
	}

	public static void main(String[] argv){
		
		BinaryTree<Long,String> tree = new BinaryTree<Long,String>();
		int count=0;
		count+=tree.add(10l, "10");
		count+=tree.add(100l,"100");
		count+=tree.add(20l, "20");
		count+=tree.add(15l, "15");
		count+=tree.add(55l, "55");
		count+=tree.add(77l, "77");
		count+=tree.add(22l, "22");
		count+=tree.add(33l, "33");
		count+=tree.add(44l, "44");
		count+=tree.add(5l,  "5");
		count+=tree.add(25l, "25");
		count+=tree.add(66l, "66");
		
		System.out.println("count="+count+"\n"+tree);
		
		tree.delete(55l);

		System.out.println("count="+count+"\n"+tree);
		
	}
	
	private String nodeToSting(Node<T1,T2> node, String res){
		String str=res+"\n";
			
		str+="N[]:"+node.value.toString();
		if(node.left != null) {
			str+=" L[]:"+node.left.key.toString();
		}
		if(node.right != null) {
			str+=" R[]:"+node.right.key.toString();
		}
		
		if(node.left != null) {
			str=nodeToSting(node.left, str);	
		}
		if(node.right != null) {
			str=nodeToSting(node.right, str);	
		}
		return str;
		
	}
}
