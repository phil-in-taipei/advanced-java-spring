package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProtoTypeDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PrototypeDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code for 1st Bean: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code for 1st Bean: " + springBean2.hashCode());

        SpringBean2 springBeanOne = ctx.getBean(SpringBean2.class);
        System.out.println("Hash code for 2nd Bean: " + springBeanOne.hashCode());

        SpringBean2 springBeanTwo = ctx.getBean(SpringBean2.class);
        System.out.println("Hash code for 2nd Bean: " + springBeanTwo.hashCode());

        ctx.close();
    }
}
