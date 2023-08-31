## Bean Instantiation

本节介绍`Spring`中`Bean`的初始化方式，有三种（对应官方文档小节的内容紧跟后面）：

- 构造器初始化：[Instantiation with a Constructor](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-factory-class-ctor)
- 静态工厂初始化：[beans-factory-class-static-factory-method](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-factory-class-static-factory-method)
- 对象工厂初始化：[beans-factory-class-instance-factory-method](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-factory-class-instance-factory-method)

本节给出精简例子

### 构造器初始化

```xml
<bean id="account_askia" name="askia Askia" class="domain.AccountBean"/>
```

```java
// 上面的配置相当于调用了默认构造器
默认构造方法
 public AccountBean() {
        name = "uname";
        age = 0;
        address = "unknown";
 }
```

-------

补充：因为并未讲到`DI(Dependency Inject，也叫依赖注入)`，所以下面的该小节后面的内容暂时有个印象即可！

```xml
<bean id="account_zhangsan" name="zhangsan;ZhangSan;MR-ZHANG" class="domain.AccountBean">
        <constructor-arg name="address" value="广东省广州市创意峡谷A坐101"/>
        <constructor-arg name="age" value="30"/>
        <constructor-arg name="name" value="张三"/>
</bean>
```

```java
// 相当于调用了
public AccountBean(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
}
```

-----

```xml
 <bean id="account_xiaohong" name="xiaohong,XiaoHong,XIAOHONG" class="domain.AccountBean">
        <property name="address" value="广东省广州市创意峡谷A坐101"/>
        <property name="age" value="24"/>
        <property name="name" value="小红"/>
</bean>
```

```java
// 相当于调用了默认构造器 + Setter方法
默认构造方法
public AccountBean() {
        name = "uname";
        age = 0;
        address = "unknown";
}
 
public AccountBean setName(String name) {
        this.name = name;
        return this;
}
public AccountBean setAge(int age) {
        this.age = age;
        return this;
 }
 public AccountBean setAddress(String address) {
        this.address = address;
        return this;
 }
```

----

### 静态工厂初始化

```java
<bean id="now" class="java.time.LocalDateTime" factory-method="now"/>
```

```java
// 相当于调用了LocalDateTime.now()
LocalDateTime localDateTime = LocalDateTime.now();
System.out.println(localDateTime);
```

如果是自定义的类：![image-20230831224411818](README/image-20230831224411818.png)

则：

```xml
<bean id="beansFactory" name="factory" class="factory.BeansFactory" factory-method="getInstance"/>
```

### 对象工厂初始化

```xml
<!-- 对象工厂创建对象：
        factory-bean：工厂对象的id值
        factory-method：工厂方法
        不需要指定Class对象
  -->
<bean id="userObjectFactory" class="cn.argentoaskia.factory.UserObjectFactory"/>
<bean id="userByObjectFactory" factory-bean="userObjectFactory" factory-method="createUser"/>
```

![image-20230831224826442](README/image-20230831224826442.png)

## Nested class Instantiation

[官方文档参考](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-factory-class)

![image-20230831224953679](README/image-20230831224953679.png)

解释起来就是说，嵌套类`Bean`可以这样定义：

```
包名.类名.嵌套类
包名.类名$嵌套类
```

如下面的代码：

```java
package springdemo1;

public class Main {
	public static class Main2{

    }
}
```

如果希望定义`Main2`的`Bean`，可以这样：

```xml
<bean class="springdemo1.Main.Main2" id="main"/>
<bean class="springdemo1.Main$Main2" id="main"/>
```

## Annotation-based Instantiation

自`Spring 2.5`以后出现了基于注解形式的初始化方式来初始化对象，开启了所谓组件扫描时代（即`Spring`将所有注册到容器内的`Bean`都看成是一个个组件），这种组件扫描的方式使你更加简单地运用构造器初始化对象！

相关内容及官方参考文档引用：

- `annotation-config`配置：[annotation-config](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config.html)

- `@Component`及其扩展注解：[beans-stereotype-annotations](https://docs.spring.io/spring-framework/reference/core/beans/classpath-scanning.html#beans-stereotype-annotations)
- `Meta-annotation`（元注解）和`Composed Annotations`（组合注解）：[beans-meta-annotations](https://docs.spring.io/spring-framework/reference/core/beans/classpath-scanning.html#beans-meta-annotations)
- `Component-scan`(组件扫描)：[beans-scanning-autodetection](https://docs.spring.io/spring-framework/reference/core/beans/classpath-scanning.html#beans-scanning-autodetection)

### 组件及组件扫描

`Spring 2.5`添加了`@Component`用于标记组件和`@Autowire`注解进行依赖注入！

#### 组件

在一个类上标记`@Component`会将该类标记为组件，再经过`Spring`组件扫描之后，就会创建该类的单例对象（默认情况下调用默认构造器创建）放在容器内！

`@Component`有一个值`value`，标记该`Bean`的`id`值，默认情况下如果写该值则以类名首字母小写作为`id`值

```java
@Component("default")
public class User {
    private Integer id;
    private String name;
    private String address;
    private int age;
    private Date birthday;
    private LocalDateTime upload;

    public User() {
        this.id = -1;
        this.name = "uname";
        this.address = "none";
        this.age = 0;
        this.birthday = null;
        this.upload = LocalDateTime.of(1970, 1, 1, 0, 0,0);
    }
    // Setter 、Getter暂时省略
}
```

除了`@Component`之外，根据业务不同，还有很多基于`@Component`魔改的注解（再`web`开发中经常使用）

- `@Controller`：标记该`Bean`是`SpringMVC`中的控制器（类似于`Servlet`）
- `@Service`：标记该`Bean`是业务层的`Bean`
- `@Repository`：标记该`Bean`是数据层的`Bean`

他们的源代码如下（举`@Controller`例子，其他都一样的）：

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Controller {

   @AliasFor(annotation = Component.class)
   String value() default "";
}
```

其中标记了`@Component`，`Spring`会递归发现注解中的`@Component`，我们一般称这种基于某个注解创建出来的具备原来的注解相关能力的新注解为组合注解（`Composed Annotations`）！而类似于`@Component`这样的能够创建出新注解出来的注解被称之为元注解（`Meta-annotations`）

但这种划分并不唯一，因为组合注解也可以充当元注解的角色，例如：`@RestController`就是`@Controller`和`@ResponseBody`组合，但`@Controller`理应是一个组合注解。

`Spring`的所有注解及其扩展的组合注解都可以再次被组合！并且配合`@AliasFor`进行属性同步，如上面的

```java
 @AliasFor(annotation = Component.class)
```

他会将值赋给`Component`注解类中的`value`属性

#### 组件扫描

在标记完组件之后，则需要让`Spring`进行组件扫描来创建组件并放入容器内，需要在`XML`文件中加上下面两个配置：

```xml
<!--   spring 2.5新增，注解方式创建对象  -->
<!-- 往容器内注入注解处理器用来处理支持注解的方式初始化对象 -->
<context:annotation-config/>
<!-- 扫包操作，用于扫描所有的@Component注解并创建对象 -->
<!-- base-package属性指定要扫描的包及其子包！ -->
<context:component-scan base-package="cn.argentoaskia.beans"/>
```

`<context:annotation-config/>`的作用是自动往容器中注入下列`Bean`，添加一些特殊的支持：

- `ConfigurationClassPostProcessor`：处理`@Configuration`注解
- `AutowiredAnnotationBeanPostProcessor`：处理`@Autowired`注解
- `CommonAnnotationBeanPostProcessor`：`JSR-250`注解支持，如`@Resource`、`@PostConstruct`、`@PreDestroy`
- `PersistenceAnnotationBeanPostProcessor`：处理`@PersistenceContext`注解（一般用于`JPA`）
- `RequiredAnnotationBeanPostProcessor`：处理`@Required`

实际上无需特意加上`<context:annotation-config/> `，`<context:component-scan>`也会做`<context:annotation-config/> `的相关工作！

在`Spring 3.0`中，可以使用`@ComponentScan` 和`@Configuration`来代替这种`xml`形式的配置！

###  组件扫描的缺点

当然使用组件扫描也不是万能的，他确实使你不用写`bean`标签，只需要加个注解即可创建`Bean`，但是这种方式：

- 你无法通过标记多个`@Component`的方式创建多个对象，`@Component`注解并不支持重复标记来达到重复创建的功能
- 使用`@Component`不能实现工厂方式的初始化，无论是静态工厂还是对象工厂
- 使用`@Component`的前提是自己有`Bean`的源代码，因为需要标记在源代码上

基于这些缺点，`Spring 3.0`提出了`java-based`的配置方式，完全替代掉`xml`配置

## Java-based Instantiation

`spring 3.0`提出的基于`Java`代码形式的配置，完全替代了`xml`文件，其核心在于`@Bean`、`@Configuration`以及`@ComponentScan`

相关文档：

- `@ComponentScan`：[beans-scanning-autodetection](https://docs.spring.io/spring-framework/reference/core/beans/classpath-scanning.html#beans-scanning-autodetection)

- `@Configuration`：[basic-concepts](https://docs.spring.io/spring-framework/reference/core/beans/java/basic-concepts.html)
- `@Bean`：[beans-java-declaring-a-bean](https://docs.spring.io/spring-framework/reference/core/beans/java/bean-annotation.html#beans-java-declaring-a-bean)

### JavaConfig

`Spring 3.0`中，可以将`Java`类作为配置类代替传统`XML`，只需要在类上加上`@Configuration`注解即可！

同时使用`@ComponentScan`注解来标记待扫描的包，`@ComponentScan`注解也有`basePackage`用于指定包名，如果不写则默认使用`@ComponentScan`标记的类所在的包作为包名！

`@Bean`注解相当于`xml`中的`Bean`标签，`@Bean`提供了工厂初始化对象的支持，在一个方法上标记`@Bean`，`Spring`会将该方法的返回值存放在`Spring IoC`容器内，`@Bean`注解中有一个`name`属性，用于给`Bean`起名，默认使用方法名首字母小写作为`Bean`的名字

```java
@Configuration
@ComponentScan(basePackage = "cn.argentoaskia.beans")
public class SpringContext {

    @Bean
    public User userDefault(){
        System.out.println("userDefault方法执行了...");
        return new User();
    }

    @Bean
    public User user3(){
        System.out.println("user3方法执行了...");
        UserObjectFactory userObjectFactory = new UserObjectFactory();
        return userObjectFactory.createUser();
    }

    @Bean
    public User user4(){
        System.out.println("user4方法执行了...");
        return UserStaticFactory.createDefaultUser();
    }
}
```

