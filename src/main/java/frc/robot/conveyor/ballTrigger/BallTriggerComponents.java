package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.Rev2mDistanceSensor;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

public interface BallTriggerComponents {

    WPI_TalonSRX getMotor();

    Rev2mDistanceSensor getDistanceSensorUp();
}
