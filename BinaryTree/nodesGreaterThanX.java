/*
Nodes Greater Than X

Given a Binary Tree and an integer x, find and return the count of nodes which are having data greater than x.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer x
Output Format :
count
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
8
Sample Output :
3    
 */
package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class nodesGreaterThanX {
    private static int numberOfNodesGreaterThanX(BinaryTreeNode<Integer> root,int X) {
       if(root==null){
           return 0;
       }
       int leftCount=numberOfNodesGreaterThanX(root.left, X);
       int rightCount=numberOfNodesGreaterThanX(root.right, X);
       if(root.data>X){
            return 1+leftCount+rightCount;
       }else{
           return leftCount+rightCount;
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
         int n=s.nextInt();
        System.out.println(numberOfNodesGreaterThanX(root,n));
     }

    
}