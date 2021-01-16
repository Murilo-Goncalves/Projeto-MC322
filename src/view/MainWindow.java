package view;

import controller.ObjectIO;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
        super("Sistema de Controle do COVID por Cidade");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(rootPanel);

        readCidades();

        addWindowListener(new WindowAdapter() { // cria os arquivos em .txt
            @Override
            public void windowClosing(WindowEvent event) {
                for (Cidade cidade : cidades) {
                    String path = "data/" + cidade.getNome() + ".ser";
                    ObjectIO.writeObjectToFile(path, cidade);
                }
                dispose();
                System.exit(0);                 // termina programa
            }
        });

        bCidade.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent arg0) {
                                          if (!formCidade.isVisible()) {
                                              formCidade.setVisible(true);
                                          }

                                          // Pega cidade adicionada no form Adicionar Cidade caso não seja vazia
                                          Cidade cidade = cidades.get(cidades.size()-1);
                                          if (!cidade.getNome().equals("")) comboBoxCidade.addItem(new ComboItem(cidade.getNome(), cidade));
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

    public void readCidades() {
        File dir = new File("data");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                Cidade cidade = (Cidade) ObjectIO.readObjectFromFile(file.getPath());
                cidades.add(cidade);
                comboBoxCidade.addItem(new ComboItem(cidade.getNome(), cidade));
            }
        }
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
