package frc.robot.rgb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RGB extends SubsystemBase {

    private RGBComponentsBase ledComponents;
    private LedShuffleBoard shuffleBoard;

    public RGB(RGBComponentsBase ledComponents) {
        this.ledComponents = ledComponents;
        shuffleBoard = new LedShuffleBoard(this);
        shuffleBoard.init();
    }

    public void perodic() {

    }

    public void setToRed() {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, 255, 0, 0);
        }
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }

    public void setToGreen() {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, 0, 255, 0);
        }
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }

    public void setToBlue() {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, 0, 0, 255);
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

    public void halfsies() {
        for (int i = 0; i < ledComponents.getLedBuffer().getLength() / 2; i++) {
          ledComponents.getLedBuffer().setRGB(i, 255, 0, 0);
        }
        for (int i = ledComponents.getLedBuffer().getLength() / 2; i < ledComponents.getLedBuffer().getLength(); i++) {
            ledComponents.getLedBuffer().setRGB(i, 0, 0, 255);
        }
        ledComponents.getLed().setData(ledComponents.getLedBuffer());
    }
}

