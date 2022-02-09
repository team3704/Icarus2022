package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.MotorGroup;

public class MagazineLoad extends CommandBase
{
    MotorGroup IntakeMotors;
    public double input = 0;
    @Override public void execute() {
      IntakeMotors.set(input);
    }
    public MagazineLoad() {
      IntakeMotors = new MotorGroup(new TalonSRX[] {new TalonSRX(5), new TalonSRX(2)});
    }
}
