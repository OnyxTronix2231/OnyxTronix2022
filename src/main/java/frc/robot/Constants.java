/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int DRIVE_JOYSTICK_PORT = 0;
    public static final int DEPUTY_JOYSTICK_PORT = 1;

    public static final int LOW_PRIORITY_STATUS_FRAME_PERIODIC = 255;

    public static final double TARGET_POSE_X = 8.258; // previous 9.457
    public static final double TARGET_POSE_Y = 4.069; // previous 4.3

//    public static final double TARGET_POSE_X = 0;
//    public static final double TARGET_POSE_Y = 0;

    public static final double ARC_CALIBRATION_SPEED = -0.3;

    public static final int VISION_PIPELINE = 2;
}
