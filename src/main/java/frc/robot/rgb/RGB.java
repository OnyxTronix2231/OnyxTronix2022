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
}

