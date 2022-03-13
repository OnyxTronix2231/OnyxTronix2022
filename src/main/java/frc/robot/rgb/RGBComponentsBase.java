package frc.robot.rgb;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class RGBComponentsBase {

    private AddressableLED led;
    private AddressableLEDBuffer ledBuffer;

    public RGBComponentsBase() {
        led = new AddressableLED(9);

        ledBuffer = new AddressableLEDBuffer(32);

        led.setLength(ledBuffer.getLength());
        led.setData(ledBuffer);
        led.start();
    }

    public AddressableLED getLed() {
        return led;
    }

    public AddressableLEDBuffer getLedBuffer() {
        return ledBuffer;
    }
}
