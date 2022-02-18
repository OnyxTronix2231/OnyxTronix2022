package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.Rev2mDistanceSensor;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.MOTOR_ID;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private final WPI_TalonSRX motor;
    private final Rev2mDistanceSensor distanceSensor;

    public BallTriggerComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensor() {
        return distanceSensor;
    }
}
