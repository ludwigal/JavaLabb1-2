import java.awt.*;
import java.lang.Math;


public abstract class Vehicle implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vec2 location;
    private int rotation;
    private boolean stateofenginge;
    

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.location = new Vec2(100, 100);
        this.rotation = 0;
        this.stateofenginge = false;
    }
    
    public double getlocx(){
        return (this.location.getlocationx());
    }
    
    public void Move(){
       location.MoveAngle(getCurrentSpeed(), rotation);
    }

    public void TurnRight()
    {
        rotation = Math.floorMod(rotation - 1, 360);
    }

    public void TurnLeft()
    {
        rotation = Math.floorMod(rotation + 1, 360);
    }

    public void printlocation()
    {
        location.printlocation(modelName, rotation);
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
        this.stateofenginge = true;

    }

    public void stopEngine(){
	    setCurrentSpeed(0);
        this.stateofenginge = false;
    }

    public boolean engingestate(){
        return (this.stateofenginge);
    }
    
    protected double speedFactor(){
        return enginePower * 0.01;
    }

    private void setCurrentSpeed(double speed){
        currentSpeed = CarMath.clamp0max(speed, 0, getEnginePower());
    }
    
    protected void incrementSpeed(double amount){
	    setCurrentSpeed(Math.max(Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower),
                                getCurrentSpeed()));
    }
    
    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.min(Math.max(getCurrentSpeed() - speedFactor() * amount,0),
                                getCurrentSpeed()));
    }

    // TODO fix this method according to lab pm


    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(CarMath.clamp01(amount));
        System.out.println(getCurrentSpeed());
    }

    public static class CarMath{ 
        public static double clamp0max(double val, double min, double max){
            return Math.max(Math.min(val, max), min);
        }

        public static double clamp01(double val){
            double min = 0;
            double max = 1;
            return Math.max(Math.min(val, max), min);
        }
    
        public static double betterMod(double val, double mod)//Why can mod do negative numbers???
        {
            if (mod < 0)
            {
                throw new IllegalArgumentException("You cannot have a negative mod m80", null);
            }
    
            val = val % mod;
            while (val < 0)
            {
                val += mod;
            }
    
            return val;
        }

    }
}