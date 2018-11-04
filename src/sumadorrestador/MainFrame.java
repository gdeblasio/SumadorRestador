package sumadorrestador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
    private int count = 0;
    private final JTextField textField = new JTextField(String.valueOf(0),2);

    public MainFrame() {
        this.setTitle("Sumador/Restador");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 300, 100);
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sumarButton());
        panel.add(restarButton());
        return panel;
    }

    private JButton sumarButton() {
        JButton button = new JButton("sumar", new ImageIcon("sumar.png"));
        button.addActionListener(incrementa());
        return button;
    }

    private ActionListener incrementa() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 10) {
                    count = 0;
                } else {
                    count = count + 1;
                }
                textField.setText(String.valueOf(count));
            }
        };
    }

    private JButton restarButton() {
        JButton button = new JButton("restar", new ImageIcon("restar.png"));
        button.addActionListener(decrementa());
        return button;
    }

    private ActionListener decrementa() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    count = 10;
                } else {
                    count = count - 1;
                }
                textField.setText(String.valueOf(count));
            }
        };
    }

}
