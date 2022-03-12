package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

public interface ClimberComponents {

    WPI_TalonFX getMasterMotor();

    TalonEncoder getMasterMotorEncoder();

    WPI_TalonFX getStabilizerMotor();

    TalonEncoder getStabilizerMotorEncoder();
}
