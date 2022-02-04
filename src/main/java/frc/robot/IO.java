package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class IO {
    public static final XboxController c_xbox = new XboxController(RobotMap.XBOX_PORT);
    public static final Joystick c_stick_left = new Joystick(RobotMap.JOYSTICKL_PORT);
    public static final Joystick c_stick_right = new Joystick(RobotMap.JOYSTICKR_PORT);
}
