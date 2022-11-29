import java.lang.Math;

public class Vec2{
    private double x, y; 

    public Vec2(double xIn, double yIn)
    {
        x = xIn;
        y = yIn;
    }

    public void MoveAngle(double speed, double angle)
    {
        angle = Math.toDegrees(angle);

        x += (speed * Math.cos(angle));
        y += (speed * Math.sin(angle));
    }

    public void printlocation(String name, double rot){
        System.out.printf(name + ": X: %f/Y: %f/ rotation: %f\n", x, y, rot);
    }
     public double getlocationx(){
        return x;
     }
}