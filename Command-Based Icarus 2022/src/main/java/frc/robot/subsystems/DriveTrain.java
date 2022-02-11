package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private final MotorController m_l0 = new WPI_TalonSRX(Constants.IO.m_dl[0]);
    private final MotorController m_l1 = new WPI_TalonSRX(Constants.IO.m_dl[1]);
    private final MotorController m_r0 = new WPI_TalonSRX(Constants.IO.m_dr[0]);
    private final MotorController m_r1 = new WPI_TalonSRX(Constants.IO.m_dr[1]);

    private final MotorControllerGroup mg_l = new MotorControllerGroup(m_l0, m_l1);
    private final MotorControllerGroup mg_r = new MotorControllerGroup(m_r0, m_r1);

    public final DifferentialDrive dd = new DifferentialDrive(mg_l, mg_r);

    public DriveTrain() {
        m_r0.setInverted(true);
        m_r1.setInverted(true);
    }

    public double driveSpeed = 1;

    @Override public void periodic() {
        dd.setMaxOutput(driveSpeed);
        SmartDashboard.putNumber("Drive Speed", driveSpeed);
    }
}
