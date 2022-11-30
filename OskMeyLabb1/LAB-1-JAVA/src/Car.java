import java.awt.*;
import java.lang.Math;


public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vec2 location;
    private int rotation;
    private boolean enginestate;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.location = new Vec2(100, 100);
        this.rotation = 0;
        this.enginestate = false;
    }

    public void move(){
       location.MoveAngle(getCurrentSpeed(), rotation);
    }

    public void turnRight()
    {
        rotation = Math.floorMod(rotation -1 , 360);
    }

    public void turnLeft()
    {
        rotation = Math.floorMod(rotation +1, 360);
    }

    public void printLocation()
    {
        location.printLocation(modelName, rotation);
    }

    public double getRotation()
    {
        return rotation;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    setCurrentSpeed(0.1);
        this.enginestate=true;
    }

    public void stopEngine(){
	    setCurrentSpeed(0);
        this.enginestate=false;
    }
    
    protected double speedFactor(){
        return enginePower * 0.01;
    }

    private void setCurrentSpeed(double speed){
        currentSpeed = CarMath.clamp(speed, 0, getEnginePower());
    }

    private void incrementSpeed(double amount){
	    setCurrentSpeed(CarMath.clamp((getCurrentSpeed() + speedFactor() * amount),getCurrentSpeed(),enginePower
        ));
    }
    
    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.min(Math.max(getCurrentSpeed() - speedFactor() * amount,0),
                                getCurrentSpeed()));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (this.enginestate) {            // If the engine is on then you can gas
        incrementSpeed(CarMath.clamp01(amount));
        System.out.println(getCurrentSpeed());
    }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(CarMath.clamp01(amount));
        System.out.println(getCurrentSpeed());
    }

    private static class CarMath{ 
        public static double clamp(double val, double min, double max){
            return Math.max(Math.min(val, max), min);
        }

        public static double clamp01(double val){
            double min = 0;
            double max = 1;
            return Math.max(Math.min(val, max), min);
        }
    

    }
}