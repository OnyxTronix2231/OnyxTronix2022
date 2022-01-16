package frc.robot.drivetrain;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class DriveTrainConstants {
    public static final double MAX_OUTPUT_FORWARD = 0;
    public static final double MAX_OUTPUT_REVERSE = 0;
    public static final double CURRENT_LIMIT = 0;
    public static final double TRIGGER_THRESHOLD_CURRENT = 0;
    public static final double TRIGGER_THRESHOLD_TIME = 0;
    public static final double RAMP_TIME = 0.3;
    static final int ENCODER_UNITS = 2048;
    static final double CONVERSION_RATE = 0; //
    public static final double ENCODER_UNITS_TO_METER = 1;

//    public static final class TrajectoryConstants {
//
//        public static final double TRAJECTORY_P = 0;
//        public static final double ENCODER_CPR = ENCODER_UNITS * CONVERSION_RATE;
//        public static final double MAX_SPEED_METERS_PER_SECOND = 0;
//        public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 0;
//        public static final double TRACKWIDTH_METERS = 0;
//        private static final double KS = 0;
//        private static final double KV = 0;
//        private static final double KA = 0;
//        public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
//                new DifferentialDriveKinematics(TRACKWIDTH_METERS);
//        public static final SimpleMotorFeedforward FEEDFORWARD = new SimpleMotorFeedforward(KS, KV, KA);
//    }
}
