package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import sensors.counter.TalonEncoder;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberComponentsBase implements ClimberComponents {

    private final WPI_TalonFX leftMotor;
    private final WPI_TalonFX rightMotor;
    private final DoubleSolenoid doubleSolenoid;
    private final TalonEncoder leftEncoder;
    private final TalonEncoder rightEncoder;

    public ClimberComponentsBase() {
        leftMotor = new WPI_TalonFX(LEFT_MOTOR_DEVICE_NUMBER);
        leftMotor.configFactoryDefault();
        leftMotor.setNeutralMode(NeutralMode.Brake);

        rightMotor = new WPI_TalonFX(RIGHT_MOTOR_DEVICE_NUMBER);
        rightMotor.setNeutralMode(NeutralMode.Brake);
        rightMotor.configFactoryDefault();
        
        doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, SOLENOID_FORWARD_CHANNEL
                , SOLENOID_REVERSE_CHANNEL);
        leftEncoder = new TalonEncoder(leftMotor);
        rightEncoder = new TalonEncoder(rightMotor);
    }

    @Override
    public WPI_TalonFX getRightMotor() {
        return rightMotor;
    }

    @Override
    public WPI_TalonFX getLeftMotor() {
        return leftMotor;
    }

    @Override
    public DoubleSolenoid getDoubleSolenoid() {
        return doubleSolenoid;
    }

    @Override
    public TalonEncoder getLeftEncoder() {
        return leftEncoder;
    }

    @Override
    public TalonEncoder getRightEncoder() {
        return rightEncoder;
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
