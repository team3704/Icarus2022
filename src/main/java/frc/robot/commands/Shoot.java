package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.BallTrack;

public class Shoot extends CommandBase {
    private BallTrack s_bt;

    public Shoot(BallTrack s0) {
        s_bt = s0;
    }

    @Override
    public void execute() {
        s_bt.shooter_speed = MathUtil.applyDeadband(
            UserInput.j_xbox.getRawAxis(XboxController.Axis.kRightTrigger.value) -
            UserInput.j_xbox.getRawAxis(XboxController.Axis.kLeftTrigger.value)
        , 0.2) * 1;
    }
}
