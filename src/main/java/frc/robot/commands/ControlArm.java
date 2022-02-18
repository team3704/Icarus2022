package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.BallTrack;

public class ControlArm extends CommandBase {
    BallTrack s_bt;

    public ControlArm(BallTrack s_bt) {
        this.s_bt = s_bt;
    }

    @Override
    public void end(boolean interrupted) {
        s_bt.sparky_speed = 0;
    }

    @Override
    public void execute() {
        s_bt.sparky_speed = MathUtil.applyDeadband(UserInput.j_xbox.getRawAxis(XboxController.Axis.kRightY.value), 0.1);
    }

    @Override
    public void initialize() {
        
    }
}