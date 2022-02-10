package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class UserInput implements Subsystem {
    public Joystick jFlightLeft = new Joystick(Constants.JoystickUSB.FlightStickLeft);
    public Joystick jFlightRight = new Joystick(Constants.JoystickUSB.FlightStickRight);
    public XboxController xManipulate = new XboxController(Constants.JoystickUSB.ManipulationXboxController);

    
}
