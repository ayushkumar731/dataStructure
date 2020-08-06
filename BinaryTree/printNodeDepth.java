package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class printNodeDepth {
    private static void printNode(BinaryTreeNode<Integer> root,int k) {
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
            return;
        }
        printNode(root.left, k-1);
        printNode(root.right, k-1);
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
        printNode(root,k);
    }
}