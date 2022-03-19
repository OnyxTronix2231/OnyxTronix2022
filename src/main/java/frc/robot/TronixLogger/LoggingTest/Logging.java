package frc.robot.TronixLogger.LoggingTest;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.TronixLogger.Logging.TronixLogger;

public class Logging extends SubsystemBase {
     private final LoggingCompoents components;
     private TronixLogger log;

    public Logging(LoggingCompoents components, TronixLogger log) {
        this.components = components;
       // this.log = new TronixLogger("loader");
      //  this.log.addBooleanListener("test", this::isOpen, 20);
//        this.log.update();
    }

    public boolean isOpen(){
        return components.getMicroSwitch().isOpen();
    }

    @Override
    public void periodic() {
      //  log.update();
    }
}
