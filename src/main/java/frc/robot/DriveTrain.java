package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain {
    public static double speed_l = 0, speed_r = 0;

    public static MotorGroup 
        left = new MotorGroup(new TalonSRX[] {new TalonSRX(RobotMap.MOTOR_PORT_FL), new TalonSRX(RobotMap.MOTOR_PORT_BL)}),
        right = new MotorGroup(new TalonSRX[] {new TalonSRX(RobotMap.MOTOR_PORT_FR), new TalonSRX(RobotMap.MOTOR_PORT_BR)});

    public static void arcadeDrive() {
        left.set((IO.c_xbox.getLeftX() - IO.c_xbox.getLeftY()) * speed_l);
        right.set((IO.c_xbox.getLeftX() + IO.c_xbox.getLeftY()) * speed_r);
    }
    public static void tankDrive() {
        left.set(-IO.c_stick_left.getRawAxis(1) * speed_l);
        right.set(-IO.c_stick_right.getRawAxis(1) * speed_r);
    }
}
