import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SwingCoach extends SuperSwing {
   
    public SwingCoach(boolean visible) {
    super(visible);
    f.setTitle("Sub Coach uwu");
    f.add(this);
    }
    
    @Override
        protected JButton Button1() {
        JButton b1 = new JButton("Se Hold");
        b1.setBackground(pink);
        b1.setForeground(softBlack);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {
               displayList(addTableModel(TeamList.teamList, Team.col));
            }
        });
        return b1;
    }
    
    
        protected JButton Button2() {
        JButton b2 = new JButton("Registrer nyt Resultat");
        b2.setBackground(pink);
        b2.setForeground(softBlack);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               resultFrame();
            }
        });
        return b2;
    }
    
        protected JButton Button3() {
        JButton b3 = new JButton("Nyt Hold?");
        b3.setBackground(pink);
        b3.setForeground(softBlack);
        b3.addActionListener(new ActionListener() {
        //action for button 3
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        return b3;
    }
    
      
      //stays here just in case, but will be removed if Signes method works
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
    public void displayList(DefaultTableModel tableModel){
       super.displayList(tableModel);
       addButton("", "Se hold");
    
    }
    
    public void resultFrame() {
        JFrame resultFrame = new JFrame("Indtast nyt Resultat");
        resultFrame.setVisible(true);
        resultFrame.setSize(350, 400);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Login.centerFrameOnScreen(resultFrame);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(blue);

        Member[] memberArray = MemberList.memberList.toArray(new Member[MemberList.memberList.size()]);
        JComboBox<Member> memberComboBox = new JComboBox<Member>(memberArray);
        
        JCheckBox enableTextFieldCheckBox = new JCheckBox("Resultatet er fra et Stævne");
        enableTextFieldCheckBox.setBackground(blue);
        enableTextFieldCheckBox.setForeground(softBlack);
        JTextField textFieldComp = new JTextField(10);
        JLabel labelLoca = new JLabel("Lokation for stævnet: ");
        labelLoca.setVisible(false);
        JTextField textFieldRank = new JTextField(5);
        JLabel labelRank = new JLabel("Placering: ");
        labelRank.setVisible(false);
        textFieldComp.setEnabled(false); // Initially disable the text field
        textFieldComp.setVisible(false); // Initially hide the text field
        textFieldRank.setEnabled(false);
        textFieldRank.setVisible(false);
        
        JTextField text1Field = new JTextField(5);
        JTextField text2Field = new JTextField(30);
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
        panel.add(memberComboBox, gbc);
        
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
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(enableTextFieldCheckBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelLoca, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(textFieldComp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(labelRank, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(textFieldRank, gbc);

        enableTextFieldCheckBox.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
               textFieldComp.setEnabled(enableTextFieldCheckBox.isSelected());
               textFieldComp.setVisible(enableTextFieldCheckBox.isSelected());
               textFieldRank.setEnabled(enableTextFieldCheckBox.isSelected());
               textFieldRank.setVisible(enableTextFieldCheckBox.isSelected());
               labelRank.setVisible(enableTextFieldCheckBox.isSelected());
               labelLoca.setVisible(enableTextFieldCheckBox.isSelected());
            }
         });
         
        final boolean isCompetitiveBoxChecked = enableTextFieldCheckBox.isSelected();
        
        // Adding the Done button
        JButton doneButton = new JButton("Tilføj");
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(doneButton, gbc);
        resultFrame.add(panel);

            doneButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
               Member selectedMember = (Member) memberComboBox.getSelectedItem();
               int teamNumber = selectedMember.getTeamNumber();
               int memberNumber = MemberList.memberList.indexOf(memberComboBox.getSelectedItem());
               int length = Integer.parseInt(text1Field.getText()); 
               String swimmingStyle = text2Field.getText(); 
               int m = Integer.parseInt(text3Field.getText());
               int s = Integer.parseInt(text4Field.getText());
               int ms = Integer.parseInt(text5Field.getText());
               String location = textFieldComp.getText();
               int placement = Integer.parseInt(textFieldRank.getText());
               
               // Extraction of Member Team index IDs and stuff from different lists so the methods work together seamlessly, idk, it works
               Team team = TeamList.teamList.get(selectedMember.getTeamNumber()-1);
               if (isCompetitiveBoxChecked) {
                  ((CompTeam)team).addResult(team.teamMemberList.indexOf(selectedMember), length, swimmingStyle, m, s, ms, location, placement);
               } else {
                  team.addResult(team.teamMemberList.indexOf(selectedMember), length, swimmingStyle, m, s, ms);
               }
               resultFrame.dispose();
               
               }
            }); // Done button action listener ends here

            text1Field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
            text2Field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    } // This ends resultFrame
    
    
}