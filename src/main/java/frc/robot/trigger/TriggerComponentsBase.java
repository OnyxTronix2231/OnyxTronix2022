package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Ultrasonic;

import static frc.robot.trigger.TriggerConstants.*;


public class TriggerComponentsBase implements TriggerComponents {

    private WPI_TalonFX triggerMotor;
    private Ultrasonic sensor;

    public TriggerComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        sensor = new Ultrasonic(PING_CHANNEL,ECHO_CHANNEL);
    }

    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public Ultrasonic getSensor() {return sensor;}

}
