package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Ultrasonic;

public interface TriggerComponents {

    WPI_TalonFX getTriggerMotor();
    Ultrasonic getUltraSonic();

}
