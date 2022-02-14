package frc.robot.subsystems;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
    private final NetworkTableInstance nti   = NetworkTableInstance.getDefault();
    public  final NetworkTable nt            = nti.getTable("limelight");
    private final NetworkTableEntry angle_h  = nt.getEntry("tx"); // target offset angle horozontal
    private final NetworkTableEntry angle_v  = nt.getEntry("ty"); // target offset angle vertical
    private final NetworkTableEntry area     = nt.getEntry("ta"); // target area
    private final NetworkTableEntry skew     = nt.getEntry("ts"); // target skew
    // api: https://docs.limelightvision.io/en/latest/networktables_api.html
    // docs: https://docs.limelightvision.io/en/latest/
    // estimating distance: https://docs.limelightvision.io/en/latest/cs_estimating_distance.html
    // downloads: https://limelightvision.io/pages/downloads/ (finder tool is essential!)
    // default adress: http://10.37.4.28:5801/ (use to manage the limelight)
    // TODO: tune the limelight using the adress above

    @Override public void periodic() {
        
    }
}