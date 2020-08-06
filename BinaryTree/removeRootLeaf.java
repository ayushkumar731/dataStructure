package BinaryTree;
import java.util.Scanner;
public class removeRootLeaf {
    private static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
        if(root==null){
            return null;
        }
        
        if(root.left==null&&root.right==null){
                return null;
        }
        root.left=removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;
    }
    private static void print(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+":");
        if(root.left!=null){
            System.out.print("L"+root.left.data+",");
        }
        if(root.right!=null){
            System.out.print("R"+root.right.data);
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
        root=removeLeaf(root);
        print(root);
     }    
}