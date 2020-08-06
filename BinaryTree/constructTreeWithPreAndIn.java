/**
 Construct Tree Using Inorder and Preorder
Send Feedback
Given Preorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
Note: Assume binary tree contains only unique elements.
Input format :

Line 1 : n (Total number of nodes in binary tree)

Line 2 : Pre order traversal

Line 3 : Inorder Traversal

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
12
1 2 3 4 15 5 6 7 8 10 9 12
4 15 3 2 5 1 6 10 8 7 9 12
Sample Output :
1:L:2,R:6
2:L:3,R:5
6:L:-1,R:7
3:L:4,R:-1
5:L:-1,R:-1
7:L:8,R:9
4:L:-1,R:15
8:L:10,R:-1
9:L:-1,R:12
15:L:-1,R:-1
10:L:-1,R:-1
12:L:-1,R:-1
 */
package BinaryTree;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class constructTreeWithPreAndIn {
    private static BinaryTreeNode<Integer> helper(int siPre, int eiPre, int siIn, int eiIn, int[] pre, int[] in) {
        if(siPre>eiPre||siIn>eiIn){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(pre[siPre]);
        int rootIndex=0;
        for(int i=0;i<=eiIn;i++){
            if(in[i]==root.data){
                rootIndex=i;
                break;
            }
        }
        int leftInStart=siIn;
        int leftInEnd=rootIndex-1;
        int rightInStart=rootIndex+1;
        int rightInEnd=eiIn;

        int leftPreStart=siPre+1;
        int rightPreEnd=eiPre;

        int length=leftInEnd-leftInStart+1;
        int leftPreEnd=leftPreStart+length-1;
        int rightPreStart=leftPreEnd+1;
        BinaryTreeNode<Integer> left=helper(leftPreStart, leftPreEnd, leftInStart, leftInEnd, pre, in);
        BinaryTreeNode<Integer> right=helper(rightPreStart, rightPreEnd, rightInStart, rightInEnd, pre, in);
        root.left=left;
        root.right=right;
        return root;
    }
    private static BinaryTreeNode<Integer> constructTreePreAndIn(int[] pre, int[] in) {
        return helper(0,pre.length-1,0,in.length-1,pre,in);
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
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] pre=new int[n];
        for(int i=0;i<n;i++){
            pre[i]=s.nextInt();
        }
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            in[i]=s.nextInt();
        }
        BinaryTreeNode<Integer> root=constructTreePreAndIn(pre,in);
        print(root);
    }
}