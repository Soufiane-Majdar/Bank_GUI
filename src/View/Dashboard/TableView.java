package View.Dashboard;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import Model.Domain.Client;


public class TableView extends JTable {

    private String[]    columnsNames;
    private Object[][]  data;
    static int  index;



    public TableView(DefaultTableModel model){
        super(model);
        index=0;

        Font font = new Font("Verdana", Font.PLAIN, 10);
        setFont(font);
        setRowHeight(20);


        JTableHeader tableHeader = this.getTableHeader();
        tableHeader.setBackground(new Color(103, 114, 226));
        tableHeader.setForeground(Color.white);
        Font headerFont = new Font("Verdana", Font.PLAIN, 12);
        tableHeader.setFont(headerFont);
    }





    // // ADD Columns
    public void addColumns(String... colNames)
    {
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        for(String colName : colNames)
        {
            model.addColumn(colName);
        }
    }

    // ADD Row
    public void addRow(Object[] data)
    {
        // add index to data
        Object[] newData = new Object[data.length];
        for(int i=0;i<data.length;i++)
        {
            newData[i]=data[i];
        }
        data=newData;

        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.addRow(data);
    }

    // ADD one client
    public void addClient(Client c)
    {
        this.addRow(new Object[]{c.getId(),c.getNom(),c.getPrenom(),c.getLogin(),c.getMotDePasse(),c.getCin(),c.getEmail(),c.getTel(),c.getSexe()});
    }
    
    public void initClientsData(List<Client> clients)
    {
        // delet all rows evry time
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.setRowCount(0);
        for(Client c : clients)
        {
            this.addRow(new Object[]{c.getId(),c.getNom(),c.getPrenom(),c.getLogin(),c.getMotDePasse(),c.getCin(),c.getEmail(),c.getTel(),c.getSexe()});
        }
    }
 
    // get columns names
    public List<String> getColumns()
    {
        int columnsCount = this.getColumnCount();
        List<String> columns = new java.util.ArrayList<String>();
        for(int i=0;i<columnsCount;i++)
        {
            columns.add(this.getColumnName(i));
        }
        return columns;
    }
    
    
}
