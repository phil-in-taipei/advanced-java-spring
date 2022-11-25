package platform.codingnomads.co.corespring.examples.beanscopes.singleton;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SingletonDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SingletonDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        SpringBean2 springBeanOne = ctx.getBean(SpringBean2.class);
        System.out.println("Hash code for Bean2: " + springBeanOne.hashCode());

        SpringBean2 springBeanTwo = ctx.getBean(SpringBean2.class);
        System.out.println("Hash code for Bean2: " + springBeanTwo.hashCode());

        ctx.close();
    }
}
