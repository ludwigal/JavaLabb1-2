import java.awt.*;
import java.util.ArrayList;
public class CarTransporter extends Truck implements Loadable{
    protected UpAndDownLift lift;
    protected ArrayList<Car> LoadedCars = new ArrayList<Car>();
    protected ArrayList<Car> UnloadedCars = new ArrayList<Car>();
    public CarTransporter(){
        super(2, Color.red, 125, "Scania");
        this.lift = new UpAndDownLift();

    }

    public boolean getliftstate(){
        return this.lift.getstate();

    }
    
    public void Load(Car car){
        System.out.println(this.getCurrentSpeed());
        if (car.getlocx() - this.getlocx() < 10  && this.getCurrentSpeed() == 0 &! this.getliftstate() && car.getCurrentSpeed() == 0 && this.LoadedCars.size() < 4){
            this.LoadedCars.add(car);
        }else
        System.out.println("Stanna motorn och dra ner liften");

    }

    public void Unload(int amount){
        if (this.getCurrentSpeed() == 0 &! this.getliftstate()){
            int f = this.LoadedCars.size();
            for (int i = (f-1); i != (f - amount)-1; i--){
                this.UnloadedCars.add(this.LoadedCars.remove(i));
            }
        }
    }
}

