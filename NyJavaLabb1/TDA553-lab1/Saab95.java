import java.awt.*;

public class Saab95 extends Car{

    protected Turbo turbo;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
        this.turbo = new Turbo();
    }

    @Override
    protected double speedFactor(){
        double turboFactor = 1;
        if(this.turbo.turboOn) turboFactor = 1.3;
        return getEnginePower() * 0.01 * turboFactor;
    }
}
