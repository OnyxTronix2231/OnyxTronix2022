package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.interfaces.PIDController;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

public interface ShooterComponents {

    WPI_TalonFX getMasterMotor();

    Counter getCounter();

    PIDController getController();
}
