package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class UserInput implements Subsystem {
    public Joystick j_FL = new Joystick(Constants.USB.j_fl);
    public Joystick j_FR = new Joystick(Constants.USB.j_fr);
    public XboxController j_M = new XboxController(Constants.USB.j_mx);
}
