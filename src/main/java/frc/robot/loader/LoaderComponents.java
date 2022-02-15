package frc.robot.loader;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

public interface LoaderComponents {

    WPI_TalonFX getLoaderMotor();
    TriangulatingRangefinder getBackSensor();
    TriangulatingRangefinder getFrontSensor();

}
