package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static int getLocationPoint(String type, Dimension size) {
        int var10000;
        switch (type) {
            case "x":
                var10000 = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                var10000 = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }

    public static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }
}
