package frc.robot.loader;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.loader.LoaderConstants.*;

public class Loader extends SubsystemBase {

    private final LoaderComponents loaderComponents;

    public Loader(LoaderComponents components) {
        this.loaderComponents = components;
    }

    public void moveLoaderBySpeed(double speed) {
        loaderComponents.getLoaderMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
    }

    public boolean isStuck() {
        return loaderComponents.getLoaderMotor().getSupplyCurrent() > NORMAL_AMP;
    }
}
