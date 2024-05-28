import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class SwingTeam extends SuperSwing{//class to be added to Couch class.
   JButton b1, b2;
   
   public SwingTeam(int teamNumber){
      super(false);
      setVisible(true);
      f.setSize(300,300);
      displayList(addTableModel(TeamList.teamList.get(teamNumber).teamMemberList, Member.couchCol));
      //setButtons();
     // super.Button1().setText("Se discipliner");
      //b2.setText("Se Medlemmer");
   }
   
   /*
   public void setButtons(){
      b1 = super.Button1();
      b2 = super.Button2();
   }*/
   
   public JButton Button1(){
      JButton button = super.Button1();
      button.setText("Se discipliner");
      button.setBackground(turkis1);
      return button;
   }
   
   public JButton Button2(){
   JButton button = super.Button2();
   button.setText("Se Medlemmer");
   button.setBackground(blue);
      return button;

   }
   
   
   //add jtable
   
   @Override
   public DefaultTableModel addTableModel(ArrayList<?> list, String[] col){
      DefaultTableModel tableModel = new TableModel(col, 0, f);
      Object [] row = {};
      tableModel.setColumnIdentifiers(col);
      /*
      System.out.println(TeamList.teamList.get(2).teamMemberList.size());
      System.out.println(TeamList.team2.teamMemberList.size());
      
      System.out.println("Medlemmer i list: " + list.size());
      int i = 0;*/
         for(Object o : list){
            if (o instanceof Member){
               //i++;
               Member m = (Member) o;
               row = m.getMemberCouchInfoAsArray();
               tableModel.addRow(row);
            }
         }
         
         //System.out.println(i);
         
      return tableModel;
   }

}