package platform.codingnomads.co.corespring.examples.autowiredannotation;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("dram")
@ToString
public class DRAM implements Memory{
}
