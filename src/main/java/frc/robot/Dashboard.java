package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.*;

// use this class to communitcate with Shuffleboard
// layouts saved in Icarus2022/dashboards

public final class Dashboard {
    public static void update() {
        SmartDashboard.putNumber("Drive Speed", DriveTrain.speed);
        SmartDashboard.updateValues();
    }
}
