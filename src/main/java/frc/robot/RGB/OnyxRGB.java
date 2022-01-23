package frc.robot.RGB;

import com.ctre.phoenix.CANifier;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.Arrays;

import static frc.robot.RGB.Constants.kMotorControllerCh;


public class OnyxRGB extends SubsystemBase {
    private static float RGB[] = new float[3];
    private final ColorNameToRGB colorNameToRGB;

    public OnyxRGB(){
        colorNameToRGB = new ColorNameToRGB();
        Arrays.fill(RGB, 0);
        Hardware.canifier.setPWMOutput(kMotorControllerCh.value, 0);
        Hardware.canifier.enablePWMOutput(kMotorControllerCh.value, true);
    }


    @Override
    public void periodic(){
        Hardware.canifier.setLEDOutput(RGB[0], CANifier.LEDChannel.LEDChannelA);
        Hardware.canifier.setLEDOutput(RGB[1], CANifier.LEDChannel.LEDChannelB);
        Hardware.canifier.setLEDOutput(RGB[2], CANifier.LEDChannel.LEDChannelC);
    }

    public void onStop(){
        Hardware.canifier.enablePWMOutput(Constants.kMotorControllerCh.value, false);
    }

    public void setColor(Colors color){
        RGB = colorNameToRGB.getColorNameToRGB(color);
    }
}
