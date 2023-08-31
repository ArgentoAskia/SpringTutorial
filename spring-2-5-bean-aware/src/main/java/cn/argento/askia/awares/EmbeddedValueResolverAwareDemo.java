package cn.argento.askia.awares;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class EmbeddedValueResolverAwareDemo implements EmbeddedValueResolverAware {
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
    }
}
