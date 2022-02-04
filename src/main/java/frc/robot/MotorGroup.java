package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class MotorGroup {
    BaseTalon[] motors;
    /**
     * @param Motors hello
     */
    public MotorGroup(BaseTalon[] motors) {
        this.motors = motors;
    }
    public void set(double powerPercent) {
        for(BaseTalon motor : motors) {
            motor.set(ControlMode.PercentOutput, powerPercent);
        }
    }
    public void invert(int motorIndex) {
        motors[motorIndex].setInverted(InvertType.InvertMotorOutput);
    }
}
