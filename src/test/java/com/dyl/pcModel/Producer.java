package com.dyl.pcModel;

public class Producer  implements  Runnable{

    private Resource resource;
    public Producer(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.produce();
        }
    }
}
