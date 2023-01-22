package View.Dashboard;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.JavaBean;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.swing.text.JTextComponent;



public class CenterPanel extends JPanel {


    JPanel topPanel, centerPan ,rightPanel;
    JLabel title;
    JButton btn_Action;

    TableView table;
    JScrollPane sp;

    Object[] data;
    Object[] column;

    int tbl_marginTop=0;

    private Map<String,JTextField> txts;


    // public void initActionBTN(String btn_title)
    // {
    //     btn_Action.setText(btn_title);
    // }

    public void initTexts(String btn_title){

        // txts.clear();

        if(txts==null)
        {
            txts= new HashMap<>();
                int x=0;
                int y=0;
                int i=0;
                //600
                for( i = 1; i<=table.getColumns().size();i++)
                {
                    // make bounds of textFealds to have 3 txt in a row 
                    x = (i-1)%3;
                    y = (i-1)/3;
                    if(table.getColumns().get(i-1)!=null)
                    {
                    JTextField txt = new JTextField();
                    String title =table.getColumns().get(i-1);
                    // set Placeholder
                    TextPrompt tp = new TextPrompt(title, txt);
        
                    txt.setBounds(10+x*200, 10+y*40, 180, 30);
                    
                    txts.put(table.getColumns().get(i-1),txt);
        
                
                    tbl_marginTop=(10+y*40)+40;
                    }
                }
        
                x = (i-1)%3;
                y = (i-1)/3;
        
          
                    btn_Action = new JButton();
                    btn_Action.setText(btn_title);
                    System.out.println(btn_title);
                    btn_Action.setBounds(10+x*200, 10+y*40, 120, 30);
                    btn_Action.setBackground(new Color(103, 114, 226));
                    btn_Action.setForeground(Color.WHITE);
                    btn_Action.setFont(new Font("Arial", Font.BOLD,15));
                    centerPan.add(btn_Action);
        
                
        
                // add txts to center Panel
                for(i = 0; i<table.getColumns().size();i++)
                {
                    centerPan.add(txts.get(table.getColumns().get(i)));
                }
            
        
        
                sp.setBounds(10, tbl_marginTop, 580, 200);
        }  
        else
        {
            btn_Action.setText(btn_title);
            System.out.println(btn_title+" ex");
            
            if(btn_title=="Suprimer")
            {
                for(int i = 0; i<table.getColumns().size();i++)
                {
                    if(table.getColumns().get(i)!="Index" && table.getColumns().get(i)!="Login" && table.getColumns().get(i)!="CIN"&& table.getColumns().get(i)!="ID")
                    {
                    txts.get(table.getColumns().get(i)).setEnabled(false);
                    txts.get(table.getColumns().get(i)).setBackground(new Color(211, 214, 215));
                    }
                }
            }
            else{
                for(int i = 0; i<table.getColumns().size();i++)
                {
                    txts.get(table.getColumns().get(i)).setEnabled(true);
                    txts.get(table.getColumns().get(i)).setBackground(Color.WHITE);

                }
            }
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
        

        centerPan.add(sp);

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

    // geters
    public JButton getBtn_Action() {
        return btn_Action;
    }

    public Map<String, JTextField> getTxts() {
        return txts;
    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public Object[] getColumn() {
        return column;
    }

    public void setColumn(Object[] column) {
        this.column = column;
    }

    public void setTxts(Map<String, JTextField> txts) {
        this.txts = txts;
    }

    public void setBtn_Action(JButton btn_Action) {
        this.btn_Action = btn_Action;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }

    public void setCenterPan(JPanel centerPan) {
        this.centerPan = centerPan;
    }

    public void setTbl_marginTop(int tbl_marginTop) {
        this.tbl_marginTop = tbl_marginTop;
    }


    
}

