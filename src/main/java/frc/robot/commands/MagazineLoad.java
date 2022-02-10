package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.utils.MotorGroup;

public class MagazineLoad extends CommandBase
{
    MotorGroup IntakeMotors;
    public double input = 0;

    public MagazineLoad() {
      IntakeMotors = new MotorGroup(new TalonSRX[] {
        new TalonSRX(RobotMap.MOTOR_PORT_M0),
        new TalonSRX(RobotMap.MOTOR_PORT_M1)
      });
    }
    @Override public void execute() {
      IntakeMotors.set(input);
    }
    @Override public void end(boolean interrupted) {}
    @Override public boolean isFinished() { return false; }
}
