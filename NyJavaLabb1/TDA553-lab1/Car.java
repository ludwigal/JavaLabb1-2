import java.awt.*;
public abstract class Car extends Vehicle{

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);


    }

    public void gas(double amount){
        if (this.engingestate()){
        incrementSpeed(CarMath.clamp01(amount));
        System.out.println(getCurrentSpeed());
    }else
    System.out.println("Slå igång motorn");
    }
}