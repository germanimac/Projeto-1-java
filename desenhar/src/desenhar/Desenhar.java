//TRABALHO DE PARADIGMAS DE PROGRAMAÇÃO B
//PROFESSOR: LEANDRO AFONSO XASTRE
//ALUNOS:   GABRIEL GONÇALVES MATTOS SANTINI     RA: 18189084
//          MARCELO GERMANI OLMOS                RA: 18048298  
package desenhar;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Desenhar extends Frame {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //inicia o jogo
        janela game = new janela();
        game.show();
        server serv = new server();
        serv.getMsg(game);
    }    
}








