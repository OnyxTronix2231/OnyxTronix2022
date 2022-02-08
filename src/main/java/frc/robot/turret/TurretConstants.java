package frc.robot.turret;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

import static frc.robot.turret.TurretConstants.RobotConstants.*;

public final class TurretConstants {

    /*fixed values*/
    public static final Pose2d TARGET_POS = new Pose2d(0, 0, new Rotation2d()); //TODO: confirm
    public static final int DEG_IN_CIRCLE = 360;
    public static final int HALF_ROTATION = 180;

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
    public static final double ROTATION_SETBACK = 0.3;
    public static final double TOLERANCE_DEGREE = 1; //TODO: Correct the number
    public static final double DEG_IN_TURRET_ROTATION = CONVERSION_RATE * DEG_IN_CIRCLE;
    public static final double DEFULT_TURRET_SPEED = 0.5;


    public static class RobotConstants {

        /*mechanic values*/
        public static final int ENCODER_ID = 0; //TODO: Correct the number
        public static final int TURRET_MOTOR_ID = 0; //TODO: Correct the number
        public static final int CONVERSION_RATE = 1; //TODO: Correct the number
        public static final double MAX_DEG = 0; //TODO: Correct the number
        public static final double MIN_DEG = 0; //TODO: Correct the number
        public static final int ENCODER_UNITS_IN_ROTATION = 4096; //TODO: confirm
    }

    public static final class calculations {

        static double degToEnc(double deg) {
            return (deg * ENCODER_UNITS_IN_ROTATION) / DEG_IN_TURRET_ROTATION;
        }

        public static double encToDeg(double enc) {
            return (enc * DEG_IN_TURRET_ROTATION) / ENCODER_UNITS_IN_ROTATION;
        }
    }
}
