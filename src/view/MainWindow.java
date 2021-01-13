package view;

import model.Convenio;
import model.Regiao;
import model.Sexo;
import model.Sintomas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private JLabel lbl = new JLabel("O que deseja adicionar ao sistema Covidados?");
    private JButton bCidade = new JButton("Cidade");
    private JButton bCidadao = new JButton("Cidadão");
    private JButton bHospital = new JButton("Hospital");
    private AdicionarCidade formCidade = new AdicionarCidade("Adicionar Cidade");
    private AdicionarCidadao formCidadao = new AdicionarCidadao("Adicionar Cidadão");
    private AdicionarHospital formHospital = new AdicionarHospital("Adicionar Hospital");

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        setTitle("Sistema Covidados");

        bCidade.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent arg0) {
                                          if (!formCidade.isVisible()) {
                                              formCidade.setVisible(true);
                                          }
                                      }
                                  });

        bCidadao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!formCidadao.isVisible()) {
                    formCidadao.setVisible(true);
                }
            }
        });

        bHospital.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!formHospital.isVisible()) {
                    formHospital.setVisible(true);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(lbl);
        panel.add(bCidade);
        panel.add(bCidadao);
        panel.add(bHospital);

        add(panel);
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

    public ArrayList<Sintomas> getCidadaoSintomas() {
        return formCidadao.getSintomas();
    }

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
}
