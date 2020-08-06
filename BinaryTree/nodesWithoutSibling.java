/*
Nodes without sibling

Given a binary tree, print all nodes that don’t have a sibling.
Edit : Print the elements in different lines. And order of elements doesn't matter.
Input format :
Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.
Output format :
Print nodes separated by new line.
Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
9    
 */
package BinaryTree;
import java.util.Scanner;
public class nodesWithoutSibling {
    private static void issibling(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        if(root.left!=null&&root.right==null){
            System.out.print(root.left.data+" ");
        }
        if(root.left==null&&root.right!=null){
            System.out.print(root.right.data+" ");
        }
        issibling(root.left);
        issibling(root.right);
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
        issibling(root);
    }
}