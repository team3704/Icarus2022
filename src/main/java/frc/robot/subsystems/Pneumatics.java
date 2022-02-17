package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
	Compressor compressor = null;

	public Pneumatics() {
		try {
			compressor = new Compressor(PneumaticsModuleType.CTREPCM);
		} catch (Exception e) {
			System.out.println("Can't get the compressor. Is the PCM connected?");
		}
	}

	@Override public void periodic() {
		if (compressor != null) {
			
		}
 	}
}