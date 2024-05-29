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

public class SwingChairMan extends SuperSwing {
   
   private Member member;
   
   public SwingChairMan(boolean visible) { // Constructor
      super (visible);
      f.setTitle("Svømmeklubben Delfinen");
      
        //Tabs work start here 
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Medlemmer",openChairman());
        tabbedPane.addTab("Hold", openCoach());//openCoach());
        tabbedPane.addTab("Kontingent",openAcc());
        f.add(tabbedPane, BorderLayout.CENTER);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        setBackground(turkis1);
        }
        
        protected JButton Button1() {
        JButton b1 = new JButton("Nyt medlem");
            b1.setBackground(pink);
             b1.setForeground(softBlack);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {
               swimmerFrame();
            }
        });
        return b1;
    }
        protected JButton Button2() {
        JButton b2 = new JButton("Se Medlemmer");
                b2.setBackground(blue);
        b2.setForeground(softBlack);
        b2.addActionListener(new ActionListener() {
        //action for button 2
            public void actionPerformed(ActionEvent e) {
                        displayList(addTableModel(MemberList.memberList, Member.col));
            }
        });
        return b2;
    }
    
        protected JButton Button3() {
        JButton b3 = new JButton("Se Hold");
                b3.setBackground(pink);
        b3.setForeground(softBlack);
        b3.addActionListener(new ActionListener() {
        //action for button 3
            public void actionPerformed(ActionEvent e) {
               displayList(addTableModel(TeamList.teamList, Team.col));
            }
        });
        return b3;
    }
       //buttonPanel.setBackground(turkis2);
    
        private JPanel openChairman() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        //panel.add(chairManButtons(),BorderLayout.WEST);
         panel.add(this); //BorderLayout.CENTER);
        return panel;
        } 
        private JPanel openCoach() {
           JPanel panel = new JPanel(new BorderLayout());
           panel.setBackground(new Color(255, 200, 200));
           panel.add(new SwingCoach(false));
           return panel;
        }
        
        private JPanel openAcc() {
        JPanel panel = new JPanel(new BorderLayout());
           panel.setBackground(new Color(255, 200, 200));
           panel.add(new SwingAcc(false));
 
        return panel;
        }
         
     public void displayList(DefaultTableModel tableModel){
         super.displayList(tableModel);
         addButton("Knap", "Betalt", "I restance");
     }
}      

