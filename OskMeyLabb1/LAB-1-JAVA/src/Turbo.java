public class Turbo {
    private boolean turboOn = false;

    public void setTurboOn(){
	    this.turboOn = true;
    }

    public void setTurboOff(){
	    this.turboOn = false;
    }

    public boolean getstateofturbo(){
        return this.turboOn;
    }
}
