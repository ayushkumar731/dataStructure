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
    private static BinaryTreeNode<Integer> takeInput(boolean isRoot,int data,boolean isLeft) {
        if(isRoot){
            System.out.println("Enter the parentData");
        }else{
            if(isLeft){
                System.out.println("Enter the left child of :"+data);
            }else{
             System.out.println("Enter the right child of :"+data);
            }
        }
        Scanner s=new Scanner(System.in);
        int rootData=s.nextInt();
        if(rootData==-1){
             return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> left=takeInput(false, rootData,true);
        BinaryTreeNode<Integer> right=takeInput(false, rootData,false);
        root.left=left;
        root.right=right;
        return root;
     }
     public static void main(String[] args) {
         BinaryTreeNode<Integer> root=takeInput(true,0,true);
        System.out.println(diameter(root).diameter);
     }
}