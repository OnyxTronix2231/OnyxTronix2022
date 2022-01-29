package frc.robot.shooterWood;

public class ShooterWoodConstants {

    static final double MAX_VELOCITY = 69000;
    static final double MAX_CLOSE_LOOP_OUTPUT = 1023;
    static final double ENCODER_UNITS_PER_ROUND = 2048;
    static final double DECISECONDS_PER_MIN = 600;
    static final double PIDF_P = 0.5;
    static final double PIDF_I = 0;
    static final double PIDF_D = 15;
    static final double PIDF_F = MAX_CLOSE_LOOP_OUTPUT/MAX_VELOCITY;
}
