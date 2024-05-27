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

         /*button.addActionListener(e ->{
            System.out.println("peddersen of findus");
         });*/
      }
      //button.setText("heiij");
      
     /* button.addActionListener(e ->{
         //setBackground(Color.PINK);
         
         //SwingChairMan.buttonList.add(button);
      });*/
      //button.setBackground(Color.PINK);
      //System.out.println("jbutton:" + row + ", " + column);
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