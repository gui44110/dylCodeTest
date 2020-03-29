package com.dyl.tree.binaryTree;


/**
 * 二叉树前序，中序，后序遍历方法
 */
public class BinaryTree {


    /**
     * 初始化Node
     * @return
     */
    public Node init(){
        Node I = new Node(8,null,null);
        Node H = new Node(4,null,null);
        Node G = new Node(2,null,null);
        Node F = new Node(7,null,I);
        Node E = new Node(5,H,null);
        Node D = new Node(1,null,G);
        Node C = new Node(9,F,null);
        Node B = new Node(3,D,E);
        Node A = new Node(6,B,C);
        return A;

    }

    public void printNode(Node node){
        System.out.println(node.getData());
    }

    /**
     * 前序遍历方法
     * @param node
     */
    public void theFirstTraversal(Node node){
        printNode(node);

        if(node.getLeftNode()!=null){
            theFirstTraversal(node.getLeftNode());
        }

        if(node.getRightNode()!=null){
            theFirstTraversal(node.getRightNode());
        }

    }

    /**
     * 中序遍历
     */
    public void theMidTraversal(Node node){
        if(node.getLeftNode()!=null){
            theMidTraversal(node.getLeftNode());
        }

        printNode(node);

        if(node.getRightNode() != null){
            theMidTraversal(node.getRightNode());
        }
    }

    /**
     * 后序遍历
     */
    public void theLastTraversal(Node node){
        if(node.getLeftNode() != null){
            theLastTraversal(node.getLeftNode());
        }
        if(node.getRightNode() != null){
            theLastTraversal(node.getRightNode());
        }

        printNode(node);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node = binaryTree.init();

        System.out.println("-----前序遍历");
        binaryTree.theFirstTraversal(node);
        System.out.println("-----中序遍历");
        binaryTree.theMidTraversal(node);
        System.out.println("-----后序遍历");
        binaryTree.theLastTraversal(node);
    }



}
