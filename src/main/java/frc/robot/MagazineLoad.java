package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MagazineLoad
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
