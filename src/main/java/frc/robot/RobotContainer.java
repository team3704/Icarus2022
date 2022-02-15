// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

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
  private final Pneumatics sub_Pneumatics = new Pneumatics();

  private final TankDrive  cmd_TankDrive  = new TankDrive (sub_DriveTrain);

  private final Map<RobotState, ParallelCommandGroup> stateComands = new HashMap<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //#region Configure the button bindings
    UserInput.b_MX
      .whenPressed (new SetLL(sub_Limelight, sub_Limelight.nt.getEntry("ledMode"), 1))
      .whenReleased(new SetLL(sub_Limelight, sub_Limelight.nt.getEntry("ledMode"), 0));
    UserInput.b_MA.whenPressed(generateAutoDriveCommand(1,  0.5, 0));
    UserInput.b_MB.whenPressed(generateAutoDriveCommand(1, -0.5, 0));
    UserInput.b_ML.whenPressed(new SetLL(sub_Limelight, sub_Limelight.nt.getEntry("camMode"), 1));
    UserInput.b_MR.whenPressed(new SetLL(sub_Limelight, sub_Limelight.nt.getEntry("camMode"), 0));
    //#endregion
    //#region Setup command groups
    stateComands.put(RobotState.Auto, new ParallelCommandGroup(
      new SequentialCommandGroup(
        new WaitCommand(5),
        // drive test sequence
        generateAutoDriveCommand(0.25,  0, -1), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25,  0,  1), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25, -1,  0), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25,  1,  0), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25, -1, -1), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25,  1,  1), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25, -1,  1), new WaitCommand(0.25),
        generateAutoDriveCommand(0.25,  1, -1)
      )
    ));
    stateComands.put(RobotState.Teleop, new ParallelCommandGroup(
      cmd_TankDrive
    ));
    //#endregion
  }

  private AutoDrive generateAutoDriveCommand(double time, double throttle, double turn) {
    return new AutoDrive(sub_DriveTrain, throttle, turn, time);
  }

  public enum RobotState {
    Teleop,
    Auto,
    Test
  }
  private ParallelCommandGroup mainCommand = new ParallelCommandGroup();
  /**
   * Sets up the commands and subsystems for each state
   * @param s The state to set
   */
  public void changeState(RobotState s) {
    mainCommand.cancel();
    if (s == null) {
      System.out.println("Robot disabled. (state = null)");
    } else {
      mainCommand = stateComands.get(s);
      mainCommand.schedule();
    }
    // add subsystems to the scheduler (in case they were removed)
    CommandScheduler.getInstance().registerSubsystem(
      sub_Limelight,
      sub_DriveTrain,
      sub_Pneumatics
    );
  }
}