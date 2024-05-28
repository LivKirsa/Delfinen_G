import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.LocalDate;
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
   protected JPanel listPanel;
   FileHandling fileHandling = new FileHandling();
      
   public SuperSwing(boolean visible) {
   f = new JFrame(); 
      setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setTitle("SuperSwing");
        f.setVisible(visible);

        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        
        listPanel = new JPanel();
        add(listPanel);
        listPanel.setLayout(new BorderLayout());
        addCloseAction(f);
        buttonPanel();
      }
    
    public void addCloseAction(JFrame frame){
           frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(
                    frame,
                    "Er du sikker på du vil afslutte?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirmed == JOptionPane.YES_OPTION) {
                    fileHandling.writeFile();
                    frame.dispose();
                }
            }
        });
    }
      
    

    public void buttonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(30, 1));

        JButton b1 = Button1();
        JButton b2 = Button2();
        JButton b3 = Button3();

        buttonPanel.add(b1);
        buttonPanel.add(b2);

        add(buttonPanel, BorderLayout.WEST);
    }

    protected JButton Button1() {
        JButton b1 = new JButton("knap1");
        b1.setBackground(Color.BLUE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        return b1;
        
        
    }

    protected JButton Button2() {
        JButton b2 = new JButton("Knap2");
        b2.setBackground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        return b2;
    }

    protected JButton Button3() {
        JButton b3 = new JButton("knap3");
        b3.setBackground(Color.RED);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        return b3;
    }

    JTable table;

    public void displayList(DefaultTableModel tableModel) {
        table = new JTable(tableModel);
        table.setColumnSelectionAllowed(false);

         
         table.setFillsViewportHeight(true);
        JScrollPane scrollpane = new JScrollPane(table); 
        scrollpane.setVisible(true);      
        listPanel.add(scrollpane);
        
        revalidate();
    }

    public void addButton(String columnName, String buttonText) {
        table.addMouseListener(new JTableButtonMouseListener(table));
        ((TableModel)table.getModel()).columnNumber = table.getColumn(columnName).getModelIndex();

        ButtonRenderer buttonRenderer = new ButtonRenderer(buttonText, blue);
        table.getColumn(columnName).setCellRenderer(buttonRenderer);
    }

    public void addButton(String columnName, String buttonText, String buttonText2) {
        table.addMouseListener(new JTableButtonMouseListener(table));
        ((TableModel)table.getModel()).columnNumber = table.getColumn(columnName).getModelIndex();

        ButtonRenderer buttonRenderer = new ButtonRenderer(buttonText, buttonText2, turkis1, turkis2);
        table.getColumn(columnName).setCellRenderer(buttonRenderer);
    }

    public DefaultTableModel addTableModel(ArrayList<?> list, String[] col) {
        DefaultTableModel tableModel = new TableModel(col, 0, f);
        Object[] row = {};
        tableModel.setColumnIdentifiers(col);

        for (Object o : list) {
            if (o instanceof Member) {
                row = ((Member)o).getMemberInfoAsArray();
            } else if (o instanceof Team) {
                row = ((Team)o).getTeamInfoAsArray();
            } else if (o instanceof Result) {
                row = ((Result)o).getResultInfoAsArray();
            }
            tableModel.addRow(row);
        }
        return tableModel;
    }

    public void swimmerFrame() {
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
    }

    public void resultFrame() {
        JFrame resultFrame = new JFrame("Tilføj nyt Resultat");
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
        textFieldComp.setEnabled(false);
        textFieldComp.setVisible(false);
        textFieldRank.setEnabled(false);
        textFieldRank.setVisible(false);

        JTextField text1Field = new JTextField(5);
        JTextField text2Field = new JTextField(30);
        JTextField text3Field = new JTextField(5);
        JTextField text4Field = new JTextField(5);
        JTextField text5Field = new JTextField(5);
        JLabel label0 = new JLabel("Medlem: ");
        JLabel label1 = new JLabel("Meter: ");
        JLabel label2 = new JLabel("Disciplin: ");
        JLabel labelS = new JLabel("Minutter: ");
        JLabel labelM = new JLabel("Sekunder: ");
        JLabel labelMS = new JLabel("Millisekunder: ");

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
        gbc.anchor = GridBagConstraints.CENTER;
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

                Team team = TeamList.teamList.get(selectedMember.getTeamNumber() - 1);
                if (isCompetitiveBoxChecked) {
                    ((CompTeam)team).addResult(team.teamMemberList.indexOf(selectedMember), length, swimmingStyle, m, s, ms, location, placement);
                } else {
                    team.addResult(team.teamMemberList.indexOf(selectedMember), length, swimmingStyle, m, s, ms);
                }
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
    }// this ends result frame
}
