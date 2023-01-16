package View.Dashboard;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class TableView extends JTable {

     
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





    // ADD Columns
    public void addColumns(Object[] columns)
    {
        // add "Index" to Comluns
        Object[] newColumns = new Object[columns.length+1];
        newColumns[0]="Index";
        for(int i=0;i<columns.length;i++)
        {
            newColumns[i+1]=columns[i];
        }
        columns=newColumns;

        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.setColumnIdentifiers(columns);

    }

    // ADD Row
    public void addRow(Object[] data)
    {
        // add index to data
        Object[] newData = new Object[data.length+1];
        newData[0]=index;
        for(int i=0;i<data.length;i++)
        {
            newData[i+1]=data[i];
        }
        data=newData;

        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.addRow(data);
        index++;
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
