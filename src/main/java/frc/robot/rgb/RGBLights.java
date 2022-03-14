package frc.robot.rgb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.rgb.commands.BlinkYouStupidFatPigHeadedDick;

public class RGBLights extends SubsystemBase {

    private static RGBComponentsBase ledComponents;
    private static LedShuffleBoard shuffleBoard;
    private static RGBLights rgbLights = null;

    public static RGBLights getInstance() {
        if (rgbLights == null) {
            ledComponents = new RGBComponentsBase();
            rgbLights = new RGBLights();
            shuffleBoard = new LedShuffleBoard();
            shuffleBoard.init();
        }
        return rgbLights;
    }

    public RGBLights() {
    }

    public void setToColor(int red, int green, int blue) {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, red, green, blue);
        }
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }

    public void rainbow() {
        double m_rainbowFirstPixelHue = 50;
        for (var i = 0; i < ledComponents.getLedBuffer().getLength(); i++) {
            final double hue = (m_rainbowFirstPixelHue + (i * 180 / ledComponents.getLedBuffer().getLength())) % 180;
            ledComponents.getLedBuffer().setHSV(i, (int)hue, 255, 128);
        }
        m_rainbowFirstPixelHue += 3;
        m_rainbowFirstPixelHue %= 180;
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }

    public void halfsies(int[] color1, int[] color2) {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength() / 2; i++) {
          ledComponents.getLedBuffer().setRGB(i, color1[0], color1[1], color1[2]);
        }
        for (int i = ledComponents.getLedBuffer().getLength() / 2; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, color2[0], color2[1], color2[2]);
        }
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }
}

