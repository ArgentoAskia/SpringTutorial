package cn.argentoaskia.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Indexed;

import java.util.*;
public class User {
    private String name;
    private Integer age;
    private String address;
    private double weight;
    private IP ip;
    private List<String> friends;
    private IP[] friendlyIps;
    private Set<Float> geos;
    private Map<String, Object> mapperNames;
    private Properties backupsProperties;

    // 更加变态的嵌套
    private Set<Double[]> lastGeos;
    private Map<String, Double[]> lastGeosWithName;


    @Override
    public String toString() {
        return "User{" + ",\n" +
                "  name = '" + name + '\'' + ",\n" +
                "  age = " + age + ",\n" +
                "  address = '" + address + '\'' + ",\n" +
                "  weight = " + weight + ",\n" +
                "  ip = " + ip + ",\n" +
                "  friends = " + friends + ",\n" +
                "  friendlyIps = " + Arrays.toString(friendlyIps) + ",\n" +
                "  geos = " + geos + ",\n" +
                "  mapperNames = " + mapperNames + ",\n" +
                "  backupsProperties = " + backupsProperties + ",\n" +
                "  lastGeos = " + travelSet() + ",\n" +
                "  lastGeosWithName = " + travelLastGeosWithName() + "\n" +
                '}';
    }
    private String travelSet(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append("\n");
        Iterator<Double[]> iterator = lastGeos.iterator();
        while(iterator.hasNext()){
            Double[] next = iterator.next();
            String s = Arrays.toString(next);
            stringBuilder.append("    ").append(s).append(",").append("\n");
        }
        stringBuilder.append("  ]");
        return stringBuilder.toString();
    }
    private String travelLastGeosWithName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("\n");
        Iterator<String> set = lastGeosWithName.keySet().iterator();
        while(set.hasNext()){
            String next = set.next();
            Double[] doubles = lastGeosWithName.get(next);
            String s = Arrays.toString(doubles);
            stringBuilder.append("    ").append(next).append("=").append(s).append(",").append("\n");
        }
        stringBuilder.append("  }");
        return stringBuilder.toString();
    }

    public void setLastGeos(Set<Double[]> lastGeos) {
        this.lastGeos = lastGeos;
    }

    public void setLastGeosWithName(Map<String, Double[]> lastGeosWithName) {
        this.lastGeosWithName = lastGeosWithName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public IP getIp() {
        return ip;
    }

    public void setIp(IP ip) {
        this.ip = ip;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public IP[] getFriendlyIps() {
        return friendlyIps;
    }

    public void setFriendlyIps(IP[] friendlyIps) {
        this.friendlyIps = friendlyIps;
    }

    public Set<Float> getGeos() {
        return geos;
    }

    public void setGeos(Set<Float> geos) {
        this.geos = geos;
    }

    public Map<String, Object> getMapperNames() {
        return mapperNames;
    }

    public void setMapperNames(Map<String, Object> mapperNames) {
        this.mapperNames = mapperNames;
    }

    public Properties getBackupsProperties() {
        return backupsProperties;
    }

    public void setBackupsProperties(Properties backupsProperties) {
        this.backupsProperties = backupsProperties;
    }
}
