package BinaryTree;
import java.util.Scanner;
public class printNodeDepth {
    private static void printNode(BinaryTreeNode<Integer> root,int k) {
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
            return;
        }
        printNode(root.left, k-1);
        printNode(root.right, k-1);
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
        int k=s.nextInt();
        printNode(root,k);
    }
}