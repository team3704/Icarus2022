package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climbing extends SubsystemBase {
	WPI_VictorSPX m_cl = new WPI_VictorSPX(Constants.CAN.m_climb[0]);
	WPI_VictorSPX m_cr = new WPI_VictorSPX(Constants.CAN.m_climb[1]);
	
	MotorControllerGroup mg_climb = new MotorControllerGroup(m_cl, m_cr);

	public double climb_speed;

	public Climbing() {
		m_cr.setInverted(InvertType.InvertMotorOutput);
	}

	@Override public void periodic() {
		mg_climb.set(climb_speed);
	}
}
