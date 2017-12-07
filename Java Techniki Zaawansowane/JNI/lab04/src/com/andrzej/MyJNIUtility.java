package com.andrzej;

public class MyJNIUtility {
    //static {System.load("myUtility");}
    //public native String getData();
    public native int getProcessWorkingSet();
    public native int getProcessVMSize();
}
