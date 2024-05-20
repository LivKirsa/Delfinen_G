import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SwingChairMan extends JPanel {


    public SwingChairMan() {
    JFrame f = new JFrame(); 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setVisible(true);
        
        //Tabs work start here 
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("formand",openChairman());
        tabbedPane.addTab("Couch",openCoach());
        tabbedPane.addTab("Accounten",openAcc());
        f.add(tabbedPane, BorderLayout.NORTH);
        
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        //signe
        setBackground(new Color(255,200,200));
        }
       

        private JPanel chairManButtons(){
         JPanel buttonPanel = new JPanel(new GridLayout(30, 1));
         JButton b1 = new JButton("Tilføj medlem");
         JButton b2 = new JButton("Se Medlemmer");
         JButton b3 = new JButton("tilføj trainer");
         
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.RED);
        b3.setBackground(Color.GREEN);
        

        add(buttonPanel, BorderLayout.WEST);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swimmerFrame();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayList(MemberList.memberList);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayListWithButtons(MemberList.memberList);
            }
        });
        
        return buttonPanel; 

        //f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
    }     
    
    //tabs here 
        private JPanel openChairman() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        panel.add(chairManButtons(),BorderLayout.WEST);
         panel.add(this, BorderLayout.CENTER);
        return panel;
        } 
        private JPanel openCoach() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        SwingCoach swingCoach = new SwingCoach(); 
        panel.add(swingCoach.getContentPane(), BorderLayout.CENTER); 
        return panel;
        }
        
        private JPanel openAcc() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 200, 200));
        SwingAcc SwingAcc = new SwingAcc(); 
        panel.add(SwingAcc.getContentPane(), BorderLayout.CENTER); 
        return panel;
    }
    
    public void swimmerFrame() {
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

        panel.add(text1Field);
        panel.add(text2Field);
        panel.add(text3Field);

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);

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
                    System.out.println("Box 1 was checked");
                } else {
                    System.out.println("Box 1 was unchecked");
                }
            }
        });

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

    public void displayList(ArrayList<?> list) {
        //f.setTitle("Members List");
         
        JPanel listPanel = new JPanel();
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
        setVisible(true);
    }

    public void displayListWithButtons(ArrayList<?> list) {
        //setTitle("List with buttons");

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(list.size(), 1));

        for (Object item : list) {
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
        setLayout(new BorderLayout());
        this.removeAll(); 
        this.add(scrollPane, BorderLayout.CENTER);
        this.revalidate(); 
        this.repaint();

     //   setLocationRelativeTo(null);
        setVisible(true);
    }
     
}
