public class UpAndDownLift extends Lift{
    private boolean liftstate = true;
    public void movelift(){

    }

    public void downlift(double currentspeed, boolean enginestate){
        if (currentspeed > 0){
            System.out.println("Stanna bilen");
        }else if(enginestate && currentspeed == 0) {
            this.liftstate=false;
        }


    }

    public void uplift(){
        this.liftstate=true;


}
    public boolean getstate(){
        return(this.liftstate);
    }
}

