package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class SpringDeveloper {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }
    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready with profile annotation.");
    }
}
