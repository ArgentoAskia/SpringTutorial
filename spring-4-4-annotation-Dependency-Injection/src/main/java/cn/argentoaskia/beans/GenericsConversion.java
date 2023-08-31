package cn.argentoaskia.beans;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

//  依靠ConversionService来进行类型转换任务
// 1.首先需要实现org.springframework.core.convert.converter.Converter<S, T>接口
// 2.创建DefaultFormattingConversionService默认实现对象，调用addConverter()添加转换器
// 3.即可实现@Value自定义的类型
// 注意转换器的类型必须是<String, 其他>
public class GenericsConversion implements Converter<String, Generics<String>> {
    @Override
    public Generics<String> convert(String source) {
        Generics<String> generics = new Generics<>();
        generics.setData(source);
        return generics;
    }
}
