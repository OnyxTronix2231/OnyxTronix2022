package frc.robot.turret;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

import static frc.robot.Constants.TARGET_POSE_X;
import static frc.robot.Constants.TARGET_POSE_Y;
import static frc.robot.turret.TurretConstants.ComponentsConstants.*;

public final class TurretConstants {

    /*fixed values*/
    public static final Pose2d TARGET_POS = new Pose2d(0, 0, new Rotation2d()); //TODO: Correct the number
    public static final int DEG_IN_CIRCLE = 360;
    public static final int DEG_IN_HALF_CIRCLE = 180;

    /*PID values*/
    public static final int ACCELERATION = 50000;
    public static final int CRUISE_VELOCITY = 17000;
    public static final int ACC_SMOOTHING = 0;
    public static final double KP = 0.6;
    public static final double KI = 0.005;
    public static final double KD = 2;
    public static final double KF = 0.047;

    /*system settings*/
    public static final int MIDDLE_ANGLE = 0;
    public static final int INTEGRAL_ZONE = 100;
    public static final double TOLERANCE_DEGREES = 2; //TODO: Correct the number
    public static final double DEFAULT_TURRET_SPEED = 0.2;

    /*field settings*/
    public static final double SIDE_TARGET_OFFSET = 0.25; //TODO: Correct the number
    public static final double DRIVERS_DIRECTION = 0;
    public static final Pose2d P1 = new Pose2d(TARGET_POSE_X, 0.5 * TARGET_POSE_Y, new Rotation2d());
    public static final Pose2d P2 = new Pose2d(TARGET_POSE_X, 1.5 * TARGET_POSE_Y, new Rotation2d());

    public static class ComponentsConstants {

        /*mechanic values*/
        static final int ENCODER_UNITS_RESOLUTION = 2048;
        static final int OUTER_ENCODER_UNITS_RESOLUTION = 4096;
        static final int TURRET_MOTOR_ID = 9;
        static final int TURRET_ENCODER_ID = 0;
        static final int ENCODER_DEFAULT_ERROR = 480; // out of 4096
        static final double ENCODER_OFFSET = 1;
        static final double CONVERSION_RATE = 1.0 / 75;
        static final double MAX_DEG = 320; //TODO: Correct the number
        static final double MIN_DEG = -60; //TODO: Correct the number
        static final double DEG_IN_TURRET_ROTATION = DEG_IN_CIRCLE * CONVERSION_RATE;

        static final int SUPPLY_CURRENT_LIMIT = 20;
        static final int SUPPLY_TRIGGER_THRESHOLD_CURRENT = 25;
        static final double SUPPLY_TRIGGER_THRESHOLD_TIME = 0.05;
        static final boolean SUPPLY_CURRENT_LIMIT_ENABLED = true;
        static final double OPEN_LOOP_RAMP = 0;
        static final double CLOSE_LOOP_RAMP = 0;
    }

    public static final class Calculation {

        static int degreesToEncoderUnits(double degree) {
            return (int) ((degree * ENCODER_UNITS_RESOLUTION) / DEG_IN_TURRET_ROTATION);
        }

        static int degreesToAbsoluteEncoderUnits(double degree) {
            return (int) ENCODER_OFFSET + degreesToEncoderUnits(degree);
        }

        public static double encoderUnitsToDegrees(double encoderUnits) {
            return (encoderUnits * DEG_IN_TURRET_ROTATION) / ENCODER_UNITS_RESOLUTION;
        }

        public static double absoluteEncoderUnitsToDegrees(double encoderUnits) {
            return encoderUnitsToDegrees(encoderUnits - ENCODER_OFFSET);
        }

        public static double fixAngleAccordingToLimits(double deg) {
            double fixedAngle = deg;
            if (fixedAngle > MAX_DEG) {
                fixedAngle -= DEG_IN_CIRCLE;
            }
            if (fixedAngle < MIN_DEG) {
                fixedAngle += DEG_IN_CIRCLE;
            }
            return fixedAngle;
        }
    }
}
