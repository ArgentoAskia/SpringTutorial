package cn.argentoaskia.beans;

public class IP {
    // 具体IP
    private String ipStr;
    // 主机名
    private String host;
    // 子网掩码
    private String mark;

    public IP() {
        this.ipStr = "127.0.0.1";
        this.host = "localhost";
        this.mark = "255.255.255.0";
    }

    public IP(String ipStr, String host, String mark) {
        this.ipStr = ipStr;
        this.host = host;
        this.mark = mark;
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
