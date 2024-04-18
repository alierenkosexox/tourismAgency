package view;
import business.UserManager;
import core.Helper;
import entity.User;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;

public class LoginView extends LayOut{
    private JPanel container;
    private JLabel welcome;
    private JTextField lbl_username;
    private JTextField lbl_password;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JTextField fld_username;
    private final UserManager userManager;

    public LoginView(){
        this.userManager = new UserManager();
        this.add(this.container);
        this.guiInitilaze(400,400);
    }
}
