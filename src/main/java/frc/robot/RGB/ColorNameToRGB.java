package frc.robot.RGB;

import java.util.HashMap;

public class ColorNameToRGB {
    static HashMap<Enum<Colors>, float[]> COLORS = new HashMap<>();

    public ColorNameToRGB(){
        COLORS.put(Colors.Red, Constants.RED_RGB);
        COLORS.put(Colors.Blue, Constants.BLUE_RGB);
        COLORS.put(Colors.Green, Constants.GREEN_RGB);
        COLORS.put(Colors.Yellow, Constants.YELLOW_RGB);
        COLORS.put(Colors.Pink, Constants.PINK_RGB);
        COLORS.put(Colors.Purple, Constants.PURPLE_RGB);
        COLORS.put(Colors.White, Constants.WHITE_RGB);
        COLORS.put(Colors.Black, Constants.BLACK_RGB);
    }

    public float[] getColorNameToRGB(Colors color){
        return COLORS.get(color);
    }
}
