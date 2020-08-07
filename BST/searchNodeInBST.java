/*
Search In BST

Given a BST and an integer k. Find if the integer k is present in given BST or not. Return the node with data k if it is present, return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Node with data k
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
2
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
(empty)
 */
package BST;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import BinaryTree.BinaryTreeNode;
public class searchNodeInBST {
    private static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int k) {
        if(root==null){
            return null;
        }
        if(root.data==k){
            return root;
        }else if(root.data<k){
           return  searchInBST(root.right, k);
        }else if(root.data>k){
          return searchInBST(root.left, k);
        }
        return null;
        
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
         int k=s.nextInt();
         root=searchInBST(root,k);
         if(root!=null){
             System.out.println(root.data);
         }
     }
}