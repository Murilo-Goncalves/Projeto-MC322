package view;

import model.*;

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

    private JComboBox<ComboItem> comboBoxSexo;
    private JComboBox<ComboItem> comboBoxRegiao;
    private JComboBox<ComboItem> comboBoxConvenio;

    private JCheckBox cansacoCheckBox;
    private JCheckBox febreCheckBox;
    private JCheckBox tosseSecaCheckBox;
    private JCheckBox dorDeCabecaCheckBox;
    private JCheckBox dorNoCorpoCheckBox;
    private JCheckBox dorDeGargantaCheckBox;
    private JCheckBox congestaoNasalCheckBox;
    private JCheckBox perdaDePaladarCheckBox;
    private JCheckBox diarreiaCheckBox;
    private JCheckBox conjuntiviteCheckBox;
    private JCheckBox erupcoesCutaneasCheckBox;
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

    private Cidade cidade;

    private final AdicionarPaciente formPaciente = new AdicionarPaciente("Ficha médica");

    public AdicionarCidadao(String title) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle(title);

        comboBoxSexo.addItem(new ComboItem("Prefiro não declarar", Sexo.PREFIRO_NAO_DECLARAR));
        comboBoxSexo.addItem(new ComboItem("Não binário", Sexo.NAO_BINARIO));
        comboBoxSexo.addItem(new ComboItem("Feminino", Sexo.FEMININO));
        comboBoxSexo.addItem(new ComboItem("Masculino", Sexo.MASCULINO));

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
        // *** except "numberFormatException"? ***
        idade = Integer.parseInt(textFieldIdade.getText());
        telefone = textFieldTelefone.getText();
        email = textFieldEmail.getText();

        ComboItem item;
        item = (ComboItem) comboBoxSexo.getSelectedItem();
        sexo = (Sexo) item.getValue();
        item = (ComboItem) comboBoxRegiao.getSelectedItem();
        regiao = (Regiao) item.getValue();
        item = (ComboItem) comboBoxConvenio.getSelectedItem();
        convenio = (Convenio) item.getValue();

        if (cansacoCheckBox.isSelected()) { sintomas.add(Sintomas.CANSACO); }
        if (febreCheckBox.isSelected()) { sintomas.add(Sintomas.FEBRE); }
        if (faltaDeArCheckBox.isSelected()) { sintomas.add(Sintomas.FALTA_DE_AR); }
        if (conjuntiviteCheckBox.isSelected()) { sintomas.add(Sintomas.CONJUNTIVITE); }
        if (congestaoNasalCheckBox.isSelected()) { sintomas.add(Sintomas.CONGESTAO_NASAL_OU_CORIZA); }
        if (diarreiaCheckBox.isSelected()) { sintomas.add(Sintomas.DIARREIA); }
        if (dorDeCabecaCheckBox.isSelected()) { sintomas.add(Sintomas.DOR_DE_CABECA); }
        if (dorNoCorpoCheckBox.isSelected()) { sintomas.add(Sintomas.DOR_NO_CORPO); }
        if (dorNoPeitoCheckBox.isSelected()) { sintomas.add(Sintomas.DOR_NO_PEITO); }
        if (dorDeGargantaCheckBox.isSelected()) { sintomas.add(Sintomas.DOR_DE_GARGANTA); }
        if (perdaDePaladarCheckBox.isSelected()) { sintomas.add(Sintomas.PERDA_PALADAR_OU_OLFATO); }
        if (tosseSecaCheckBox.isSelected()) { sintomas.add(Sintomas.TOSSE_SECA); }
        if (erupcoesCutaneasCheckBox.isSelected()) { sintomas.add(Sintomas.ERUPCOES_CUTANEAS); }

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

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
