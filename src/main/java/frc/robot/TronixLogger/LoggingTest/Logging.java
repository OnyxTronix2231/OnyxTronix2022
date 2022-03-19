package frc.robot.TronixLogger.LoggingTest;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.TronixLogger.Logging.TronixLogger;

public class Logging extends SubsystemBase {
    private final LoggingCompoents components;

    public Logging(LoggingCompoents components, TronixLogger log) {
        this.components = components;
        TronixLogger.getInstance().addBooleanListener("Switch", this::isOpen, 420);
        TronixLogger.getInstance().addDoubleListener("RPM",this::rpm,69,420);
    }

    public boolean isOpen() {
        return components.getMicroSwitch().isOpen();
    }

    public double rpm(){
        double rpm = 0;
        return rpm;
    }


}
