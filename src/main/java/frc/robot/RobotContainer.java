// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final frc.robot.subsystems.DriveTrain sub_DriveTrain   = new frc.robot.subsystems.DriveTrain();
  private final frc.robot.subsystems.Limelight  sub_Limelight    = new frc.robot.subsystems.Limelight();
  private final frc.robot.subsystems.Power      sub_Power        = new frc.robot.subsystems.Power();
  private final frc.robot.subsystems.BallTrack  sub_BallTrack    = new frc.robot.subsystems.BallTrack();
  private final frc.robot.subsystems.Climbing   sub_Climbing     = new frc.robot.subsystems.Climbing();

  private final frc.robot.commands.Shoot        cmd_Shoot        = new frc.robot.commands.Shoot(sub_BallTrack);
  private final frc.robot.commands.TankDrive    cmd_TankDrive    = new frc.robot.commands.TankDrive(sub_DriveTrain);
  private final frc.robot.commands.SetLL        cmd_SetLL        (NetworkTableEntry entry, Integer value) { return new frc.robot.commands.SetLL(sub_Limelight, entry, value); }
  private final frc.robot.commands.autonomous.AutoDrive    cmd_AutoDrive    (double x, double z, double time) { return new frc.robot.commands.autonomous.AutoDrive(sub_DriveTrain, x, z, time); }
  private final frc.robot.commands.ControlArm   cmd_ControlArm   = new frc.robot.commands.ControlArm(sub_BallTrack);
  private final frc.robot.commands.ControlClimb cmd_ControlClimb = new frc.robot.commands.ControlClimb(sub_Climbing);
  private final frc.robot.commands.autonomous.AutoAim      cmd_AutoAim      = new frc.robot.commands.autonomous.AutoAim(sub_DriveTrain, sub_Limelight);
  private final frc.robot.commands.ArmDown      cmd_ArmDown      = new frc.robot.commands.ArmDown(sub_BallTrack);
  private final frc.robot.commands.autonomous.AutoShoot cmd_AutoShoot (double time) {return new frc.robot.commands.autonomous.AutoShoot(sub_BallTrack, time);}
  
  private final Map<RobotState, ParallelCommandGroup> stateCommands = new HashMap<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //#region Configure the button bindings
    UserInput.b_xboxL.toggleWhenPressed(cmd_SetLL(sub_Limelight.nt.getEntry("camMode"), 1));
    UserInput.b_xboxR.toggleWhenPressed(cmd_SetLL(sub_Limelight.nt.getEntry("ledMode"), 1));
    UserInput.b_xboxX.whileHeld(cmd_SetLL(sub_Limelight.nt.getEntry("ledMode"), 2));
    //UserInput.b_xboxY.toggleWhenPressed(cmd_ArmDown);
    UserInput.b_xboxBack.whenPressed(() -> {
      sub_BallTrack.m_arm.setSelectedSensorPosition(0);
    });
    //#endregion
    //#region Setup command groups
      stateCommands.put(RobotState.Auto, new ParallelCommandGroup(
      new SequentialCommandGroup(
        new WaitCommand(0.5),
        new ParallelCommandGroup(
          cmd_AutoDrive(-0.8, 0, 1.9),
          cmd_AutoShoot(5)
        )
        // cmd_AutoAim
      )
    ));
    stateCommands.put(RobotState.Teleop, new ParallelCommandGroup(
      cmd_TankDrive, cmd_ControlArm, cmd_ControlClimb, cmd_Shoot
    ));
    //#endregion
  }
  public enum RobotState { Teleop, Auto, Test }
  private ParallelCommandGroup mainCommand = null; // reference to the current state dependent command
  /**
   * Sets up the commands and subsystems for each state
   * @param s The state to set
   */
  public void setState(RobotState s) {
    sub_BallTrack.arm_target_position = 0;
    if (mainCommand != null) {
      mainCommand.cancel();
    }
    if (s == null) {
      System.out.println("Robot disabled. (state = null)");
    } else {
      mainCommand = stateCommands.get(s);
      mainCommand.schedule();
    }
    if (s == RobotState.Teleop) {
      sub_BallTrack.m_arm.setSelectedSensorPosition(0);
    } else if (s == RobotState.Auto) {
      
    }
  }
}