package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        setTitle("Sistema Covidados");

        JLabel lbl = new JLabel("O que deseja adicionar ao sistema Covidados?");
        JButton bCidade = new JButton("Cidade");
        JButton bCidadao = new JButton("Cidadão");
        JButton bHospital = new JButton("Hospital");
        AdicionarCidade formCidade = new AdicionarCidade("Adicionar Cidade");
        AdicionarCidadao formCidadao = new AdicionarCidadao("Adicionar Cidadão");
        AdicionarHospital formHospital = new AdicionarHospital("Adicionar Hospital");

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

    public static void main(String[] args) {
        JFrame window = new MainWindow();
        window.pack();
        window.setVisible(true);
    }
}
