package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import static frc.robot.intake.IntakeConstant.BackComponentConstants.*;

public class IntakeBackComponentsBase implements IntakeComponents {

    private final WPI_TalonFX motor;
    private final DoubleSolenoid solenoid;

    public IntakeBackComponentsBase() {
        motor = new WPI_TalonFX(BACK_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getConfiguration());
        motor.setNeutralMode(NeutralMode.Brake);
        motor.enableCurrentLimit(CURRENT_LIMIT_ENABLED_BACK);

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

    private TalonFXConfiguration getConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakCurrentLimit = PEAK_AMP;
        config.peakCurrentDuration = PEAK_AMP_DURATION;
        config.continuousCurrentLimit = CONTINUOUS_CURRENT_LIMIT;
        config.openloopRamp = OPEN_LOOP_RAMP;
        config.closedloopRamp = CLOSED_LOOP_RAMP;
        return config;
    }
}
