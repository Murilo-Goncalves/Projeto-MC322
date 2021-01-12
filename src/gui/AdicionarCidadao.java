package gui;

import javax.swing.*;
import java.awt.event.*;

public class AdicionarCidadao extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JCheckBox cansaçoCheckBox;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JCheckBox febreCheckBox;
    private JCheckBox tosseSecaCheckBox;
    private JCheckBox dorDeCabeçaCheckBox;
    private JCheckBox dorNoCorpoCheckBox;
    private JCheckBox dorDeGargantaCheckBox;
    private JCheckBox congestãoNasalCheckBox;
    private JCheckBox perdaDePaladarCheckBox;
    private JCheckBox diarreiaCheckBox;
    private JCheckBox conjuntiviteCheckBox;
    private JCheckBox erupçõesCutâneasCheckBox;
    private JCheckBox faltaDeArCheckBox;
    private JCheckBox dorNoPeitoCheckBox;

    public AdicionarCidadao(String title) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle(title);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setLocationRelativeTo(null);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
