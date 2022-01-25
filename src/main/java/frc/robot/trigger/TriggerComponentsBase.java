package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Ultrasonic;

import static frc.robot.trigger.TriggerConstants.*;


public class TriggerComponentsBase implements TriggerComponents {

    private WPI_TalonFX triggerMotor;
    private Ultrasonic ultrasonic;

    public TriggerComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        ultrasonic = new Ultrasonic(PING_CHANNEL,ECHO_CHANNEL);
        ultrasonic.setAutomaticMode(true);
    }

    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public Ultrasonic getUltraSonic() {
        return ultrasonic;
    }
    
}
