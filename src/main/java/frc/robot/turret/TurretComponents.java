package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.Counter;

public interface TurretComponents {

    WPI_TalonFX getMotor();

    Counter getEncoder();

    CtreMotionMagicController getController();
}
