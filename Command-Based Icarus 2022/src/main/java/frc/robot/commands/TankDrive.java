package frc.robot.commands;

import java.util.HashMap;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.UserInput;

public class TankDrive implements Command {
    HashMap<Constants.SH, Subsystem> subsystems = new HashMap<>();
    UserInput s_ui;
    DriveTrain s_dt;

    public TankDrive(UserInput s0, DriveTrain s1) {
        subsystems.put(Constants.SH.dt, s1); s_dt = s1;
        subsystems.put(Constants.SH.ui, s0); s_ui = s0;
    }
    @Override public void execute() {
        double pl = s_ui.j_FL.getY();
        double pr = s_ui.j_FR.getY();
        s_dt.dd.tankDrive(pl, pr);
    }
    @Override public void end(boolean interrupted) {
        s_dt.dd.tankDrive(0, 0);
    }
    @Override public Set<Subsystem> getRequirements() { return (Set<Subsystem>) subsystems.values(); }
}
