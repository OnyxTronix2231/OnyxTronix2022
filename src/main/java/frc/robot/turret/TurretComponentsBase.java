package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
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

    public TurretComponentsBase() {
        motor = new WPI_TalonFX(TURRET_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getTalonFxConfiguration());
        motor.setNeutralMode(NeutralMode.Brake);

        WPI_TalonSRX motor2 = new WPI_TalonSRX(TALON_ENCODER_ID);
        motor.setSelectedSensorPosition((motor2.getSensorCollection().getPulseWidthPosition() + ENCODER_DEFAULT_ERROR) / (CONVERSION_RATE * 2));

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
}
