import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;

public class Noel extends Bot{

    public static void main(String[] args){
        new Noel().start();
    }

    Noel(){
        super(BotInfo.fromFile("Noel.json"));
    }

    @Override
    public void run() {
        while(isRunning()){
            forward(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }

    //Fire when other bot seen
    @Override
    public void onScannedBot(ScannedBotEvent e){
        fire(1);
    }

    //hit By bullet
    @Override
    public void onHitByBullet(BulletHitEvent e){
        //Calculate vearing to direction of bullet
        double bearing = calcBearing(e.getBullet().getDirection());

        //turn 90 degrees to bullet direction beased on bearing
        turnLeft(90-bearing);
    }
}
