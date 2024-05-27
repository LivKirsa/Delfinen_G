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
      
        //Tabs work starts here 
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Medlemmer",openChairman());
        tabbedPane.addTab("Hold", openCoach());
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
               public void actionPerformed(ActionEvent e) {
                  displayList(addTableModel(MemberList.memberList, Member.col));
               }
           });
           return b2;
        }
    
        private JPanel openChairman() {
           JPanel panel = new JPanel(new BorderLayout());
           panel.setBackground(turkis2);
           //panel.add(chairManButtons(),BorderLayout.WEST);
            panel.add(this); //BorderLayout.CENTER);
           return panel;
        } 
        
        private JPanel openCoach() {
           JPanel panel = new JPanel(new BorderLayout());
           panel.setBackground(turkis2);
           panel.add(new SwingCoach(false));
           return panel;
        }
        
        private JPanel openAcc() {
        JPanel panel = new JPanel(new BorderLayout());
           panel.setBackground(turkis2);
           panel.add(new SwingAcc(false));
           return panel;
        }
            
   public void swimmerFrame() {
   
     // Method for adding new Member
     JFrame swimmerFrame = new JFrame();
     swimmerFrame.setTitle("Opret nyt Medlem");
     swimmerFrame.setVisible(true);
     swimmerFrame.setSize(300, 300);
     swimmerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     Login.centerFrameOnScreen(swimmerFrame);
   
     JPanel panel = new JPanel(new GridBagLayout());
     GridBagConstraints gbc = new GridBagConstraints();
     gbc.insets = new Insets(5, 5, 5, 5);
     panel.setBackground(blue);
   
     JTextField text1Field = new JTextField(20);
     JTextField text2Field = new JTextField(20);
     JLabel label1 = new JLabel("Navn: ");
     JLabel label2 = new JLabel("Fødselsdag: ");
     
     ButtonGroup genderGroup = new ButtonGroup();
     ButtonGroup membershipGroup = new ButtonGroup();
     ButtonGroup competitionGroup = new ButtonGroup();
   
     JRadioButton maleRadioButton = new JRadioButton("Mand");
     JRadioButton femaleRadioButton = new JRadioButton("Kvinde");
     maleRadioButton.setBackground(blue);
     femaleRadioButton.setBackground(blue);
     genderGroup.add(maleRadioButton);
     genderGroup.add(femaleRadioButton);
   
     JRadioButton activeRadioButton = new JRadioButton("Aktiv");
     JRadioButton passiveRadioButton = new JRadioButton("Passiv");
     activeRadioButton.setBackground(blue);
     passiveRadioButton.setBackground(blue);
     membershipGroup.add(activeRadioButton);
     membershipGroup.add(passiveRadioButton);
   
     JRadioButton competitiveRadioButton = new JRadioButton("Konkurrence");
     JRadioButton casualRadioButton = new JRadioButton("Motionist");
     competitiveRadioButton.setBackground(blue);
     casualRadioButton.setBackground(blue);
     competitionGroup.add(competitiveRadioButton);
     competitionGroup.add(casualRadioButton);
   
     gbc.gridx = 0;
     gbc.gridy = 0;
     gbc.anchor = GridBagConstraints.CENTER;
     panel.add(label1, gbc);
   
     gbc.gridx = 0;
     gbc.gridy = 1;
     gbc.anchor = GridBagConstraints.CENTER;
     panel.add(text1Field, gbc);
   
     gbc.gridx = 0;
     gbc.gridy = 2;
     gbc.anchor = GridBagConstraints.CENTER;
     panel.add(label2, gbc);
   
     gbc.gridx = 0;
     gbc.gridy = 3;
     gbc.anchor = GridBagConstraints.CENTER;
     panel.add(text2Field, gbc);

     gbc.gridx = 0;
     gbc.gridy = 4;
     gbc.anchor = GridBagConstraints.WEST;
     panel.add(maleRadioButton, gbc);
   
     gbc.gridx = 0;
     gbc.gridy = 4;
     gbc.anchor = GridBagConstraints.EAST;
     panel.add(femaleRadioButton, gbc);

     gbc.gridx = 0;
     gbc.gridy = 5;
     gbc.anchor = GridBagConstraints.WEST;
     panel.add(activeRadioButton, gbc);
   
     gbc.gridx = 0;
     gbc.gridy = 5;
     gbc.anchor = GridBagConstraints.EAST;
     panel.add(passiveRadioButton, gbc);

     gbc.gridx = 0;
     gbc.gridy = 6;
     gbc.anchor = GridBagConstraints.WEST;
     panel.add(competitiveRadioButton, gbc);
   
     gbc.gridx = 0;
     gbc.gridy = 6;
     gbc.anchor = GridBagConstraints.EAST;
     panel.add(casualRadioButton, gbc);
   
     // Done button
     JButton doneButton = new JButton("Tilføj");
     gbc.gridx = 0;
     gbc.gridy = 7;
     gbc.anchor = GridBagConstraints.CENTER;
     panel.add(doneButton, gbc);
   
     swimmerFrame.add(panel);
            doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String name = text1Field.getText(); 
            String birthdayString = text2Field.getText(); 
            boolean isActiveMembership = activeRadioButton.isSelected();
            boolean isCompetitiveSwimmer = competitiveRadioButton.isSelected();
            boolean isMan = maleRadioButton.isSelected();
            
            LocalDate birthday;
            try {
               birthday = LocalDate.parse(birthdayString);
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(swimmerFrame, "Invalid birthday format. Please use YYYY-MM-DD.");
            return;
            }
            Member newMember = new Member(name, birthdayString, isActiveMembership, isCompetitiveSwimmer, isMan);
            swimmerFrame.dispose(); 
            }
        }); 
            text1Field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
            text2Field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    } // This ends swimmerFrame
    
    /*
    public DefaultTableModel addTableModel(ArrayList <?> list, String[] col){
      DefaultTableModel tableModel = (TableModel)super.addTableModel(list, col);
      addButton("Knap");
      return tableModel;
    }*/
    
     public void displayList(DefaultTableModel tableModel){
         super.displayList(tableModel);
         addButton("Knap", "Betalt", "I restance");
     }
}      

