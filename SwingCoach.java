import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SwingCoach extends JPanel {
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
      
   /*public SwingCoach(boolean bwa){
   setLayout(new BorderLayout());
      buttonPanel();
      f.setVisible(false);
   }*/
      
      public void buttonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        JButton b1 = new JButton("Se Holdlister");
        JButton b2 = new JButton("Indtast svømmeresultater"); 
        JButton b3 = new JButton("Holdoversigt");
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
            
         }
       });
      //actions of the se medlem button 
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         //SwimmerFrame();
         }
       });
       //actions of the add trainer to a team. 
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         displayListWithButtons(TeamList.teamList); 
         }
       });
       
       // size of the window 
       f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
}
public  void displayListWithButtons(ArrayList<?> list) {
        //setTitle("List with buttons");

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


}