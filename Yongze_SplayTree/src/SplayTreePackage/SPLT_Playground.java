package SplayTreePackage;

public class SPLT_Playground {
  public static void main(String[] args){
    genTest();
  }
  
  public static void genTest(){
    SPLT tree= new SPLT();
    tree.insert("0");
    System.out.println("size is "+tree.size());
    tree.insert("C");
    System.out.println("size is "+tree.size());
    tree.insert("A");
    System.out.println("size is "+tree.size());
    tree.insert("B");
    System.out.println("size is "+tree.size());
    tree.insert("E");
    System.out.println("size is "+tree.size());
    tree.insert("D");
    System.out.println("size is "+tree.size());
    tree.remove("C");
    System.out.println("size is "+tree.size());
    tree.remove("A");
    System.out.println("size is "+tree.size());
    printLevelOrder(tree);
    tree.remove("D");
    System.out.println("size is "+tree.size());
    printLevelOrder(tree);
  }

    static void printLevelOrder(SPLT tree){ 
    //will print your current tree in Level-Order...Requires a correct height method
    //https://en.wikipedia.org/wiki/Tree_traversal
      int h=tree.getRoot().getHeight();
      for(int i=0;i<=h;i++){
        System.out.print("Level "+i+":");
        printGivenLevel(tree.getRoot(), i);
        System.out.println();
      }
      
    }
    static void printGivenLevel(BST_Node root,int level){
      if(root==null)return;
      if(level==0)System.out.print(root.data+" ");
      else if(level>0){
        printGivenLevel(root.left,level-1);
        printGivenLevel(root.right,level-1);
      }
    }
   static void printInOrder(BST_Node root){
      if(root!=null){
      printInOrder(root.getLeft());
      System.out.print(root.getData()+" ");
      printInOrder(root.getRight());
      }
  }
  
}