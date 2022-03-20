package frc.robot.stabilizers;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

import static frc.robot.stabilizers.StabilizerConstants.*;

public class StabilizerComponentsBase implements StabilizerComponents {

    private WPI_TalonFX motor;
    private TalonEncoder encoder;

    public StabilizerComponentsBase() {
        motor = new WPI_TalonFX(STABILIZER_MOTOR_DEVICE_NUMBER);
        motor.configFactoryDefault();
        motor.configAllSettings(getFalconConfiguration());
        motor.setNeutralMode(NeutralMode.Brake);

        encoder = new TalonEncoder(motor);
        encoder.reset();
    }

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.supplyCurrLimit.currentLimit = SUPPLY_CURRENT_LIMIT;
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

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public TalonEncoder getEncoder() {
        return encoder;
    }
}
