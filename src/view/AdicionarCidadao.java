package view;

import model.Convenio;
import model.Regiao;
import model.Sexo;
import model.Sintomas;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdicionarCidadao extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNome;
    private JTextField textFieldCpf;
    private JTextField textFieldLogin;
    private JTextField textFieldSenha;
    private JTextField textFieldIdade;
    private JTextField textFieldTelefone;
    private JTextField textFieldEmail;

    private JComboBox comboBoxSexo;
    private JComboBox comboBoxRegiao;
    private JComboBox comboBoxConvenio;

    private JCheckBox cansaçoCheckBox;
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
    private JCheckBox desejaProcurarUmHospitalCheckBox;

    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private int idade;
    private String telefone;
    private String email;
    private Sexo sexo;
    private Regiao regiao;
    private Convenio convenio;
    private ArrayList<Sintomas> sintomas;
    private boolean procuraHospital;

    private AdicionarPaciente formPaciente = new AdicionarPaciente("Ficha médica");

    public AdicionarCidadao(String title) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle(title);

        comboBoxSexo.addItem(new ComboItem("Não binário", Sexo.NAO_BINARIO));
        comboBoxSexo.addItem(new ComboItem("Feminino", Sexo.FEMININO));
        comboBoxSexo.addItem(new ComboItem("Masculino", Sexo.MASCULINO));
        comboBoxSexo.addItem(new ComboItem("Prefiro não declarar", Sexo.PREFIRO_NAO_DECLARAR));

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
        cpf = textFieldCpf.getText();
        login = textFieldLogin.getText();
        senha = textFieldSenha.getText();
        // *** except ***
        idade = Integer.parseInt(textFieldIdade.getText());
        telefone = textFieldTelefone.getText();
        email = textFieldEmail.getText();
        ComboItem item;
        item = (ComboItem) comboBoxSexo.getSelectedItem();
        sexo = (Sexo) item.getValue();
        item = (ComboItem) comboBoxRegiao.getSelectedItem();
        regiao = (Regiao) item.getValue()
        item = (ComboItem) comboBoxConvenio.getSelectedItem();
        convenio = (Convenio) item.getValue();
        procuraHospital = desejaProcurarUmHospitalCheckBox.isSelected();
        if (procuraHospital) {
            formPaciente.setVisible(true);
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public ArrayList<Sintomas> getSintomas() {
        return sintomas;
    }

    public boolean getProcuraHospital() {
        return procuraHospital;
    }
}
