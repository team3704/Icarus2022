package frc.utils;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Timer;

public class Sequencer {
    public ArrayList<Autonomous[]> functions = new ArrayList<>();
    public ArrayList<Double> timeouts = new ArrayList<>();
    private boolean ended;
    Timer t = new Timer();

    /**
     * @param cmd A commands that will execute in it's order in the sequencers list
     * @param time The amount of time until the autonomous function runs *after* the function(s) before it finishes running, if any
     */
    public void addCommand(Autonomous cmd, double time) {
        functions.add(new Autonomous[]{cmd});
        timeouts.add(time);
    }

    /**
     * @param cmds A group of commands that will all execute simultaneously in their order in the sequencers list
     * @param time The amount of time until the autonomous functions run *after* the function(s) before it finishes running, if any
     */
    public void addCommand(Autonomous[] cmds, double time) {
        functions.add(cmds);
        timeouts.add(time);
    }

    /**
     * Stops the sequencer from running
     */
    public void end() {
        ended = true;
        for(Autonomous[] functionGroup : functions) {
            for(Autonomous function : functionGroup) {
                function.finishAuton();
            }
        }
    }

    /**
     * Starts running every command function in the sequencer constantly after the times that each command was set for
     * @param timeout amount of time until command sequence starts
     */
    public void start(double timeout) {
        t.reset();
        t.start();
        while(t.get() < timeout) {}
        ended = false;
        for(int i = 0; i < functions.size(); ++i) {
            t.reset();
            if(i != 0) {
                for(Autonomous function : functions.get(i - 1)) {
                    function.finishAuton();
                }
            }
            while(t.get() < timeouts.get(i)) {
                if(ended) return;
                for(Autonomous function : functions.get(i)) {
                    function.runAuton();
                }
            }
        }
        for(Autonomous function : functions.get(functions.size() - 1)) {
            function.finishAuton();
        }
    }
}