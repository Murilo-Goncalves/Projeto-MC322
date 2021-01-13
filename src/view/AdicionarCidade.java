package view;

import model.Cidade;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdicionarCidade extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNome;
    private String nome;

    public AdicionarCidade(String title, ArrayList<Cidade> cidades) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle(title);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdicionar(cidades);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setLocationRelativeTo(null);
    }

    private void onAdicionar(ArrayList<Cidade> cidades) {
        nome = textFieldNome.getText();
        textFieldNome.setText("");
        cidades.add(new Cidade(nome));
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public String getNome() {
        return nome;
    }
}
