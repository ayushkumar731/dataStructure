/*
Construct BST

Given a sorted integer array A of size n which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
Note : If array size is even, take first mid as root.
Input format :
Line 1 : Integer n (Size of array)
Line 2 : Array elements (separated by space)
Output Format :
BST elements (in pre order traversal, separated by space)
Sample Input :
7
1 2 3 4 5 6 7
Sample Output :
4 2 1 3 6 5 7 
 */
package BST;
import java.util.Scanner;
import BinaryTree.BinaryTreeNode;
public class constructBSTfromArray {
    private static BinaryTreeNode<Integer> helper(int[] arr, int si, int ei) {
        if(si>ei){
            return null;
        }
        int m=(si+ei)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[m]);
        root.left=helper(arr,si,m-1);
        root.right=helper(arr, m+1, ei);
        return root;
    }
    private static BinaryTreeNode<Integer> constructBST(int[] arr) {
        return helper(arr,0,arr.length-1);
    }
    private static void print(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        BinaryTreeNode<Integer> root=constructBST(arr);
        print(root);
    }
}