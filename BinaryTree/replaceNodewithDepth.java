/*
Replace Node With Depth

Given a a binary tree. Replace each of it's data with the depth of tree.
Root is at depth 0, change its value to 0 and next level nodes are at depth 1 and so on.
Print the tree after modifying in inorder fashion. 
*/

package BinaryTree;
import java.util.Scanner;
public class replaceNodewithDepth {
    private static void replaceNode(BinaryTreeNode<Integer> root,int level) {
        if(root==null){
            return;
        }
        replaceNode(root.left, level+1);
        System.out.println(root.data=level);
        replaceNode(root.right, level+1);
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
         replaceNode(root,0);
     }

   
}