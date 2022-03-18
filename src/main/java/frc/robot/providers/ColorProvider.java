package frc.robot.providers;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.conveyor.ballTrigger.BallTriggerComponents;

import java.util.ArrayList;

public class ColorProvider extends SubsystemBase {

    private final BallTriggerComponents ballTriggerComponents;
    private final ArrayList<Color> colorsDetected;
    private Color lastSeenColor;
    private Color currentColor;
    private static final int RED_THRESHOLD = 10; // TODO: Tune values
    private static final int BLUE_THRESHOLD = 10; // TODO: Tune values

    public ColorProvider(BallTriggerComponents ballTriggerComponents) {
        this.ballTriggerComponents = ballTriggerComponents;
        colorsDetected = new ArrayList<>();
    }

    @Override
    public void periodic() {
        currentColor = ballTriggerComponents.getColorSensor().getColor();
        if(foundBall()) {
            currentColor = isBlueBall() ? Color.kBlue : Color.kRed;
            if(lastSeenColor != currentColor) {
                lastSeenColor = currentColor;
                colorsDetected.add(lastSeenColor);
            }
        }
    }

    private boolean foundBall() {
        return currentColor.red >= RED_THRESHOLD || currentColor.blue >= BLUE_THRESHOLD;
    }

    private boolean isBlueBall() {
        return currentColor.blue > currentColor.red;
    }

    private Color getAllianceColor() {
        if(DriverStation.getAlliance() == DriverStation.Alliance.Red) {
            return Color.kRed;
        }
        return Color.kBlue;
    }

    public Color getLastSeenColor() {
        if(colorsDetected.isEmpty()) {
            return getAllianceColor();
        }
        return colorsDetected.get(0);
    }

    public void removeColor() {
        if(!colorsDetected.isEmpty()) {
            colorsDetected.remove(0);
        }
    }
}
