package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj.I2C;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.ComponentsConstants.*;
import static frc.robot.conveyor.loader.LoaderConstants.ComponentsConstant.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private final WPI_TalonSRX motor;
    private final Rev2mDistanceSensor distanceSensor;

    public BallTriggerComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);


    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensorUp() {
        return distanceSensor;
    }

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.supplyCurrLimit.currentLimit = CURRENT_LIMIT_ENABLED;
        config.supplyCurrLimit.triggerThresholdCurrent = SUPPLY_TRIGGER_THRESHOLD_CURRENT;
        config.supplyCurrLimit.triggerThresholdTime = SUPPLY_TRIGGER_THRESHOLD_TIME;
        config.supplyCurrLimit.enable = SUPPLY_CURRENT_LIMIT_ENABLED;
        config.statorCurrLimit.currentLimit = STATOR_CURRENT_LIMIT;
        config.statorCurrLimit.triggerThresholdCurrent = STATOR_TRIGGER_THRESHOLD_CURRENT;
        config.statorCurrLimit.triggerThresholdTime = STATOR_TRIGGER_THRESHOLD_TIME;
        config.statorCurrLimit.enable = STATOR_CURRENT_LIMIT_ENABLED;
        config.openloopRamp = OPEN_LOOP_RAMP;
        config.closedloopRamp = CLOSE_LOOP_RAMP;
        return config;
    }
}

