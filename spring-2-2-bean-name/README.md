## Bean name

关于`Bean Name`的相关内容请参考[spring-beans-bean-name](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-beanname)（`Naming Beans`小节），本小结内容基于该官方文档及部分补充！会分别标记补充内容！

### 具有多个名称的Bean

`Bean name`并不同于`Bean id`，`Bean id`是唯一的，而`Bean name`可以多个！

有些时候我们不希望一个`bean`只有一个名称，某些情况下期望能够给`bean`起一个别名，这个时候就需要使用到`name`属性，需要多个名称的时候，可以用`,`或者`;`或者`空格`进行分离：

```xml
<bean id=“container” class="springdemo1.SpringMoreContainer" name="container2;container3;container4"/> 

<bean id=“container” class="springdemo1.SpringMoreContainer" name="container2,container3,container4"/>

<bean id=“container” class="springdemo1.SpringMoreContainer" name="container2 container3 container4"/> 
```

在调用`getBean()`获取Bean的时候，可以使用`name`属性的名称而非`id`：

```java
applicationContext.getBean("container4");
applicationContext.getBean("container");
```

### 补充：匿名Bean

我们都知道往容器内注册的`Bean`一般都拥有一个`id`：

```xml
<bean id="containerDemo" class="springdemo1.SpringMoreContainer"></bean>
```

`getBean()`通过`id`来获取`Bean`！

但实际上，你甚至连`id`都可以不用写，直接写`class`，容器会自己生成一个唯一的名字给这个`Bean`，通常是`class`属性的名称加上`#X（X代表数字）`

```xml
<bean class="springdemo1.SpringMoreContainer"/>
<!-- 容器内会生成一个id为springdemo1.SpringMoreContainer#0的bean -->
```

如果存在多个这样的未定义`id`的`bean`标签，容器将会这样处理：

```xml
<bean class="springdemo1.SpringMoreContainer"/> --> springdemo1.SpringMoreContainer#0
<bean class="springdemo1.SpringMoreContainer"/> -->
springdemo1.SpringMoreContainer#1
```

你仍然可以使用`getBean()`来获取这种匿名的`bean`：

```java
applicationContext.getBean("springdemo1.SpringMoreContainer#0");
```

但是注意，**这种匿名的bean将不能被引用，如果某个bean在进行依赖注入时需要使用这个匿名的Bean，无法使用`ref`属性引用。**

同时如果存在多个这样的匿名且类型相同的Bean，如假设容器内已经 存在：

- springdemo1.SpringMoreContainer#0
- springdemo1.SpringMoreContainer#1
- springdemo1.SpringMoreContainer#2

这样使用getBean()：

```java
applicationContext.getBean("springdemo1.SpringMoreContainer");
```

将永远获取最后一个Bean。如上面的就是获取`springdemo1.SpringMoreContainer#2`

## Alias name

关于`Alias name`的更多内容，请参考[Aliasing a Bean outside the Bean Definition](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-beanname-alias)小节。

### Alias别名

可以通过`alias`标签来给`Bean`起别名，这样起别名将不仅限于`name`属性，`id`也可以

```xml
<alias name="fromName | id" alias="toName"/>
```

例如，需要给`container`起别名的话，就需要这样：

```xml
<alias name="container" alias="moreContainer"/>
<alias name="container" alias="subContainer"/>
```

下面三段代码作用相同：

```java
applicationContext.getBean("container");
applicationContext.getBean("moreContainer");
applicationContext.getBean("subContainer");
```
