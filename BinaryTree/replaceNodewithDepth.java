/*
Replace Node With Depth

Given a a binary tree. Replace each of it's data with the depth of tree.
Root is at depth 0, change its value to 0 and next level nodes are at depth 1 and so on.
Print the tree after modifying in inorder fashion. 
*/

package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class replaceNodewithDepth {
    private static void replaceNode(BinaryTreeNode<Integer> root,int level) {
        if(root==null){
            return;
        }
        replaceNode(root.left, level+1);
        System.out.println(root.data=level);
        replaceNode(root.right, level+1);
    }
    private static BinaryTreeNode<Integer> takeInput() {
        Scanner s=new Scanner(System.in);
        int data= s.nextInt();
        if(data==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> front=q.poll();
            int left=s.nextInt();
            if(left!=-1){
                BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<Integer>(left);
                front.left=leftChild;
                q.add(leftChild);
            }
            int right=s.nextInt();
            if(right!=-1){
                BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(right);
                front.right=rightChild;
                q.add(rightChild);
            }
        }
        return root;

     }
     public static void main(String[] args) {
         BinaryTreeNode<Integer> root=takeInput();
         replaceNode(root,0);
     }

   
}