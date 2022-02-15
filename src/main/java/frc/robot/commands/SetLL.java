package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class SetLL extends CommandBase {
	Limelight s_ll;
	NetworkTableEntry entry;
	Number value;
	Number origValue;

	public SetLL(Limelight s0, NetworkTableEntry e, int n) {
		addRequirements(s0);
		s_ll = s0;
		entry = e;
		value = n;
	}

	@Override public void initialize() { origValue = entry.getNumber(0); }
	@Override public void execute() { entry.setNumber(value); }
	@Override public void end(boolean interrupted) { entry.setNumber(origValue); }
	// must be interupted to end
	@Override public boolean isFinished() { return false; }
}
