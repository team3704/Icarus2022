package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
	Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

	@Override public void periodic() {

	}
}
