package frc.robot.loader;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import static frc.robot.loader.LoaderConstants.LOADER_MOTOR_ID;

public class LoaderComponentsBase implements LoaderComponents {

    private final WPI_TalonFX loaderMotor;

    public LoaderComponentsBase() {
        loaderMotor = new WPI_TalonFX(LOADER_MOTOR_ID);
        loaderMotor.configFactoryDefault();
    }

    @Override
    public WPI_TalonFX getLoaderMotor() {
        return loaderMotor;
    }
}
