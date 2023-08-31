package cn.argento.askia.awares;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class ImportAwareDemo implements ImportAware {
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {

    }
}
