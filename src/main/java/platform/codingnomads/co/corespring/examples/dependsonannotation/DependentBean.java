package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class DependentBean {
    @Autowired
    private JDK jdk;

    public DependentBean() {
        System.out.println("DependentBean is ready and depends on JDK.");
    }
}
