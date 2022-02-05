package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;
import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.RobotConstants.*;

public class TurretComponentsBase implements TurretComponents {

    private final WPI_TalonFX motor;
    private final CANCoder encoder;
    private final CtreMotionMagicController controller;

    public TurretComponentsBase(){
        motor = new WPI_TalonFX(TURRET_MOTOR_ID);
        motor.configFactoryDefault();
        motor.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        motor.setSelectedSensorPosition(
                motor.getSensorCollection().getIntegratedSensorAbsolutePosition() , 0, 0);
        motor.setNeutralMode(NeutralMode.Brake);

        encoder = new CANCoder(ENCODER_ID);
        // need to fix the motion magic lib so it will work with CANCoder
        controller = new CtreMotionMagicController(
                motor, encoder, new PIDFTerms(KP, KI, KD, KF), MAX_ACC, CRUISE_VELOCITY, ACC_SMOOTHING);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public CANCoder getEncoder() {
        return encoder;
    }

    @Override
    public CtreMotionMagicController getController() {
        return controller;
    }
}
