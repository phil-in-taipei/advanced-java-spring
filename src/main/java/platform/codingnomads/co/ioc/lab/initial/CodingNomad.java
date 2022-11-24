package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    private Laptop laptop;

    @Autowired
    private OS os;

    @Autowired
    public void setName(Laptop laptop) {
        this.laptop = laptop;
    }

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This coding nomad is creating awesome software using: " +
                                "\n    IDE: ({0}:{1}), JDK: ({2}:{3}), " +
                                "\n    Framework: ({4}:{5})"
                                + ", \n    laptop: ({6}), os: ({7})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        laptop.getName(),
                        os.getName()
                );
    }
}
