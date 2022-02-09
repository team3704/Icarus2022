package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;

public class MotorGroup {
    BaseTalon[] motors;
    public MotorGroup(BaseTalon[] motors) {
        this.motors = motors;
    }
    public void set(double powerPercent) {
        for(BaseTalon motor : motors) motor.set(ControlMode.PercentOutput, powerPercent);
    }
    // invert moters before getting passed into group (or keep a reference to them to invert later)
    public void invert(int motorIndex, Boolean inverted) {
        motors[motorIndex].setInverted(true);
    }
}
