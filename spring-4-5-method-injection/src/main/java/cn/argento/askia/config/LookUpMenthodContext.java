package cn.argento.askia.config;

import cn.argento.askia.beans.AsyncCommand;
import cn.argento.askia.beans.Command;
import cn.argento.askia.beans.CommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "cn.argento.askia")
public class LookUpMenthodContext {

    //  多亏了Full模式，你甚至可以使用这种方式的Lookup
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Command asyncCommand(){
        return new AsyncCommand();
    }

    @Bean
    public CommandManager commandManager2(){
        // 使用这种方式你甚至不需要标记@LookUp
        // 每次对asyncCommand()的调用都会产生一个新的对象
        final Command command = asyncCommand();
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return command;
            }
        };
    }

}
