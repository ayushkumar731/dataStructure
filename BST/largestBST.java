/*
Largest BST
Send Feedback
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree.
Return the height of largest BST.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2
*/
package BST;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import BinaryTree.BinaryTreeNode;

class minMax{
    int min;
    int max;
    boolean isBst;
    public minMax(int min,int max,boolean isBst){
        this.min=min;
        this.max=max;
        this.isBst=isBst;
    }
}

public class largestBST {
    private static int height(BinaryTreeNode<Integer> root) {
		if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    private static minMax isBST(BinaryTreeNode<Integer> root) {
        if(root==null){
            minMax ans=new minMax(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
            return ans;
        }
        minMax leftOutput=isBST(root.left);
        minMax rightOutput=isBST(root.right);
        boolean isTree=true;
        int max=Math.max(leftOutput.max, root.data);
        int min=Math.min(rightOutput.min,root.data);
        
        if(leftOutput.max>=root.data){
            isTree=false;
        }
        if(rightOutput.min<root.data){
            isTree=false;
        }
        if(!leftOutput.isBst||!rightOutput.isBst){
            isTree=false;
        }
        minMax ans=new minMax(min,max,isTree);
        return ans;
    }
    private static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        if(isBST(root).isBst){
            return height(root);
        }else{
            return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
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
         System.out.println(largestBSTSubtree(root));
     }
}