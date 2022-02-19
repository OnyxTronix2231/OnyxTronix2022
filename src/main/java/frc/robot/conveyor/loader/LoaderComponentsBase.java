package frc.robot.conveyor.loader;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.loader.LoaderConstants.ComponentsConstant.*;

public class LoaderComponentsBase implements LoaderComponents {

    private final WPI_TalonFX motor;
    private final TriangulatingRangefinder backSensor;
    private final TriangulatingRangefinder frontSensor;

    public LoaderComponentsBase() {
        motor = new WPI_TalonFX(MOTOR_ID);
        motor.configFactoryDefault();
        this.backSensor = new TriangulatingRangefinder(BACK_SENSOR_CHANNEL);
        this.frontSensor = new TriangulatingRangefinder(FRONT_SENSOR_CHANNEL);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    public TriangulatingRangefinder getBackSensor() {
        return backSensor;
    }

    @Override
    public TriangulatingRangefinder getFrontSensor() {
        return frontSensor;
    }
}
