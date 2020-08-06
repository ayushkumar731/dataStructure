/**
 Create & Insert Duplicate Node
Send Feedback
Given a Binary Tree with N number of nodes, for each node create a new duplicate node, and insert that duplicate as left child of the original node.
Note : Root will remain same. So you just need to insert nodes in the given Binary Tree and no need to print or return anything.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Level order traversal of updated tree. (Every level in new line)
Constraints :
1 <= N <= 1000
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output :
8:L:8,R:10
8:L:5,R:-1
10:L:10,R:-1
5:L:5,R:6
10:L:-1,R:-1
5:L:2,R:-1
6:L:6,R:7
2:L:2,R:-1
6:L:-1,R:-1
7:L:7,R:-1
2:L:-1,R:-1
7:L:-1,R:-1
 */
package BinaryTree;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class createAndDuplicate {
    private static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        BinaryTreeNode<Integer> temp=root.left;
        BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>(root.data);
        newNode.left=root.left;
        root.left=newNode;
        insertDuplicateNode(temp);
        insertDuplicateNode(root.right);

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
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInput();
        insertDuplicateNode(root);
        print(root);
    }
}