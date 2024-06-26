import java.awt.event.MouseAdapter;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class JTableButtonMouseListener extends MouseAdapter {
    private final JTable table;
        
   public JTableButtonMouseListener(JTable table) {
     this.table = table;
   }

  public void mouseClicked(MouseEvent e) {
    int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
    int row = e.getY()/table.getRowHeight(); //get the row of the button

    if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
      Object value = table.getValueAt(row, column);

      if (value instanceof JButton) {
            ((JButton)value).doClick();//perform a click event
         }
      }
   }
}