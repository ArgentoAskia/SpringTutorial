package cn.argento.askia.beans2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class User {
    private Integer id;
    private String name;
    private Date birthday;
    private LocalDateTime upload;

    public User() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User="+ super.toString() +"{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", upload=").append(upload);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    @Autowired
    public User setId(@Value("123") Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }


    @Autowired
    public User setName(@Value("Askia") String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Autowired
    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public LocalDateTime getUpload() {
        return upload;
    }

    @Autowired
    public User setUpload(LocalDateTime upload) {
        this.upload = upload;
        return this;
    }
}
