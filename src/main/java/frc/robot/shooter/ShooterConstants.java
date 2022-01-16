package frc.robot.shooter;

import java.util.function.DoubleSupplier;

public class ShooterConstants {
    static final DoubleSupplier SPEED = ()->1;
    static final double ENCODERUNITSPERROUND = 2048;
    static final double DECISECONDSPERMINUTE = 600;
    static final double PIDF_P = 1;
    static final double PIDF_I = 1;
    static final double PIDF_D = 1;
    static final double PIDF_F = 1;
    static final int MASTER_MOTOR_ID = 1;
    static final int SLAVE_MOTOR_ID = 1;

}
