package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberComponentsBase implements ClimberComponents {

    private final WPI_TalonFX masterArmMotor;
    private final WPI_TalonFX slaveArmMotor;
    private final WPI_TalonFX stabilizerMotor;
    private final TalonEncoder masterMotorEncoder;
    private final TalonEncoder stabilizerMotorEncoder;

    public ClimberComponentsBase() {
        stabilizerMotor = new WPI_TalonFX(STABILIZER_MOTOR_DEVICE_NUMBER);
        masterArmMotor = new WPI_TalonFX(MASTER_ARM_MOTOR_DEVICE_NUMBER);
        masterArmMotor.configFactoryDefault();
        masterArmMotor.configAllSettings(getFalconConfiguration());
        masterArmMotor.setNeutralMode(NeutralMode.Brake);
        slaveArmMotor = new WPI_TalonFX(SLAVE_ARM_MOTOR_DEVICE_NUMBER);
        slaveArmMotor.configFactoryDefault();
        slaveArmMotor.configAllSettings(getFalconConfiguration());
        slaveArmMotor.follow(masterArmMotor);
        masterMotorEncoder = new TalonEncoder(masterArmMotor);
        masterMotorEncoder.reset();

        stabilizerMotorEncoder = new TalonEncoder(stabilizerMotor);
        stabilizerMotorEncoder.reset();
    }

    @Override
    public WPI_TalonFX getMasterMotor() {
        return slaveArmMotor;
    }

    @Override
    public WPI_TalonFX getStabilizerMotor() {
        return stabilizerMotor;
    }

    @Override
    public TalonEncoder getStabilizerMotorEncoder() {
        return stabilizerMotorEncoder;
    }

    public WPI_TalonFX getMasterArmMotor() {
        return masterArmMotor;
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
