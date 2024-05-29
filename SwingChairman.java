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
            
 public void swimmerFrame() {
        JFrame swimmerFrame = new JFrame();
        swimmerFrame.setVisible(true);
        swimmerFrame.setSize(300, 300);
        swimmerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Login.centerFrameOnScreen(swimmerFrame);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        // JPanel panel = new JPanel();
        panel.setBackground(blue);

        JTextField text1Field = new JTextField(20);
        JTextField text2Field = new JTextField(20);
        JLabel label1 = new JLabel("Name:");
        JLabel label2 = new JLabel("Birthday:");

        JCheckBox checkBox1 = new JCheckBox("isActiveMembership");
        JCheckBox checkBox2 = new JCheckBox("isCompetitiveSwimmer");
        JCheckBox checkBox3 = new JCheckBox("isMan");
         
        //this just places it around found online. 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(text1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(text2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(checkBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(checkBox2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(checkBox3, gbc);
        
         // Adding the Done button
        JButton doneButton = new JButton("Done");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(doneButton, gbc);

        swimmerFrame.add(panel);

        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    System.out.println("Box 1 was checked");
                } else {
                    System.out.println("Box 1 was unchecked");
                }
            }
        });

        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox2.isSelected()) {
                    System.out.println("Box 2 was checked");
                } else {
                    System.out.println("Box 2 was unchecked");
                }
            }
        });

        checkBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox3.isSelected()) {
                    System.out.println("Box 3 was checked");
                } else {
                    System.out.println("Box 3 was unchecked");
                }
            }
        });
            doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String name = text1Field.getText(); 
            String birthdayString = text2Field.getText(); 
            boolean isActiveMembership = checkBox1.isSelected();
            boolean isCompetitiveSwimmer = checkBox2.isSelected();
            boolean isMan = checkBox3.isSelected();
            fileHandling.writeFile();
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

