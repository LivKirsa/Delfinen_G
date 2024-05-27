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

public class SwingChairMan extends JPanel {
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
   
   private Member member;
   private SwingCoach swingCoach;
   
   static JFrame f = new JFrame(); 
       
   public SwingChairMan() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setTitle("Svømmeklubben Delfinen");
        
        //Tabs work start here 
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Chairman",openChairman());
        tabbedPane.addTab("Couch", openCoach());//openCoach());
        tabbedPane.addTab("Accountant",openAcc());
        f.add(tabbedPane, BorderLayout.NORTH);
        
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        setBackground(turkis1);
        setLayout(new BorderLayout());
        }
       

        private JPanel chairManButtons(){
         JPanel buttonPanel = new JPanel(new GridLayout(30, 1));
         buttonPanel.setBackground(turkis2);
         JButton b1 = new JButton("Tilføj nyt Medlem");
         JButton b2 = new JButton("Se Medlemmer");
         JButton b3 = new JButton("Tilføj Træner");
         
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        b1.setBackground(pink);
        b1.setForeground(softBlack);
        b2.setBackground(blue);
        b2.setForeground(softBlack);
        b3.setBackground(pink);
        b3.setForeground(softBlack);

        add(buttonPanel, BorderLayout.WEST);
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swimmerFrame();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            displayList(MemberList.memberList);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               displayList(TeamList.teamList);
            }
        });
        
        return buttonPanel; 
    }
    
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

    public void displayList(ArrayList<?> list) {        
        Object[] tempArr = list.toArray();
        String[] col = Member.col;
        DefaultTableModel tableModel = addJTable(tempArr, col);
        
        JTable table = new JTable(tableModel);
        //table.setBackground(Color.WHITE);
        table.setColumnSelectionAllowed(false);
        table.addMouseListener(new JTableButtonMouseListener(table));
        
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        table.getColumn("Knap").setCellRenderer(buttonRenderer);
        
        JScrollPane scrollpane = new JScrollPane(table); 
        scrollpane.setVisible(true);      
        add(scrollpane, BorderLayout.CENTER);
        //setBackground(Color.WHITE);
        revalidate();
    }
    

    static ArrayList <JButton> buttonList = new ArrayList <JButton>();
    
    public DefaultTableModel addJTable(Object[] list, String[] col){//ArrayList <Object> list, String [] col){

       //DefaultTableModel tableModel = new DefaultTableModel(col, 0);
       TableModel tableModel = new TableModel(col, 0);
       for (Object o : list){
         if(o instanceof Member){
            Member m = (Member) o;
            //tableModel.addColumn("Knap");
            Object [] row = m.getMemberInfoAsArray();
            /*row[row.length - 1] = new JButton("hej");
            if (row[row.length - 1] instanceof JButton){
               
            }*/
            
            //row[row.length -1 ] = addButton(row.length - 1);
            
            tableModel.addRow(m.getMemberInfoAsArray());
            tableModel.setColumnIdentifiers(Member.col);
            //tableModel.setColumnClass
            //tableModel.setRowColour(1, Color.BLACK);
            
         }else if (o instanceof Team){

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
