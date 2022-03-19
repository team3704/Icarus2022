package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallTrack;

public class AutoShoot extends CommandBase {
    BallTrack ballTrack;
    Timer timer = new Timer();
    double time;
    public AutoShoot(BallTrack ballTrackSubsystem, double time) {
        ballTrack = ballTrackSubsystem;
        this.time = time;
    }
    @Override public void initialize() {
        timer.start();
    }
    @Override public void execute() {
        ballTrack.shooter_speed = 0.8;
        if(timer.get() > time / 2 || time < 3) {
            ballTrack.feed_speed = 1;
            //ballTrack.intake_speed = 1;
        }
    }    
    @Override public void end(boolean interrupted) {
        ballTrack.shooter_speed = ballTrack.feed_speed = 0;//ballTrack.intake_speed = 0;
    }
    @Override public boolean isFinished() {
        return timer.get() > time;
    }
}
