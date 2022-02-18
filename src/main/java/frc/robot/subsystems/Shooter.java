package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private final MotorController shooterController = new WPI_TalonFX(Constants.CAN.m_shooter[0]);
    public double output = 0;
    @Override public void periodic() {
        shooterController.set(output);
    }
}
