package SplayTreePackage;

public class SPLT implements SPLT_Interface {
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	public BST_Node getRoot() { // please keep this in here! I need your root
								// node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		// TODO Auto-generated method stub
		if (empty()) {
			root = new BST_Node(s);
			size += 1;
			root.justMade = false;
		} else {
			root = root.insertNode(s);
			if (root.justMade == true) {
				size += 1;
				root.justMade = false;
			}
		}
	}

	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub
		root = root.containsNode(s);
		if (root.getData() != s) {
			return;
		}
		if (root.getData() == s) {
			if (size == 1) {
				size--;
				root = null;
			} else {
				size--;
				BST_Node left = root.left;
				BST_Node right = root.right;
				if (left == null&&right != null) {
					root = right;
					root.par=null;
				} else if(right==null&&left!=null){
					root=left.findMax();
					root.par=null;
					root.right=null;
				}else{
					root = left.findMax();
					root.right = right;
					root.par=null;
					right.par=root;
				}
			}
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			root = root.findMin();
			return root.data;
		}
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			root = root.findMax();
			return root.data;
		}
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (empty()) {
			return false;
		}
		root = root.containsNode(s);
		if (root.getData() == s) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}
}
