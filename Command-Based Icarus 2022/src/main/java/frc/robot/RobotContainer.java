// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.LLLeds;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain sub_DriveTrain = new DriveTrain();
  private final Limelight  sub_Limelight  = new Limelight();

  private final TankDrive  cmd_TankDrive  = new TankDrive (sub_DriveTrain);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    UserInput.b_MX
      .whenPressed (new LLLeds(sub_Limelight, 1))
      .whenReleased(new LLLeds(sub_Limelight, 0));
    UserInput.b_MA.whenPressed(generateAutoDriveCommand(1,  0.5, 0));
    UserInput.b_MB.whenPressed(generateAutoDriveCommand(1, -0.5, 0));
  }

  private AutoDrive generateAutoDriveCommand(double time, double throttle, double turn) {
    return new AutoDrive(sub_DriveTrain, throttle, turn, time);
  }

  public enum RobotState {
    Teleop,
    Auto,
    Test
  }
  /**
   * Sets up the commands and subsystems for each state
   * @param s The state to set
   */
  public void changeState(RobotState s) {
    CommandScheduler.getInstance().cancelAll();
    ParallelCommandGroup cg = new ParallelCommandGroup();
    switch (s) {
      case Auto:
        cg.addCommands(
          new WaitCommand(5),
          new LLLeds(sub_Limelight, 1),
          new WaitCommand(5),
          new LLLeds(sub_Limelight, 2),
          new WaitCommand(5),
          new LLLeds(sub_Limelight, 3),
          new WaitCommand(5),
          new LLLeds(sub_Limelight, 0)
        );
        break;
      case Teleop:
        cg.addCommands(cmd_TankDrive);
        break;
      case Test:
        break;
      default:
        break;
    }
    cg.schedule();

    // add subsystems to the scheduler (in case they were removed)
    CommandScheduler.getInstance().registerSubsystem(
      sub_Limelight,
      sub_DriveTrain
    );
  }
}
