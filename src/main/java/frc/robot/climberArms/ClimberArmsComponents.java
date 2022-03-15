package frc.robot.climberArms;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

public interface ClimberArmsComponents {

    WPI_TalonFX getMasterMotor();

    TalonEncoder getMasterMotorEncoder();
}
