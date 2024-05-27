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
    int row    = e.getY()/table.getRowHeight(); //get the row of the button

    /*Checking the row or column is valid or not*/
      if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
        Object value = table.getValueAt(row, column);//new ButtonRenderer().getTableCellRendererComponent(table, table.getValueAt(row, column), true, true, row, column);
        
        //System.out.println(row + ", " + column);
        /*if (column == table.getColumnCount() - 1){
            System.out.println(row);
            
            Member member = MemberList.memberList.get(row);
            
            if (member.getIsPaid()){
               member.setIsPaid(false);
            }else{
               member.setIsPaid(true);
            }
            
        }*/

        if (value instanceof JButton) {
            //perform a click event
            ((JButton)value).doClick();
         }
      }
   }
}