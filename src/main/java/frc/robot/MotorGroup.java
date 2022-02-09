package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;

public class MotorGroup {
    public BaseTalon[] motors;
    public MotorGroup(BaseTalon[] motors) {
        this.motors = motors;
    }
    public void set(double powerPercent) {
        for(BaseTalon motor : motors) motor.set(ControlMode.PercentOutput, powerPercent);
    }
}
