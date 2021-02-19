package com.dyl.sort.binaryTree;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树前序，中序，后序遍历方法
 */
public class BinaryTreeTraversal {


    /**
     * 初始化Node
     * @return
     */
    public BinaryTreePo init(){
        BinaryTreePo I = new BinaryTreePo(8,null,null);
        BinaryTreePo H = new BinaryTreePo(4,null,null);
        BinaryTreePo G = new BinaryTreePo(2,null,null);
        BinaryTreePo F = new BinaryTreePo(7,null,I);
        BinaryTreePo E = new BinaryTreePo(5,H,null);
        BinaryTreePo D = new BinaryTreePo(1,null,G);
        BinaryTreePo C = new BinaryTreePo(9,F,null);
        BinaryTreePo B = new BinaryTreePo(3,D,E);
        BinaryTreePo A = new BinaryTreePo(6,B,C);
        return A;

    }

    public static void printNode(BinaryTreePo binaryTreePo){
        System.out.println(binaryTreePo.getData());
    }

    /**
     * 前序遍历方法
     * @param binaryTreePo
     */
    public static void theFirstTraversal(BinaryTreePo binaryTreePo){
        printNode(binaryTreePo);

        if(binaryTreePo.getLeftBinaryTreePo()!=null){
            theFirstTraversal(binaryTreePo.getLeftBinaryTreePo());
        }

        if(binaryTreePo.getRightBinaryTreePo()!=null){
            theFirstTraversal(binaryTreePo.getRightBinaryTreePo());
        }

    }

    /**
     * 前序遍历 不使用递归的方式，实用stack的方式
     * @param binaryTreePo
     */
    public static void theFirstTraversalStack(BinaryTreePo binaryTreePo){
        Stack<BinaryTreePo> stack = new Stack<>();
        BinaryTreePo root = binaryTreePo;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                System.out.print(root.getData() +" ");
                stack.push(root);
                root = root.getLeftBinaryTreePo();
            }
            if(!stack.isEmpty()){
                BinaryTreePo pop = stack.pop();
                root = pop.getRightBinaryTreePo();
            }
        }
    }


    public static void test(BinaryTreePo binaryTreePo){
        Stack<BinaryTreePo> stack = new Stack<>();
        BinaryTreePo root = binaryTreePo;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeftBinaryTreePo();
            }
            if(!stack.isEmpty()){
                BinaryTreePo pop = stack.pop();
                root = pop.getRightBinaryTreePo();
            }
        }

    }

    /**
     * 前序遍历的结果应该是 6，3，1，2，5，4，9，7，8
     */
    @Test
    public void testTheFirstTraversal(){
        BinaryTreePo init = init();
        test(init);
    }

    /**
     * 中序遍历
     */
    public void theMidTraversal(BinaryTreePo binaryTreePo){
        if(binaryTreePo.getLeftBinaryTreePo()!=null){
            theMidTraversal(binaryTreePo.getLeftBinaryTreePo());
        }

        printNode(binaryTreePo);

        if(binaryTreePo.getRightBinaryTreePo() != null){
            theMidTraversal(binaryTreePo.getRightBinaryTreePo());
        }

    }

    /**
     * 中序遍历
     * @param binaryTreePo
     */
    public void theMidTraversalStack(BinaryTreePo binaryTreePo){
        Stack<BinaryTreePo> stack = new Stack<>();
        BinaryTreePo root = binaryTreePo;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.getLeftBinaryTreePo();
            }
            if(!stack.isEmpty()){
                BinaryTreePo pop = stack.pop();
                System.out.println(pop.getData());
                root = pop.getRightBinaryTreePo();
            }
        }
    }

    public void practiseMid(BinaryTreePo binaryTreePo){
        Stack<BinaryTreePo> stack = new Stack<>();
        BinaryTreePo root = binaryTreePo;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.getLeftBinaryTreePo();
            }
            if(!stack.isEmpty()){
                BinaryTreePo pop = stack.pop();
                System.out.println(pop.getData());
                root = pop.getRightBinaryTreePo();
            }
        }
    }
    @Test
    public void testTheMidTraversal(){
        BinaryTreePo init = init();
        practiseMid(init);
    }


    /**
     * 后序遍历
     */
    public void theLastTraversal(BinaryTreePo binaryTreePo){
        if(binaryTreePo.getLeftBinaryTreePo() != null){
            theLastTraversal(binaryTreePo.getLeftBinaryTreePo());
        }
        if(binaryTreePo.getRightBinaryTreePo() != null){
            theLastTraversal(binaryTreePo.getRightBinaryTreePo());
        }

        printNode(binaryTreePo);
    }

    public void testTheLast(){
        BinaryTreePo init = init();
        theLastTraversal(init);
    }



    public void level(BinaryTreePo binaryTreePo){
        LinkedList<BinaryTreePo> queue = new LinkedList<>();
        BinaryTreePo root = binaryTreePo;
        queue.add(binaryTreePo);
        while (!queue.isEmpty()){
            BinaryTreePo pop = queue.pop();
            System.out.println(pop.getData());
            if(pop.getLeftBinaryTreePo()!=null){
                queue.add(pop.getLeftBinaryTreePo());
            }
            if(pop.getRightBinaryTreePo()!=null){
                queue.add(pop.getRightBinaryTreePo());
            }
        }
    }

    @Test
    public void testLevel(){
        BinaryTreePo init = init();
        level(init);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        BinaryTreePo binaryTreePo = binaryTreeTraversal.init();

        System.out.println("-----前序遍历");
        binaryTreeTraversal.theFirstTraversal(binaryTreePo);
        System.out.println("-----中序遍历");
        binaryTreeTraversal.theMidTraversal(binaryTreePo);
        System.out.println("-----后序遍历");
        binaryTreeTraversal.theLastTraversal(binaryTreePo);
    }


}
