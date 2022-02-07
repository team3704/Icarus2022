package frc.robot;

import edu.wpi.first.networktables.*;

public final class Vision {
    private static NetworkTableInstance nti   = NetworkTableInstance.getDefault();
    private static NetworkTable nt            = nti.getTable("limelight");
    private static NetworkTableEntry
        angle_h  = nt.getEntry("tx"), // target offset angle horozontal
        angle_v  = nt.getEntry("ty"), // target offset angle vertical
        area     = nt.getEntry("ta"), // target area
        skew     = nt.getEntry("ts"); // target skew
    // api: https://docs.limelightvision.io/en/latest/networktables_api.html
    // docs: https://docs.limelightvision.io/en/latest/
    // estimating distance: https://docs.limelightvision.io/en/latest/cs_estimating_distance.html
    // downloads: https://limelightvision.io/pages/downloads/ (finder tool is essential!)
    // default adress: http://10.37.4.28:5801/ (use to manage the limelight)
    // TODO: tune the limelight using the adress above

    public static void update() {

    }
}