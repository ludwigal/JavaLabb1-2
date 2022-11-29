public class AngleLift extends Lift{
    private int liftangle = 0;
    public void movelift(){

    }
    public void downlift(double amount, double currentspeed){
        if (currentspeed > 0 ){
            System.out.println("Stanna bilen");
        }else
            this.liftangle-=amount;
            if (this.liftangle < 0){
                this.liftangle = 0;
            }
    }

    public void uplift(double amount){
        this.liftangle+=amount;
        if (this.liftangle > 70){
            this.liftangle = 70;
    }

}
    public int getstate(){
        return(this.liftangle);
    }
}
