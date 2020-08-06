package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class levelOrderTraversal {
    private static void printLevelOrderTraversal(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> pendingChildren =new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);
        while(!pendingChildren.isEmpty()){
            int count=pendingChildren.size();
            while(count>0){
                BinaryTreeNode<Integer> front=pendingChildren.peek();
                System.out.print(front.data+" ");
                pendingChildren.poll();
                if(front.left!=null){
                    pendingChildren.add(front.left);
                }
                if(front.right!=null){
                    pendingChildren.add(front.right);
                }
                count--;
            }
            System.out.println();
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
        printLevelOrderTraversal(root);
     }

}