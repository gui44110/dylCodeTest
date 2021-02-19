package com.dyl.sort.binaryTree;


/**
 * 二叉树结构的类
 */
public class BinaryTreePo {

    private int data;

    private BinaryTreePo leftBinaryTreePo;

    private BinaryTreePo rightBinaryTreePo;

    public BinaryTreePo(int data, BinaryTreePo leftBinaryTreePo, BinaryTreePo rightBinaryTreePo) {
        this.data = data;
        this.leftBinaryTreePo = leftBinaryTreePo;
        this.rightBinaryTreePo = rightBinaryTreePo;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreePo getLeftBinaryTreePo() {
        return leftBinaryTreePo;
    }

    public void setLeftBinaryTreePo(BinaryTreePo leftBinaryTreePo) {
        this.leftBinaryTreePo = leftBinaryTreePo;
    }

    public BinaryTreePo getRightBinaryTreePo() {
        return rightBinaryTreePo;
    }

    public void setRightBinaryTreePo(BinaryTreePo rightBinaryTreePo) {
        this.rightBinaryTreePo = rightBinaryTreePo;
    }
}
