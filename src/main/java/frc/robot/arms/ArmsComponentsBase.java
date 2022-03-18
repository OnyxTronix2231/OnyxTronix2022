package frc.robot.arms;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

import static frc.robot.arms.ArmsConstants.*;

public class ArmsComponentsBase implements ArmsComponents {

    private final WPI_TalonFX masterMotor;
    private final WPI_TalonFX slaveMotor;
    private final TalonEncoder masterMotorEncoder;

    public ArmsComponentsBase() {
        masterMotor = new WPI_TalonFX(SLAVE_ARM_MOTOR_DEVICE_NUMBER);
        masterMotor.configFactoryDefault();
        masterMotor.configAllSettings(getFalconConfiguration());
        masterMotor.setNeutralMode(NeutralMode.Brake);
        slaveMotor = new WPI_TalonFX(MASTER_ARM_MOTOR_DEVICE_NUMBER);
        slaveMotor.configFactoryDefault();
        slaveMotor.configAllSettings(getFalconConfiguration());
        slaveMotor.follow(masterMotor);
        slaveMotor.setInverted(true);
        slaveMotor.setNeutralMode(NeutralMode.Brake);
        masterMotorEncoder = new TalonEncoder(slaveMotor);
        masterMotorEncoder.reset();
    }

    @Override
    public WPI_TalonFX getMasterMotor() {
        return masterMotor;
    }

    @Override
    public TalonEncoder getMasterMotorEncoder() {
        return masterMotorEncoder;
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
}
