package View.Dashboard;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableView extends JTable {

     
    static int  index;
    
    

    public TableView(DefaultTableModel model){
        super(model);
        index=0;
    }





    // ADD Columns
    public void addColumns(String[] columns)
    {
        // add "Index" to Comluns
        String[] newColumns = new String[columns.length+1];
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
 
    
    
}
