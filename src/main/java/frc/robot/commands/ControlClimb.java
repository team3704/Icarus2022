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
		s_c.climb_speed = 0 * ((UserInput.j_xbox.getPOV() == 90) ? 1 : ((UserInput.j_xbox.getPOV() == 270) ? -1 : 0));
	}
}
