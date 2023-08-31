package cn.argento.askia.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class IP {
    // 具体IP
    private String ipStr;
    // 主机名
    private String host;
    // 子网掩码
    private String mark;

    public IP(InetAddress address){
        this.host = address.getHostName();
        this.ipStr = address.getHostAddress();
        this.mark = "255.255.255.0";
    }

    @Autowired
    public IP() {
        this.ipStr = "127.0.0.1";
        this.host = "localhost";
        this.mark = "255.255.255.0";
    }
    private void init(String ipStr, String host, String mark){
        this.ipStr = ipStr;
        this.host = host;
        this.mark = mark;
    }
    public IP(String full){
        String[] split = full.split(",");
        if (split.length == 1){
            split = full.split(" ");
        }
        if (split.length != 3){
            throw new IllegalArgumentException("full splitting result's length is not 3!");
        }
        init(split[0], split[1], split[2]);
    }

    public IP(String ipStr, String host, String mark) {
        init(ipStr, host, mark);
    }

    @Override
    public String toString() {
        return "IP{" +
                "ipStr='" + ipStr + '\'' +
                ", host='" + host + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    public String getIpStr() {
        return ipStr;
    }

    public void setIpStr(String ipStr) {
        this.ipStr = ipStr;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
