package frc.robot.conveyor.loader;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.loader.LoaderConstants.BACK_SENSOR_CHANNEL;
import static frc.robot.conveyor.loader.LoaderConstants.FRONT_SENSOR_CHANNEL;
import static frc.robot.conveyor.loader.LoaderConstants.LOADER_MOTOR_ID;

public class LoaderComponentsBase implements LoaderComponents {

    private final WPI_TalonFX motor;
    private final TriangulatingRangefinder backSensor;
    private final TriangulatingRangefinder frontSensor;

    public LoaderComponentsBase() {
        motor = new WPI_TalonFX(LOADER_MOTOR_ID);
        motor.configFactoryDefault();

        backSensor = new TriangulatingRangefinder(BACK_SENSOR_CHANNEL);

        frontSensor = new TriangulatingRangefinder(FRONT_SENSOR_CHANNEL);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public TriangulatingRangefinder getFrontSensor() {
        return frontSensor;
    }

    @Override
    public TriangulatingRangefinder getBackSensor() {
        return backSensor;
    }
}
