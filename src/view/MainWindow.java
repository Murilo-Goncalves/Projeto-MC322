package view;

import controller.FileIO;
import controller.ObjectIO;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class MainWindow extends JFrame {
    private JButton bHospital;
    private JButton bCidadao;
    private JComboBox<ComboItem> comboBoxCidade;
    private JButton bCidade;
    private JPanel rootPanel;
    private JComboBox comboBoxHospital;
    private JComboBox comboBoxPaciente;
    private JButton removerHospital;
    private JButton removerPaciente;
    private JButton removerCidade;
    private final ArrayList<Cidade> cidades = new ArrayList<Cidade>();
    private final AdicionarCidade formCidade = new AdicionarCidade("Adicionar Cidade", cidades);
    private final AdicionarCidadao formCidadao = new AdicionarCidadao("Adicionar Cidadão", comboBoxPaciente);
    private final AdicionarHospital formHospital = new AdicionarHospital("Adicionar Hospital");

    public MainWindow() {
        super("Sistema de Controle do COVID por Cidade");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(rootPanel);
        readCidades();

        // cria as pastas, os arquivos em .txt e arquivos .ser (binário)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                createFiles();  // cria pastas e arquivos que salvarao os dados do programa.
                dispose();
                System.exit(0);  // termina programa
            }
        });
        
        /* Adiciona as cidades nas opcoes da comboBox, ao se
           clicar em "Adicionar (cidade)". */
        bCidade.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent arg0) {
                  if (!formCidade.isVisible()) {
                      formCidade.setVisible(true);
                  }

                  // Pega cidade adicionada no form Adicionar Cidade
                  Cidade cidade = cidades.get(cidades.size()-1);
                  if (!cidade.getNome().equals("")) {
                      comboBoxCidade.addItem(new ComboItem(cidade.getNome(), cidade));
                  }
              }
          });

        /* Adiciona os cidadaos informacoes da cidade, de acordo com a cidade selecionada, ao se
           clicar em "Adicionar (cidadao)". */
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
                    if (!cidade.getCidadaos().contains(cidadao)) {
                        cidade.adicionaCidadao(cidadao);
                    }
                }
            }
        });

        /* Adiciona os hospitais nas opcoes da comboBox, de acordo com a cidade selecionada, ao se
           clicar em "Adicionar (hospital)". */
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
                    }
                    else {
                        cidade.adicionaHospital((HospitalPublico) hospital);
                    }

                    comboBoxHospital.addItem(new ComboItem(hospital.getNome(), hospital));
                }
            }
        });

        /* Remove uma cidade e todos os hospitais e pacientes presentes na mesma */
        removerCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!cidades.isEmpty()) {
                    ComboItem comboCidade = (ComboItem) comboBoxCidade.getSelectedItem();
                    Cidade cidade = (Cidade) comboCidade.getValue();
                    cidades.remove(cidade);
                    comboBoxCidade.removeItem(comboCidade);
                    comboBoxHospital.removeAllItems();
                    comboBoxPaciente.removeAllItems();
                }
            }
        });

        /* Faz a leitura de quais hospitais pertencem a cidade, e atualiza a comboBox */
        comboBoxCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!cidades.isEmpty()) {
                    ComboItem comboCidade = (ComboItem) comboBoxCidade.getSelectedItem();
                    Cidade cidade = (Cidade) comboCidade.getValue();
                    readHospitais(cidade);
                }
            }
        });
        /*
            Remove um hopital da comboBox de remover hospitais, bem como do array list
            de hospitais, dentro de cidade.
            Além disso, remove todos os pacientes dentro desse hopital.
        */
        removerHospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!cidades.isEmpty()) {
                    ComboItem comboCidade = (ComboItem) comboBoxCidade.getSelectedItem();
                    Cidade cidade = (Cidade) comboCidade.getValue();

                    if (comboBoxHospital.getSelectedItem() != null) {
                        ComboItem comboHospital = (ComboItem) comboBoxHospital.getSelectedItem();
                        if (comboHospital.getValue() instanceof HospitalPublico) {
                            HospitalPublico hospital = (HospitalPublico) comboHospital.getValue();
                            cidade.removeHospital(hospital);
                            comboBoxHospital.removeItem(comboHospital);
                            comboBoxPaciente.removeAllItems();
                        } else if (comboHospital.getValue() instanceof HospitalPrivado) {
                            HospitalPrivado hospital = (HospitalPrivado) comboHospital.getValue();
                            cidade.removeHospital(hospital);
                            comboBoxHospital.removeItem(comboHospital);
                            comboBoxPaciente.removeAllItems();
                        }
                    }
                }
            }
        });

        /* O método verifica qual hospital foi selecionado no comboBox de hospital, e
           atualiza quais pacientes estao neste hopital.
        */
        comboBoxHospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBoxHospital.getSelectedItem() != null) {
                    ComboItem comboHospital = (ComboItem) comboBoxHospital.getSelectedItem();

                    if (comboHospital.getValue() instanceof HospitalPublico) {
                        HospitalPublico hospital = (HospitalPublico) comboHospital.getValue();
                        readPacientes(hospital);
                    } else if (comboHospital.getValue() instanceof HospitalPrivado) {
                        HospitalPrivado hospital = (HospitalPrivado) comboHospital.getValue();
                        readPacientes(hospital);
                    }
                }
            }
        });

        /* Remove determinado paciente da comboBox, e do array de pacientes, dentro do hospital */
        removerPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!cidades.isEmpty()) {
                    ComboItem comboHospital = (ComboItem) comboBoxHospital.getSelectedItem();
                    assert comboHospital != null;
                    Hospital hospital = (Hospital) comboHospital.getValue();
                    ComboItem comboPaciente = (ComboItem) comboBoxPaciente.getSelectedItem();
                    assert comboPaciente != null;
                    Paciente paciente = (Paciente) comboPaciente.getValue();
                    hospital.removerPaciente(paciente);
                    comboBoxPaciente.removeItem(comboPaciente);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    /* Faz leitura de quais cidades foram adicionadas, para mostrar na aba das cidades */
    private void readCidades() {
        File dir = new File("data/objects");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                Cidade cidade = (Cidade) ObjectIO.readObjectFromFile(file.getPath());
                cidades.add(cidade);
                comboBoxCidade.addItem(new ComboItem(cidade.getNome(), cidade));
                readHospitais(cidade);
                // atualiza quais sao os pacientes, quando abrimos o sistema
                if (cidade.getHospitaisPublicos() != null)                  // em readHospitais,
                    readPacientes(cidade.getHospitaisPublicos().get(0));    // um hospital público
                else if (cidade.getHospitaisPrivados() != null)             // possui preferência
                    readPacientes(cidade.getHospitaisPrivados().get(0));
            }
        }
    }

    /* Faz leitura de quais hospitais estao adicionados em uma cidades, para
       mostrar na aba de remover hospitais.
    */
    private void readHospitais(Cidade cidade) {
        comboBoxHospital.removeAllItems();
        for (HospitalPublico hospital : cidade.getHospitaisPublicos()) {
            comboBoxHospital.addItem(new ComboItem(hospital.getNome(), hospital));
        }
        for (HospitalPrivado hospital : cidade.getHospitaisPrivados()) {
            comboBoxHospital.addItem(new ComboItem(hospital.getNome(), hospital));
        }
    }


    /* Faz a leitura de quais  pacientes estao em um hospital, para mostrar na aba de
       remover pacientes.
    */
    private void readPacientes(HospitalPublico hospital) {
        comboBoxPaciente.removeAllItems();
        for (Paciente paciente : hospital.getPacientes()) {
            comboBoxPaciente.addItem(new ComboItem(paciente.getNome(), paciente));
        }
    }

    private void readPacientes(HospitalPrivado hospital) {
        comboBoxPaciente.removeAllItems();
        for (Paciente paciente : hospital.getPacientes()) {
            comboBoxPaciente.addItem(new ComboItem(paciente.getNome(), paciente));
        }
    }

    /* Método para remover diretório, auxiliar para createFiles, uma vez que é
       usado para atualizar o diretório do usuário.
    */
    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    /*
    * Método auxiliar para addWindowListener
    * Cria as respectivas pastas e arquivos que armazenarao os dados das cidades,
      dos hospitais e dos cidadaos.
    * As informacoes salvas serao em ambos os formatos de binário, utilizada pelo
      sistema para ler as informacoes antigas, quanto no formato de texto, o qual é
      de leita natural para o usuário.
    */
    private void createFiles() {
        File data = new File("data");

        deleteDirectory(data);

        if (!data.exists())
            data.mkdirs();

        // separa pastas em objects (binário) e info-cidades (texto)
        File objects = FileIO.createFolder(data, "objects");
        File infoCidades = FileIO.createFolder(data, "info-cidades");

        for (Cidade cidade : cidades) {
            // salva os arquivos binários
            assert objects != null;
            ObjectIO.writeObjectToFile(objects.getAbsolutePath() + "/" +
                    cidade.getNome() + ".ser", cidade);

            // cria uma pasta para cada cidade
            File cidadeN = FileIO.createFolder(infoCidades, cidade.getNome());
            assert cidadeN != null;
            /*
                Salva o arquivo da cidade na pasta de mesmo nome, e cria pastas de
                hospitais público e privado.
            */
            FileIO.saveFile(cidadeN, cidade.getNome(), cidade.toString());
            File hospitaisPublicos = FileIO.createFolder(cidadeN, "Hospitais Publicos");
            assert hospitaisPublicos != null;
            for (HospitalPublico hospitalPublico : cidade.getHospitaisPublicos()) {
            /*
                Cria uma pasta para cada hospital público, e insere dentro da pasta os
                arquivos do hospital e a pasta "Pacientes", com os arquivos dos pacientes"
            */

                File HospitalPubN = FileIO.createFolder(hospitaisPublicos,
                                                        hospitalPublico.getNome());
                assert HospitalPubN != null;
                FileIO.saveFile(HospitalPubN, hospitalPublico.getNome(),
                                hospitalPublico.toString());
                File Pacientes = FileIO.createFolder(HospitalPubN, "Pacientes");
                assert Pacientes != null;
                for (Paciente paciente : hospitalPublico.getPacientes()) {
                    assert paciente != null;
                    FileIO.saveFile(Pacientes, paciente.getNome(), paciente.toString());
                }
            }
            File hospitaisPrivados = FileIO.createFolder(cidadeN, "Hospitais Privados");
            assert hospitaisPrivados != null;
            for (HospitalPrivado hospitalPriv : cidade.getHospitaisPrivados()) {
              /*
                Cria uma pasta para cada hospital privado, e insere dentro da pasta os
                arquivos do hospital e a pasta "Pacientes", com os arquivos dos pacientes"
              */
                File HospitalPrivN = FileIO.createFolder(hospitaisPrivados,
                                                            hospitalPriv.getNome());
                assert HospitalPrivN != null;
                FileIO.saveFile(HospitalPrivN, hospitalPriv.getNome(), hospitalPriv.toString());
                File Pacientes = FileIO.createFolder(HospitalPrivN, "Pacientes");
                assert Pacientes != null;
                for (Paciente paciente : hospitalPriv.getPacientes()) {
                    assert paciente != null;
                    FileIO.saveFile(Pacientes, paciente.getNome(), paciente.toString());
                }
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
