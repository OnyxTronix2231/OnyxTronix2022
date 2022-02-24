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
    public static final int MAX_ACC = 0; //TODO: calibrate
    public static final int CRUISE_VELOCITY = 0; //TODO: calibrate
    public static final int ACC_SMOOTHING = 0; //TODO: calibrate
    public static final double KP = 0; //TODO: calibrate
    public static final double KI = 0; //TODO: calibrate
    public static final double KD = 0; //TODO: calibrate
    public static final double KF = 0; //TODO: calibrate

    /*system settings*/
    public static final int MIDDLE_ANGLE = 0;
    public static final double TOLERANCE_DEGREES = 0.5; //TODO: Correct the number
    public static final double DEFAULT_TURRET_SPEED = 0.2;
    public static final double CALIBRATION_SPEED = 0.3;

    public static class ComponentsConstants {

        /*mechanic values*/
        static final int ENCODER_UNITS_IN_ROTATION = 4096;
        static final int TURRET_MOTOR_ID = 9;
        static final int TALON_ENCODER_ID = 8;
        //static final double CONVERSION_RATE = 1.0 / 75;
        static final double CONVERSION_RATE = 1.0;
        static final double MAX_DEG = 200; //TODO: Correct the number
        static final double MIN_DEG = -200; //TODO: Correct the number
        static final double DEG_IN_TURRET_ROTATION = DEG_IN_CIRCLE * CONVERSION_RATE;
    }

    public static final class Calculation {

        static double degreesToEncoderUnits(double degree) {
            return (degree * ENCODER_UNITS_IN_ROTATION) / DEG_IN_TURRET_ROTATION;
        }

        public static double encoderUnitsToDegrees(double encoderUnits) {
            return (encoderUnits * DEG_IN_TURRET_ROTATION) / ENCODER_UNITS_IN_ROTATION;
        }
    }
}
