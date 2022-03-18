package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class AutoAim extends CommandBase {
  DriveTrain s_dt;
  Limelight s_ll;

  final double error = 0.1;

  public AutoAim(DriveTrain s0, Limelight s1) {
    s_dt = s0; s_ll = s1;
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public void execute() {
    double t_h = s_ll.angle_h.getDouble(0), t_v = s_ll.angle_v.getDouble(0);
    double t_dist = Math.abs(Math.sqrt(t_h + t_v));
    if (t_h < error || t_h > -error) t_dist = 0;
    s_dt.dd.arcadeDrive(0, Math.copySign(t_dist, -t_h));
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
