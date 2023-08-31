package cn.argentoaskia.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Company {
    private Integer id;
    private String name;
    private Date birthday;
    private Integer times;

    public Company() {
        this.id = 0;
        this.name = "unknown";
        this.birthday = new Date(0);
        this.times = 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Company{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", times=").append(times);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public Company setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Company setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Integer getTimes() {
        return times;
    }

    public Company setTimes(Integer times) {
        this.times = times;
        return this;
    }
}
