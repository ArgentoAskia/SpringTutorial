package cn.argento.askia.awares.bean;

import cn.argento.askia.bean.User4;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class UserBeanNameAwareDemo extends User4 implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName被执行了...");
        System.out.println("beanName:" + name);
    }

    public UserBeanNameAwareDemo(){
        super();
    }

    public UserBeanNameAwareDemo(Integer id, String name, String address, int age, Date birthday, LocalDateTime upload) {
        super(id, name, address, age, birthday, upload);
    }
}
