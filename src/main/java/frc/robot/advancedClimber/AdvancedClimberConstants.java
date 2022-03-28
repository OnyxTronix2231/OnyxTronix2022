package frc.robot.advancedClimber;

public class AdvancedClimberConstants {

    // DESIRED PITCH ANGLE STAGE 0NE 25
    // DESIRED PITCH ANGLE STAGE ZERO 72
    //desiredPitchAngleStageTwo 5
    // KEEP STABILIZER SPEED 0.2
    // STABILIZED SETPOINT -80000
    // ARMS DELTA 20000
    // ARMS SPEED 0.3
    // DELTA FOR STABILIZER FINISH 30000

    // START CLIMB //

    public static final int START_LOAD_POSITION = 2500;
    public static final int START_RELEASE_POSITION = 10000;


    // STAGE ZERO //

    public static final double DESIRED_STABILIZER_SPEED_STAGE_ZERO = -0.2; // TODO CHANGE
    public static final double DESIRED_ARMS_SPEED_STAGE_ZERO = 72; // TODO CHANGE
    public static final int STABILIZER_POSITION_STAGE_ZERO = -80000; // TODO CHANGE


    // STAGE ONE //
    public static final double DESIRED_PITCH_ANGLE_STAGE_ONE = 25; // TODO WORKING
    public static final double DESIRED_ARMS_SPEED_STAGE_ONE = 0.3; // TODO CHANGE

    // STAGE TWO //

    public static final double DESIRED_PITCH_ANGLE_STAGE_TWO = 9; // TODO CHANGE
    public static final double DESIRED_ARMS_SPEED_STAGE_TWO = 0.5; // TODO CHANGE
    public static final double DESIRED_STABILIZER_SPEED_STAGE_TWO = 0.5; // TODO CHANGE

    // STAGE THREE //

    public static final double RELEASE_ARMS_TIMEOUT = 2;
    public static final double DESIRED_ARMS_SPEED_STAGE_THREE = -DESIRED_ARMS_SPEED_STAGE_TWO; // TODO CHANGE
    public static final double DESIRED_STABILIZER_SPEED_STAGE_THREE = 0.2; // TODO CHANGE

    // KEEP STABILIZER

    public static final double KEEP_STABILIZER_SPEED = 0.3; // TODO CHANGE

    // STAGE FOUR //

    public static final double DESIRED_STABILIZER_SPEED_STAGE_FOUR = -0.2; // TODO CHANGE
    public static final double DESIRED_ARMS_SPEED_RELEASE = -0.4; // TODO CHANGE
    public static final double DESIRED_ARMS_SPEED_RELEASE_FINAL = -0.5; // TODO CHANGE


}
