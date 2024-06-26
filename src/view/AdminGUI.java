package view;
import business.AdminManager;
import business.LoginManager;
import core.Helper;
import dao.LoginDao;
import entity.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

// Admin ile ilgili operasyonların gerçekleşeceği class
public class AdminGUI extends LayOut {
    private AdminManager adminManager = new AdminManager();
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JTable tbl_personel;
    private DefaultTableModel mdl_personel;
    private Object[] row_personel;
    private JTextField fld_tcNo;
    private JTextField fld_userName;
    private JTextField fld_name;
    private JTextField fld_surname;
    private JComboBox cmb_userType;
    private JButton btn_addUser;
    private JTextField fld_password;
    private User admin;
    public AdminGUI(User admin){
        this.admin = admin;
        add(wrapper);
        guiInitialize(800,500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LoginGUI backToLogin = new LoginGUI(new LoginManager(new LoginDao()));
            }
        });

        // tablonun kullanıcıya gösterilmesi yapılan işlem adımları
        mdl_personel = new DefaultTableModel();
        mdl_personel.setColumnIdentifiers(new Object[]{"Kullanıcı id","TC","Kullanıcı Adı","Şifre","Adı","Soyadı","Kullanıcı Tipi"});
        row_personel = new Object[7];
        tbl_personel.setModel(mdl_personel);

        cmb_userType.addItem("Admin");
        cmb_userType.addItem("Employee");

        // mouse listener
        tbl_personel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_personel.setRowSelectionInterval(tbl_personel.rowAtPoint(e.getPoint()), tbl_personel.rowAtPoint(e.getPoint()));
            }
        });
        loadPersonelTable();
        // personel listesi için oluşturulan JpopupMenü
        JPopupMenu tbl_personel_popup = new JPopupMenu();
        tbl_personel_popup.add("Güncelle").addActionListener(e ->{
            if(adminManager.updateUser(
                    // id sine göre kullanıcı seçilir
                    Integer.parseInt(tbl_personel.getValueAt(tbl_personel.getSelectedRow(),0).toString()),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),1).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),2).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),3).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),4).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),5).toString(),
                    String.valueOf(cmb_userType.getSelectedItem())
            )){
                loadPersonelTable();
                Helper.showMsg("Başarılı","Kullanıcı Güncellendi");// --SELECTION 25--
            } else {
                Helper.showMsg("Hata","Beklenmeyen bir hata oluştu !");// --SELECTION 25--
            }
        });
        tbl_personel_popup.add("Sil").addActionListener(e ->{
            if(adminManager.deleteUser(Integer.parseInt(tbl_personel.getValueAt(tbl_personel.getSelectedRow(),0).toString()))){
                loadPersonelTable();
                Helper.showMsg("Başarılı","Kullanıcı Silindi");// --SELECTION 25--
            } else {
                Helper.showMsg("Hata","Beklenmeyen bir hata oluştu !");// --SELECTION 25--
            }
        });
        tbl_personel.setComponentPopupMenu(tbl_personel_popup);

        btn_addUser.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_tcNo) || Helper.isFieldEmpty(fld_userName) || Helper.isFieldEmpty(fld_password) ||
                    Helper.isFieldEmpty(fld_name) || Helper.isFieldEmpty(fld_surname)) {
                Helper.showMsg("Uyarı !", "İlgili alanları doldurunuz");// --SELECTION 25--
            } else {
                if (adminManager.addUser(
                        fld_tcNo.getText(),
                        fld_userName.getText(),
                        fld_password.getText(),
                        fld_name.getText(),
                        fld_surname.getText(),
                        cmb_userType.getSelectedItem().toString()
                )) {
                    loadPersonelTable();
                    Helper.showMsg("Başarılı", "Kullanıcı Eklendi");// --SELECTION 25--
                }
            }
        });
    }
    //  loadPersonelTable metodu Db de ki personel tablosunu kullanıcının göreceği formata dönüştürüyor
    private void loadPersonelTable(){
        DefaultTableModel db = (DefaultTableModel) tbl_personel.getModel();
        db.setRowCount(0);
        for(User user : adminManager.getUserList()){
            row_personel[0] = user.getUserID();
            row_personel[1] = user.getTcNo();
            row_personel[2] = user.getUsername();
            row_personel[3] = user.getPassword();
            row_personel[4] = user.getName();
            row_personel[5] = user.getSurname();
            row_personel[6] = user.getUserType();
            mdl_personel.addRow(row_personel);
        }
    }
}