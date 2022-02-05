package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.*;

import static frc.robot.trigger.BallTriggerConstants.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private WPI_TalonFX triggerMotor;
    private Rev2mDistanceSensor distanceSensor;

    public BallTriggerComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);
    }

    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensor() {
        return distanceSensor;
    }
}
