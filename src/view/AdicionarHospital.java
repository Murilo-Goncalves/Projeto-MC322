package view;

import model.Convenio;
import model.Regiao;

import javax.swing.*;
import javax.swing.event.InternalFrameListener;
import java.awt.event.*;

public class AdicionarHospital extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNome;
    private JTextField textFieldNLeitos;
    private JComboBox<ComboItem> comboBoxRegiao;
    private JComboBox<ComboItem> comboBoxConvenio;
    private JComboBox<ComboItem> comboBoxCidade;
    private JCheckBox oHospitalEPrivadoCheckBox;

    private String nome;
    private int capacidadeLeitos;
    private Regiao regiao;
    private boolean isPrivado;

    public AdicionarHospital(String title) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle(title);

        comboBoxRegiao.addItem(new ComboItem("Norte", Regiao.NORTE));
        comboBoxRegiao.addItem(new ComboItem("Sul", Regiao.SUL));
        comboBoxRegiao.addItem(new ComboItem("Leste", Regiao.LESTE));
        comboBoxRegiao.addItem(new ComboItem("Oeste", Regiao.OESTE));
        comboBoxRegiao.addItem(new ComboItem("Centro", Regiao.CENTRO));

        comboBoxConvenio.addItem(new ComboItem("Nenhum", Convenio.SEM_CONVENIO));
        comboBoxConvenio.addItem(new ComboItem("Amil", Convenio.AMIL));
        comboBoxConvenio.addItem(new ComboItem("Notredame", Convenio.NOTREDAME));
        comboBoxConvenio.addItem(new ComboItem("Bradesco", Convenio.BRADESCO));
        comboBoxConvenio.addItem(new ComboItem("Unimed", Convenio.UNIMED));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdicionar();
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

    private void onAdicionar() {
        nome = textFieldNome.getText();
        // *** except ***
        capacidadeLeitos = Integer.parseInt(textFieldNLeitos.getText());
        // FAZER COMBOBOX
        isPrivado = oHospitalEPrivadoCheckBox.isSelected();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidadeLeitos() {
        return capacidadeLeitos;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public boolean getIsPrivado() {
        return isPrivado;
    }
}
