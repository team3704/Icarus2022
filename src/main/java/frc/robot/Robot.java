// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer.RobotState;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private RobotContainer rc;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings,
    // and do pretty much everything else lol.
    rc = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override public void robotPeriodic     () { CommandScheduler.getInstance().run(); }

  @Override public void disabledInit      () { rc.setState(           null  ); }
  @Override public void autonomousInit    () { rc.setState(RobotState.Auto  ); }
  @Override public void teleopInit        () { rc.setState(RobotState.Teleop); }
  @Override public void testInit          () { rc.setState(RobotState.Test  ); }

  @Override public void disabledPeriodic  () {}
  @Override public void autonomousPeriodic() {}
  @Override public void teleopPeriodic    () {}
  @Override public void testPeriodic      () {}
}
