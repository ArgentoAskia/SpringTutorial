package cn.argentoaskia.factory;

import cn.argentoaskia.beans.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class UserObjectFactory {

    public User createUser(){
        User user = new User();
        user.setAddress("对象工厂创建")
                .setAge(25)
                .setBirthday(new Date())
                .setId(3)
                .setName("张三-对象工厂创建")
                .setUpload(LocalDateTime.now());
        return user;
    }
}
