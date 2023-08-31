package cn.argentoaskia.callback;

import cn.argentoaskia.bean.User3;

public class User3AutoCloseXMLLifeCycleCallback extends User3 implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("4.1.通过指定destroy-method属性为：(inferred)，可以实现自动关闭，而不需要写具体方法名。");
        System.out.println("4.2.这种方式会让spring默认情况下调用close方法或者shutdown方法");
        System.out.println("4.3.因此可以考虑在实现了Closeable或者AutoCloseable的类上使用！");
    }

    public void init(){
        System.out.println("4.正常初始化方法...");
    }
}
