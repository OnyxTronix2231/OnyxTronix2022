package frc.robot.RGB;

import java.util.HashMap;

public class ColorNameToRGB {
    static HashMap<Enum<Colors>, float[]> COLORS = new HashMap<>();

    public ColorNameToRGB(){
        COLORS.put(Colors.Red, new float[]{255, 0, 0});
        COLORS.put(Colors.Blue, new float[]{0, 0, 255});
        COLORS.put(Colors.Green, new float[]{0, 255, 0});
        COLORS.put(Colors.Yellow, new float[]{255, 255, 0});
        COLORS.put(Colors.Pink, new float[]{255, 20, 147});
        COLORS.put(Colors.Purple, new float[]{128, 0, 128});
        COLORS.put(Colors.White, new float[]{255, 255, 255});
        COLORS.put(Colors.Black, new float[]{0, 0, 0});
    }

    public float[] getColorNameToRGB(Colors color){
        return COLORS.get(color);
    }
}
