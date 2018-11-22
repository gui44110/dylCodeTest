package com.dyl.enumPackage;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/11/22 15:58
 */
public enum MyColor {

    READ(1,"2"),YELLOW(2,"2");

    MyColor(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    private int code;

    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
