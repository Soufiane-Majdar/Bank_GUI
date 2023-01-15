package View.Dashboard;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CenterPanel extends JPanel {


    JPanel topPanel, leftPanel ,rightPanel,footerPnel;
    JLabel title;



    private void initPanels()
    {
        topPanel= new JPanel();
        topPanel.setBackground(new Color(202, 206, 245));
        topPanel.setBounds(10, 10, 590, 40);

        leftPanel= new JPanel();
        leftPanel.setBackground(new Color(247, 249, 252));
        leftPanel.setBounds(10, 50, 300, 320);

        rightPanel= new JPanel();
        rightPanel.setBackground(new Color(247, 249, 252));
        rightPanel.setBounds(310, 50, 290, 320);

        footerPnel= new JPanel();
        footerPnel.setBackground(new Color(199, 201, 215));
        footerPnel.setBounds(10, 370, 590, 40);

    }

    private void initLabels(){
        title= new JLabel();
        title.setText("<HTML><U>Formulaire Client</U><HTML>");
        title.setForeground(new Color(58, 51, 122));
        title.setBorder(new EmptyBorder(6,0,0,0));
        title.setFont(new Font("Arale",Font.BOLD,17));
        topPanel.add(title);

    }


    public CenterPanel(){
        setBounds(180, 50, 620, 450);
        setLayout(null);
        setBackground(new Color(247, 249, 252));
        initPanels();
        initLabels();
        add(topPanel);
        add(leftPanel);
        add(rightPanel);
        add(footerPnel);
    }
}

