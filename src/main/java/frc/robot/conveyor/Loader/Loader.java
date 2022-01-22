package frc.robot.conveyor.Loader;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.Loader.LoaderConstants.*;

public class Loader extends SubsystemBase {

    private final LoaderComponents components;

    public Loader(LoaderComponents components) {
        this.components = components;
    }


   // public void moveLoaderBySpeed(double speed) {
       // components.getLoaderMotor().set(speed);
    //}


    public boolean isStuck() {
        return components.getLoaderMotor().getSupplyCurrent() > LOADER_NORMAL_AMP;
        //in one side is geting amper and other is checking amper he he ha ha yeahhhhhhh
    }
}
