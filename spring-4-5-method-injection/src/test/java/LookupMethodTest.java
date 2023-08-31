import cn.argento.askia.beans.Command;
import cn.argento.askia.beans.CommandManager;
import cn.argento.askia.config.LookUpMenthodContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LookUpMenthodContext.class)
public class LookupMethodTest {

    @Autowired
    @Qualifier("commandManager")
    private CommandManager commandManager;

    @Autowired
    @Qualifier("commandManager2")
    private CommandManager commandManager2;
    @Test
    public void Test(){
        Random random = new Random();
        final Object process = commandManager.process(random.nextBoolean());
        System.out.println(process);
        final Object process2 = commandManager.process(random.nextBoolean());
        System.out.println(process2);
        final Object process3 = commandManager.process(random.nextBoolean());
        System.out.println(process3);
    }


    @Test
    public void Test2(){
        Random random = new Random();
        final Object process = commandManager2.process(random.nextBoolean());
        System.out.println(process);
        final Object process2 = commandManager2.process(random.nextBoolean());
        System.out.println(process2);
        final Object process3 = commandManager2.process(random.nextBoolean());
        System.out.println(process3);
    }
}
