package frc.robot.LoggingTest;

import edu.wpi.first.wpilibj.DigitalInput;
import sensors.Switch.Microswitch;

public class LoggingCompoentsBase implements LoggingCompoents{

    private Microswitch microswitch;
    private DigitalInput digitalInput;

    public LoggingCompoentsBase(){
        digitalInput = new DigitalInput(0);
        microswitch = new Microswitch(digitalInput);
    }

    @Override
    public Microswitch getMicroSwitch() {
        return microswitch;
    }
}
