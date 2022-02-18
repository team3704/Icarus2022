package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
    DriveTrain s_dt;

    public TankDrive(DriveTrain s0) {
        addRequirements(s0);
        s_dt = s0;
    }
    
    @Override public void execute() {
        double leftSpeed = MathUtil.applyDeadband(UserInput.j_flightLeft.getY(), 0.025);
        double rightSpeed = MathUtil.applyDeadband(UserInput.j_flightRight.getY(), 0.025);
        double zAxisPercent = (-UserInput.j_flightRight.getZ() + 1) / 2d;
        s_dt.driveSpeed = (Math.round(zAxisPercent * 10) / 10d); // decrease precision of speed control
        s_dt.dd.tankDrive(leftSpeed, rightSpeed, false);
    }
    @Override public void end(boolean interrupted) {
        s_dt.dd.tankDrive(0, 0);
    }
}
