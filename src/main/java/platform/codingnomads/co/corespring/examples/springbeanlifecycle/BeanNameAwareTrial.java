package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import lombok.NonNull;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanNameAwareTrial implements BeanNameAware {
    @Override
    public void setBeanName(@NonNull String name) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("The BEAN NAME is being set to: ".concat(name));
        System.out.println("-------------------------------------------------------------------");    }
}
