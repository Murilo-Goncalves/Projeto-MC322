package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private final ArrayList<Cidade> cidades = new ArrayList<Cidade>();
    private final AdicionarCidade formCidade = new AdicionarCidade("Adicionar Cidade", cidades);
    private final AdicionarCidadao formCidadao = new AdicionarCidadao("Adicionar Cidadão");
    private final AdicionarHospital formHospital = new AdicionarHospital("Adicionar Hospital");
    private JButton bHospital;
    private JButton bCidadao;
    private JComboBox<ComboItem> comboBoxCidade;
    private JButton bCidade;
    private JPanel rootPanel;

    public MainWindow() {
        super("Sistema Covidados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(rootPanel);

        bCidade.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent arg0) {
                                          if (!formCidade.isVisible()) {
                                              formCidade.setVisible(true);
                                          }

                                          // Pega cidade adicionada no form Adicionar Cidade caso não seja vazia
                                          Cidade tmp = cidades.get(cidades.size()-1);
                                          if (!tmp.getNome().equals("")) comboBoxCidade.addItem(new ComboItem(tmp.getNome(), tmp));
                                      }
                                  });

        bCidadao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBoxCidade.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar uma cidade para adicionar um cidadão.");
                }
                else if (!formCidadao.isVisible()) {
                    // Seta a cidade do cidadão
                    ComboItem item = (ComboItem) comboBoxCidade.getSelectedItem();
                    Cidade cidade = (Cidade) item.getValue();
                    formCidadao.setCidade(cidade);

                    // Abre o forms de adicionar cidadão
                    formCidadao.setVisible(true);

                    // Adiciona o cidadão na cidade escolhida no combo box
                    Cidadao cidadao = formCidadao.getCidadao();
                    if (!cidade.getCidadaos().contains(cidadao)) { cidade.adicionaCidadao(cidadao); }
                }

            }
        });

        bHospital.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBoxCidade.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar uma cidade para adicionar um hospital.");
                }
                else if (!formHospital.isVisible()) {
                    // Seta a cidade do hospital

                    formHospital.setVisible(true);

                    // Seta a cidade do hospital para a cidade escolhida no combo box
                    ComboItem item = (ComboItem) comboBoxCidade.getSelectedItem();
                    Cidade cidade = (Cidade) item.getValue();
                    Hospital hospital = formHospital.getHospital();
                    if (hospital instanceof  HospitalPrivado) {
                        cidade.adicionaHospital((HospitalPrivado) hospital);
                    } else {
                        cidade.adicionaHospital((HospitalPublico) hospital);
                    }
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public String getCidadeNome() {
        return formCidade.getNome();
    }

    public String getCidadaoNome() {
        return formCidadao.getNome();
    }

    public String getCpf() {
        return formCidadao.getCpf();
    }

    public String getCidadaoLogin() {
        return formCidadao.getLogin();
    }

    public String getCidadaoSenha() {
        return formCidadao.getSenha();
    }

    public int getCidadaoIdade() {
        return formCidadao.getIdade();
    }

    public String getCidadaoTelefone() {
        return formCidadao.getTelefone();
    }

    public String getCidadaoEmail() {
        return formCidadao.getEmail();
    }

    public Sexo getCidadaoSexo() {
        return formCidadao.getSexo();
    }

    public Convenio getCidadaoConvenio() {
        return formCidadao.getConvenio();
    }

    public ArrayList<Sintomas> getCidadaoSintomas() { return formCidadao.getSintomas(); }

    public boolean getCidadaoProcuraHospital() {
        return formCidadao.getProcuraHospital();
    }

    public String getHospitalNome() {
        return formHospital.getNome();
    }

    public int getHospitalCapacidadeLeitos() {
        return formHospital.getCapacidadeLeitos();
    }

    public Regiao getHospitalRegiao() {
        return formHospital.getRegiao();
    }

    public boolean getHospitalIsPrivado() {
        return formHospital.getIsPrivado();
    }

    public ArrayList<Cidade> getCidades() { return cidades; }
}
