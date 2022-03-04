package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.StatusFrameConfig;

import static frc.robot.Constants.LOW_PRIORITY_STATUS_FRAME_PERIODIC;
import static frc.robot.intake.IntakeConstant.BackComponentConstants.*;

public class IntakeBackComponentsBase implements IntakeComponents {

    private final WPI_TalonFX motor;
    private final DoubleSolenoid solenoid;

    public IntakeBackComponentsBase() {
        motor = new WPI_TalonFX(BACK_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getFalconConfiguration());
        motor.setNeutralMode(NeutralMode.Coast);
        motor.setInverted(false);

        new StatusFrameConfig(motor).disablePID1().disableFollowerCAN();

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, BACK_SOLENOID_FORWARD_CHANNEL,
                BACK_SOLENOID_REVERSE_CHANNEL);
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
        config.supplyCurrLimit.currentLimit = CURRENT_LIMIT_ENABLED_BACK;
        config.supplyCurrLimit.triggerThresholdCurrent = SUPPLY_TRIGGER_THRESHOLD_CURRENT_BACK;
        config.supplyCurrLimit.triggerThresholdTime = SUPPLY_TRIGGER_THRESHOLD_TIME_BACK;
        config.supplyCurrLimit.enable = SUPPLY_CURRENT_LIMIT_ENABLED_BACK;
        config.statorCurrLimit.currentLimit = STATOR_CURRENT_LIMIT_BACK;
        config.statorCurrLimit.triggerThresholdCurrent = STATOR_TRIGGER_THRESHOLD_CURRENT_BACK;
        config.statorCurrLimit.triggerThresholdTime = STATOR_TRIGGER_THRESHOLD_TIME_BACK;
        config.statorCurrLimit.enable = STATOR_CURRENT_LIMIT_ENABLED_BACK;
        config.openloopRamp = OPEN_LOOP_RAMP_BACK;
        config.closedloopRamp = CLOSE_LOOP_RAMP_BACK;
        return config;
    }
}
