package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    private Shooter shooter;
    public Shoot(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override public void execute() {
        shooter.output = 1;
    }

    @Override public void end(boolean interrupted) {
        shooter.output = 0;
    }
    
    @Override public boolean isFinished() {return false;}
}
