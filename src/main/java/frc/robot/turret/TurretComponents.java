package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import pid.CtreMotionMagicController;
import sensors.counter.Counter;

public interface TurretComponents {

    WPI_TalonFX getMotor();

    CANCoder getEncoder();

    CtreMotionMagicController getController();
}
