package frc.robot.conveyor.loader;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.loader.LoaderConstants.*;

public class LoaderComponentsBase implements LoaderComponents {

    private final WPI_TalonFX loaderMotor;
    private final TriangulatingRangefinder backSensor;
    private final TriangulatingRangefinder frontSensor;

    public LoaderComponentsBase() {
        loaderMotor = new WPI_TalonFX(LOADER_MOTOR_ID);
        loaderMotor.configFactoryDefault();
        this.backSensor = new TriangulatingRangefinder(BACK_SENSOR_CHANNEL);
        this.frontSensor = new TriangulatingRangefinder(FRONT_SENSOR_CHANNEL);
    }

    @Override
    public WPI_TalonFX getLoaderMotor() {
        return loaderMotor;
    }

    public TriangulatingRangefinder getBackSensor() {
        return backSensor;
    }

    @Override
    public TriangulatingRangefinder getFrontSensor() {
        return frontSensor;
    }
}
