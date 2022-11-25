package platform.codingnomads.co.corespring.examples.autowiredannotation;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("ram")
@ToString
public class RAM implements Memory {

}
