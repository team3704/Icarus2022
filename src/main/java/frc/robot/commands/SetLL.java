package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class SetLL extends CommandBase {
	Limelight s_ll;
	NetworkTableEntry e;
	Number v;
	Number ov;

	public SetLL(Limelight s0, NetworkTableEntry a0, int a1) {
		s_ll = s0; e = a0; v = a1;
	}

	@Override public void initialize() { ov = e.getNumber(0); }
	@Override public void execute() { e.setNumber(v); }
	@Override public void end(boolean interrupted) { e.setNumber(ov); }
}
