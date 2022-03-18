package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BallTrack;

public class ArmDown extends CommandBase {
  BallTrack s_bt;

  public ArmDown(BallTrack s_bt) {
    this.s_bt = s_bt;
  }

  @Override
  public void initialize() {
    s_bt.arm_target_position *= -1;
  }

  @Override
  public void end(boolean interrupted) {
    s_bt.arm_target_position = Constants.Position.Arm.top;
  }
}
