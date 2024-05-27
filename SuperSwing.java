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
        //f.add(this);
        // size of the window 
       f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
       buttonPanel();
      }
      
      public void buttonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        
        JButton b1 = Button1(); 
        JButton b2 = Button2(); 
        JButton b3 = Button3(); 
        
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        //buttonPanel.add(b3);
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
    //stays here just in case, but will be replaced if Signes method works

/*
displayList(addJTable(list, col));

DefaultTableModel tableModel = addJTable(list, col);
displayList(tableModel);*/

JTable table;
    public void displayList(DefaultTableModel tableModel){//ArrayList<?> list, String[]col) {        
        
        //DefaultTableModel tableModel = addJTable(tempArr, col, rowList);
        
        table = new JTable(tableModel);
        table.setColumnSelectionAllowed(false);
         
        // addButton("Knap");
        JScrollPane scrollpane = new JScrollPane(table); 
        scrollpane.setVisible(true);      
        add(scrollpane, BorderLayout.CENTER);
        
        revalidate();
    }
    
    public void addButton(String columnName, String buttonText){
        table.addMouseListener(new JTableButtonMouseListener(table));
        ((TableModel)table.getModel()).columnNumber = table.getColumn(columnName).getModelIndex();
        
        ButtonRenderer buttonRenderer = new ButtonRenderer(buttonText, blue);
        table.getColumn(columnName).setCellRenderer(buttonRenderer);
    }
    
    public void addButton(String columnName, String buttonText, String buttonText2){
        table.addMouseListener(new JTableButtonMouseListener(table));
        ((TableModel)table.getModel()).columnNumber = table.getColumn(columnName).getModelIndex();
        
        ButtonRenderer buttonRenderer = new ButtonRenderer(buttonText, buttonText2, turkis1, turkis2);
        table.getColumn(columnName).setCellRenderer(buttonRenderer);
    }
    
    //making a tablemodel
    public DefaultTableModel addTableModel(ArrayList <?> list, String[] col){

      DefaultTableModel tableModel = new TableModel(col, 0, f);
      Object [] row = {};
      tableModel.setColumnIdentifiers(col);
       
      for (Object o : list){
         if(o instanceof Member){
            row = ((Member)o).getMemberInfoAsArray();
         }else if (o instanceof Team){
            row = ((Team)o).getTeamInfoAsArray();
         }else if (o instanceof Result){
            row = ((Result)o).getResultInfoAsArray();
         }
         
         tableModel.addRow(row);
      }//end of for each loop
      
      return tableModel;
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
    } // This ends swimmerFrame
}       
