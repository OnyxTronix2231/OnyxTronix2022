package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.CtreEncoder;
import sensors.counter.TalonEncoder;

public interface TurretComponents {

    WPI_TalonFX getMotor();

    TalonEncoder getEncoder();

    CtreMotionMagicController getController();
}
