package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.CtreEncoder;

import java.beans.Encoder;

import static frc.robot.turret.TurretConstants.*;

public class TurretComponentsBase implements TurretComponents    {

    private WPI_TalonFX motor;
    private CtreEncoder encoder;
    private CtreMotionMagicController controller;

    public TurretComponentsBase(){
        motor = new WPI_TalonFX(TURRET_MOTOR_PORT);
        motor.configFactoryDefault();

        motor.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        motor.setSelectedSensorPosition( motor.getSensorCollection().getIntegratedSensorAbsolutePosition() , 0, 0);

        encoder = new CtreEncoder(motor);
        controller = new CtreMotionMagicController(motor, encoder, new PIDFTerms(K_P, K_I, K_D, K_F), MAX_ACC, CRUISE_VELOCITY, ACC_SMOTHING);
    }

    @Override
    public WPI_TalonFX getMotor(){
        return motor;
    }

    @Override
    public CtreEncoder getEncoder() {
        return encoder;
    }

    @Override
    public CtreMotionMagicController getController() {
        return controller;
    }
}
