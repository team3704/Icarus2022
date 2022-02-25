package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** Does everything to move the balls around the robot. */
public class BallTrack extends SubsystemBase {
    TalonSRX    m_arm  = new TalonSRX(Constants.CAN.m_arm);
    WPI_TalonFX m_sl   = new WPI_TalonFX(Constants.CAN.m_shooter[0]);

    MotorControllerGroup mg_shooter = new MotorControllerGroup(m_sl);

    public double
        arm_target_position,
        arm_gravity_force = 0.1,
        shooter_speed
    ;

    public BallTrack() {

    }

    @Override
    public void periodic() {
        { // arm motion magic
            final double TICKS_P_DEGREE = 4096 / 360;
            double pos = m_arm.getSelectedSensorPosition();
            double angle = (pos - Constants.Position.Arm.center) - TICKS_P_DEGREE; // offset angle from center?
            double scalar = Math.cos(Math.toRadians(angle));
            m_arm.set(ControlMode.MotionMagic, arm_target_position, DemandType.ArbitraryFeedForward, arm_gravity_force * scalar);
        }
        mg_shooter.set(shooter_speed);
    }
}
