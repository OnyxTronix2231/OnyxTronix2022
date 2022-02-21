package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.TalonEncoder;

import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.Calculation.degreesToEncoderUnits;
import static frc.robot.turret.TurretConstants.ComponentsConstants.*;

public class TurretComponentsBase implements TurretComponents {

    private final WPI_TalonFX motor;
    private final TalonEncoder encoder;
    private final CtreMotionMagicController controller;

    public TurretComponentsBase() {
        motor = new WPI_TalonFX(TURRET_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getTalonFxConfiguration());
        //motor.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        //motor.setSelectedSensorPosition(
        //        motor.getSensorCollection().getIntegratedSensorAbsolutePosition(), 0, 0);
        motor.setNeutralMode(NeutralMode.Brake);

        this.encoder = new TalonEncoder(motor);
        controller = new CtreMotionMagicController(
                motor, this.encoder, new PIDFTerms(KP, KI, KD, KF), MAX_ACC, CRUISE_VELOCITY, ACC_SMOOTHING);
    }

    public TalonFXConfiguration getTalonFxConfiguration() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.forwardSoftLimitThreshold = degreesToEncoderUnits(MAX_DEG);
        config.forwardSoftLimitEnable = false;
        config.reverseSoftLimitThreshold = degreesToEncoderUnits(MIN_DEG);
        config.reverseSoftLimitEnable = false;
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
