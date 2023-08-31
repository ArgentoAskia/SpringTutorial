package cn.argento.askia.beans;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class CommandManager {

    public Object process(Object commandState){
        Command command = createCommand();
        return command.execute(commandState);
    }

    // 因为Command是一个SCOPE_PROTOTYPE的Bean，不会存储在容器，所以不能Autowire
    // 可以通过@LookUp的来处理这种需要注入SCOPE_PROTOTYPE的Bean
    // 该抽象方法的格式必须是：
    // <public|protected> [abstract] <return-type> theMethodName(no-arguments);
    @Lookup
    protected abstract Command createCommand();
}
