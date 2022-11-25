package platform.codingnomads.co.corespring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                CoreLabConfig.class);

        Oven oven = ctx.getBean(Oven.class);

        System.out.println("---------------------------------------------------------------------------------------------");

        System.out.println(
                "Cooking some food items using the: "
                + oven.getBrand() + " " + oven.getModel() + " oven."
        );

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("*********************************************************************************************");

        String[] foodProducts = ctx.getBeanNamesForType(FoodProduct.class);

        for (String foodProduct : foodProducts) {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println(
                    "Currently cooking: " + ctx.getBean(foodProduct, FoodProduct.class).getFood().toUpperCase()
                    + "; manufacturer: " + ctx.getBean(foodProduct, FoodProduct.class).getBrand() + ".");
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("*********************************************************************************************");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("That was a good day's work!");

        System.out.println("---------------------------------------------------------------------------------------------");
    }

}
