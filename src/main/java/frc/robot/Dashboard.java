package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.*;

// use this class to communitcate with Shuffleboard
// layouts saved in /dashboards

public final class Dashboard {
    public static void update() {
        SmartDashboard.putNumber("Speed Left", DriveTrain.speed_l);
        SmartDashboard.putNumber("Speed Right", DriveTrain.speed_r);
    }
}
