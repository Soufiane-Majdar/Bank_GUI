package View.Dashboard;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.swing.text.JTextComponent;



public class CenterPanel extends JPanel {


    JPanel topPanel, centerPan ,rightPanel;
    JLabel title;

    TableView table;
    JScrollPane sp;

    Object[] data;
    Object[] column;

    int tbl_marginTop=0;

    private Map<String,JTextField> txts;



    private void initTexts(){
        txts = new HashMap<>();
        //600
        for(int i = 1; i<=table.getColumns().size();i++)
        {
            // make bounds of textFealds to have 3 txt in a row 
            int x = (i-1)%3;
            int y = (i-1)/3;
            JTextField txt = new JTextField();
            String title =table.getColumns().get(i-1);
            // set Placeholder
            TextPrompt tp = new TextPrompt(title, txt);

            // txt.addFocusListener(new FocusAdapter() {

               
            //     @Override
            //     public void focusGained(FocusEvent e) {
            //         txt.setText(title);
            //     }

            //     @Override
            //     public void focusLost(FocusEvent e) {
            //        txt.setText("");
            //     }
            // });

            txt.setBounds(10+x*200, 10+y*40, 180, 30);
            
            txts.put(table.getColumns().get(i-1),txt);

            tbl_marginTop=(10+y*40)+40;
        }

        // add txts to center Panel
        for(int i = 0; i<table.getColumns().size();i++)
        {
            centerPan.add(txts.get(table.getColumns().get(i)));
        }
    }


    private void initTableView(){
        table = new TableView(new DefaultTableModel());

        data =new Object[]{"101","Majdar","Soufiane","SoufianeMJ","sf%&4lcj456mfpsFGhd","GB748","sofiane@mail.com","06 0000000","1023"};
        column=new Object[]{"ID","Nom","Prenom","Login","PssWord","CIN","Email","Tele","ID Agance"};

        // Create a couple of columns 
        table.addColumns(column);


        for(int i=0;i<20;i++)
        {
            table.addRow(data);
        }

        sp=new JScrollPane(table);
        

    }



    private void initPanels()
    {
        topPanel= new JPanel();
        topPanel.setBackground(new Color(202, 206, 245));
        topPanel.setBounds(10, 10, 590, 40);
        

        centerPan= new JPanel();
        centerPan.setBackground(new Color(247, 249, 252));
        centerPan.setBounds(10, 50, 600, 360);
        centerPan.setLayout(null);



        initTableView();
        centerPan.add(sp);

        initTexts();
        sp.setBounds(10, tbl_marginTop, 580, 200);
        System.out.println(tbl_marginTop);



    }

    private void initLabels(){
        title= new JLabel();
        title.setText("<HTML><U>Formulaire Admin</U><HTML>");
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
  
     
    }
}

