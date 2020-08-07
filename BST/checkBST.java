/*
Binary tree is BST or not
 */
package BST;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import BinaryTree.BinaryTreeNode;

class BST{
    int min;
    int max;
    boolean IsBSTchecked;
    public BST(int min,int max,boolean IsBSTchecked){
        this.min=min;
        this.max=max;
        this.IsBSTchecked=IsBSTchecked;
    }
}

public class checkBST {
    private static BST isBST(BinaryTreeNode<Integer> root) {
       if(root==null){
           int min=Integer.MAX_VALUE;
           int max=Integer.MIN_VALUE;
           boolean IsBSTchecked=true;
           BST ans=new BST(min,max,IsBSTchecked);
           return ans;
       }
       BST leftOutput=isBST(root.left);
       BST rightOutput=isBST(root.right);
       boolean isTree=true;
       int max=Math.max(leftOutput.max, root.data);
       int min=Math.min(rightOutput.min,root.data);
       
       if(leftOutput.max>=root.data){
           isTree=false;
       }
       if(rightOutput.min<root.data){
           isTree=false;
       }
       if(!leftOutput.IsBSTchecked||!rightOutput.IsBSTchecked){
           isTree=false;
       }
       BST ans=new BST(min,max,isTree);
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
        System.out.println(isBST(root).IsBSTchecked);
     }
}