package platform.codingnomads.co.corespring.examples.beanannotation.jsr_250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SampleBean {

    public SampleBean() {
        System.out.println("bean is getting ready!");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean @PostConstruct is gathering resources..");
    }

    @PostConstruct
    public void firstMethod() {
        System.out.println("bean @PostConstruct is doing something..");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("time to @PreDestroy and head home..");
    }

    @PreDestroy
    public void secondMethod() {
        System.out.println("time to @PreDestroy and do something else..");
    }

}
