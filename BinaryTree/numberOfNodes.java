package BinaryTree;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class numberOfNodes {
    private static int numberOfNode(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int leftCount=numberOfNode(root.left);
        int rightCount=numberOfNode(root.right);
        return 1+ leftCount + rightCount;
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
        System.out.println(numberOfNode(root));
    }

   

    
}