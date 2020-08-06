/*
Diameter Of Binary Tree

Given a Binary Tree, find and return the diameter of input binary tree.
Diameter is - largest count of nodes between any two leaf nodes in the binary tree (both the leaf nodes are inclusive).
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
diameter
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
7                  
 */
package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class dia{
    int height;
    int diameter;
    public dia(int height,int diameter){
        this.height=height;
        this.diameter=diameter;
    }
}
public class diameterOfBinaryTree {
    
    private static dia diameter(BinaryTreeNode<Integer> root) {
        if(root==null){
            int height=0;
            int diameter=0;
            dia ans=new dia(height,diameter);
            return ans;
        }
        dia leftOutput=diameter(root.left);
        dia rightOutput=diameter(root.right);
        int height=Math.max(leftOutput.height,rightOutput.height)+1;
        int dia1=leftOutput.height+rightOutput.height+1;
        int dia2=leftOutput.diameter;
        int dia3=rightOutput.diameter;
        int diameter=Math.max(dia1, Math.max(dia2, dia3));
        dia ans=new dia(height,diameter);
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
        System.out.println(diameter(root).diameter);
     }
}