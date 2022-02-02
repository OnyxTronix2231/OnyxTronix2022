package frc.robot.RGB;

import java.util.HashMap;

public class ColorNameToRGB {

    static HashMap<Enum<Color>, float[]> COLORS = new HashMap<>();

    public ColorNameToRGB() {
        COLORS.put(Color.Red, Constants.RED_RGB);
        COLORS.put(Color.Blue, Constants.BLUE_RGB);
        COLORS.put(Color.Green, Constants.GREEN_RGB);
        COLORS.put(Color.Yellow, Constants.YELLOW_RGB);
        COLORS.put(Color.Pink, Constants.PINK_RGB);
        COLORS.put(Color.Purple, Constants.PURPLE_RGB);
        COLORS.put(Color.White, Constants.WHITE_RGB);
        COLORS.put(Color.Black, Constants.BLACK_RGB);
    }

    public float[] getColorNameToRGB(Color color) {
        return COLORS.get(color);
    }
}
