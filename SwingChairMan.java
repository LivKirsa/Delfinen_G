import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.awt.Color;

public class SwingChairMan extends JPanel {

private Member member;
private SwingCoach swingCoach;
Color turkis1 = new Color(199, 237, 231);
Color turkis2 = new Color(177, 224, 218);
Color turkis3 = new Color(140, 204, 200);
Color turkis4 = new Color(103, 159, 157);
Color purple = new Color(159, 141, 185);
Color pink = new Color(232, 173, 210);
Color blue = new Color(171, 218, 233);
Color softWhite = new Color(241, 234, 231);


    public SwingChairMan() {
    JFrame f = new JFrame(); 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        //Tabs work start here 
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("formand",openChairman());
        tabbedPane.addTab("Couch", openCoach());//openCoach());
        tabbedPane.addTab("Accounten",openAcc());
        f.add(tabbedPane, BorderLayout.NORTH);
        
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        //signe
        setBackground(turkis1);
        }
       

        private JPanel chairManButtons(){
         // Create SwingCaouch to use methods from there dum dum
        swingCoach = new SwingCoach();
        
         JPanel buttonPanel = new JPanel(new GridLayout(30, 1));
         JButton b1 = new JButton("Tilføj medlem");
         JButton b2 = new JButton("Se Medlemmer");
         JButton b3 = new JButton("tilføj trainer");
         
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.RED);
        b3.setBackground(Color.GREEN);
        

        add(buttonPanel, BorderLayout.WEST);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swimmerFrame();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            swingCoach.displayListWithButtons(MemberList.memberList, SwingChairMan.this);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            displayList(MemberList.memberList); 
            }
        });
        
        return buttonPanel; 
    }     
    
    //tabs here 
        private JPanel openChairman() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        panel.add(chairManButtons(),BorderLayout.WEST);
         panel.add(this, BorderLayout.CENTER);
        return panel;
        } 
        private JPanel openCoach() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        SwingCoach swingCoach = new SwingCoach(); 
        panel.add(swingCoach.getContentPane(), BorderLayout.CENTER); 
        return panel;
        }
        
        private JPanel openAcc() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        SwingAcc SwingAcc = new SwingAcc(); 
        panel.add(SwingAcc.getContentPane(), BorderLayout.CENTER); 
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

        JLabel label1 = new JLabel("Name:");
        JLabel label2 = new JLabel("Birthday:");

        JTextField text1Field = new JTextField(20);
        JTextField text2Field = new JTextField(20);

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
    }
    public void displayList(ArrayList<?> list) {
         
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(list.size(), 1));
         listPanel.setBackground(Color.BLACK);
         
        for (Object item : list) {
            JPanel rowPanel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("     " + item.toString());
            rowPanel.add(label, BorderLayout.CENTER);
            listPanel.add(rowPanel);
        }
        
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        this.removeAll(); 
        this.add(scrollPane, BorderLayout.CENTER);
        this.revalidate(); 
        this.repaint();
        //setLocationRelativeTo(null);
        setVisible(true);
    } 
        
}