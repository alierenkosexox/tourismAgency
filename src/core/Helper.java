package core;

import javax.swing.*;

public class Helper {

    // Show a message dialog with the specified title and message
    public static void showMsg(String title, String message) {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Text fld alanlarının boş olup olmadığını kontrol eden metod
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().isEmpty();
    }

    public static boolean confirm(String str) {
        String msg;
        switch (str) {
            case "sure":
                msg = "Are you sure you want to perform this action?";
                break;
            default:
                msg = str;
                break;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Are you sure you want to proceed?", JOptionPane.YES_NO_OPTION) == 0;
    }
}
