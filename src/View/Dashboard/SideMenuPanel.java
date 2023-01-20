package View.Dashboard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class SideMenuPanel extends JPanel {

    private Map<String, JLabel> Labels;

    private JLabel lbl_Logo;
    public JLabel lbl_Auther;
    private ImageIcon img_Logo;

    private void initImages(){
        // Logo image
        img_Logo = new ImageIcon("img/bank-building-90.png");
        //////////////////////////////////
    }

    private void initLabels(List<String> lbls,List<ImageIcon>imgs){

        // Logo Label
        lbl_Logo = new JLabel("<HTML><U>Bank XYZ</U></HTML>");
        lbl_Logo.setBounds(20, 10, 160, 50);
        lbl_Logo.setForeground(new Color(103, 114, 226));

        lbl_Logo.setIcon(new ImageIcon(img_Logo.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        // add font to lbl_Logo to make it pro
        lbl_Logo.setFont(new Font("Arial", Font.BOLD,20));
        //////////////////////////////////




        Labels = new HashMap<>();
        AtomicInteger ic= new AtomicInteger();
        final int[] y = {80};
        lbls.forEach((label)->{

            JLabel lbl = new JLabel(label);
            lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lbl.setBounds(0, y[0], 180, 50);
            y[0] = y[0] +50;

            //lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setForeground(Color.gray);
            lbl.setIcon(new ImageIcon(imgs.get(ic.intValue()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            lbl.setIconTextGap(20);
            //lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setBorder(new EmptyBorder(0,20,0,0));
            if(ic.get() ==0)
            {
                lbl.setBackground(new Color(247, 249, 252));
                lbl.setOpaque(true);

            }
            else
            {
                lbl.setBackground(Color.WHITE);
                lbl.setOpaque(true);
            }
            Labels.put(label,lbl);
            ic.getAndIncrement();
        });

        lbl_Auther=new JLabel();
        lbl_Auther.setBounds(10,430, 180, 50);
        lbl_Auther.setText("<HTML><B>By:</B><U>Soufiane Majdar<U><HTML>");
        lbl_Auther.setFont(new Font("Arial",Font.PLAIN,12));
        lbl_Auther.setForeground(Color.gray);
        lbl_Auther.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public SideMenuPanel(List<String> lbls,List<ImageIcon> imgs){
        initImages();
        initLabels(lbls,imgs);

        setBackground(Color.white);
        setBounds(0, 0, 180, 500);
        //setLayout(new GridLayout(Labels.size(),1,5,0));
        setLayout(null);

        add(lbl_Logo);

        Labels.forEach((name,lbl)->{
            this.add(lbl);
        });

        add(lbl_Auther);


    }

    public Map<String, JLabel> getLabels() {
        return Labels;
    }
}
