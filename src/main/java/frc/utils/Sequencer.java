package frc.utils;

import edu.wpi.first.wpilibj.Timer;

public class Sequencer {
    public Autonomous[][] functions;
    public double timeouts[];
    public boolean ended;
    Timer t = new Timer();
    public void end() {
        ended = true;
    }
    public void start() {
        ended = false;
        for(int i = 0; i < functions.length; ++i) {
            t.start();
            for(Autonomous function : functions[i]) {
                while(t.get() < timeouts[i] && !ended) {}
                function.runAuton();
            }
        }
    }
}
