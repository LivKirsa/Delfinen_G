import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JPanel;

public class TableModel extends DefaultTableModel{
   JFrame frame;
   //ArrayList <Integer> columnNumber = new ArrayList <Integer>();
   int columnNumber = - 1;
   String columnName;
   JPanel couchPanel;
   
   public TableModel(String[] col, int row, JFrame frame){
      super(col, row);
      this.frame = frame;
   }
   
   public TableModel(String[] col, int row, JFrame frame, JPanel panel){
      super(col, row);
      this.frame = frame;
      couchPanel = panel;
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
         switch(columnName){
            case "Knap":
               Member member = MemberList.memberList.get(rowIndex);
         if (member.getIsPaid()){
            member.setIsPaid(false);
         }else{
            member.setIsPaid(true);
         }

               break;
               
         case "Hold":
               SwingCoach.teamPanel = new SwingTeam(rowIndex);
               //System.out.println(rowIndex);
               //couchPanel.setBackground(Color.PINK);
               SwingCoach.teamPanel.repaint();
               break;
               
         }

         frame.repaint();
         });
         return button;
      }//end of if statement
      return value;
   }
   
   public class PaidButtonListener implements ActionListener{
      int rowIndex;
      
      public PaidButtonListener(int rowIndex){
         this.rowIndex = rowIndex;
      }
      
      @Override
      public void actionPerformed(ActionEvent e){

      }
      
      public void isPaid(){
         
         Member member = MemberList.memberList.get(rowIndex);
         if (member.getIsPaid()){
            member.setIsPaid(false);
         }else{
            member.setIsPaid(true);
         }
      }
      
      public void viewTeam(int teamNumber){
         System.out.println("Se Hold");
         //TeamList.teamList.get(teamNumber);
      }
      
      public void setCouch(){
         //skip for now
      }
      
      //public void
    }
}
