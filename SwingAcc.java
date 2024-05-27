import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SwingAcc extends SuperSwing {
   
    public SwingAcc(boolean visible) {
    super(visible);
    f.setTitle("Sub ACC");
    f.add(this);
    }
    
        public void buttonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(30, 1));
        
        //adding Button1 to the panel
        JButton b1 = Button1(); 
        
        buttonPanel.add(b1);
        
        add(buttonPanel, BorderLayout.WEST);
      }
       protected JButton Button1() {
        JButton b1 = new JButton("Se Restance");
        b1.setBackground(Color.PINK);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {
               displayList(addTableModel(MemberList.memberList, Member.accCol));
            }
        });
        return b1;
    }
}