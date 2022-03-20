package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.ColorSensorV3;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

public interface BallTriggerComponents {

    WPI_TalonFX getMotor();

    TriangulatingRangefinder getAnalogSensor();
}
