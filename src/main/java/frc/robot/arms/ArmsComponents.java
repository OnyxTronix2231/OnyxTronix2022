package frc.robot.arms;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

public interface ArmsComponents {

    WPI_TalonFX getMasterMotor();

    TalonEncoder getMasterMotorEncoder();
}
