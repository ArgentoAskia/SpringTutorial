package cn.argento.askia;


import cn.argento.askia.modes.beans.IP;
import cn.argento.askia.modes.config.FullModeConfig;
import cn.argento.askia.modes.config.LiteModeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FullModeConfig.class, LiteModeConfig.class})
public class FullLiteModeTest {

    @Autowired
    private IP ip;

    @Autowired
    private IP ip2;

    @Test
    public void Test(){
        System.out.println("lite IP：" + ip);
        System.out.println("full IP：" + ip2);
    }


}
