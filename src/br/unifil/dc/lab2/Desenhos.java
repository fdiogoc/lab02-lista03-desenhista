package br.unifil.dc.lab2;

import java.awt.*;

/**
 * Write a description of class Desenhos here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Desenhos {
    public static void desenhoQuadrado(Graphics2D g,int x, int y,int a, int reducao, int quantidade) {
     
        for(int i = 0; i<quantidade;i++){
            g.drawRect(x+(i*reducao), y+(i*reducao), a-(i*reducao)*2, a-(i*reducao)*2);
        }
    }

    public static void desenharAsterisco(Graphics2D g) {
        g.setStroke(new BasicStroke(10));

        g.setColor(Color.BLACK);
        g.drawLine(50, 100, 100, 50);
        g.drawLine(50, 50, 100, 100);
        g.drawLine(75, 50, 75, 100);
        g.drawLine(50, 75, 100, 75);
    }

    public static void desenharSmiles(Graphics2D g) {
        g.setStroke(new BasicStroke(10));
        // ROSTO01
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, 100, 100);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, 100, 100);
        // OLHOS
        g.fillOval(25, 20, 20, 20);
        g.fillOval(55, 20, 20, 20);
        // BOCA
        g.fillArc(25, 30, 50, 55, 0, -180);

        // ROSTO02
        g.setColor(Color.YELLOW);
        g.fillOval(150, 0, 100, 100);
        g.setColor(Color.BLACK);
        g.drawOval(150, 0, 100, 100);
        // OLHOS
        g.fillOval(175, 20, 20, 20);
        g.fillOval(205, 20, 20, 20);
        // BOCA
        g.drawLine(175, 65, 225, 65);

        // ROSTO03
        g.setColor(Color.RED);
        g.fillOval(300, 0, 100, 100);
        g.setColor(Color.BLACK);
        g.drawOval(300, 0, 100, 100);
        // OLHOS
        g.fillOval(325, 30, 20, 20);
        g.fillOval(355, 30, 20, 20);

        g.setStroke(new BasicStroke(6));
        // BOCA
        g.drawArc(325, 60, 50, 25, 0, 180);
        // SOMBRACELHA
        g.drawLine(325, 18, 350, 23);
        g.drawLine(350, 23, 375, 18);
    }

    public static void bandeira(Graphics2D g, Dimension dim) {
        Color verdeBandeira = new Color(0, 156, 59);
        Color azulBandeira = new Color(0, 39, 118);
        Color amareloBandeira = new Color(255, 223, 0);
        final int X = 0, Y = 1, W = 0, H = 1;
        final int[] superiorEsquerdo = { (int) (.1f * dim.width), (int) (.1f * dim.height) };
        final int[] dimensoes = { (int) (.5f * dim.width), (int) ((.5f * dim.width) * .6f) };

        final int[] polyX = { superiorEsquerdo[X], superiorEsquerdo[X] + (dimensoes[W] / 2) + superiorEsquerdo[X] / 2,
                superiorEsquerdo[X] * 2 + dimensoes[W],
                superiorEsquerdo[X] + (dimensoes[W] / 2) + superiorEsquerdo[X] / 2 };
        final int[] polyY = { (superiorEsquerdo[Y] + (dimensoes[H] / 2)) + (superiorEsquerdo[Y] / 2),
                superiorEsquerdo[Y], (superiorEsquerdo[Y] + (dimensoes[H] / 2)) + (superiorEsquerdo[Y] / 2),
                (superiorEsquerdo[Y] * 2) + (dimensoes[H]) };

        g.setColor(verdeBandeira);
        g.fillRect(superiorEsquerdo[X], superiorEsquerdo[Y], superiorEsquerdo[X] + dimensoes[W],
                superiorEsquerdo[Y] + dimensoes[H]);
        g.setColor(amareloBandeira);
        g.fillPolygon(polyX, polyY, 4);
        g.setColor(azulBandeira);
        g.fillOval(superiorEsquerdo[X] + (dimensoes[W] / 4), (int) (superiorEsquerdo[Y] * 1.55),
                superiorEsquerdo[X] + dimensoes[W] / 2, (int) (superiorEsquerdo[Y] + (dimensoes[H] * 0.7)));
    }

    /**
     * Função chaamda pela tela, nela montamos o "predio"
     * 
     * @param g
     * @param dim
     */
    public static void DesenharPredioCompleto(Graphics2D g, Dimension dim) {
        predioAndar(g, dim, 1, 2, 0);
        predioAndar(g, dim, 6, 4, 100);
        predioAndar(g, dim, 2, 3, 200);
        predioAndar(g, dim, 3, 4, 300);
        predioAndar(g, dim, 5, 6, 400);
        predioAndar(g, dim, 2, 3, 500);
        predioAndar(g, dim, 1, 1, 600);

    }

    /**
     * Função que desenha o prédio, com a tela padrão 800x600, o numero maximo de
     * andares que cabem na tela são 7, numero que está dentro da funçãa; está
     * função chama outra que desenha as janelas;
     * 
     * @param g                 Graphics2D
     * @param dim               Dimension
     * @param QntAndar          - Quandidade de andar do prédio
     * @param QntJan            - Quantidade de janelas por andar
     * @param posInicialPredioX - Posição que o prédio sera dedenhado
     */
    public static void predioAndar(Graphics2D g, Dimension dim, int QntAndar, int QntJan, int posInicialPredioX) {
        // QUANTIDADE QUE VAZA A TELA, e precisava de um ponto fixo para fazer o "chão"
        final int MAX_ANDAR = 6;
        g.setColor(Color.BLACK);
        final int X = 0, Y = 1, W = 0, H = 1;
        final int[] superiorEsquerdo = { 40, 40 };
        final int[] dimensoes = { 40, 40 };

        final int posInicialX = superiorEsquerdo[X] + posInicialPredioX;
        final int posInicialY = (superiorEsquerdo[Y] + (dimensoes[H] * (MAX_ANDAR - QntAndar))) * 2;
        final int tamX = superiorEsquerdo[X] + dimensoes[W];
        final int tamY = (superiorEsquerdo[Y] + dimensoes[H]) * QntAndar;
        g.fillRect(posInicialX, posInicialY, tamX, tamY);
        predioJanela(g, posInicialX, posInicialY, QntAndar, QntJan, dimensoes);
    }

    /**
     * @param g
     * @param posInicialX posição iniail do prédio
     * @param posInicialY posição iniail do prédio/andar
     * @param QntAndar    quantidade de andares do prédio
     * @param QntJan      Quantidade de janelas pou andar
     * @param dimensoes   tamanho do andar que foi definido na função anterior
     */
    public static void predioJanela(Graphics2D g, int posInicialX, int posInicialY, int QntAndar, int QntJan,
            int[] dimensoes) {
        final int Y = 1, W = 0, H = 1;
        g.setColor(Color.WHITE);

        // TAMANHO DAS JANELAS
        final int TamXJanAndar = dimensoes[W] / 4;
        final int TamYJanAndar = dimensoes[H] / 4;
        final int espacoEntreJanelas = (dimensoes[W] - TamXJanAndar) / QntJan;
        // FOR PARA CADA ANDAR
        for (int i = 0; i < QntAndar; i++) {
            for (int z = 1; z <= QntJan; z++) {
                // CHEIO DOS NUMEROS MAGICOS SIM, SEM CRIATIVIDADE PARA NOME DE VARIAVEIS
                final int posXJanAndar = posInicialX + (espacoEntreJanelas * z * 2);
                final int posYJanAndar = (posInicialY + dimensoes[Y] / 2) + (dimensoes[Y] * i) * 2;

                g.fillRect(posXJanAndar, posYJanAndar, TamXJanAndar, TamYJanAndar);

            }

        }

    }

}
