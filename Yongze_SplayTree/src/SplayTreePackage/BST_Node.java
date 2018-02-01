package SplayTreePackage;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par; // parent...not necessarily required, but can be useful in
					// splay tree
	boolean justMade; // could be helpful if you change some of the return types
						// on your BST_Node insert.
	// I personally use it to indicate to my SPLT insert whether or not we
	// increment size.

	BST_Node(String data) {
		this.data = data;
		this.justMade = true;
	}

	BST_Node(String data, BST_Node left, BST_Node right, BST_Node par) { // feel
																			// free
																			// to
																			// modify
																			// this
																			// constructor
																			// to
																			// suit
																			// your
																			// needs
		this.data = data;
		this.left = left;
		this.right = right;
		this.par = par;
		this.justMade = true;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is (meaning also make sure they do in fact
	// return data,left,right respectively)

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public BST_Node containsNode(String s) { // it was me
		if (data.equals(s)){
			return Splay(this);}
		if (data.compareTo(s) > 0) {// s lexiconically less than data
			if (left == null){
				return Splay(this);}
			return left.containsNode(s);
		}
		if (data.compareTo(s) < 0) {
			if (right == null){
				return Splay(this);}
			return right.containsNode(s);
		}
		return null; // shouldn't hit
	}

	public BST_Node findMin() {
		if (left != null){
			return left.findMin();}
		return Splay(this);
	}

	public BST_Node findMax() {
		if (right != null){
			return right.findMax();}
		return Splay(this);
	}
	public BST_Node insertNode(String s){
		if(data==s){
			return Splay(this);
		}
			if(data.compareTo(s)>0){ //if s is less than data
			if(left==null){
				left=new BST_Node(s);
				left.par = this;
				return Splay(left);
			}
			return left.insertNode(s);
		}
		if(data.compareTo(s)<0){ //if s is greater than data
			if(right==null){
				right=new BST_Node(s);
				right.par = this;
				return Splay(right);
			}
			return right.insertNode(s);
		}
		return null;}	

	public int getHeight() {
		int l = 0;
		int r = 0;
		if (left != null)
			l += left.getHeight() + 1;
		if (right != null)
			r += right.getHeight() + 1;
		return Integer.max(l, r);
	}

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
	 public void makeLeftChildParent(BST_Node c, BST_Node p)
     {
//         if ((c == null) || (p == null) || (p.left != c) || (c.par != p))
//             throw new RuntimeException("Bai Gei Zao Nian Ba");
         if (p.par != null)
         {
             if (p == p.par.left)
                 p.par.left = c;
             else 
                 p.par.right = c;
         }
         if (c.right != null)
             c.right.par = p;
 
         c.par = p.par;
         p.par = c;
         p.left = c.right;
         c.right = p;
     }
	 public void makeRightChildParent(BST_Node c, BST_Node p)
     {
//         if ((c == null) || (p == null) || (p.right != c) || (c.par != p))
//             throw new RuntimeException("Bai Gei Zao Nian Ba");
         if (p.par != null)
         {
             if (p == p.par.left)
                 p.par.left = c;
             else
                 p.par.right = c;
         }
         if (c.left != null)
             c.left.par = p;
         c.par = p.par;
         p.par = c;
         p.right = c.left;
         c.left = p;
     }
	 private BST_Node Splay(BST_Node x)
     {
         while (x.par != null)
         {
             BST_Node Parent = x.par;
             BST_Node GrandParent = Parent.par;
             if (GrandParent == null)
             {
                 if (x == Parent.left)
                     makeLeftChildParent(x, Parent);
                 else
                     makeRightChildParent(x, Parent);                 
             } 
             else
             {
                 if (x == Parent.left)
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeLeftChildParent(Parent, GrandParent);
                         makeLeftChildParent(x, Parent);
                     }
                     else 
                     {
                         makeLeftChildParent(x, x.par);
                         makeRightChildParent(x, x.par);
                     }
                 }
                 else 
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeRightChildParent(x, x.par);
                         makeLeftChildParent(x, x.par);
                     } 
                     else 
                     {
                         makeRightChildParent(Parent, GrandParent);
                         makeRightChildParent(x, Parent);
                     }
                 }
             }
         }
         return x;
     }
	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

}