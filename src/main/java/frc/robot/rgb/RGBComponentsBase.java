package frc.robot.rgb;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

import static frc.robot.rgb.RGBConstants.*;

public class RGBComponentsBase {

    private final AddressableLED led;
    private final AddressableLEDBuffer ledBuffer;

    public RGBComponentsBase() {
        led = new AddressableLED(RGB_PORT);

        ledBuffer = new AddressableLEDBuffer(LED_LENGTH);

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
