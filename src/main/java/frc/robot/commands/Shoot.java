package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallTrack;

public class Shoot extends CommandBase {
    private BallTrack s_bt;
    public Shoot(BallTrack s0) {
        s_bt = s0;
    }

    @Override public void execute() {
        s_bt.shooter_speed = 1;
    }

    @Override public void end(boolean interrupted) {
        s_bt.shooter_speed = 0;
    }
    
    @Override public boolean isFinished() {return false;}
}
