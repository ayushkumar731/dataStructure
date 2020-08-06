package BinaryTree;
import java.util.Scanner;
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
        System.out.println(isBalancedTree(root).isBalanaced);
     }
}