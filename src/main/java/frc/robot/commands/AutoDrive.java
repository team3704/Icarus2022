package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
    DriveTrain s_dt;
    Timer moveTimer = new Timer();
    double th, turn, time;
    
    public AutoDrive(DriveTrain s0, double x, double z, double t) {
        addRequirements(s0);
        s_dt = s0;
        th = x;
        turn = z;
        time = t;
    }
    @Override public void initialize() { moveTimer.start(); }
    @Override public void end(boolean interrupted) {
        moveTimer.stop();
        s_dt.dd.tankDrive(0, 0);
    }
    @Override public void execute() {
        s_dt.dd.arcadeDrive(th, turn, false);
    }
    @Override public boolean isFinished() { return (moveTimer.get() > time); }
}