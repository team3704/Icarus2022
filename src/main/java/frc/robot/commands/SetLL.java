package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class SetLL extends CommandBase {
	Limelight s_ll;
	NetworkTableEntry e;
	Number v;
	Number ov;

	public SetLL(Limelight s0, NetworkTableEntry _e, int _n) {
		s_ll = s0; e = _e; v = _n;
	}

	@Override public void initialize() { ov = e.getNumber(0); }
	@Override public void execute() { e.setNumber(v); }
	@Override public void end(boolean interrupted) { e.setNumber(ov); }
	// must be interupted to end
	@Override public boolean isFinished() { return false; }
}
