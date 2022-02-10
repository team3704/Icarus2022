package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class DriveTrain implements Subsystem {
    public final MotorController m_l0 = (MotorController) new TalonSRX(Constants.IO.m_dl[0]);
    public final MotorController m_l1 = (MotorController) new TalonSRX(Constants.IO.m_dl[1]);
    public final MotorController m_r0 = (MotorController) new TalonSRX(Constants.IO.m_dr[0]);
    public final MotorController m_r1 = (MotorController) new TalonSRX(Constants.IO.m_dr[1]);

    public final MotorControllerGroup mg_l = new MotorControllerGroup(m_l0, m_l1);
    public final MotorControllerGroup mg_r = new MotorControllerGroup(m_r0, m_r1);

    public final DifferentialDrive dd = new DifferentialDrive(mg_l, mg_r);
}
