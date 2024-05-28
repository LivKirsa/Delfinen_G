import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.ArrayList;

public class TableModel extends DefaultTableModel{
   JFrame frame;
   //ArrayList <Integer> columnNumber = new ArrayList <Integer>();
   int columnNumber = - 1;
   String columnName;
   
   public TableModel(String[] col, int row, JFrame frame){
      super(col, row);
      this.frame = frame;
   }
   
   @Override
    public boolean isCellEditable(int row, int column) {//cells cannot be edited
        return false;
    }
   @Override
   public Object getValueAt(final int rowIndex, final int columnIndex) {
      Object value = super.getValueAt(rowIndex, columnIndex);
      
      if (columnIndex == columnNumber){
         columnName = getColumnName(columnNumber);
         
         JButton button = new JButton();
         button.addActionListener( e ->{
         
           // switch(columnName){
             //  Case "Knap":
                  Member member = MemberList.memberList.get(rowIndex);
                  if (member.getIsPaid()){
                     member.setIsPaid(false);
                  }else{
                     member.setIsPaid(true);
                  }
                 // break,
              //case "Hold":
               
           // }
            frame.repaint();
         });
         return button;
      }//end of if statement
      return value;
   }
}
