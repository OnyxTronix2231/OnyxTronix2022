package frc.robot.Conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.Rev2mDistanceSensor;

public interface BallTriggerComponents {

    WPI_TalonSRX getTriggerMotor();
    Rev2mDistanceSensor getDistanceSensorUp();


}
