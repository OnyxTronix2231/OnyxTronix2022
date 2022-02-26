package frc.robot.turret;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

import static frc.robot.turret.TurretConstants.ComponentsConstants.*;

public final class TurretConstants {

    /*fixed values*/
    public static final Pose2d TARGET_POS = new Pose2d(0, 0, new Rotation2d()); //TODO: Correct the number
    public static final int DEG_IN_CIRCLE = 360;
    public static final int DEG_IN_HALF_CIRCLE = 180;

    /*PID values*/
    public static final int ACCELERATION = 4000; //TODO: calibrate
    public static final int CRUISE_VELOCITY = 480; //TODO: calibrate
    public static final int ACC_SMOOTHING = 0; //TODO: calibrate
    public static final double KP = 4; //TODO: calibrate
    public static final double KI = 0; //TODO: calibrate
    public static final double KD = 3; //TODO: calibrate
    public static final double KF = 1.82; //TODO: calibrate

    /*system settings*/
    public static final int MIDDLE_ANGLE = 0;
    public static final double TOLERANCE_DEGREES = 0; //TODO: Correct the number
    public static final double DEFAULT_TURRET_SPEED = 1;

    public static class ComponentsConstants {

        /*mechanic values*/
        static final int ENCODER_UNITS_IN_ROTATION = 4096;
        static final int TURRET_MOTOR_ID = 9;
        static final int TALON_ENCODER_ID = 8;
        static final double ENCODER_OFFSET = 2062;
        //static final double CONVERSION_RATE = 1.0 / 75;
        static final double CONVERSION_RATE = 1.0;
        static final double MAX_DEG = 160; //TODO: Correct the number
        static final double MIN_DEG = -270; //TODO: Correct the number
        static final double DEG_IN_TURRET_ROTATION = DEG_IN_CIRCLE * CONVERSION_RATE;
    }

    public static final class Calculation {

        static int degreesToEncoderUnits(double degree) {
            return (int) ((degree * ENCODER_UNITS_IN_ROTATION) / DEG_IN_TURRET_ROTATION);
        }

        static int degreesToAbsoluteEncoderUnits(double degree) {
            return (int) ENCODER_OFFSET + degreesToEncoderUnits(degree);
        }

        public static double encoderUnitsToDegrees(double encoderUnits) {
            return (encoderUnits * DEG_IN_TURRET_ROTATION) / ENCODER_UNITS_IN_ROTATION;
        }

        public static double absoluteEncoderUnitsToDegrees(double encoderUnits) {
            return encoderUnitsToDegrees(encoderUnits - ENCODER_OFFSET);
        }

        public static double fixAngleAccordingToLimits(double deg) {
            double fixedAngle = deg % DEG_IN_CIRCLE;
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
