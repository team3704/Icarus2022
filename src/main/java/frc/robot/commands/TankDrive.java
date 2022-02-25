package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
    DriveTrain s_dt;

    public TankDrive(DriveTrain s0) {
        addRequirements(s0);
        s_dt = s0;
    }
    @Override public void initialize() {
        s_dt.dd.setSafetyEnabled(false); // screw safety
    }
    @Override public void execute() {
        double leftSpeed = UserInput.j_flightLeft.getY();
        double rightSpeed = UserInput.j_flightRight.getY();
        double zAxisPercent = (-UserInput.j_flightRight.getZ() + 1) / 2d;
        s_dt.driveSpeed = (Math.round(zAxisPercent * 10) / 10d); // decrease precision of speed control
        s_dt.dd.setDeadband(0.05);
        s_dt.dd.tankDrive(leftSpeed, rightSpeed, false);
    }
    @Override public void end(boolean interrupted) {
        s_dt.dd.tankDrive(0, 0);
        s_dt.dd.setDeadband(0);
        s_dt.dd.setSafetyEnabled(true);
    }
}
