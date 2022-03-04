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
        s_bt.arm_target_position = MathUtil.clamp(
            s_bt.arm_target_position - MathUtil.applyDeadband(
                UserInput.j_xbox.getRawAxis(XboxController.Axis.kLeftY.value),
                0.1
            ) * 25,
            Constants.Position.Arm.bottom, Constants.Position.Arm.top
        );
    }
    @Override public void initialize() {
        
    }
}