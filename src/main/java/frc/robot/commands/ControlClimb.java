package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.Climbing;

public class ControlClimb extends CommandBase {
	Climbing s_c;

	public ControlClimb(Climbing s0) {
		s_c = s0;
	}

	@Override public void execute() {
		double v = 0;
		if (UserInput.j_xbox.getPOV() == 90) v = 1;
		else
		if (UserInput.j_xbox.getPOV() == 270) v = -1;
		s_c.climb_speed = v * 0.5;
	}
}
