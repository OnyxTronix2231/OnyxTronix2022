package frc.robot.conveyor.loader;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.loader.LoaderConstants.ComponentsConstant.*;
import static frc.robot.intake.IntakeConstant.FrontComponentsConstants.*;
import static frc.robot.intake.IntakeConstant.FrontComponentsConstants.*;

public class LoaderComponentsBase implements LoaderComponents {

    private final WPI_TalonFX motor;
    private final TriangulatingRangefinder frontSensor;
    private final TriangulatingRangefinder backSensor;

    public LoaderComponentsBase() {
        motor = new WPI_TalonFX(MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getFalconConfiguration());
        motor.setNeutralMode(NeutralMode.Coast);
        motor.setInverted(false);

        this.frontSensor = new TriangulatingRangefinder(FRONT_SENSOR_CHANNEL);
        this.backSensor = new TriangulatingRangefinder(BACK_SENSOR_CHANNEL);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public TriangulatingRangefinder getFrontSensor() {
        return frontSensor;
    }

    @Override
    public TriangulatingRangefinder getBackSensor() {
        return backSensor;
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
