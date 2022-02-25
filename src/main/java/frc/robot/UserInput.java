package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Conains static instances for input devices. */
public class UserInput {
    public static final Joystick j_flightLeft = new Joystick(Constants.USB.j_flightLeft);
    public static final Joystick j_flightRight = new Joystick(Constants.USB.j_flightRight);
    public static final Joystick j_xbox  = new Joystick(Constants.USB.j_xbox);

    public static final JoystickButton // Instanciate the buttons for the xbox controller
        b_xboxA      = new JoystickButton(j_xbox, XboxController.Button.kA.value),
        b_xboxB      = new JoystickButton(j_xbox, XboxController.Button.kB.value),
        b_xboxX      = new JoystickButton(j_xbox, XboxController.Button.kX.value),
        b_xboxY      = new JoystickButton(j_xbox, XboxController.Button.kY.value),
        b_xboxL      = new JoystickButton(j_xbox, XboxController.Button.kLeftBumper.value),
        b_xboxR      = new JoystickButton(j_xbox, XboxController.Button.kRightBumper.value),
        b_xboxStickL = new JoystickButton(j_xbox, XboxController.Button.kLeftStick.value),
        b_xboxStickR = new JoystickButton(j_xbox, XboxController.Button.kRightStick.value)
    ;
}