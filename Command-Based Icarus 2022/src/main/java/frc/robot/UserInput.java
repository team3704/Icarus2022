package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/** Conains static instances for input devices. */
public class UserInput {
    public static final Joystick j_FL = new Joystick(Constants.USB.j_fl);
    public static final Joystick j_FR = new Joystick(Constants.USB.j_fr);
    public static final XboxController j_M = new XboxController(Constants.USB.j_mx);
}
