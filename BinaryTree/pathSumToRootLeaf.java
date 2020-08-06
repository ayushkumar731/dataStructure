/*
Path Sum Root to Leaf
Send Feedback
Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number k.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2 : k

Output format : Print each path in new line, elements separated by space

Sample Input 1 :
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13
Sample Output 1 :
5 6 2
5 7 1

*/
package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class pathSumToRootLeaf {
    public static void rootToLeaf(BinaryTreeNode<Integer> root, int k,String str){
        if(root==null){
            return;
        }
        if(root.data>k){
            return;
        }else{            
            str=str+root.data;
            if(k!=root.data){
                str=str+" ";
            }
            k=k-root.data;
            if(k==0){
                System.out.println(str);           
            }
            rootToLeaf(root.left,k,str);
            rootToLeaf(root.right,k,str);            
        }
    }
    private static void SumRootToLeaf(BinaryTreeNode<Integer> root,int k) {
        rootToLeaf(root,k,"");
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
        SumRootToLeaf(root,k);
     }
}