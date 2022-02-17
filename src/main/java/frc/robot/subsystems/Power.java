package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Power extends SubsystemBase {
	PowerDistribution pdp = new PowerDistribution();

	public Power() {
		
	}

	@Override public void periodic() {
	}
}