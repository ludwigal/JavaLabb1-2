
import java.awt.*;

public class Saab95 extends Car{

    public Turbo turbo;
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
        this.turbo = new Turbo();
    }

    @Override
    public double speedFactor(){
        double turboFactor = 1;
        if(this.turbo.getstateofturbo()) turboFactor = 1.3;
        return getEnginePower() * 0.01 * turboFactor;
    }
}
