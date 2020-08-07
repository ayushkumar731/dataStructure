/*
Replace with Sum of greater nodes
Send Feedback
Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
You don't need to return or print, just change the data of each node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output format : Elements are printed in level order wise, every level in new line

Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25 
 */
package BST;
import BinaryTree.BinaryTreeNode;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class replaceWithLargerNodesSum {
    
    private static int helper(BinaryTreeNode<Integer> root, int sum) {
        if(root==null){
            return sum;
        }
        if(root.left==null&&root.right==null){
            root.data=root.data+sum;
            return root.data;
        }
        int right=helper(root.right,sum);
        right=root.data+right;
        root.data=right;
        int left=helper(root.left, right);
        return left;
    }
    private static void replaceWithLargerNodesSuminBST(BinaryTreeNode<Integer> root) {
        helper(root,0);
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
     public static void main(String[] args) {
         BinaryTreeNode<Integer> root=takeInput();
          replaceWithLargerNodesSuminBST(root);
          printLevelOrderTraversal(root);
     }
}