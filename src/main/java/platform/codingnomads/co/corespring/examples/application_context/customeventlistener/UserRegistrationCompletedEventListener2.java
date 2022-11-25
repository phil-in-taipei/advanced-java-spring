package platform.codingnomads.co.corespring.examples.application_context.customeventlistener;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationCompletedEventListener2 implements ApplicationListener<UserRegistrationCompletedEvent> {

    @Override
    public void onApplicationEvent(UserRegistrationCompletedEvent event) {
        System.out.println("------------------------------------------------------");
        System.out.println("-----------------Second Event Listener----------------");
    }
}
