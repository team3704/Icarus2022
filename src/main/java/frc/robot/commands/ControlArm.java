package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.UserInput;
import frc.robot.subsystems.BallTrack;

public class ControlArm extends CommandBase {
    BallTrack s_bt;

    public ControlArm(BallTrack s0) {
        s_bt = s0;
    }

    @Override public void end(boolean interrupted) {

    }
    @Override public void execute() {
        s_bt.intake_speed = MathUtil.applyDeadband(
            UserInput.j_xbox.getRawAxis(XboxController.Axis.kRightY.value),
            0.2
        ) * 0.5;
        s_bt.feed_speed = MathUtil.applyDeadband(
            UserInput.j_xbox.getRawAxis(XboxController.Axis.kLeftY.value),
            0.042069
        ) * 0.75;
    }
    @Override public void initialize() {
        
    }
}