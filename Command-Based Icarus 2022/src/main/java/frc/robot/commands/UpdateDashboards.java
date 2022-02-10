package frc.robot.commands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class UpdateDashboards implements Command {
    HashMap<Constants.SH, Subsystem> subsystems = new HashMap<>();

    public UpdateDashboards(DriveTrain s0) {
        subsystems.put(Constants.SH.dt, s0);
    }

    @Override
    public void execute() {

    }

    @Override
    public Set<Subsystem> getRequirements() { return (Set<Subsystem>) subsystems.values(); }
}
