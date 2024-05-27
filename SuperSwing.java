import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class SuperSwing extends JPanel {
   Color turkis1 = new Color(199, 237, 231);
   Color turkis2 = new Color(177, 224, 218);
   Color turkis3 = new Color(140, 204, 200);
   Color turkis4 = new Color(103, 159, 157);
   Color purple = new Color(159, 141, 185);
   Color pink = new Color(232, 173, 210);
   Color blue = new Color(171, 218, 233);
   Color softWhite = new Color(241, 234, 231);
   Color darkBlue = new Color(53, 120, 180);
   Color softBlack = new Color(50, 42, 51);
   
   protected JFrame f; 
   
   public SuperSwing(boolean visible) {
   f = new JFrame(); 
      setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setTitle("SuperSwing");
        f.setVisible(visible);
        f.add(this);
        // size of the window 
       f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
       buttonPanel();
      }
      
      void buttonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        
        JButton b1 = Button1(); 
        JButton b2 = Button2(); 
        JButton b3 = Button3(); 
        
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
 //add Buttonpanel til WEST
       add(buttonPanel, BorderLayout.WEST);
}
      
      protected JButton Button1() {
        JButton b1 = new JButton("knap1");
        b1.setBackground(Color.BLUE);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b1;
    }
      protected JButton Button2() {
        JButton b2 = new JButton("Knap2");
        b2.setBackground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b2;
    }
      protected JButton Button3() {
        JButton b3 = new JButton("knap3");
        b3.setBackground(Color.RED);
        b3.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b3;
    } 
    public void displayList(ArrayList<?> list) {        
        Object[] tempArr = list.toArray();
        String[] col = Member.col;
        DefaultTableModel tableModel = addJTable(tempArr, col);
        
        JTable table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        
        JScrollPane scrollpane = new JScrollPane(table); 
        scrollpane.setVisible(true);      
        add(scrollpane, BorderLayout.CENTER);
        setBackground(Color.WHITE);
        revalidate();
    }
    
    public DefaultTableModel addJTable(Object[] list, String[] col) {

       DefaultTableModel tableModel = new DefaultTableModel(col, 0);
       for (Object o : list) {
         if (o instanceof Member) {
            Member m = (Member) o;
            tableModel.addRow(m.getMemberInfoAsArray());
            tableModel.setColumnIdentifiers(Member.col);
            //tableModel.setRowColour(1, Color.BLACK);
            tableModel.addColumn(", ");
         } else if (o instanceof Team) {
            Team t= (Team) o;
            tableModel.addRow(t.getTeamInfoAsArray());
            tableModel.setColumnIdentifiers(Team.col);
         } else if (o instanceof Result) {
            Result r = (Result) o;
               /*if (r instanceof CompResult){
                  r = (CompResult) r;
               }*/
            tableModel.addRow(r.getResultInfoAsArray());
            tableModel.setColumnIdentifiers(Result.col);
         }
       }

       
      return tableModel;
    }        

       }

