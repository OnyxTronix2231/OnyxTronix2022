package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.Rev2mDistanceSensor;

public interface BallTriggerComponents {

    WPI_TalonSRX getMotor();

    Rev2mDistanceSensor getDistanceSensorUp();
}
