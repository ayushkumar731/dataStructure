/*
Construct Tree Using Inorder and PostOrder

Given Postorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
Note: Assume binary tree contains only unique elements.
Input format :

Line 1 : n (Total number of nodes in binary tree)

Line 2 : Post order traversal

Line 3 : Inorder Traversal

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
8
8 4 5 2 6 7 3 1
4 8 2 5 1 6 3 7
Sample Output :
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:8
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1
8:L:-1,R:-1
 */
package BinaryTree;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class constructTreeWithInAndPost {
    private static BinaryTreeNode<Integer> helper(int siPost, int eiPost, int siIn, int eiIn, int[] post, int[] in) {
        if(siPost>eiPost||siIn>eiIn){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(post[eiPost]);
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

        int leftPostStart=siPost;
        int rightPostEnd=eiPost-1;

        int length=leftInEnd-leftInStart+1;
        int leftPostEnd=leftPostStart+length-1;
        int rightPostStart=leftPostEnd+1;
        BinaryTreeNode<Integer> left=helper(leftPostStart, leftPostEnd, leftInStart, leftInEnd, post, in);
        BinaryTreeNode<Integer> right=helper(rightPostStart, rightPostEnd, rightInStart, rightInEnd, post, in);
        root.left=left;
        root.right=right;
        return root;
    }
    private static BinaryTreeNode<Integer> constructTreePostAndIn(int[] post, int[] in) {
        return helper(0,post.length-1,0,in.length-1,post,in);
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
        int[] post=new int[n];
        for(int i=0;i<n;i++){
            post[i]=s.nextInt();
        }
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            in[i]=s.nextInt();
        }
        BinaryTreeNode<Integer> root=constructTreePostAndIn(post,in);
        print(root);
    }
}