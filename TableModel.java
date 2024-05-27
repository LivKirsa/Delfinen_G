import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JFrame;

public class TableModel extends DefaultTableModel{
   JFrame frame;
   
   public TableModel(String[] col, int row, JFrame frame){
      super(col, row);
      this.frame = frame;
   }

   @Override
   public Object getValueAt(final int rowIndex, final int columnIndex) {
      Object value = super.getValueAt(rowIndex, columnIndex);
      if (columnIndex == 12){
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
