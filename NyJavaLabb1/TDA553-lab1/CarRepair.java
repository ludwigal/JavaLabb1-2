import java.util.ArrayList;
public class CarRepair implements Loadable{
    protected ArrayList<Car> LoadedCars = new ArrayList<Car>();
    protected ArrayList<Car> UnloadedCars = new ArrayList<Car>();
    private Vec2 location;
    private int loadsize;
    public CarRepair(int x, int y, int loadsize){
        this.location = new Vec2(x, y);
        this.loadsize = loadsize;
    }
    public double getlocx(){
        return (this.location.getlocationx());
    }
    public void Load(Car car){
        if (car.getlocx() - this.getlocx() < 10  && car.getCurrentSpeed() == 0 && this.LoadedCars.size() < loadsize){
            this.LoadedCars.add(car);
        }else
        System.out.println("Stanna motorn och dra ner liften");
    }
    public void Unload(int amount){
            int f = this.LoadedCars.size();
            for (int i = (f-1); i != (f - amount)-1; i--){
                this.UnloadedCars.add(this.LoadedCars.remove(i));

}
}
}