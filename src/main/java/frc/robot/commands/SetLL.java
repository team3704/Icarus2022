package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Limelight;

public class SetLL extends InstantCommand {
	Limelight s_ll;
	NetworkTableEntry entry;
	int value;

	public SetLL(Limelight s0, NetworkTableEntry e, int n) {
		addRequirements(s0);
		s_ll = s0;
		entry = e;
		value = n;
	}

	@Override public void execute() {
		entry.setNumber(value);
	}	
}
