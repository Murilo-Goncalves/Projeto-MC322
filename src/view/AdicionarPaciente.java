package view;

import model.Hospital;

import javax.swing.*;
import java.awt.event.*;

public class AdicionarPaciente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JCheckBox possuiDoencasCronicasCheckBox;
    private JCheckBox eFumanteCheckBox;
    private JCheckBox testouPositivoParaCOVIDCheckBox;
    private JTextField textFieldMassa;
    private JLabel hospitalEncontrado;

    private int massaCorporal;
    private boolean hasDoencasCronicas;
    private boolean isFumante;
    private boolean hasCovid;

    private Hospital hospital;

    public AdicionarPaciente(String title) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle(title);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdicionar();
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

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdicionar();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setLocationRelativeTo(null);
    }

    private void onAdicionar() {
        try {
            massaCorporal = Integer.parseInt(textFieldMassa.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "A massa corporal do paciente precisa conter apenas inteiros.");
            return;
        }

        hasDoencasCronicas = possuiDoencasCronicasCheckBox.isSelected();
        isFumante = eFumanteCheckBox.isSelected();
        hasCovid = testouPositivoParaCOVIDCheckBox.isSelected();

        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void setDefaultValues() {
        textFieldMassa.setText("");
        possuiDoencasCronicasCheckBox.setSelected(false);
        eFumanteCheckBox.setSelected(false);
        testouPositivoParaCOVIDCheckBox.setSelected(false);
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setHospitalEncontrado(String hospitalEncontrado) {
        this.hospitalEncontrado.setText(hospitalEncontrado);
    }

    public int getMassaCorporal() {
        return massaCorporal;
    }

    public boolean getHasDoencasCronicas() {
        return hasDoencasCronicas;
    }

    public boolean getIsFumante() {
        return isFumante;
    }

    public boolean getHasCovid() {
        return hasCovid;
    }
}
