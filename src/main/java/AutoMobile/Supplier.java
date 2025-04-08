package AutoMobile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Supplier {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigrationAutoMobile.class);

        Oil oil = context.getBean(Oil.class);
        oil.liqued();

        Bike bike = context.getBean(Bike.class);
        bike.buuuungggg();

        context.close();
    }
}
