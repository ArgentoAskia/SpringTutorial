package cn.argentoaskia.beans;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.*;
import org.springframework.core.io.ContextResource;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

// 这里展示了@Value的非配置文件方式能够注入的所有值
// @Value标记在构造器的时候只能标记在参数
// 当Setter方法只有有一个参数的时候可以标记在Setter方法
// 常用的是标记在字段上
// 覆盖顺序：标记在Setter方法上 > 标记在Field上 > 标记在Constructor上
@Component
public class MoreValueAnnotationAutowired {

    @Value("500")
    private int anInt;
    @Value("5000")
    private long aLong;
    @Value("true")
    private boolean aBoolean;
    @Value("50")
    private short aShort;
    @Value("5")
    private byte aByte;
    @Value("5.1")
    private float aFloat;
    @Value("5.2")
    private double aDouble;
    @Value("a")
    private char aChar;

    @Value("hello world!")
    private String string;

    @Value("500")
    private Integer integer;
    @Value("5000")
    private Long longWrapper;
    @Value("true")
    private Boolean boolWrapper;
    @Value("50")
    private Short shortWrapper;
    @Value("5")
    private Byte byteWrapper;
    @Value("5.1")
    private Float floatWrapper;
    @Value("5.2")
    private Double doubleWrapper;
    @Value("a")
    private Character character;

    // 时间需要满足下面格式
    // 实际上是调用new Date(String)构造器来创建该类型
    // 所以理论上所有带字符串类型的单构造器的类都能注入
    // 具体参考TypeConverterDelegate的197行左右的
    /*
    if (conversionAttemptEx == null && !requiredType.isInterface() && !requiredType.isEnum()) {
        try {
            // 核心在这里
            Constructor<T> strCtor = requiredType.getConstructor(String.class);
            return BeanUtils.instantiateClass(strCtor, convertedValue);
        }
        catch (NoSuchMethodException ex) {
            // proceed with field lookup
            if (logger.isTraceEnabled()) {
                logger.trace("No String constructor found on type [" + requiredType.getName() + "]", ex);
            }
        }
        catch (Exception ex) {
            if (logger.isDebugEnabled()) {
                logger.debug("Construction via String failed for type [" + requiredType.getName() + "]", ex);
            }
        }
    }
     */
    @Value("Sat, 12 Aug 1995 13:30:00 GMT")
    // 美国标准时间格式
//    @Value("2019/11/10 11:35:20 PM")
    private Date date;
    // 我们给IP类定义一个String.class的构造器来证明
    @Value("192.168.0.1 Askia 255.255.255.0")
    private IP ip;


    // 靠PropertyEditor接口来设置值
    // 在子类的PropertyEditorSupport下有很多的XXXEditor用于转换值
    // 其中URIEditor用于转换uri值
    // 具体@Value注解需要怎么写值可以参考具体的XXXEditor类的SetAsText()
    // 会先重overriddenDefaultEditors中的12钟Editor中查找；URIEditor、FileEditor、ClassArrayEditor(Class[])、ReaderEditor(Reader)、
    // URLEditor、InputSourceEditor(org.xml.sax.InputSource)、ClassEditor(Class)、ResourceEditor(org.springframework.core.io.Resource和org.springframework.core.io.ContextResource)、
    // ResourceArrayEditor(org.springframework.core.io.Resource[])、InputstreamEditor、PathEditor、
    // 然后重createDefaultEditors()方法中创建的47钟Editor中查找，参考PropertyEditorRegistrySupport类的createDefaultEditors()方法
    // 最后如果还是没有找到，则默认需要自定义Editor(实现PropertyEditorSupport类)，一般用于自定义的类，比如cn.argento.askia.User,则需要定义cn.argento.askia.UserEditor类
    // BeanUtils的findEditorByConvention()会帮你创建这个Editor实例
    // 还有一种方法：实现ConversionService接口来提供转换！
    @Value("www.baidu.com")
    private URI uri;
    // 这些都可以，支持classpath标志！
    @Value("classpath:cn/argentoaskia/beans/Fruit.class")
//    @Value("C:/cn/argentoaskia/beans/Fruit.java")
//    @Value("cn/argentoaskia/beans/Fruit.java")
    private File file;
    @Value("classpath:cn/argentoaskia/beans/Fruit.class")
    private Path path;

    @Value("cn.argentoaskia.beans.Fruit,cn.argentoaskia.beans.IP")
    private Class<?>[] classes;

    // Reader和inputStream则需要提供一个文件的位置
    @Value("classpath:readerText.txt")
    private Reader reader;
    @Value("classpath:readerText.txt")
    private InputStream inputStream;

    @Value("UTF-8")
    private Charset charset;
    // 原理同URI
    // URL则需要满足URL的格式
    @Value("https://www.argentoaskia.com")
    private URL url;

    @Value("zh_CN")
    private Locale locale;

    @Value("cn.argentoaskia.beans.IP")
    private Class<IP> ipClass;


    // 扩展的47种
    @Value("name=Askia\nvalue=Askia\n")
    private Properties properties;

    @Value("GMT+8")
    private TimeZone timeZone;

    @Value("Asia/Shanghai")
    private ZoneId zoneId;

    @Value("95fef692-3144-42aa-a056-825cce208afd")
    private UUID uuid;


    @Value("2.34455656")
    private BigDecimal bigDecimal;

    @Value("123456789123456789")
    private BigInteger bigInteger;

    // 枚举靠的是217行的convertedValue = attemptToConvertStringToEnum(requiredType, trimmedValue, convertedValue);
    @Value("APPLE")
    private Fruit fruit;


    // 数组形式的直接注入只支持byte[]、char[]、short[]、int[]、long[]、String[]
    // byte中的2会被转为Ascii值，同时,也会变成byte
    // 转换byte和char不需要分割成员，因此,也会被转为byte和char
    @Value("2?2,2.2")
    private byte[] bytes;
    @Value("abcdefg")
    private char[] chars;

    @Value("3,3,3,3")
    private short[] shorts;
    @Value("5,5,5,5")
    private int[] ints;
    @Value("10,10,10,10")
    private long[] longs;

    // 其他的类型输入可以使用这种投机取巧的方式注入第一个值！
    @Value("2")
    private Long[] dates;


    private String constructor;

    @Value("field inject")
    private String field;

    @Value("field inject")
    private String setter;

    @Autowired
    public MoreValueAnnotationAutowired(@Value("constructor inject")String constructor,
                                        @Value("constructor inject") String field,
                                        @Value("constructor inject") String setter){
        this.constructor = constructor;
        this.field = field;
        this.setter = setter;
    }

    // 当只有一个参数的时候也可以这样写
//    @Value("setter Inject")
//    public MoreValueAnnotationAutowired setSetter(String setter) {
//        this.setter = setter;
//        return this;
//    }

    // 我更喜欢的写法
    @Autowired
    public MoreValueAnnotationAutowired setSetter(@Value("setter Inject") String setter) {
        this.setter = setter;
        return this;
    }
    private String readerReadAllStr(){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            char[] charsBuffer = new char[1024];
            int read = 0;
            while ((read = reader.read(charsBuffer, 0, charsBuffer.length)) != -1){
                stringBuilder.append(charsBuffer, 0, read);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    private byte[] inputstreamReadAllbyte(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int read = 0;
            int index = 0;
            while ((read = inputStream.read(buffer, 0, buffer.length)) != -1){
                byteArrayOutputStream.write(buffer, 0, read);
                index = index + read;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MoreValueAnnotationAutowired{");
        sb.append("anInt=").append(anInt);
        sb.append(", aLong=").append(aLong);
        sb.append(", aBoolean=").append(aBoolean);
        sb.append(", aShort=").append(aShort);
        sb.append(", aByte=").append(aByte);
        sb.append(", aFloat=").append(aFloat);
        sb.append(", aDouble=").append(aDouble);
        sb.append(", aChar=").append(aChar);
        sb.append(", string='").append(string).append('\'');
        sb.append(", integer=").append(integer);
        sb.append(", longWrapper=").append(longWrapper);
        sb.append(", boolWrapper=").append(boolWrapper);
        sb.append(", shortWrapper=").append(shortWrapper);
        sb.append(", byteWrapper=").append(byteWrapper);
        sb.append(", floatWrapper=").append(floatWrapper);
        sb.append(", doubleWrapper=").append(doubleWrapper);
        sb.append(", character=").append(character);
        sb.append(", date=").append(date);
        sb.append(", ip=").append(ip);
        sb.append(", uri=").append(uri);
        sb.append(", file=").append(file);
        sb.append(", path=").append(path);
        sb.append(", classes=").append(classes == null ? "null" : Arrays.asList(classes).toString());
        sb.append(", reader=").append(readerReadAllStr());
        sb.append(", inputStream=").append(inputstreamReadAllbyte());
        sb.append(", charset=").append(charset);
        sb.append(", url=").append(url);
        sb.append(", locale=").append(locale);
        sb.append(", ipClass=").append(ipClass);
        sb.append(", properties=").append(properties);
        sb.append(", timeZone=").append(timeZone);
        sb.append(", zoneId=").append(zoneId);
        sb.append(", uuid=").append(uuid);
        sb.append(", bigDecimal=").append(bigDecimal);
        sb.append(", bigInteger=").append(bigInteger);
        sb.append(", fruit=").append(fruit);
        sb.append(", bytes=");
        if (bytes == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < bytes.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(bytes[i]);
            sb.append(']');
        }
        sb.append(", chars=");
        if (chars == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < chars.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(chars[i]);
            sb.append(']');
        }
        sb.append(", shorts=");
        if (shorts == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < shorts.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(shorts[i]);
            sb.append(']');
        }
        sb.append(", ints=");
        if (ints == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < ints.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(ints[i]);
            sb.append(']');
        }
        sb.append(", longs=");
        if (longs == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < longs.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(longs[i]);
            sb.append(']');
        }
        sb.append(", dates=").append(dates == null ? "null" : Arrays.asList(dates).toString());
        sb.append(", constructor='").append(constructor).append('\'');
        sb.append(", field='").append(field).append('\'');
        sb.append(", setter='").append(setter).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
