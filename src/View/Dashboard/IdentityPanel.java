package View.Dashboard;

import javax.swing.*;
import java.awt.*;

public class IdentityPanel extends JPanel {

    JLabel lbl_Lgout,lbl_Avatar,lbl_Title;

    ImageIcon img_Lgout, img_Avatar;




    private void initImages()
    {
        img_Lgout = new ImageIcon("img/log-out_90.png");
        img_Avatar = new ImageIcon("img/account-96.png");

    }


    private void initLabels()
    {
        lbl_Lgout = new JLabel();
        lbl_Lgout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_Lgout.setBounds(574, 10, 100, 30);
        lbl_Lgout.setForeground(Color.WHITE);
        lbl_Lgout.setIcon(new ImageIcon(img_Lgout.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

        lbl_Title= new JLabel();
        lbl_Title.setBounds(3, 3, 180, 50);
        lbl_Title.setFont(new Font("Arial",Font.PLAIN,12));
        lbl_Title.setForeground(new Color(247, 249, 252));

        lbl_Avatar = new JLabel();
        lbl_Avatar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_Avatar.setBounds(534, 10, 100, 30);
        lbl_Avatar.setForeground(Color.WHITE);
        lbl_Avatar.setIcon(new ImageIcon(img_Avatar.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));

    }

    public void setLbl_Title(String title)
    {
        lbl_Title.setText("|-> "+title);
    }

    public IdentityPanel(String title){
        initImages();
        initLabels();
        setLbl_Title(title);


        setBackground(new Color(103, 114, 226));
        setBounds(180, 0, 620, 50);
        setLayout(null);
        add(lbl_Lgout);
        add(lbl_Title);
        add(lbl_Avatar);

    }

}
