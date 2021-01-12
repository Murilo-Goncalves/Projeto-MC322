package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddForm extends JDialog {
    public AddForm(String item) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setTitle(item);

        JLabel nomeLbl = new JLabel("Nome");
        JTextField nomeField = new JTextField(20);
        JLabel cpfLbl = new JLabel("CPF");
        JTextField cpfField = new JTextField(20);
        JLabel loginLbl = new JLabel("Login");
        JTextField loginField = new JTextField(20);
        JLabel senhaLbl = new JLabel("Senha");
        JTextField senhaField = new JTextField(20);
        JButton okButton = new JButton ("Ok");

        okButton.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                setVisible(false);
            }
        });

        JPanel panel = new JPanel();
        panel.add(nomeLbl);
        panel.add(nomeField);
        panel.add(cpfLbl);
        panel.add(cpfField);
        panel.add(loginLbl);
        panel.add(loginField);
        panel.add(senhaLbl);
        panel.add(senhaField);
        panel.add(okButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
}
