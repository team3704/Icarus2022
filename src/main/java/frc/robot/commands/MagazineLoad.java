package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.IO;
import frc.robot.MotorGroup;

public class MagazineLoad extends CommandBase
{
    static TalonSRX[] motors = new TalonSRX[]
    {
      new TalonSRX(5), new TalonSRX(2)
    };
    static MotorGroup IntakeMotors = new MotorGroup(motors);
    public static void moveMotor() 
    {
      double leftT = IO.c_xbox.getLeftTriggerAxis();
      IntakeMotors.set(leftT);
    }
    public static void moveMotor(int index) 
    {
      double leftT = IO.c_xbox.getLeftTriggerAxis();
      motors[index].set(ControlMode.PercentOutput, leftT);
    }
}
