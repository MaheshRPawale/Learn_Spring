package human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Heart {
	
	private Legs legs;
	private Nose nose;
	
	@Autowired
	public Heart(Legs legs, Nose nose) {
		this.legs = legs;
		this.nose = nose;
	}
	
	public void beat() {
		legs.kick();
        System.out.println("Heart is beating rhythmically......");
        nose.breathe();
    }

    
    public void pumpBlood() {
    	nose.smell();
        System.out.println("Pumping blood to the ...");
    }

}
