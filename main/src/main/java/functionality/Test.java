package functionality;

import java.util.Timer;
import java.util.TimerTask;

public class Test {

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("5 segundos");
            }
        }, 3000);
    }


}
