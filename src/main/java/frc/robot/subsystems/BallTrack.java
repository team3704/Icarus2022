package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** Does everything to move the balls around the robot. */
public class BallTrack extends SubsystemBase {
    TalonSRX    m_arm  = new TalonSRX(Constants.CAN.m_arm);
    WPI_TalonFX m_sl   = new WPI_TalonFX(Constants.CAN.m_shooter[0]);

    MotorControllerGroup mg_shooter = new MotorControllerGroup(m_sl);

    public double
        arm_target_position,
        shooter_speed,
        intake_speed
    ;
    public int
        arm_target_position_int
    ;

    public BallTrack() {
        
    }

    @Override
    public void periodic() {
        { // arm motion magic
            arm_target_position_int = ((int) Math.round(arm_target_position / 25) * 25);
            m_arm.set(ControlMode.MotionMagic, arm_target_position_int, DemandType.Neutral, 0);
        }
        mg_shooter.set(shooter_speed);
        SmartDashboard.putNumber("Arm Target Position", (arm_target_position_int));
    }
}
