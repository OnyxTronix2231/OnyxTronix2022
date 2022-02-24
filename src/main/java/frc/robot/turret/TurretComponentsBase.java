package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
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
        motor.setNeutralMode(NeutralMode.Brake);


        WPI_TalonSRX motor2 = new WPI_TalonSRX(TALON_ENCODER_ID);
        motor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

        motor.configRemoteFeedbackFilter(motor2, 0);
        motor.configSelectedFeedbackSensor(RemoteFeedbackDevice.RemoteSensor0, 0, 0);
        motor.setSelectedSensorPosition(
                motor2.getSensorCollection().getAnalogInRaw(), 0, 0);

        this.encoder = new TalonEncoder(new WPI_TalonSRX(TALON_ENCODER_ID));

        controller = new CtreMotionMagicController(
                motor, this.encoder, new PIDFTerms(KP, KI, KD, KF), MAX_ACC, CRUISE_VELOCITY, ACC_SMOOTHING);
    }

    public TalonFXConfiguration getTalonFxConfiguration() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.forwardSoftLimitThreshold = degreesToEncoderUnits(MAX_DEG);
        config.forwardSoftLimitEnable = true;
        config.reverseSoftLimitThreshold = degreesToEncoderUnits(MIN_DEG);
        config.reverseSoftLimitEnable = true;
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
