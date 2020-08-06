/*
Print nodes at distance k from node

Given a binary tree, a node and an integer K, print nodes which are at K distance from the the given node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2 : Node

Line 3 : K

Output format : Answer nodes in different line

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3
1
Sample Output :
9
6
 */
package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class nodesAtDistanceK {
    private static void depth(BinaryTreeNode<Integer> root, int k) {
        if(root==null)
            return;

        if(k==0){
            System.out.println(root.data);
            return;
        }

        depth(root.left,k-1);
        depth(root.right,k-1);
    }
    private static int helper(BinaryTreeNode<Integer> root, int node, int k){
        if(root==null){
            return -1;
        }
        if(root.data.equals(node)){
            depth(root,k);
            return k-1;
        }
        int left = helper(root.left,node,k);
        int right = helper(root.right,node,k);
        if(left!=-1){
            if(left==0){
                System.out.println(root.data);
            }          
            depth(root.right,left-1);
            return left-1;
        }
        if(right!=-1){
            if(right==0){
                System.out.println(root.data);
            }
            depth(root.left,right-1);
            return right-1;
        }
        return -1;
    }
    private static void nodesDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        helper(root,node,k);
    }
    static int node;
    static int k;
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
        node=s.nextInt();
        k=s.nextInt();
        return root;

     }
     public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInput();
        Scanner s=new Scanner(System.in);
        nodesDistanceK(root,node,k);
     }
}