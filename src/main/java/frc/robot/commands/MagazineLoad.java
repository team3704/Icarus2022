package frc.robot.commands;
import java.util.Set;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotMap;
import frc.utils.Autonomous;
import frc.utils.MotorGroup;

public class MagazineLoad implements Command, Autonomous
{
    MotorGroup IntakeMotors;
    public double input = 0;

    public MagazineLoad() {
      IntakeMotors = new MotorGroup(new TalonSRX[] {
        new TalonSRX(2),
        new TalonSRX(5)
      });
    }
    @Override public void execute() {
      IntakeMotors.set(input);
    }
    @Override public void end(boolean interrupted) {}
    @Override public boolean isFinished() { return false; }
    @Override
    public Set<Subsystem> getRequirements() {
      return null;
    }
    @Override
    public void finishAuton() {
      IntakeMotors.set(0);
    }
    @Override
    public void runAuton() {
      IntakeMotors.set(0.2);     
    }

}
