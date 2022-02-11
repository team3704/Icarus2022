package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Limelight;

public class LLLeds extends InstantCommand {
    Limelight s_ll;
    int ledState;

    NetworkTableEntry te_ledMode;

    public LLLeds(Limelight s0, int ls)  {
        addRequirements(s0);
        s_ll = s0;
        ledState = ls;
        te_ledMode = s0.nt.getEntry("ledMode");
    }

    @Override public void execute() {
        te_ledMode.setNumber(ledState);
    }
}