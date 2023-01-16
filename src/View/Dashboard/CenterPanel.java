package View.Dashboard;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class CenterPanel extends JPanel {


    JPanel topPanel, centerPan ,rightPanel,footerPnel;
    JLabel title;

    TableView table;
    JScrollPane sp;


    private void initTableView(){
        table = new TableView(new DefaultTableModel());

        Object[] data =new Object[]{"101","Majdar","Soufiane","SoufianeMJ","sf%&4lcj456mfpsFGhd","GB748","sofiane@mail.com","06 0000000","1023"};
        String column[]={"ID","Nom","Prenom","Login","PssWord","CIN","Email","Tele","ID Agance"};

        // Create a couple of columns 
        table.addColumns(column);


        for(int i=0;i<20;i++)
        {
            table.addRow(data);
        }

        sp=new JScrollPane(table);
        sp.setBounds(10, 100, 580, 200);

    }



    private void initPanels()
    {
        topPanel= new JPanel();
        topPanel.setBackground(new Color(202, 206, 245));
        topPanel.setBounds(10, 10, 590, 40);
        

        centerPan= new JPanel();
        centerPan.setBackground(new Color(247, 249, 252));
        centerPan.setBounds(10, 50, 600, 320);
        centerPan.setLayout(null);

        initTableView();
        centerPan.add(sp);


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

        add(centerPan);
  
        add(footerPnel);
    }
}

