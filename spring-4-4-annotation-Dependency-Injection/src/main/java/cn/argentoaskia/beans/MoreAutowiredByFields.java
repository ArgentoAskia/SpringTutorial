package cn.argentoaskia.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;
// 字段注入Demo
// @Value可以帮助注入字符串、数字、URI、URL、Enum、Locate、Date、字符串数组！
// @Autowired可以帮忙注入容器内的bean，不管类型是什么
// 并且这两个注解都可以标记在Setter、构造器、字段上！
// 配合SpringEL可以注入
@Component
public class MoreAutowiredByFields {
    // autowire request
    // 注入数组、List、Set等的自动收集
    // @Order排序问题
    // 直接类型满足于自动收集的先后顺序
    // Map<String, 对象类型>也会进行自动收集！
    // Optional包装类注入
    @Autowired
    @Qualifier("IP")
    private IP ip;
    // 亦可以标记该bean不是一定需要的
    @Autowired(required = false)
    @Qualifier("localDateTime")
    private LocalDateTime time;
    // 多个收集，使用@Order排序
    // Fruit是带顺序的！
    @Autowired
    private List<Fruit> fruits;
    @Autowired
    private IP[] friendlyIps;

    // 也可以直接注入现成的内容
    @Autowired
    private Set<Float> geos;

    // 当存在现成和收集的单个，Spring会如何选择？
    @Autowired
    private List<Date> dates;

    // key=bean id value=IP Object
    @Autowired
    private Map<String, IP> mapperNames;

    // 支持自动注入Optional包装
    @Autowired
    @Qualifier("ip1")
    private Optional<IP> optionalIP;


    // 泛型嵌套泛型
    @Autowired
    private List<Generics<String>> genericsList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MoreAutowiredByFields{");
        sb.append("ip=").append(ip);
        sb.append(", time=").append(time);
        sb.append(", fruits=").append(fruits);
        sb.append(", friendlyIps=").append(friendlyIps == null ? "null" : Arrays.asList(friendlyIps).toString());
        sb.append(", geos=").append(geos);
        sb.append(", dates=").append(dates);
        sb.append(", mapperNames=").append(mapperNames);
        sb.append(", optionalIP=").append(optionalIP);
        sb.append(", genericsList=").append(genericsList);
        sb.append('}');
        return sb.toString();
    }
}
