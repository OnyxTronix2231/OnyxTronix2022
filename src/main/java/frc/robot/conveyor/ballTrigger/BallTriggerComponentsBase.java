package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj.I2C;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.ComponentsConstants.MOTOR_ID;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private final WPI_TalonSRX motor;
    private final Rev2mDistanceSensor distanceSensor;
    private final ColorSensorV3 colorSensor;

    public BallTriggerComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);

        colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensorUp() {
        return distanceSensor;
    }

    @Override
    public ColorSensorV3 getColorSensor() {
        return colorSensor;
    }
}
