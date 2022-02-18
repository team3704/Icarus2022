// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final frc.robot.subsystems.DriveTrain sub_DriveTrain = new frc.robot.subsystems.DriveTrain();
  private final frc.robot.subsystems.Limelight  sub_Limelight  = new frc.robot.subsystems.Limelight();
  private final frc.robot.subsystems.Pneumatics sub_Pneumatics = new frc.robot.subsystems.Pneumatics();
  private final frc.robot.subsystems.Power      sub_Power      = new frc.robot.subsystems.Power();
  private final frc.robot.subsystems.Shooter    sub_Shooter    = new frc.robot.subsystems.Shooter();

  private final frc.robot.commands.Shoot        cmd_Shoot = new frc.robot.commands.Shoot(sub_Shooter);
  private final frc.robot.commands.TankDrive    cmd_TankDrive  = new frc.robot.commands.TankDrive(sub_DriveTrain);
  private final frc.robot.commands.SetLL        cmd_SetLL        (NetworkTableEntry entry, Integer value) { return new frc.robot.commands.SetLL(sub_Limelight, entry, value);    }
  private final frc.robot.commands.AutoDrive    cmd_AutoDrive    (double x, double z, double time)        { return new frc.robot.commands.AutoDrive(sub_DriveTrain, x, z, time); }

  private final Map<RobotState, ParallelCommandGroup> stateComands = new HashMap<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //#region Configure the button bindings
    UserInput.b_xboxL.toggleWhenPressed(cmd_SetLL(sub_Limelight.nt.getEntry("camMode"), 1));
    UserInput.b_xboxR.toggleWhenPressed(cmd_SetLL(sub_Limelight.nt.getEntry("ledMode"), 1));
    UserInput.b_xboxX.whileHeld(cmd_SetLL(sub_Limelight.nt.getEntry("ledMode"), 2));
    UserInput.b_xboxY.whileHeld(cmd_Shoot);
    //#endregion
    //#region Setup command groups
    stateComands.put(RobotState.Auto, new ParallelCommandGroup(
      new SequentialCommandGroup(
        new WaitCommand(5),
        // drive test sequence
        cmd_AutoDrive(0   ,  1   , 1),
        cmd_AutoDrive(0   , -1   , 1),
        cmd_AutoDrive(0   ,  0.5 , 1),
        cmd_AutoDrive(0   , -0.5 , 1),
        cmd_AutoDrive(0   ,  0.25, 1),
        cmd_AutoDrive(0   , -0.25, 1),
        cmd_AutoDrive( 0.5,  0   , 1),
        cmd_AutoDrive(-0.5,  1   , 1)
      )
    ));
    stateComands.put(RobotState.Teleop, new ParallelCommandGroup(
      cmd_TankDrive
    ));
    //#endregion
  }
  public enum RobotState {
    Teleop,
    Auto,
    Test
  }
  private ParallelCommandGroup mainCommand; // reference to the current state dependent command
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
      sub_Pneumatics,
      sub_Power
    );
  }
}