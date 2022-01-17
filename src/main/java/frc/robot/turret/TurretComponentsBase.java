package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;
import static frc.robot.turret.TurretConstants.*;
public class TurretComponentsBase implements TurretComponents {

    private final WPI_TalonFX motor;
    private final CtreEncoder encoder;
    private final CtreMotionMagicController controller;

    public TurretComponentsBase(){
        motor = new WPI_TalonFX(TURRET_MOTOR_PORT);
        motor.configFactoryDefault();
        motor.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        motor.setSelectedSensorPosition( motor.getSensorCollection().getIntegratedSensorAbsolutePosition() , 0, 0);

        encoder = new CtreEncoder(motor);
        controller = new CtreMotionMagicController(motor, encoder, new PIDFTerms(KP, KI, KD, KF), MAX_ACC, CRUISE_VELOCITY, ACC_SMOTHING);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public Counter getEncoder() {
        return encoder;
    }

    @Override
    public CtreMotionMagicController getController() {
        return controller;
    }
}
