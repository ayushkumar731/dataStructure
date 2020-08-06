/*
Min and max

Given a binary tree, find and return the min and max data value of given binary tree.
Return the output as an object of PairAns class, which is already created.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Max and min (separated by space)
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
14 1
 */
package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class pair{
    int min;
    int max;
    public pair(int min,int max){
        this.min=min;
        this.max=max;
    }
}
public class minAndMax {
    private static pair minMax(BinaryTreeNode<Integer> root) {
        if(root==null){
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            pair ans=new pair(min,max);
            return ans;
        }
        pair left=minMax(root.left);
        pair right=minMax(root.right);

        int leftMin=left.min;
        int rightMin=right.min;
        int leftMax=left.max;
        int rightMax=right.max;
        
        int min=Math.min(root.data,Math.min(leftMin, rightMin));
        int max=Math.max(root.data, Math.max(leftMax, rightMax));
        pair ans=new pair(min,max);
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
        pair ans=minMax(root);
        System.out.print(ans.max+" "+ans.min);
        
    }
}