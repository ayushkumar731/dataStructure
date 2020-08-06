package BinaryTree;
import java.util.Scanner;
public class sumOfNodes {
    private static int sumOfNode(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int left = sumOfNode(root.left);
        int right = sumOfNode(root.right);
        return root.data+ left + right;
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
        System.out.println(sumOfNode(root));
    }
}