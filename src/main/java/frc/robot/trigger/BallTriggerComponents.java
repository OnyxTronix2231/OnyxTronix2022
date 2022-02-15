package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj.DigitalInput;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

public interface BallTriggerComponents {

    WPI_TalonFX getTriggerMotor();
    Rev2mDistanceSensor getDistanceSensorUp();


}
