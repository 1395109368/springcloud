package com.song.enuma;

/**
 * @Auther: sf
 * @Date: 2020/8/22
 * @version: 1.0
 * hah
 */
public enum EnumTest {
    firstError("200","状态正常"),
    secondError("404","访问路径不正确"),
    thirdError("500","资源不存在");

    public static void main(String[] args) {
        System.out.println(EnumTest.secondError.getValue());


    }


    private String key;
    private String value;
    EnumTest(String key,String value){
        this.key=key;
        this.value=value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
