package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MagazineLoad
{
    static TalonSRX[] motors = new TalonSRX[]
    {
      new TalonSRX(0), new TalonSRX(0)
    };
    static MotorGroup IntakeMotors = new MotorGroup(motors);
    public static void moveMotor() 
    {
      double leftT = IO.c_xbox.getLeftTriggerAxis();
      IntakeMotors.set(leftT);
    }
}
