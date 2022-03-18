package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** Does everything to move the balls around the robot. */
public class BallTrack extends SubsystemBase {
    public TalonSRX    m_arm    = new TalonSRX(Constants.CAN.m_arm);
    VictorSPX   m_intake = new VictorSPX(Constants.CAN.m_intake);
    VictorSPX   m_feed   = new VictorSPX(Constants.CAN.m_feed);
    WPI_TalonFX m_sl     = new WPI_TalonFX(Constants.CAN.m_shooter[0]);

    MotorControllerGroup mg_shooter = new MotorControllerGroup(m_sl);

    public double
        arm_target_position,
        shooter_speed,
        intake_speed,
        feed_speed
    ;
    public BallTrack() {
        m_sl.setInverted(InvertType.InvertMotorOutput);
    }

    @Override
    public void periodic() {
        double topPercentage = (m_arm.getSelectedSensorPosition() + 100) / -1300;
        double bottomPercentage = (m_arm.getSelectedSensorPosition() + 100) / 1300;
        // positive = up -100
        // negative = down -1400
        if(arm_target_position == -100) m_arm.set(ControlMode.PercentOutput, (topPercentage));
        else m_arm.set(ControlMode.PercentOutput, bottomPercentage);
        
        /*{ //#region arm
            m_arm.set(ControlMode.MotionMagic, arm_target_position, DemandType.Neutral, 0);
            m_intake.set(ControlMode.PercentOutput, intake_speed);
        } //#endregion*/
        { //#region feeder
            m_feed.set(ControlMode.PercentOutput, feed_speed);
        } //#endregion
        { //#region shooter
            mg_shooter.set(shooter_speed);
        } //#endregion
    }
}
