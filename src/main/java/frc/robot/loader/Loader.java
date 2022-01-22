package frc.robot.loader;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.loader.LoaderConstants.*;

public class Loader extends SubsystemBase {

    private final LoaderComponents components;

    public Loader(LoaderComponents components) {
        this.components = components;
    }


    public void moveLoaderBySpeed(double speed) {
        components.getLoaderMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
    }
    public boolean isStuck() {
        return components.getLoaderMotor().getSupplyCurrent() > NORMAL_AMP;
    }
}
