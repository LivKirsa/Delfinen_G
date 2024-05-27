import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JFrame;

public class TableModel extends DefaultTableModel{
   JFrame frame;
   int columnNumber;
   
   public TableModel(String[] col, int row, JFrame frame){
      super(col, row);
      this.frame = frame;
   }
    public boolean isCellEditable(int row, int column) {
        // Only the button column (e.g., column 12) is editable
        return false;
    }
   @Override
   public Object getValueAt(final int rowIndex, final int columnIndex) {
      Object value = super.getValueAt(rowIndex, columnIndex);
      if (columnIndex == columnNumber){
         JButton button = new JButton();
         button.addActionListener( e ->{
         
            Member member = MemberList.memberList.get(rowIndex);
            if (member.getIsPaid()){
               member.setIsPaid(false);
            }else{
               member.setIsPaid(true);
            }
            button.setText("" + rowIndex);
            frame.repaint();
         });
         return button;
      }
      return value;
   }
}
