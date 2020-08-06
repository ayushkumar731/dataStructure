package BinaryTree;
import java.util.Scanner;
public class nodesGreaterThanX {
    private static int numberOfNodesGreaterThanX(BinaryTreeNode<Integer> root,int X) {
       if(root==null){
           return 0;
       }
       int leftCount=numberOfNodesGreaterThanX(root.left, X);
       int rightCount=numberOfNodesGreaterThanX(root.right, X);
       if(root.data>X){
            return 1+leftCount+rightCount;
       }else{
           return leftCount+rightCount;
       }
    }
    private static BinaryTreeNode<Integer> takeInput(boolean isRoot,int data,boolean isLeft) {
        if(isRoot){
            System.out.println("Enter the parentData");
        }else{
            if(isLeft){
                System.out.println("Enter the left child of :"+data);
            }else{
             System.out.println("Enter the right child of :"+data);
            }
        }
        Scanner s=new Scanner(System.in);
        int rootData=s.nextInt();
        if(rootData==-1){
             return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> left=takeInput(false, rootData,true);
        BinaryTreeNode<Integer> right=takeInput(false, rootData,false);
        root.left=left;
        root.right=right;
        return root;
     }
     public static void main(String[] args) {
         BinaryTreeNode<Integer> root=takeInput(true,0,true);
         Scanner s=new Scanner(System.in);
         int n=s.nextInt();
        System.out.println(numberOfNodesGreaterThanX(root,n));
     }

    
}