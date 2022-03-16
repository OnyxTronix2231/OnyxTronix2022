package frc.robot.LoggingTest;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Logger;

public class Logging extends SubsystemBase {
     private final LoggingCompoents components;
     private final Logger log;

    public Logging(LoggingCompoents components, Logger log) {
        this.components = components;
        this.log = new Logger("loader");
        this.log.addBooleanListener("test", ()-> isOpen(), 20);
        this.log.update();
    }

    public boolean isOpen(){
        return components.getMicroSwitch().isOpen();
    }
}
