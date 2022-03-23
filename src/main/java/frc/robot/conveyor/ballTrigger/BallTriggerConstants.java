package frc.robot.conveyor.ballTrigger;

public final class BallTriggerConstants {

    static final double IDENTIFIED_VOLTAGE = 0.6;
    static final double BALLTRIGGER_SPEED = 0.6;
    static final double MOVE_BALL_TO_LOADER_FROM_BALLTRIGGER_SPEED = -0.6;
    static final double THRESHOLD_BLUENESS = 0.3;
    static final double THRESHOLD_REDNESS = 0.35;

    public static class ComponentsConstants {

        static final int MOTOR_ID = 8;
        static final int ANALOG_ID= 2;
        static final int SUPPLY_CURRENT_LIMIT = 20;
        static final int SUPPLY_TRIGGER_THRESHOLD_CURRENT = 30;
        static final int SUPPLY_TRIGGER_THRESHOLD_TIME = 50;
        static final boolean SUPPLY_CURRENT_LIMIT_ENABLED = true;
        static final double OPEN_LOOP_RAMP = 0.1;
        static final double CLOSE_LOOP_RAMP = 0;
    }
}
