package frc.robot.Conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.*;
import static frc.robot.Conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private WPI_TalonSRX triggerMotor;
    private Rev2mDistanceSensor distanceSensor;

    public BallTriggerComponentsBase() {
        triggerMotor = new WPI_TalonSRX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);
    }

    @Override
    public WPI_TalonSRX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensorUp() {
        return distanceSensor;
    }
}
