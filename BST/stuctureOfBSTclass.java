/*
BST Class

Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BSt or not. Return true or false.
2. insert -
Given an element, insert that element in the BST at the correct position. Assume unique elements will be given.
3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
wherer, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.
 */
package BST;
import BinaryTree.BinaryTreeNode;

class BSTDeleteReturn{
    BinaryTreeNode<Integer> root;
    boolean deleted;

    public BSTDeleteReturn(BinaryTreeNode<Integer> root,boolean deleted){
        this.root=root;
        this.deleted=deleted;
    }
}

class BSTconstruct{
    private BinaryTreeNode<Integer> root;
    private int size;

    private static int min(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int leftMin=min(root.left);
        int rightMin=min(root.right);
        return Math.min(root.data,Math.min(leftMin,rightMin));
    }
    private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root,int x){
        if(root==null){
            return new BSTDeleteReturn(null,false);
        }
        if(root.data<x){
            BSTDeleteReturn outputRight=deleteDataHelper(root.right,x);
            root.right=outputRight.root;
            outputRight.root=root;
            return outputRight;            
        }
        if(root.data>x){
            BSTDeleteReturn outputLeft=deleteDataHelper(root.left,x);
            root.left=outputLeft.root;
            outputLeft.root=root;
            return outputLeft;            
        }
        if(root.left==null&&root.right==null){
            return new BSTDeleteReturn(null,true);
        }
        if(root.left!=null&&root.right==null){
            return new BSTDeleteReturn(root.left,true);
        }
        if(root.left==null&&root.right!=null){
            return new BSTDeleteReturn(root.right,true);
        }
        int rightMin=min(root.right);
        root.data=rightMin;
        BSTDeleteReturn outputRight=deleteDataHelper(root.right,rightMin);
        root.right=outputRight.root;
        return new BSTDeleteReturn(root,true);
    }

    public boolean deleteData(int x){
        BSTDeleteReturn output=deleteDataHelper(root,x);
        root=output.root;
        if(output.deleted){
            size--;
        }
        return output.deleted;
    }
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int n) {
        if(root==null){
            BinaryTreeNode<Integer> newRoot=new BinaryTreeNode<Integer>(n);
            return newRoot;
        }
        if(root.data>n){
            root.left=insertHelper(root.left, n);
        }else{
            root.right=insertHelper(root.right, n);
        }
        return root;
    }
    public void insert(int n){
       root=insertHelper(root,n);
       size++;
    }
    public int size(){
        return size;
    }
    private static void printTreeHelper(BinaryTreeNode<Integer> node){
        if(node==null){
            return;
        }
        System.out.print(node.data+":");
        if(node.left!=null){
            System.out.print("L"+":"+node.left.data+",");
        }
        if(node.right!=null){
            System.out.print("R"+":"+node.right.data);
        }
        System.out.println();
        printTreeHelper(node.left);
        printTreeHelper(node.right);

    }
    public void printTree(){
        printTreeHelper(root);
    }

    private boolean searchHelper(BinaryTreeNode<Integer> root, int n) {
        if(root==null){
            return false;
        }
        if(root.data==n){
            return true;
        }
        if(root.data>n){
           return searchHelper(root.left,n);
        }else{
           return searchHelper(root.right, n);
        }
    }
    public boolean search(int n){
        return searchHelper(root,n);
    }
}
public class stuctureOfBSTclass {
    
    public static void main(String[] args) {
        BSTconstruct b=new BSTconstruct();
        b.insert(5);
        b.insert(1);
        b.insert(2);
        b.insert(10);
        b.insert(8);
        b.insert(4);
        b.insert(7);
        b.insert(6);
        b.insert(2);
        
        System.out.println(b.size());
        b.printTree();
        System.out.println(b.deleteData(7));
        System.out.println(b.size());
        b.printTree();
    }

}