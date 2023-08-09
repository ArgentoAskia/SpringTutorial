import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class DatelazyInitTest {

    // 如果id值和属性名同名则自动按类型+按名称注入
    @Autowired
    private LocalDateTime date1;

    @Autowired
    private LocalDateTime date2;

    @Autowired
    private LocalDateTime date3;

    @Autowired
    private LocalDateTime date4;


    @Test
    public void printDateTime(){
        System.out.println("Date time 1: " + date1);
        System.out.println("Date time 2: " +date2);
        System.out.println("Date time 3: " +date3);
        System.out.println("Date time 4: " +date4);
        System.out.println("因为只有在@Autowired Date3的时候，才会创建Date3的对象，相当于推迟了创建Date3的时间，所以Date3是最慢的！");
    }

}
