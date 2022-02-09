package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.MotorGroup;

public class MagazineLoad extends CommandBase
{
    MotorGroup IntakeMotors;
    public double input = 0;

    public MagazineLoad() {
      IntakeMotors = new MotorGroup(new TalonSRX[] {new TalonSRX(5), new TalonSRX(2)});
    }
    @Override public void execute() {
      IntakeMotors.set(input);
    }
    @Override public void end(boolean interrupted) {}
    @Override public boolean isFinished() { return false; }
}
