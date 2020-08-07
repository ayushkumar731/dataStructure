/*
LCA of BST

Given a binary search tree and two nodes, find LCA(Lowest Common Ancestor) of the given two nodes in the BST. Read about LCA if you are having doubts about the definition.
If out of 2 nodes only one node is present, return that node.
If both are not present, return -1.
Input format :
Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two integers, Node 1 and Node 2 (separated by space)
Output Format :
LCA
Constraints :
1 <= N <= 1000
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1
 */
package BST;
import BinaryTree.BinaryTreeNode;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class lca {
    private static int lcaInBST(BinaryTreeNode<Integer> root,int a,int b) {
        if(root==null){
            return -1;
        }
        if(root.data==a||root.data==b){
            return root.data;
        }
        int left=lcaInBST(root.left, a, b);
        int right=lcaInBST(root.right, a, b);
        if(left!=-1&&right!=-1){
            return root.data;
        }
        if(left!=-1&&right==-1){
            return left;
        }
        if(left==-1&&right!=-1){
            return right;
        }
        return -1;
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
         int a=s.nextInt();
         int b=s.nextInt();
         System.out.println(lcaInBST(root,a,b));
     }
}