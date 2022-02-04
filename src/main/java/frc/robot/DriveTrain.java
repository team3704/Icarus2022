package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain {
    public static double speed = 0;

    public static MotorGroup 
        left = new MotorGroup(new TalonSRX[] {new TalonSRX(RobotMap.MOTOR_PORT_FL), new TalonSRX(RobotMap.MOTOR_PORT_BL)}),
        right = new MotorGroup(new TalonSRX[] {new TalonSRX(RobotMap.MOTOR_PORT_FR), new TalonSRX(RobotMap.MOTOR_PORT_BR)});

    public static void arcadeDrive() {
        left.set((IO.c_xbox.getLeftX() - IO.c_xbox.getLeftY()) * speed);
        right.set((IO.c_xbox.getLeftX() + IO.c_xbox.getLeftY()) * speed);
    }
    public static void tankDrive() {
        left.set(-IO.c_stick_left.getRawAxis(1) * speed);
        right.set(-IO.c_stick_right.getRawAxis(1) * speed);
    }
}
