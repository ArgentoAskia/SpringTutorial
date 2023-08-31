package cn.argentoaskia.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

// 1.可以通过指定value属性的方式给bean起名（相当于beans标签的id值），默认以类名首字母小写的名称作为id。
// 在翻阅了各大论坛还有文档之后，暂时不知道如何通过注解的方式给对象起多个名称。
@Component
public class User2 {
    private Integer id;
    private String name;
    private String address;
    private int age;
    private Date birthday;
    private LocalDateTime upload;

    public User2() {
        this.id = -1;
        this.name = "uname";
        this.address = "none";
        this.age = 0;
        this.birthday = null;
        this.upload = LocalDateTime.of(1970, 1, 1, 0, 0,0);
    }

    @Autowired
    public User2(@Value("20") Integer id,
                 @Value("Susan") String name,
                 @Value("北京市") String address,
                 @Value("99") int age,
                 @Autowired Date birthday,
                 @Autowired LocalDateTime upload) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.birthday = birthday;
        this.upload = upload;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", upload=").append(upload);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public User2 setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User2 setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User2 setAge(int age) {
        this.age = age;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User2 setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public LocalDateTime getUpload() {
        return upload;
    }

    public User2 setUpload(LocalDateTime upload) {
        this.upload = upload;
        return this;
    }
}
