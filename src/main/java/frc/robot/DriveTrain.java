package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.utils.IO;
import frc.utils.MotorGroup;

public final class DriveTrain {
    public static double speed = 0;

    public static MotorGroup 
        left = new MotorGroup(new TalonSRX[] {new TalonSRX(RobotMap.MOTOR_PORT_FL), new TalonSRX(6)}),
        right = new MotorGroup(new TalonSRX[] {new TalonSRX(RobotMap.MOTOR_PORT_FR), new TalonSRX(1)});

    // made driving properties into seperate variables
    // change these to drive during autonomous!
    public static double throttle = 0;
    public static double turn = 0;
    public static double power_left = 0;
    public static double power_right = 0;
    
    public static void arcadeDrive() {
        throttle = IO.c_xbox.getLeftY();
        turn     = IO.c_xbox.getLeftX();
    }
    public static void tankDrive() {
        power_left  = IO.c_stick_left.getRawAxis(1);
        power_right = -IO.c_stick_right.getRawAxis(1);
    }
    public static void update() {
        left .set(((power_left ) + (throttle - turn)) * speed);
        right.set(((power_right) + (throttle + turn)) * speed);
    }
}
