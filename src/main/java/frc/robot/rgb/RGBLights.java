package frc.robot.rgb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RGBLights extends SubsystemBase {

    private RGBComponentsBase ledComponents;
    private LedShuffleBoard shuffleBoard;

    public RGBLights(RGBComponentsBase ledComponents) {
        this.ledComponents = ledComponents;
        shuffleBoard = new LedShuffleBoard(this);
        shuffleBoard.init();
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

    public void halfsies(int red1, int green1, int blue1, int red2, int green2, int blue2) {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength() / 2; i++) {
          ledComponents.getLedBuffer().setRGB(i, red1, green1, blue1);
        }
        for (int i = ledComponents.getLedBuffer().getLength() / 2; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, red2, green2, blue2);
        }
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }
}

