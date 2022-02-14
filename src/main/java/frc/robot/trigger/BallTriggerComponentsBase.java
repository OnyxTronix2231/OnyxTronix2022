package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.*;
import edu.wpi.first.wpilibj.DigitalInput;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.trigger.BallTriggerConstants.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private WPI_TalonFX triggerMotor;
    private Rev2mDistanceSensor distanceSensor;
    private DigitalInput digitalInput;

    public BallTriggerComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);
        digitalInput = new DigitalInput(0);

    }

    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensorUp() {
        return distanceSensor;
    }

    @Override
    public DigitalInput getDigitalInput() {
        return digitalInput;
    }


}
