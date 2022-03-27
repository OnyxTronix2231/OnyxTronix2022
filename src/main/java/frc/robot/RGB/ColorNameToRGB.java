package frc.robot.RGB;

import java.util.Map;

public class ColorNameToRGB {

    static final Map<Enum<Color>, float[]> COLORS = Map.of(
            Color.Red, Constants.RED_RGB,
            Color.Blue, Constants.BLUE_RGB,
            Color.Green, Constants.GREEN_RGB,
            Color.Yellow, Constants.YELLOW_RGB,
            Color.Pink, Constants.PINK_RGB,
            Color.Purple, Constants.PURPLE_RGB,
            Color.White, Constants.WHITE_RGB,
            Color.Black, Constants.BLACK_RGB,
            Color.Orange, Constants.ORANGE_RGB
    );

    public static float[] colorToRGB(Color color) {
        return COLORS.get(color);
    }
}
