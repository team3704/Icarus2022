package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.UserInput;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  DriveTrain dt;
  Joystick   dj = UserInput.j_flightRight; // RED TAPE
  boolean    r  = false; // reverse

  public ArcadeDrive(DriveTrain s0) {
    dt = s0;
  }

  @Override
  public void end(boolean interrupted) {
    dt.driveSpeed = 0;
    r = false;
  }

  @Override
  public void execute() {
    if (dj.getRawButtonPressed(3)) r ^= true;
    double zi = dt.driveSpeed = (-dj.getZ() + 1) / 2d;
    if (dj.getRawButton(2)) zi = 0.25;
    if (dj.getRawButton(1)) zi = 1;
    double it, ir;
    it = dj.getY(); ir = dj.getX();
    if (r) { it *= -1; ir *= -1; }
    dt.dd.arcadeDrive(it, ir);
  }

  @Override
  public void initialize() {
    r = false;
  }
}
