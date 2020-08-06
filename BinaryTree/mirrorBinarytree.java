/*
Mirror the given binary tree. That is, right child of every nodes should become left and left should become right.

Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output format : Elements in level order form (Every level in new line)

Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 
3 2 
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5 
6 10 
3 2 
9
 */
package BinaryTree;
import java.util.Scanner;
public class mirrorBinarytree {
    private static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> root) {
        if(root==null){
            return null;
        }
        mirror(root.left);
        mirror(root.right);
        BinaryTreeNode<Integer> temp=root.right;
        root.right=root.left;
        root.left=temp;
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
        root=mirror(root);
        print(root);
     }

    
}