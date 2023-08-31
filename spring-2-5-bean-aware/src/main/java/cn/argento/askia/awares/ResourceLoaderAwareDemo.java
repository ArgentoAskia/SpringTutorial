package cn.argento.askia.awares;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoaderAwareDemo implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }
}
