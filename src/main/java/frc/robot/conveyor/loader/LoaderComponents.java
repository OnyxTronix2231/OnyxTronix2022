package frc.robot.conveyor.loader;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

public interface LoaderComponents {

    WPI_TalonFX getMotor();

    TriangulatingRangefinder getBackSensor();

    TriangulatingRangefinder getFrontSensor();
}
