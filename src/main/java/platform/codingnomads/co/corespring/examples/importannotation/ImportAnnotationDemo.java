package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ImportAnnotationConfig.class);
        ctx.refresh();
        final SpringDeveloper2 springDeveloper2 = ctx.getBean(SpringDeveloper2.class);
        final Framework framework = ctx.getBean(Framework.class);
        ctx.close();
    }
}
