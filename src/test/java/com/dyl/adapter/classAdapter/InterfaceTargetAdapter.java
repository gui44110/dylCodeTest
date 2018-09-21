package com.dyl.adapter.classAdapter;

public class InterfaceTargetAdapter extends InterfaceAdapter {
    public void a() {
        System.out.println("仅仅想实线a的方法，别的不想实现");
    }

    public void b() {

    }

    public void c() {

    }

    public static void main(String[] args) {
        InterfaceC interfaceC = new InterfaceTargetAdapter();

        interfaceC.a();
    }
}
