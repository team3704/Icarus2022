package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.UserInput;
import frc.robot.subsystems.DriveTrain;

public class TankDrive implements Command {
    Set<Subsystem> subsystems = new HashSet<>();
    DriveTrain s_dt;

    public TankDrive(DriveTrain s0) {
        subsystems.add(s0); s_dt = s0;
    }
    
    @Override public void execute() {
        double pl = MathUtil.applyDeadband(UserInput.j_FL.getY(), 0.1);
        double pr = MathUtil.applyDeadband(UserInput.j_FR.getY(), 0.1);
        s_dt.driveSpeed = (UserInput.j_FR.getZ() + 1) / -2.0d;
        s_dt.dd.tankDrive(pl, pr);
    }
    @Override public void end(boolean interrupted) {
        s_dt.dd.tankDrive(0, 0);
    }
    @Override public Set<Subsystem> getRequirements() { return subsystems; }
    @Override public boolean isFinished() { return false; }
}
