package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        SingletonBean2 singletonBean2One = ctx.getBean(SingletonBean2.class);
        SingletonBean2 singletonBean2Two = ctx.getBean(SingletonBean2.class);

        System.out.println("-----Hashcode of SingletonBean #2-----");
        System.out.println(singletonBean2One.hashCode());
        System.out.println(singletonBean2Two.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());

        final PrototypeBean2 prototypeBeanTwo1 = ctx.getBean(PrototypeBean2.class);
        final PrototypeBean2 prototypeBeanTwo2 = ctx.getBean(PrototypeBean2.class);

        System.out.println("-----Hashcode of PrototypeBean #2-----");
        System.out.println(prototypeBeanTwo1.hashCode());
        System.out.println(prototypeBeanTwo2.hashCode());
        System.out.println();
        ctx.close();
    }
}
