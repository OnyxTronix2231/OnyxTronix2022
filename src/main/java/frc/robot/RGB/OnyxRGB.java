package frc.robot.RGB;

import com.ctre.phoenix.CANifier;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.Arrays;
import static frc.robot.RGB.Constants.*;

/**
 * OnyxRGB is a class for an easy to control RGB led set.
 *
 * @since 2022-01-23
 */
public class OnyxRGB extends SubsystemBase {

    private float[] RGB;;
    private final CANifier canifier;
    private final ColorNameToRGB colorNameToRGB;
    private int cyclesLeft;

    public OnyxRGB(int deviceID) {
        canifier = new CANifier(deviceID);
        canifier.setPWMOutput(RGB_CONTROLLER_CHANNEL.value, DUTY_CYCLES);
        canifier.enablePWMOutput(RGB_CONTROLLER_CHANNEL.value, true);

        RGB = new float[RGB_ARRAY_SIZE];
        colorNameToRGB = new ColorNameToRGB();
        turnOffRGB();
        cyclesLeft = 0;
    }

    @Override
    public void periodic() {
        if (cyclesLeft > 0) {
            canifier.setLEDOutput(RGB[R], CANifier.LEDChannel.LEDChannelA);
            canifier.setLEDOutput(RGB[G], CANifier.LEDChannel.LEDChannelB);
            canifier.setLEDOutput(RGB[B], CANifier.LEDChannel.LEDChannelC);
            cyclesLeft--;
        } else if (!(isRGBOff())){
            turnOffRGB();
        }
    }

    public void onStop() {
        turnOffRGB();
        canifier.enablePWMOutput(RGB_CONTROLLER_CHANNEL.value, false);
    }

    private void setColorByName(Color color) {
        RGB = colorNameToRGB.getColorNameToRGB(color).clone();
    }

    private void setColorByRGB(int kR, int kG, int kB) {
        kR = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, kR));
        kG = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, kG));
        kB = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, kB));

        // sets the color of the RGB to the input values

        RGB[R] = kR;
        RGB[G] = kG;
        RGB[B] = kB;
    }

    public void turnOffRGB() {
        setColorByName(Color.Black);
    }

    public boolean isRGBOff() {
        return Arrays.equals(RGB, colorNameToRGB.getColorNameToRGB(Color.Black));
    }

    public void setColorForAmountOfCycles(Color color, int cycles) {
        setColorByName(color);
        cyclesLeft = cycles;
    }

    public void setColorForAmountOfCycles(int kR, int kG, int kB, int cycles) {
        setColorByRGB(kR, kG, kB);
        cyclesLeft = cycles;
    }
}
