/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.InvalidMapException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import util.Constantes;
import view.CacaNiquelView;

/**
 *
 * @author fernandopucci
 */
public class CacaNiquelController {

    public CacaNiquelController(CacaNiquelView cacaNiquelView) {

        this.cacaNiquelView = cacaNiquelView;

    }

    private CacaNiquelView cacaNiquelView;

    public Map<Integer, ImageIcon> carregarMapaImagens(Map<Integer, ImageIcon> mapa) throws InvalidMapException {

        if (mapa != null) {

            for (int i = 0; i <= 6; i++) {

                switch (i) {

                    case 0:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_0)));
                        break;
                    case 1:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_1)));
                        break;
                    case 2:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_2)));
                        break;
                    case 3:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_3)));
                        break;
                    case 4:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_4)));
                        break;
                    case 5:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_5)));
                        break;
                    case 6:
                        mapa.put(i, new ImageIcon(getClass().getClassLoader().getResource(Constantes.PATH_FILE_6)));
                        break;
                }

            }
        } else {
            throw new InvalidMapException("Mapa nulo, impossível preencher");
        }

        return mapa;

    }

    private void checarJogo() {

        int a = cacaNiquelView.getI1();
        int b = cacaNiquelView.getI2();
        int c = cacaNiquelView.getI3();

        System.out.println(">>> A[" + a + "], B[" + b + "], C[" + c + "]");

        if ((a == 7) && (b == 7) && (c == 7)) {
            cacaNiquelView.setMoeda(cacaNiquelView.getMoeda() + 100);
            cacaNiquelView.setPontos(cacaNiquelView.getPontos() + 100);
            JOptionPane.showMessageDialog(cacaNiquelView, "Parabéns, Você é o vencedor");
            cacaNiquelView.exibirPontuacao();
//            jLabel2.setText(String.valueOf(cacaNiquelView.getMoeda()));
//            jLabel4.setText(String.valueOf(cacaNiquelView.getPontos()));

        } else if (((a == 7) && (b == 7)) || ((a == 7) && (c == 7)) || ((b == 7) && (c == 7))) {
            cacaNiquelView.setMoeda(cacaNiquelView.getMoeda() + 2);
            cacaNiquelView.setPontos(cacaNiquelView.getPontos() + 2);
            cacaNiquelView.exibirPontuacao();
//            jLabel2.setText(String.valueOf(cacaNiquelView.getMoeda()));
//            jLabel4.setText(String.valueOf(cacaNiquelView.getPontos()));
        } else if ((a == 7) || (b == 7) || (c == 7)) {
            cacaNiquelView.setMoeda(cacaNiquelView.getMoeda() + 1);
            cacaNiquelView.setPontos(cacaNiquelView.getPontos() + 1);
            cacaNiquelView.exibirPontuacao();
//            jLabel2.setText(String.valueOf(cacaNiquelView.getMoeda()));
//            jLabel4.setText(String.valueOf(cacaNiquelView.getPontos()));
        } else if ((a != 7) && (b != 7) && (c != 7)) {
            cacaNiquelView.setMoeda(cacaNiquelView.getMoeda() - 1);
            cacaNiquelView.exibirPontuacao();
//            jLabel2.setText(String.valueOf(cacaNiquelView.getMoeda()));
//            jLabel4.setText(String.valueOf(cacaNiquelView.getPontos()));
            if (cacaNiquelView.getMoeda() == 0) {
                JOptionPane.showMessageDialog(cacaNiquelView, "Você perdeu!");
                cacaNiquelView.habilitarBotoes(false);
            }

        }

    }

    public Thread getThreadChecarJogo() {

        return new Thread() {

            @Override
            public void run() {
                System.out.println("T");
                while (!cacaNiquelView.isIsValor1Concluido() || !cacaNiquelView.isIsValor2Concluido() || !cacaNiquelView.isIsValor3Concluido()) {
                    try {
                        //intervalo para sincronização de threads
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        //não há necessidade de tratarmos este erro
                    }
                }

                if (cacaNiquelView.isIsValor1Concluido() && cacaNiquelView.isIsValor2Concluido() && cacaNiquelView.isIsValor3Concluido()) {
                    System.out.println("Conferindo Jogo:");
                    checarJogo();

                }

            }

        };
    }

    public Thread getThreadRodarBtn1() {
        return new Thread() {
            @Override
            public void run() {

                int indice = (int) (Math.random() * 100);
                System.out.println(indice);
                try {
                    do {
                        for (Map.Entry<Integer, ImageIcon> entry : cacaNiquelView.getIconGenerator().getMapaArquivosIcones().entrySet()) {
                            try {

                                cacaNiquelView.atualizaImagemBotao(cacaNiquelView.getBtnValor1(), entry.getValue());

                                if (indice > 90) {
                                    Thread.sleep(40);
                                } else if (indice > 80) {
                                    Thread.sleep(70);
                                } else if (indice > 70) {
                                    Thread.sleep(100);
                                } else if (indice > 60) {
                                    Thread.sleep(130);
                                } else if (indice > 50) {
                                    Thread.sleep(170);
                                } else if (indice > 40) {
                                    Thread.sleep(200);
                                } else if (indice > 30) {
                                    Thread.sleep(230);
                                } else if (indice > 20) {
                                    Thread.sleep(250);
                                } else if (indice > 10) {
                                    Thread.sleep(300);
                                } else if (indice > 7) {
                                    Thread.sleep(310);
                                } else if (indice > 5) {
                                    Thread.sleep(400);
                                }

                                indice--;
                                if (indice == 0) {
                                    cacaNiquelView.setI1((entry.getKey() + 1));
                                    cacaNiquelView.setIsValor1Concluido(Boolean.TRUE);
                                    System.out.println(cacaNiquelView.getI1() + "- " + cacaNiquelView.isIsValor1Concluido());
                                    break;
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CacaNiquelView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } while (indice > 0);

                } catch (InvalidMapException ex) {
                    Logger.getLogger(CacaNiquelView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
    }

    public Thread getThreadRodarBtn2() {
        return new Thread() {
            @Override
            public void run() {

                int indice = (int) (Math.random() * 100);
                System.out.println(indice);
                try {
                    do {
                        for (Map.Entry<Integer, ImageIcon> entry : cacaNiquelView.getIconGenerator().getMapaArquivosIcones().entrySet()) {
                            try {

                                cacaNiquelView.atualizaImagemBotao(cacaNiquelView.getBtnValor2(), entry.getValue());

                                if (indice > 90) {
                                    Thread.sleep(40);
                                } else if (indice > 80) {
                                    Thread.sleep(70);
                                } else if (indice > 70) {
                                    Thread.sleep(100);
                                } else if (indice > 60) {
                                    Thread.sleep(130);
                                } else if (indice > 50) {
                                    Thread.sleep(170);
                                } else if (indice > 40) {
                                    Thread.sleep(200);
                                } else if (indice > 30) {
                                    Thread.sleep(230);
                                } else if (indice > 20) {
                                    Thread.sleep(250);
                                } else if (indice > 10) {
                                    Thread.sleep(300);
                                } else if (indice > 7) {
                                    Thread.sleep(310);
                                } else if (indice > 5) {
                                    Thread.sleep(400);
                                }

                                indice--;
                                if (indice == 0) {
                                    cacaNiquelView.setI2((entry.getKey() + 1));
                                    cacaNiquelView.setIsValor2Concluido(Boolean.TRUE);
                                    System.out.println(cacaNiquelView.getI2() + "- " + cacaNiquelView.isIsValor2Concluido());
                                    break;
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CacaNiquelView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } while (indice > 0);

                } catch (InvalidMapException ex) {
                    Logger.getLogger(CacaNiquelView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
    }

    public Thread getThreadRodarBtn3() {
        return new Thread() {
            @Override
            public void run() {

                int indice = (int) (Math.random() * 100);
                System.out.println(indice);
                try {
                    do {
                        for (Map.Entry<Integer, ImageIcon> entry : cacaNiquelView.getIconGenerator().getMapaArquivosIcones().entrySet()) {
                            try {

                                cacaNiquelView.atualizaImagemBotao(cacaNiquelView.getBtnValor3(), entry.getValue());

                                if (indice > 90) {
                                    Thread.sleep(40);
                                } else if (indice > 80) {
                                    Thread.sleep(70);
                                } else if (indice > 70) {
                                    Thread.sleep(100);
                                } else if (indice > 60) {
                                    Thread.sleep(130);
                                } else if (indice > 50) {
                                    Thread.sleep(170);
                                } else if (indice > 40) {
                                    Thread.sleep(200);
                                } else if (indice > 30) {
                                    Thread.sleep(230);
                                } else if (indice > 20) {
                                    Thread.sleep(250);
                                } else if (indice > 10) {
                                    Thread.sleep(300);
                                } else if (indice > 7) {
                                    Thread.sleep(310);
                                } else if (indice > 5) {
                                    Thread.sleep(400);
                                }

                                indice--;
                                if (indice == 0) {
                                    cacaNiquelView.setI3((entry.getKey() + 1));
                                    cacaNiquelView.setIsValor3Concluido(Boolean.TRUE);
                                    System.out.println(cacaNiquelView.getI3() + "- " + cacaNiquelView.isIsValor3Concluido());
                                    break;
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CacaNiquelView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } while (indice > 0);

                } catch (InvalidMapException ex) {
                    Logger.getLogger(CacaNiquelView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
    }

}
