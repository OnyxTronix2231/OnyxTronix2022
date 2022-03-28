package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import frc.robot.StatusFrameConfig;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.TalonEncoder;

import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.Calculation.degreesToAbsoluteEncoderUnits;
import static frc.robot.turret.TurretConstants.ComponentsConstants.*;

public class TurretComponentsBase implements TurretComponents {

    private final WPI_TalonFX motor;
    private final TalonEncoder encoder;
    private final CtreMotionMagicController controller;
    private final DutyCycleEncoder roboRIOEncoder;

    public TurretComponentsBase() {
        motor = new WPI_TalonFX(TURRET_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getTalonFxConfiguration());
        motor.setNeutralMode(NeutralMode.Brake);

        roboRIOEncoder = new DutyCycleEncoder(TURRET_ENCODER_ID);
        motor.setSelectedSensorPosition(((roboRIOEncoder.getAbsolutePosition() * OUTER_ENCODER_UNITS_RESOLUTION +
                ENCODER_DEFAULT_ERROR) % OUTER_ENCODER_UNITS_RESOLUTION) / (CONVERSION_RATE * 2));

        new StatusFrameConfig(motor).disablePID1();

        encoder = new TalonEncoder(motor);

        controller = new CtreMotionMagicController(
                motor, encoder, new PIDFTerms(KP, KI, KD, KF), ACCELERATION, CRUISE_VELOCITY, ACC_SMOOTHING);
    }

    public TalonFXConfiguration getTalonFxConfiguration() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.forwardSoftLimitThreshold = degreesToAbsoluteEncoderUnits(MAX_DEG);
        config.forwardSoftLimitEnable = true;
        config.reverseSoftLimitThreshold = degreesToAbsoluteEncoderUnits(MIN_DEG);
        config.reverseSoftLimitEnable = true;
        config.slot0.integralZone = INTEGRAL_ZONE;
        config.supplyCurrLimit.currentLimit = SUPPLY_CURRENT_LIMIT;
        config.supplyCurrLimit.triggerThresholdCurrent = SUPPLY_TRIGGER_THRESHOLD_CURRENT;
        config.supplyCurrLimit.triggerThresholdTime = SUPPLY_TRIGGER_THRESHOLD_TIME;
        config.supplyCurrLimit.enable = SUPPLY_CURRENT_LIMIT_ENABLED;
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

    @Override
    public CtreMotionMagicController getController() {
        return controller;
    }

    public DutyCycleEncoder getRoboRIOEncoder() {
        return roboRIOEncoder;
    }
}
