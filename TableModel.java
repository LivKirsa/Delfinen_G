import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.*;

public class TableModel extends DefaultTableModel{

   public TableModel(String[] col, int row){
      super(col, row);
   }

   @Override
   public Object getValueAt(final int rowIndex, final int columnIndex) {
      Object value = super.getValueAt(rowIndex, columnIndex);
      if (columnIndex == 12){
         JButton button = new JButton();

         button.addActionListener( e ->{
            Member member = MemberList.memberList.get(rowIndex);
            //System.out.println("table model actionlistener");
            if (member.getIsPaid()){
               member.setIsPaid(false);
            }else{
               member.setIsPaid(true);
            }
            button.setText("" + rowIndex);
            //SwingChairMan.f.repaint();
         });
         return button;
      }
      return value;
   }
}
