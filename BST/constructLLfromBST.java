/*
BST to LL

Given a BST, convert it into a sorted linked list. Return the head of LL.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Linked list elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output :
2 5 6 7 8 10
 */
package BST;
import BinaryTree.BinaryTreeNode;
import linkedList.Node;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class constructLLfromBST {
    private static Node<Integer> constructLL(BinaryTreeNode<Integer> root) {
        if(root==null){
            return null;
        }
        Node<Integer> leftHead=constructLL(root.left);
        Node<Integer> head=new Node<Integer>(root.data);
        Node<Integer> rightHead=constructLL(root.right);

        Node<Integer> leftTail=null;
        if(leftHead!=null){
            leftTail=leftHead;
            while(leftTail.next!=null){
                leftTail=leftTail.next;
            }
            leftTail.next=head;
            head.next=rightHead;
            return leftHead;
        }else{
            head.next=rightHead;
            return head;
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
         Node<Integer> head= constructLL(root);
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
     }
}