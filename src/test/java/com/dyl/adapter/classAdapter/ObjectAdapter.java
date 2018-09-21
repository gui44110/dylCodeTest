package com.dyl.adapter.classAdapter;

public class ObjectAdapter implements InterfaceA{

    private ClassB b;

    public ObjectAdapter(ClassB b){
        this.b = b;
    }
    public void A() {
        b.B();
    }

    public static void main(String[] args) {
        ClassB b = new ClassB();
        InterfaceA interfaceA = new ObjectAdapter(b);
        interfaceA.A();
    }
}
