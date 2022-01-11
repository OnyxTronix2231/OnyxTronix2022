package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public interface ShooterComponents {
    WPI_TalonFX getMasterMotor();
}
