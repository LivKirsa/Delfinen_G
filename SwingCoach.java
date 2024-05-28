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
    
        protected JButton Button1() {
        JButton b1 = new JButton("Se Holdmedlemmer");
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
        JButton b2 = new JButton("Nyt Resultat"); 
        b2.setBackground(blue);
        b2.setForeground(softBlack);
        b2.addActionListener(new ActionListener() {
        //action for button 2
            public void actionPerformed(ActionEvent e) {
            resultFrame()  ;
            }
        });
        return b2;
    }
    /*
        protected JButton Button3() {
        JButton b3 = new JButton("Se alle Hold");
        b3.setBackground(pink);
        b3.setForeground(softBlack);
        b3.addActionListener(new ActionListener() {
        //action for button 3
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b3;
    }*/
    
      
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
}