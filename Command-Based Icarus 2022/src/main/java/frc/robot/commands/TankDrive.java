package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.UserInput;

public class TankDrive implements Command {
    private final Set<Subsystem> requirements = new HashSet<>();
    private final UserInput ui;
    private final DriveTrain dt;
    public TankDrive(UserInput s0, DriveTrain s1) {
        ui = s0; dt = s1;
        requirements.add(s0);
        requirements.add(s1);
    }
    @Override public void execute() {
        double power_left = ui.jFlightLeft.getY();
        double power_right = ui.jFlightRight.getY();
    }
    @Override public Set<Subsystem> getRequirements() { return requirements; }
}
