import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class SwingChairMan extends JFrame{

private JTextArea textArea; // JTextArea declared as a class field

   
   public SwingChairMan() {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       setExtendedState(getExtendedState() | MAXIMIZED_BOTH);  
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       setVisible(true);
       
         
       JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        JButton b1 = new JButton("Tilføj medlem");
        JButton b2 = new JButton("Se Medlemmer"); 
        JButton b3 = new JButton("tilføj trainer");
        b1.setBackground(Color.BLUE);
        buttonPanel.add(b1);
        b2.setBackground(Color.RED);
        buttonPanel.add(b2);
        b3.setBackground(Color.GREEN);
        buttonPanel.add(b3);
      
      //add Buttonpanel til WEST
       add(buttonPanel, BorderLayout.WEST);
      //actions of the add Swimmer button 
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            SwimmerFrame();
         }
       });
      //actions of the se medlem button 
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         Displaymember(MemberList.memberList);
         //AddButtonToDisplayMember(MemberList.memberList);
         }
       });
       //actions of the add trainer to a team. 
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         DisplayMemberWithButtons(MemberList.memberList);
         }
       });
       
       // size of the window 
       setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
      }
       
       
       public void SwimmerFrame(){
       JFrame swimmerFrame = new JFrame();
       swimmerFrame.setVisible(true); 
       swimmerFrame.setSize(300, 200);
       swimmerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       Login.centerFrameOnScreen(swimmerFrame);
      
       JPanel panel = new JPanel();
      
       JTextField text1Field = new JTextField(20); 
       JTextField text2Field = new JTextField(20); 
       JTextField text3Field = new JTextField(20); 
       
       JCheckBox checkBox1 = new JCheckBox("Option 1");
       JCheckBox checkBox2 = new JCheckBox("Option 2");
       JCheckBox checkBox3 = new JCheckBox("Option 3");
        

        // Add the text field to the panel and boxes. 
        panel.add(text1Field);
        panel.add(text2Field);
        panel.add(text3Field);
        
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        
        swimmerFrame.add(panel);
        
        // this is the action for box 1. 
       checkBox1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (checkBox1.isSelected()) {
            System.out.println("Box 1 was checked"); 
        } else {
            System.out.println("Box 1 was unchecked");
        }
    }
});
  // this is the action for box 2. 
       checkBox2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (checkBox2.isSelected()) {
            System.out.println("Box 1 was checked"); 
        } else {
            System.out.println("Box 1 was unchecked");
        }
    }
});
// this is the action for box 3. 
       checkBox3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (checkBox3.isSelected()) {
            System.out.println("Box 1 was checked"); 
        } else {
            System.out.println("Box 1 was unchecked");
        }
    }
});
        
       }
       
       //brug den her i en ny metode hvor du tilføjer. 
    public void Displaymember2(ArrayList<?> list) {
    
        setTitle("Members List");     
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        textArea = new JTextArea(20,70);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        StringBuilder sb = new StringBuilder();
        
        for (Object item : list) {
            sb.append(item).append("\n");
        }
        
        textArea.setText(sb.toString());
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void AddButtonToDisplayMember(ArrayList<?> list){
      JPanel buttonPanel = new JPanel(); 
      //should add a column with to hold the buttons. 
      buttonPanel.setLayout(new GridLayout(0, 1));
      
      for (Object item : list){
      JButton listButton = new JButton ("tilføj tid"); 
      listButton.addActionListener((ActionEvent e) -> {
      System.out.println("hej"); 
      }); 
      buttonPanel.add(listButton);
    }
    add(buttonPanel, BorderLayout.EAST);   
}
public void DisplayMemberWithButtons(ArrayList<?> list) {
    setTitle("Members List");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new GridLayout(list.size(), 1));  

 
    for (Object member : list) {

        JPanel rowPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("     " + member.toString());
        rowPanel.add(label, BorderLayout.CENTER);

        JButton button = new JButton("Add Time");
        button.setPreferredSize(new Dimension(100, button.getPreferredSize().height));  
        button.addActionListener(e -> System.out.println("Button clicked for " + member));
        rowPanel.add(button, BorderLayout.EAST);

        listPanel.add(rowPanel);
    }

    JScrollPane scrollPane = new JScrollPane(listPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    //getContentPane().setLayout(new BorderLayout());
  add(scrollPane, BorderLayout.CENTER);

    setLocationRelativeTo(null);
    setVisible(true);
}
}