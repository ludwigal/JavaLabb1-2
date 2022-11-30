import java.awt.*;

public class Volvo240 extends Car{

    private Trim trim;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
        this.trim = new Trim(1.25);
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * this.trim.getTrimFactor();
    }

    
}
