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
         button = new JButton("goddag");
      }
      button.setText("heiij");
      
      button.addActionListener(e ->{
         //setBackground(Color.PINK);
         System.out.println("peddersen of findus");
         //SwingChairMan.buttonList.add(button);
      });
      //button.setBackground(Color.PINK);
      //System.out.println("jbutton:" + row + ", " + column);
      return button;
   }
}