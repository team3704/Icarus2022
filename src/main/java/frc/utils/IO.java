package frc.utils;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public final class IO {
    // define commonly used objects here
    public static final XboxController c_xbox = new XboxController(RobotMap.XBOX_PORT);
    public static final Joystick c_stick_left = new Joystick(RobotMap.JOYSTICKL_PORT);
    public static final Joystick c_stick_right = new Joystick(RobotMap.JOYSTICKR_PORT);
}