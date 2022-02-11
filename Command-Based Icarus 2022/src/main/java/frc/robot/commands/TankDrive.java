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
        double pl = MathUtil.applyDeadband(UserInput.j_FL.getY(), 0.1);
        double pr = MathUtil.applyDeadband(UserInput.j_FR.getY(), 0.1);
        s_dt.driveSpeed = ((-UserInput.j_FR.getZ() + 1) / (double) 2);
        s_dt.dd.tankDrive(pl, pr);
    }
    @Override public void end(boolean interrupted) {
        s_dt.dd.tankDrive(0, 0);
    }
    @Override public boolean isFinished() { return false; }
}
