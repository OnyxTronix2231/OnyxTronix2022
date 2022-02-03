package frc.robot.drivetrain;

public final class DriveTrainConstants {

    public static final int ENCODER_UNITS = 2048;
    public static final double MAX_OUTPUT_FORWARD = 1;
    public static final double MAX_OUTPUT_REVERSE = -1;
    public static final double CURRENT_LIMIT = 40;
    public static final double TRIGGER_THRESHOLD_CURRENT = 40;
    public static final double TRIGGER_THRESHOLD_TIME = 0.03;
    public static final double RAMP_TIME = 0.3;
    public static final double ENCODER_UNITS_PER_ROTATION = ENCODER_UNITS * RobotConstants.CONVERSION_RATE;

    public static class RobotConstants {

        public static final int LEFT_MASTER_MOTOR_PORT = 3;
        public static final int LEFT_SLAVE_MOTOR_PORT = 4;
        public static final int RIGHT_MASTER_MOTOR_PORT = 1;
        public static final int RIGHT_SLAVE_MOTOR_PORT = 2;
        public static final int PIGEON_PORT = 0;
        public static final double CONVERSION_RATE = 9;
        public static final double WHEEL_DIAMETER_METER = 0.1524;
        public static final double PERIMETER_METER = WHEEL_DIAMETER_METER * Math.PI;
    }

    public static class Calculations {

        static double encoderUnitsToMeters(double units) {
            return units * RobotConstants.PERIMETER_METER / ENCODER_UNITS_PER_ROTATION;
        }
    }
}
