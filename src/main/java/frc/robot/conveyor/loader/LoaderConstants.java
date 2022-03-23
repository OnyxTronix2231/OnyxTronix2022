package frc.robot.conveyor.loader;

public final class LoaderConstants {

    static final double IDENTIFY_BALL_MIN = 1.3;
    static final double LOADER_SPEED = 0.8;
    static final double EJECT_BALLS_LOADER_SPEED = -0.8;

    public static class ComponentsConstant {

        static final int MOTOR_ID = 7;
        static final int FRONT_SENSOR_CHANNEL = 1;
        static final int BACK_SENSOR_CHANNEL = 0;
        static final double SUPPLY_CURRENT_LIMIT = 20;
        static final double SUPPLY_TRIGGER_THRESHOLD_CURRENT = 0;
        static final double SUPPLY_TRIGGER_THRESHOLD_TIME = 0;
        static final boolean SUPPLY_CURRENT_LIMIT_ENABLED = true;
        static final double STATOR_CURRENT_LIMIT = 0;
        static final double STATOR_TRIGGER_THRESHOLD_CURRENT = 0;
        static final double STATOR_TRIGGER_THRESHOLD_TIME = 0;
        static final boolean STATOR_CURRENT_LIMIT_ENABLED = false;
        static final double OPEN_LOOP_RAMP = 0.1;
        static final double CLOSE_LOOP_RAMP = 0;
    }
}
