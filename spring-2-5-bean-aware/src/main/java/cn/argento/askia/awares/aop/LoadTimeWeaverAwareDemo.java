package cn.argento.askia.awares.aop;

import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

public class LoadTimeWeaverAwareDemo implements LoadTimeWeaverAware {
    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {

    }
}
