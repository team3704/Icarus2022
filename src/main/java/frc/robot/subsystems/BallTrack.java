package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallTrack extends SubsystemBase {
    Spark sparky = new Spark(Constants.PWM.m_arm);
    public double sparky_speed = 0;

    public BallTrack() {

    }

    @Override
    public void periodic() {
        sparky.set(sparky_speed);
    }
    
}
