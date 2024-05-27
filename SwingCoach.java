import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SwingCoach extends SuperSwing {
   
    public SwingCoach(boolean visible) {
    super(visible);
    f.setTitle("Sub Coach uwu");
    }
        protected JButton Button1() {
        JButton b1 = new JButton("Se Holdlister");
        b1.setBackground(Color.PINK);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b1;
    }
        protected JButton Button2() {
        JButton b2 = new JButton("Se hurtigste svømmere");
        b2.setBackground(Color.GREEN);
        b2.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b2;
    }
        protected JButton Button3() {
        JButton b3 = new JButton("opret resultater");
        b3.setBackground(Color.ORANGE);
        b3.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b3;
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
    
}