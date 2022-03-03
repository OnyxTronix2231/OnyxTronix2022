package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import static frc.robot.intake.IntakeConstant.FrontComponentsConstants.*;

public class IntakeFrontComponentsBase implements IntakeComponents {

    private final WPI_TalonFX motor;
    private final DoubleSolenoid solenoid;

    public IntakeFrontComponentsBase() {
        motor = new WPI_TalonFX(FRONT_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getFalconConfiguration());
        motor.setNeutralMode(NeutralMode.Coast);
        motor.setInverted(false);

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FRONT_SOLENOID_FORWARD_CHANNEL,
                FRONT_SOLENOID_REVERSE_CHANNEL);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public DoubleSolenoid getSolenoid() {
        return solenoid;
    }

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.supplyCurrLimit.currentLimit = SUPPLY_CURRENT_LIMIT_FRONT;
        config.supplyCurrLimit.triggerThresholdCurrent = SUPPLY_TRIGGER_THRESHOLD_CURRENT_FRONT;
        config.supplyCurrLimit.triggerThresholdTime = SUPPLY_TRIGGER_THRESHOLD_TIME_FRONT;
        config.supplyCurrLimit.enable = SUPPLY_CURRENT_LIMIT_ENABLED_FRONT;
        config.statorCurrLimit.currentLimit = STATOR_CURRENT_LIMIT_FRONT;
        config.statorCurrLimit.triggerThresholdCurrent = STATOR_TRIGGER_THRESHOLD_CURRENT_FRONT;
        config.statorCurrLimit.triggerThresholdTime = STATOR_TRIGGER_THRESHOLD_TIME_FRONT;
        config.statorCurrLimit.enable = STATOR_CURRENT_LIMIT_ENABLED_FRONT;
        config.openloopRamp = OPEN_LOOP_RAMP_FRONT;
        config.closedloopRamp = CLOSE_LOOP_RAMP_FRONT;
        return config;
    }
}
