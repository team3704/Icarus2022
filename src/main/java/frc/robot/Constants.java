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
    // RoboRIO IO Device Ports will be defined within these subclasses
    /** CAN device ids */
    public static final class CAN {
        // gearbox motor pairs have primary (master) first, then secondary (slave).
        public static final int[] m_dl = {2, 1};
        public static final int[] m_dr = {6, 5};
        public static final int[] m_shooter = {0, 0};
    }
    /** PWM port ids (mainly used for servos) */
    public static final class PWM {

    }
    /** I2C device adresses */
    public static final class IIC {
        // color sensor?
    } 
    /** USB Order for Joysticks and other USB devices. */
    public static final class USB {
        public static final int j_fl = 0, j_fr = 1, j_mx = 2;
    }
}