package servicecomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestService {

    @Autowired
    private controller.MyDemoController demoController;
    
    public void testControllerDependency() {
        System.out.println("Testing Spring Dependency Injection");
        String response = demoController.myDemo();
        System.out.println("Controller response: " + response);
    }
}