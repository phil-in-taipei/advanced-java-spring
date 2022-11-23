package platform.codingnomads.co.ioc.examples.dependencylookup;

public class PhilGreetingProvider implements GreetingProvider {
    @Override
    public String getGreeting() {
        return "Hello, this is Phil's Greeting Provider";
    }

}
