package cn.argento.askia.bean;

import org.springframework.beans.factory.BeanNameAware;

public class User4WithBeanNameAware extends User4 implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName被执行了...");
        System.out.println("beanName:" + name);
    }
}
