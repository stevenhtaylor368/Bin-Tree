
public class BinaryTree {
	public static final BinaryTree EMPTYTREE = 
            new BinaryTree(Integer.MIN_VALUE,null,null);
	private int key;
	private BinaryTree leftChild;
	private BinaryTree rightChild;
	public BinaryTree(int key, BinaryTree leftChild, BinaryTree rightChild) {
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	private void printInOrder() {
		if (this != EMPTYTREE) {
			leftChild.printInOrder();
			System.out.println(key);
			rightChild.printInOrder();
		}
	}
		
	private void printPreOrder() {
		if (this != EMPTYTREE) {
			leftChild.printPreOrder();
			rightChild.printPreOrder();
			System.out.println(key);
		}
		
	}
	private void printPostOrder() {
		// TODO Auto-generated method stub
		if (this != EMPTYTREE) {
			leftChild.printPostOrder();
			rightChild.printPostOrder();
			System.out.println(key);
		}
	}
	public BinaryTree find(int target) {
		if (target == key) return this;
		else if (target < key) return leftChild.find(target);
		else return rightChild.find(target);
	}
	
	public BinaryTree insert(int item) {
		if (this == EMPTYTREE)
			return new BinaryTree(item, EMPTYTREE, EMPTYTREE);
		else if (item < key)
			return new BinaryTree(key, leftChild.insert(item), rightChild);
		else return new BinaryTree(key, leftChild, rightChild.insert(item));
	}
	int maxDepth(BinaryTree key)  
    { 
        if (key == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(key.leftChild); 
            int rDepth = maxDepth(key.rightChild); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
        
        
    } 
	 int size() 
	    { 
		 	
	        return size(this); 
	    } 
	  
	    /* computes number of nodes in tree */
	    int size(BinaryTree tree) 
	    { 
	        if (tree != EMPTYTREE) 
	            return(size(tree.leftChild) + size(tree.rightChild)); 
	        else
	            return 1; 
	    } 
	public static void main(String[] args) {
		BinaryTree testTree =
				new BinaryTree(25,
						 new BinaryTree(12,new BinaryTree(9, EMPTYTREE, EMPTYTREE),
						 new BinaryTree(14, EMPTYTREE, EMPTYTREE)),
						 new BinaryTree(36, new BinaryTree(29, EMPTYTREE, EMPTYTREE),
						 EMPTYTREE));
						 		  
			System.out.println("testTree inorder:");
			testTree.printInOrder();
			System.out.println("Depth " + testTree.maxDepth(testTree));
			System.out.println("Size: " + testTree.size());
			System.out.println("tree containing 29: " + testTree.find(29));
			BinaryTree newTree = testTree.insert(11);
			System.out.println("tree containing 29: " + newTree.find(29));
			System.out.println("tree containing 11: " + newTree.find(11));
			System.out.println("Depth " + newTree.maxDepth(newTree));
			System.out.println("Size: " + newTree.size());
			System.out.println("newTree inorder:");
			newTree.printInOrder();
			System.out.println("testTree inorder:");
			testTree.printInOrder();
			System.out.println("Depth " + testTree.maxDepth(testTree));
			System.out.println("Size: " + testTree.size(testTree));
			BinaryTree tree03 = EMPTYTREE.insert(34).insert(48).insert(29).insert(36)
			.insert(12).insert(9);
			System.out.println("tree03 preorder:");
			tree03.printPreOrder();
			System.out.println("tree03 inorder:");
			tree03.printInOrder();
			System.out.println("tree03 postorder:");
			tree03.printPostOrder();
	        System.out.println("tree containing 36: " + tree03.find(36));
			
		}
	
	
}


