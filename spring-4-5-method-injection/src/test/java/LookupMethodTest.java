import cn.argento.askia.beans.Command;
import cn.argento.askia.beans.CommandManager;
import cn.argento.askia.config.LookUpMenthodContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LookUpMenthodContext.class)
public class LookupMethodTest {

    @Autowired
    private CommandManager commandManager;

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
}
