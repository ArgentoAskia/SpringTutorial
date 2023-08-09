import cn.argentoaskia.beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UserDependencyInjectionTest {

    @Autowired
    @Qualifier("user-askia")
    private User askia;

    @Test
    public void testUser(){
        System.out.println(askia);
    }
}
