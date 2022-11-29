import java.awt.*;
public abstract class Truck extends Vehicle{

    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);

    }

    abstract boolean getliftstate();

    public void gas(double amount){
        if (getliftstate() == true && this.engingestate()){
        incrementSpeed(CarMath.clamp(amount));
        System.out.println(getCurrentSpeed());
        }else
        System.out.println("Slå igång motorn och dra upp liften");
    }


}

