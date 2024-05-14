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
       
         
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JButton b1 = new JButton("Tilføj medlem");
        JButton b2 = new JButton("Se Medlemmer"); 
        JButton b3 = new JButton("Se Medlemmer");
        b1.setBackground(Color.BLUE);
        buttonPanel.add(b1);
        b2.setBackground(Color.RED);
        buttonPanel.add(b2);
        b3.setBackground(Color.RED);
        buttonPanel.add(b3);
      
      //add Buttonpanel til WEST
       add(buttonPanel, BorderLayout.WEST);
      //actions of the Swimmer button 
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //SwimmerFrame();
         }
       });
      //actions of the se medlem button 
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         Displaymember(MemberList.memberList);
         }
       });
       //actions of the se medlem button 
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         Displaymember(MemberList.memberList);
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
    public void Displaymember(ArrayList<?> list) {
    
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
}
