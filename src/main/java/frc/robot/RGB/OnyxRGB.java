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

    private float[] RGB; // current color
    private final CANifier canifier; // electronic shit
    private boolean isOff;
    private static OnyxRGB instance;

    private OnyxRGB() {
            canifier = new CANifier(LED_ID);
            canifier.setPWMOutput(RGB_CONTROLLER_CHANNEL.value, DUTY_CYCLES);
            canifier.enablePWMOutput(RGB_CONTROLLER_CHANNEL.value, true);

            RGB = new float[RGB_ARRAY_SIZE];
            new RGBShuffleboard();
    }

    public static OnyxRGB getInstance() {
        if(instance == null) {
            instance = new OnyxRGB();
        }
        return instance;
    }

    @Override
    public void periodic() {
        canifier.setLEDOutput(RGB[R_INDEX], CANifier.LEDChannel.LEDChannelB);
        canifier.setLEDOutput(RGB[G_INDEX], CANifier.LEDChannel.LEDChannelA);
        canifier.setLEDOutput(RGB[B_INDEX], CANifier.LEDChannel.LEDChannelC);
        isOff = Arrays.equals(RGB, ColorNameToRGB.colorToRGB(Color.Black));
    }

    public void onStop() {
        turnOff();
        canifier.enablePWMOutput(RGB_CONTROLLER_CHANNEL.value, false);
    }

    public void setColor(Color color) {
        RGB = ColorNameToRGB.colorToRGB(color).clone();
    }

    public void setColor(int kR, int kG, int kB) {
        kR = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, kR));
        kG = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, kG));
        kB = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, kB));

        // sets the color of the RGB to the input values

        RGB[R_INDEX] = kR;
        RGB[G_INDEX] = kG;
        RGB[B_INDEX] = kB;
    }

    public void turnOff() {
        setColor(Color.Black);
    }

    public boolean isRGBOff() {
        return isOff;
    }
}
