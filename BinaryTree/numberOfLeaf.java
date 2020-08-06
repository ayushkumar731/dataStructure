package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class numberOfLeaf {
    private static int numLeaf(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int leftLeafCount=numLeaf(root.left);
        int rightLeafCount=numLeaf(root.right);
        if(root.left==null&&root.right==null){
            return 1;
        }else{
            return leftLeafCount+rightLeafCount;
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
        System.out.println(numLeaf(root));
     }

    
}