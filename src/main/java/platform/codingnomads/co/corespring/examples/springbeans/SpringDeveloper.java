package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;

    private Name name;

    public SpringDeveloper(Address address, Name name) {
        this.address = address;
        this.name = name;
    }
}
