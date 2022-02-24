package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** Does everything to move the balls around the robot. */
public class BallTrack extends SubsystemBase {
    CANSparkMax m_sparky = new CANSparkMax(Constants.CAN.m_arm, MotorType.kBrushed); // arm
    WPI_TalonFX m_sl     = new WPI_TalonFX(Constants.CAN.m_shooter[0]);

    MotorControllerGroup mg_shooter = new MotorControllerGroup(m_sl);

    public double sparky_speed  = 0;
    public double shooter_speed = 0;

    public BallTrack() {
        
    }

    @Override
    public void periodic() {
        m_sparky.set(sparky_speed);
        mg_shooter.set(shooter_speed);
    }
    
}
