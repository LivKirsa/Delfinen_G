import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Component;
import java.awt.Color;

public class ButtonRenderer implements TableCellRenderer{

   @Override
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      JButton button = (JButton)value;
      if (button == null){
         button = new JButton();
      }

      if (MemberList.memberList.get(row).getIsPaid()){
         button.setBackground(new Color(124, 255, 178));
         button.setText("Betalt");
            
      }else{
         button.setText("Restance");
         button.setBackground(Color.PINK);            
      }
      return button;
   }
}
