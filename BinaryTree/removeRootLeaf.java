package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class removeRootLeaf {
    private static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
        if(root==null){
            return null;
        }
        
        if(root.left==null&&root.right==null){
                return null;
        }
        root.left=removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;
    }
    private static void print(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> pendingChildren =new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);
        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front=pendingChildren.poll();
            System.out.print(front.data+":");
            if(front.left!=null){
                System.out.print("L:"+front.left.data+",");
                pendingChildren.add(front.left);
            }
            if(front.left==null){
                System.out.print("L:"+-1+",");
            }
            if(front.right!=null){
                System.out.print("R:"+front.right.data);
                pendingChildren.add(front.right);
            }
            if(front.right==null){
                System.out.print("R:"+-1);
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
        root=removeLeaf(root);
        print(root);
     }    
}