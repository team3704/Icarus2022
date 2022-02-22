package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
    DriveTrain s_dt;
    Timer moveTimer = new Timer();
    double throttle, turn, time;
    
    public AutoDrive(DriveTrain s0, double a0, double a1, double a2) {
        addRequirements(s0);
        s_dt = s0; throttle = a0; turn = a1; time = a2;
    }

    @Override public void initialize() {
        moveTimer.start();
    }
    @Override public void execute() {
        s_dt.dd.arcadeDrive(throttle, turn, false);
    }
    @Override public void end(boolean interrupted) {
        moveTimer.stop();
        s_dt.dd.tankDrive(0, 0);
    }
    @Override public boolean isFinished() { return moveTimer.hasElapsed(time); }
}