import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.lang.*;

public class SwingCoach extends JPanel {
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
   
   JFrame f = new JFrame(); 
   
    public SwingCoach(boolean visible) {
      setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setTitle("Couch");
        f.setVisible(visible);
        f.add(this);
        buttonPanel();
      }
      
      public void buttonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        JButton b1 = new JButton("Se Holdmedlemmer");
        JButton b2 = new JButton("Nyt Resultat"); 
        JButton b3 = new JButton("Se alle Hold");
        
        b1.setBackground(pink);
        b1.setForeground(softBlack);
        b2.setBackground(blue);
        b2.setForeground(softBlack);
        b3.setBackground(pink);
        b3.setForeground(softBlack);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        
 //add Buttonpanel til WEST
       add(buttonPanel, BorderLayout.WEST);
      //actions of the add Swimmer button 
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
       });
      //actions of the se medlem button 
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         resultFrame();
         }
       });
       //actions of the add trainer to a team. 
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         displayList(TeamList.teamList); 
         }
       });
       
       // size of the window 
       f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
      }
      
   public void displayListWithButtons(ArrayList<?> list) {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(list.size(), 1));
        for (Object item : list) {//instantiating new rowPanel.
            JPanel rowPanel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("     " + item.toString() + "\n");
            rowPanel.add(label, BorderLayout.WEST);

            JButton button = new JButton("Add Time");
            button.setPreferredSize(new Dimension(100, button.getPreferredSize().height));
            button.addActionListener(e -> System.out.println("Button clicked for " + item));
            rowPanel.add(button, BorderLayout.EAST);
            listPanel.add(rowPanel);
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        //setLayout(new BorderLayout());
        //this.removeAll(); 
        //this.add(scrollPane, BorderLayout.CENTER);
        this.revalidate(); 
        this.repaint();

     //   setLocationRelativeTo(null);
        //setVisible(true);
    }
    public void displayList(ArrayList<?> list) {        
        Object[] tempArr = list.toArray();
        //ArrayList <Object> objList = new ArrayList<Object> (Arrays.asList((Object[])tempArr));
        String[] col = Team.col;
         DefaultTableModel tableModel = addJTable(tempArr, col);
            /*
            if (arr instanceof Member[]){
               //ArrayList <Member> memberList = new ArrayList<Member> (Arrays.asList((Member[])arr)); 
               String[] col = Member.col;
               tableModel = addJTable(list, col);
            }*/
            

               //String [] col = {"Restance", "Navn", "ID", "Alder", "Dato for betaling"};//acc
               //String [] col = {};//couch
               //formand(kan se alt)
               //kasserer(kan se betalingsinfo)
               //træner(kan se holdoversig og holdmedlemmer)

            //formand(kan tilføje træner)
            //træner(kan se hold og oprette resultater)
            
            //medlemsresultater
            //team resultater
            //team discipliner.

        
        /*JPanel listPanel = new JPanel();
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
        setVisible(true);*/
        
        JTable table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        //table.setColumnSelectionAllowed(true);
        
        JScrollPane scrollpane = new JScrollPane(table); 
        scrollpane.setVisible(true);      
        add(scrollpane, BorderLayout.CENTER);
        //setBackground(Color.WHITE);
        
        revalidate();
    }
    
    public DefaultTableModel addJTable(Object[] list, String[] col) {//ArrayList <Object> list, String [] col){

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
    
     public void resultFrame() {
        JFrame resultFrame = new JFrame();
        resultFrame.setVisible(true);
        resultFrame.setSize(300, 300);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Login.centerFrameOnScreen(resultFrame);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(blue);

        JTextField text0Field = new JTextField(5);
        JTextField text1Field = new JTextField(5);
        JTextField text2Field = new JTextField(20);
        JTextField text3Field = new JTextField(5);
        JTextField text4Field = new JTextField(5);
        JTextField text5Field = new JTextField(5);
        JLabel label0 = new JLabel("Medlem: ");
        JLabel label1 = new JLabel("Meter: ");
        JLabel label2 = new JLabel("Discipline: ");
        JLabel labelS = new JLabel("Minutes: ");
        JLabel labelM = new JLabel("Seconds: ");
        JLabel labelMS = new JLabel("Milliseconds: ");
        
         
        //this just places it around found online. 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(label0, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(text0Field, gbc);
        
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
        panel.add(labelS, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(text3Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelM, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(text4Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelMS, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(text5Field, gbc);
        
         // Adding the Done button
        JButton doneButton = new JButton("Done");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(doneButton, gbc);

        resultFrame.add(panel);

            doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            int memberNumber = Integer.parseInt(text0Field.getText());
            int length = Integer.parseInt(text1Field.getText()); 
            String swimmingStyle = text2Field.getText(); 
            int m = Integer.parseInt(text3Field.getText());
            int s = Integer.parseInt(text4Field.getText());
            int ms = Integer.parseInt(text5Field.getText());
            
            Member member = MemberList.memberList.get(memberNumber-1);
            Team team = TeamList.teamList.get(member.getTeamNumber()-1);

            team.addResult(memberNumber, length, swimmingStyle, m, s, ms);
            resultFrame.dispose(); 
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


}