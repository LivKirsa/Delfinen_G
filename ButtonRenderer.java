import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Component;
import java.awt.Color;

public class ButtonRenderer implements TableCellRenderer{

   String buttonText;
   String buttonText2;
   Color color;
   Color color2;
   
   //constructor
   public ButtonRenderer(String buttonText, Color color){
      this.buttonText = buttonText;
      this.color = color;
   }
   
   //constructor for paid status.
   public ButtonRenderer(String buttonText, String buttonText2, Color color, Color color2){
      this.buttonText = buttonText;
      this.buttonText2 = buttonText2;
      this.color = color;
      this.color2 = color2;
   }
   
   @Override
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      JButton button = (JButton)value;
      
      button.setText(buttonText);
      button.setBackground(color);
      
      //for ispaid. (this could be better)
      if(color2 != null){
      
         if (MemberList.memberList.get(row).getIsPaid()){
            Color color3 = new Color(124, 255, 178);
           button.setBackground(color);
           button.setText("Betalt");
                  
         }else{
           button.setText("Restance");
            button.setBackground(color2);  
         }
      }
      
      return button;
   }
}
