// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // IO Ports will be defined within this subclass
    public static final class IOPorts {
        // gearbox motor pairs have primary first, then secondary
        public static final int[] mpDirveLeft  = new int[] {0, 0};
        public static final int[] mpDirveRight = new int[] {0, 0};
    }
    public static final class JoystickUSB {
        public static final int FlightStickLeft = 0;
        public static final int FlightStickRight = 1;
        public static final int ManipulationXboxController = 2;
    }
}
