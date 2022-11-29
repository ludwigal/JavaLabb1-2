import java.awt.*;
public class Scania extends Truck{
    protected AngleLift lift;
    public Scania(){
        super(2, Color.red, 125, "Scania");
        this.lift = new AngleLift();
        //System.out.println(this.lift);
    }

    public boolean getliftstate(){
        if (this.lift.getstate() > 0){
            return false;
        }else
        return true;

    }

}
