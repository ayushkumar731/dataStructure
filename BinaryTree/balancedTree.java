package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BinaryTreeBalanced{
    int height;
    boolean isBalanaced;
    public BinaryTreeBalanced(int height,boolean isBalanaced){
        this.height=height;
        this.isBalanaced=isBalanaced;
    }
}
public class balancedTree {
    private static BinaryTreeBalanced isBalancedTree(BinaryTreeNode<Integer> root) {
        if(root==null){
            int height=0;
            boolean isBal=true;
            BinaryTreeBalanced ans=new BinaryTreeBalanced(height,isBal);
            return ans;
        }
        BinaryTreeBalanced leftOutput=isBalancedTree(root.left);
        BinaryTreeBalanced rightOutput=isBalancedTree(root.right);
        boolean isBal=true;
        int height=Math.max(leftOutput.height,rightOutput.height)+1;
        if(Math.abs(leftOutput.height-rightOutput.height)>1){
            isBal=false;
        }
       if(!leftOutput.isBalanaced || !rightOutput.isBalanaced){
           isBal=false;
       }
       BinaryTreeBalanced ans=new BinaryTreeBalanced(height,isBal);
       return ans;

        
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
        System.out.println(isBalancedTree(root).isBalanaced);
     }
}