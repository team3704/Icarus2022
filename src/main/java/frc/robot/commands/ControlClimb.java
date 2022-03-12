package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.Climbing;

public class ControlClimb extends CommandBase {
	Climbing s_c;

	public ControlClimb(Climbing s0) {
		s_c = s0;
	}

	@Override public void end(boolean interrupted) {
		
	}

	@Override public void execute() {
		s_c.climb_speed = MathUtil.applyDeadband(
			(
				UserInput.j_xbox.getRawAxis(XboxController.Axis.kRightTrigger.value) -
				UserInput.j_xbox.getRawAxis(XboxController.Axis.kLeftTrigger.value)
			),
		0.2) * 0.5;
	}

	@Override public void initialize() {

	}
}
