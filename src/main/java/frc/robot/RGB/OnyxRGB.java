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
    private static float[] RGB = new float[RGB_ARRAY_SIZE];
    public static CANifier canifier;
    private final ColorNameToRGB colorNameToRGB;
    private int cyclesLeft;

    public OnyxRGB(int deviceID){
        canifier = new CANifier(deviceID);
        canifier.setPWMOutput(kMotorControllerCh.value, DUTY_CYCLES);
        canifier.enablePWMOutput(kMotorControllerCh.value, true);

        colorNameToRGB = new ColorNameToRGB();
        turnOffRGB();
        cyclesLeft = 0;
    }

    @Override
    public void periodic(){
        if (cyclesLeft > 0) {
            canifier.setLEDOutput(RGB[R], CANifier.LEDChannel.LEDChannelA);
            canifier.setLEDOutput(RGB[G], CANifier.LEDChannel.LEDChannelB);
            canifier.setLEDOutput(RGB[B], CANifier.LEDChannel.LEDChannelC);
            cyclesLeft--;
        }
        else if (!(isRGBOff())){
            turnOffRGB();
        }
    }

    public void onStop(){
        turnOffRGB();
        canifier.enablePWMOutput(kMotorControllerCh.value, false);
    }

    private void setColorByName(Colors color){
        RGB = colorNameToRGB.getColorNameToRGB(color).clone();
    }

    private void setColorByRGB(int r, int g, int b){
        r = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, r));
        g = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, g));
        b = Math.max(MIN_RGB_VALUE, Math.min(MAX_RGB_VALUE, b));

        RGB[R] = r;
        RGB[G] = g;
        RGB[B] = b;
    }

    public void turnOffRGB(){
        setColorByName(Colors.Black);
    }

    public boolean isRGBOff(){
        return Arrays.equals(RGB, colorNameToRGB.getColorNameToRGB(Colors.Black));
    }

    public void setColorForAmountOfCycles(Colors color, int cycles){
        setColorByName(color);
        cyclesLeft = cycles;
    }

    public void setColorForAmountOfCycles(int r, int g, int b, int cycles){
        setColorByRGB(r, g, b);
        cyclesLeft = cycles;
    }
}
