package com.dyl.adapter.classAdapter;

public class ClassAdapter extends ClassB implements InterfaceA {


    public void A() {
        this.B();
    }

    public static void main(String[] args) {
        InterfaceA interfaceA = new ClassAdapter();
        interfaceA.A();

    }
}
