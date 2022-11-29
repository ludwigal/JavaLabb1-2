import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CarTest{
    public static void main(String[] args) {
       Volvo240 ss1 = new Volvo240();
       Saab95 ss5 = new Saab95();
       //CarRepair cr1 = new CarRepair(100,100,3);
       //Saab95 ss6 = new Saab95();
       //System.out.println(ss1.getlocx());
       ss1.startEngine();
       ss1.gas(0.5);

       while(true){
        try {
            ss1.TurnRight();
            ss1.Move();
            ss1.printlocation();

                Thread.sleep(10);
               
            }
        
        catch (Exception e) {
           
            // catching the exception
            System.out.println(e);
        }

       }
       //ss1.brake(0.5);
       /*CarTransporter ss2 = new CarTransporter();
       System.out.println(ss2.getlocx());
       ss2.startEngine();
       ss2.lift.downlift(ss2.getCurrentSpeed(), ss2.engingestate());
       ss2.Load(ss1);
       ss2.Load(ss5);
       System.out.println(ss2.LoadedCars);
       ss2.Unload(2);
       System.out.println(ss2.UnloadedCars);
       System.out.println(ss2.LoadedCars);
*/
    }
     
    @Test
    public void stopEngineTest()
    {
        Volvo240 volvo = new Volvo240();
        assertEquals(0, volvo.getCurrentSpeed(), 0);
    }
    @Test
    public void compareCars()
    {
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = car1;
        assertEquals(car1, car2);
    }

    @Test
    public void counterTurnTest()
    {
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();
        car1.TurnLeft();
        car1.TurnRight();
        assertEquals(car1.getRotation(), car2.getRotation(), 0);
    }

    @Test
    public void startEngineTest() {
    Volvo240 testVolvo240 = new Volvo240();
    testVolvo240.startEngine();
    testVolvo240.gas(0.5);
    testVolvo240.stopEngine();
    assertEquals(0, testVolvo240.getCurrentSpeed(), 0);
    }

    @Test
    public void canTheCarTurn() {
    Saab95 testSaab95 = new Saab95();
    testSaab95.TurnLeft();
    assertTrue(testSaab95.getRotation() != 0.0);
    }

    @Test
    public void carBrake() {
    Volvo240 Volvo240 = new Volvo240();
    Volvo240.startEngine();
    Volvo240.gas(0.5);
    Volvo240.brake(0.5);
    assertTrue(Math.floor(Volvo240.getCurrentSpeed()) < 1);
    }
  

    
}