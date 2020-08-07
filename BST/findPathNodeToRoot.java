/*
Find path in BST

Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST). Return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Path from node k to root
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output :
2
5
8
 */
package BST;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import BinaryTree.BinaryTreeNode;
import java.util.ArrayList;
public class findPathNodeToRoot {
    private static ArrayList<Integer> findpath(BinaryTreeNode<Integer> root, int k) {
        if(root==null){
            return null;
        }
        if(root.data==k){
            ArrayList<Integer> path=new ArrayList<Integer>();
            path.add(root.data);
            return path;
        }
        ArrayList<Integer> leftPath=findpath(root.left, k);
        if(leftPath!=null){
            leftPath.add(root.data);
            return leftPath;
        }
        ArrayList<Integer> rightPath=findpath(root.right, k);
        if(rightPath!=null){
            rightPath.add(root.data);
            return rightPath;
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
        ArrayList<Integer> path= findpath(root,k);
        if(path!=null){
            for(int i:path){
                System.out.println(i);
            }
        }
     }
}