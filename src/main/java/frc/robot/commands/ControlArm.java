package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

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
        //TODO: Find position limits
        s_bt.arm_target_position = MathUtil.clamp(s_bt.arm_target_position + MathUtil.applyDeadband(UserInput.j_xbox.getRawAxis(XboxController.Axis.kRightY.value), 0.2), Constants.POS.arm.bottom, Constants.POS.arm.top);
    }
    @Override public void initialize() {
        
    }
}