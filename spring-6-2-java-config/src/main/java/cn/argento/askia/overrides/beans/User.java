package cn.argento.askia.overrides.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 该类展示了构造器注入、@Bean对象、字段注入、Setter注入的顺序
 */
@Component
public class User {

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ip=").append(ip4);
        sb.append(", ip2=").append(ip2);
        sb.append(", ip3=").append(ip3);
        sb.append('}').append(hashCode());
        return sb.toString();
    }

    @Value("Askia2")
    private String name;

    @Autowired
    private IP ip4;

    @Autowired
    private IP2 ip2;

    @Autowired
    @Qualifier("IP3")
    private IP3 ip3;


    @Autowired
    public User(@Value("Askia1") String name, IP ip) {
        this.name = name;
        this.ip4 = ip;
    }

    public String getName() {
        return name;
    }

    @Value("Askia4")
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public IP getIp() {
        return ip4;
    }

    @Autowired
    public User setIp(IP ip) {
        this.ip4 = ip;
        return this;
    }
}
