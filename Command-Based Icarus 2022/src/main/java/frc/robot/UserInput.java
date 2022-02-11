package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Conains static instances for input devices. */
public class UserInput {
    public static final Joystick j_FL = new Joystick(Constants.USB.j_fl);
    public static final Joystick j_FR = new Joystick(Constants.USB.j_fr);
    public static final Joystick j_M  = new Joystick(Constants.USB.j_mx);

    public static final JoystickButton // Instanciate the buttons for the xbox controller
        b_MA = new JoystickButton(j_M, XboxController.Button.kA.value),
        b_MB = new JoystickButton(j_M, XboxController.Button.kB.value),
        b_MX = new JoystickButton(j_M, XboxController.Button.kX.value),
        b_MY = new JoystickButton(j_M, XboxController.Button.kY.value),
        b_ML = new JoystickButton(j_M, XboxController.Button.kLeftBumper.value),
        b_MR = new JoystickButton(j_M, XboxController.Button.kRightBumper.value);
}
