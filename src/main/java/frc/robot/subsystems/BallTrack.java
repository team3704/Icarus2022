package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.UserInput;

/** Does everything to move the balls around the robot. */
public class BallTrack extends SubsystemBase {
    public enum armDirection {
        Up,
        Down
    }
    public armDirection direction = armDirection.Up;
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
        // positive = up -100
        // center = -750
        // negative = down -1400
        
        { //#region arm
            //m_arm.set(ControlMode.MotionMagic, arm_target_position, DemandType.Neutral, 0);
            m_intake.set(ControlMode.PercentOutput, intake_speed);
            
            /*if(
                (direction == armDirection.Up && m_arm.getSelectedSensorPosition() > -500) ||
                (direction == armDirection.Down && m_arm.getSelectedSensorPosition() < -1000)) m_arm.set(ControlMode.PercentOutput, 0);
            else {
                double topOffSet = m_arm.getSelectedSensorPosition() / -1200;
                double th = 0.25;
                SmartDashboard.putNumber("Arm Center Offset %", topOffSet);
                SmartDashboard.putNumber("Arm Throttle", th);
                m_arm.set(
                ControlMode.PercentOutput, th * (direction == armDirection.Down ? -1 :0)
                );
            }*/
            m_arm.set(ControlMode.PercentOutput,
                (UserInput.j_xbox.getRawButton(XboxController.Button.kA.value) ? 0.5 : 0)
                - (UserInput.j_xbox.getRawButton(XboxController.Button.kB.value) ? 0.5 : 0)
            );
        } //#endregion
        { //#region feeder
            m_feed.set(ControlMode.PercentOutput, feed_speed);
        } //#endregion
        { //#region shooter
            mg_shooter.set(shooter_speed);
        } //#endregion

        SmartDashboard.putNumber("Arm Position", m_arm.getSelectedSensorPosition());
    }
}
