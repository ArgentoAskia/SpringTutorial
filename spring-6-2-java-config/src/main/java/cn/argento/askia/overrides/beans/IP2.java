package cn.argento.askia.overrides.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class IP2 {
    // 具体IP
    private String ipStr;
    // 主机名
    private String host;
    // 子网掩码
    private String mark;

    public IP2(InetAddress address){
        this.host = address.getHostName();
        this.ipStr = address.getHostAddress();
        this.mark = "255.255.255.0";
    }

    public IP2() {
        this.ipStr = "127.0.0.1";
        this.host = "localhost";
        this.mark = "255.255.255.0";
    }
    private void init(String ipStr, String host, String mark){
        this.ipStr = ipStr;
        this.host = host;
        this.mark = mark;
    }
    public IP2(String full){
        String[] split = full.split(",");
        if (split.length == 1){
            split = full.split(" ");
        }
        if (split.length != 3){
            throw new IllegalArgumentException("full splitting result's length is not 3!");
        }
        init(split[0], split[1], split[2]);
    }

    public IP2(String ipStr, String host, String mark) {
        init(ipStr, host, mark);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("IP2{");
        sb.append("ipStr='").append(ipStr).append('\'');
        sb.append(", host='").append(host).append('\'');
        sb.append(", mark='").append(mark).append('\'');
        sb.append('}').append(hashCode());
        return sb.toString();
    }

    public String getIpStr() {
        return ipStr;
    }

    @Autowired
    public void setIpStr(@Value("10.0.1.79") String ipStr) {
        this.ipStr = ipStr;
    }

    public String getHost() {
        return host;
    }

    @Autowired
    public void setHost(@Value("10.0.1.79") String host) {
        this.host = host;
    }

    public String getMark() {
        return mark;
    }

    @Autowired
    public void setMark(@Value("255.255.255.0") String mark) {
        this.mark = mark;
    }
}
