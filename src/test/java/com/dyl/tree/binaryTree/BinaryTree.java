package com.dyl.tree.binaryTree;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

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

    public static void printNode(Node node){
        System.out.println(node.getData());
    }

    /**
     * 前序遍历方法
     * @param node
     */
    public static void theFirstTraversal(Node node){
        printNode(node);

        if(node.getLeftNode()!=null){
            theFirstTraversal(node.getLeftNode());
        }

        if(node.getRightNode()!=null){
            theFirstTraversal(node.getRightNode());
        }

    }

    /**
     * 前序遍历 不使用递归的方式，实用stack的方式
     * @param node
     */
    public static void theFirstTraversalStack(Node node){
        Stack<Node> stack = new Stack<>();
        Node root = node;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                System.out.print(root.getData() +" ");
                stack.push(root);
                root = root.getLeftNode();
            }
            if(!stack.isEmpty()){
                Node pop = stack.pop();
                root = pop.getRightNode();
            }
        }
    }


    public static void test(Node node){
        Stack<Node> stack = new Stack<>();
        Node root = node;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeftNode();
            }
            if(!stack.isEmpty()){
                Node pop = stack.pop();
                root = pop.getRightNode();
            }
        }

    }

    /**
     * 前序遍历的结果应该是 6，3，1，2，5，4，9，7，8
     */
    @Test
    public void testTheFirstTraversal(){
        Node init = init();
        test(init);
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
     * 中序遍历
     * @param node
     */
    public void theMidTraversalStack(Node node){
        Stack<Node> stack = new Stack<>();
        Node root = node;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.getLeftNode();
            }
            if(!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.println(pop.getData());
                root = pop.getRightNode();
            }
        }
    }

    public void practiseMid(Node node){
        Stack<Node> stack = new Stack<>();
        Node root = node;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.getLeftNode();
            }
            if(!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.println(pop.getData());
                root = pop.getRightNode();
            }
        }
    }
    @Test
    public void testTheMidTraversal(){
        Node init = init();
        practiseMid(init);
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

    @Test
    public void testTheLast(){
        Node init = init();
        theLastTraversal(init);
    }



    public void level(Node node){
        LinkedList<Node> queue = new LinkedList<>();
        Node root = node;
        queue.add(node);
        while (!queue.isEmpty()){
            Node pop = queue.pop();
            System.out.println(pop.getData());
            if(pop.getLeftNode()!=null){
                queue.add(pop.getLeftNode());
            }
            if(pop.getRightNode()!=null){
                queue.add(pop.getRightNode());
            }
        }
    }

    @Test
    public void testLevel(){
        Node init = init();
        level(init);
    }


    static int a = 0;
    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        Node node = binaryTree.init();
//
//        System.out.println("-----前序遍历");
//        binaryTree.theFirstTraversal(node);
//        System.out.println("-----中序遍历");
//        binaryTree.theMidTraversal(node);
//        System.out.println("-----后序遍历");
//        binaryTree.theLastTraversal(node);
//
//        Thread.currentThread().interrupt();
//        if(Thread.interrupted()){
//            System.out.println(Thread.interrupted());
//        }else{
//            System.out.println(Thread.interrupted());
//        }
    int b = c();
        System.out.println(b);


    }

    public static int b(){
        return a ++ ;
    }

    public static int a(){
        return a --;
    }

    public static int c(){
        try{
            return b();
        }finally {
            return a();
        }
    }



}
