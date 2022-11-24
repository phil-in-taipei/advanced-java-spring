package platform.codingnomads.co.ioc.examples.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private Processor processor;
    private OS os;

    private RAM ram;

    private GPU gpu;

    // these fields are being injected from the ApplicationContext
    // if a class contains only one constructor (as this one does), the use of @Autowired is optional
    // if a class contains two or more constructors, @Autowired is required for constructor injection to take place
    public Laptop(Processor processor, OS os, RAM ram) {
        this.processor = processor;
        this.os = os;
        this.ram = ram;
    }

    @Autowired
    public void setDependency(GPU gpu) {
        this.gpu = gpu;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() +
                "\nOS: " + os.getName() + "\nRAM: " + ram.getName() + "\nGPU: " + gpu.getName();
    }
}
