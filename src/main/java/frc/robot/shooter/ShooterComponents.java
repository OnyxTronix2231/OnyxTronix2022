package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.interfaces.PIDController;
import sensors.counter.Counter;

public interface ShooterComponents {

    WPI_TalonFX getMasterMotor();

    Counter getCounter();

    PIDController getController();
}
