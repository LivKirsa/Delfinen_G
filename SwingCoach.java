import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SwingCoach extends JFrame {
   static SwingChairMan scm = new SwingChairMan();
   JPanel panel = new JPanel();
  CardLayout cardManager = new CardLayout();
   
    public SwingCoach() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //setVisible(true);
        //addMenuPanel(this);
        add(addMainPanel());
   }
   
   public JPanel addMainPanel(){
       //panel = new JPanel();
       
      panel.setLayout(new BorderLayout());
      panel.add(addMenuPanel(), BorderLayout.WEST);
      panel.add(cardManager, BorderLayout.CENTER);
      return panel;
   }
   
   public JPanel addMenuPanel(){
   //public void addMenuPanel(Container component){//container = JFrame/JPanel/whatever.
        JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        JButton b1 = new JButton("Se Holdlister");
        JButton b2 = new JButton("Indtast svømmeresultater"); 
        JButton b3 = new JButton("se hurtigste svømmere");
        b1.setBackground(Color.BLUE);
        buttonPanel.add(b1);
        b2.setBackground(Color.RED); 
        buttonPanel.add(b2);
        b3.setBackground(Color.GREEN);
        buttonPanel.add(b3);
        
        cardManager.addLayoutComponent(displayMemberWithButtons(TeamList.teamList), "holdoversigt");
        cardManager.addLayoutComponent(b2, "nyt resultat");
         cardManager.addLayoutComponent(b1, "top 5");

 //add Buttonpanel til WEST
       //component.add(buttonPanel, BorderLayout.WEST);
       
      //actions of the add Swimmer button 
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            panel.add(displayMemberWithButtons(TeamList.teamList), BorderLayout.CENTER);
            
         }
       });
      //actions of the se medlem button 
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         //scm.SwimmerFrame();
         }
       });
       //actions of the add trainer to a team. 
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        
         }
       });
       
       // size of the window 
       setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
       return buttonPanel;
}
//display metode med knapper. 
public JScrollPane displayMemberWithButtons(ArrayList<?> list) {
    //setTitle("List with buttons");
    //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new GridLayout(list.size(), 1));  
    if (list.size() < 20){
      listPanel.setLayout(new GridLayout(20,1));
    }

 
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
      //scrollPane.setVisible(true);
      //panel.add(scrollPane);//, BorderLayout.CENTER);
          //setVisible(true);

   return scrollPane;
    //setLocationRelativeTo(null);
}

}