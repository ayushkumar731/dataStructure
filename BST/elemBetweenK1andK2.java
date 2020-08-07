/*
Elements Between K1 and K2

Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two Integers k1 and k2
Output Format :
Required elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output :
6 7 8 10
 */
package BST;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import BinaryTree.BinaryTreeNode;
public class elemBetweenK1andK2 {
    private static void printBetweenK1andK2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if(root==null){
            return;
        }
        if(root.data<k1){
            printBetweenK1andK2(root.right, k1, k2);
        }else if(root.data>k2){
            printBetweenK1andK2(root.left, k1, k2);
        }else{
            printBetweenK1andK2(root.left, k1, k2);
            System.out.print(root.data+" ");
            printBetweenK1andK2(root.right, k1, k2);
        }

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
        Scanner s=new Scanner(System.in);
        int k1=s.nextInt();
        int k2=s.nextInt();
        printBetweenK1andK2(root,k1,k2);
     }
}