/*
Sum Of Nodes
Send Feedback
Given a binary tree, find and return the sum of all nodes.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
35
 */
package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class sumOfNodes {
    private static int sumOfNode(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int left = sumOfNode(root.left);
        int right = sumOfNode(root.right);
        return root.data+ left + right;
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
        System.out.println(sumOfNode(root));
    }
}