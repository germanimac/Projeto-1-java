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
        new janela().show();                                                    
    }    
}

class janela extends Frame implements KeyListener, MouseListener{               //declara a classe janela, implementando o mouse e o teclado e extendendo o frame
    quadro[] q;                                               
    tile_background[] t = new tile_background[16];
    
    //declaração de todas as variaveis gerais da classe
    
    public int num;
    public int change;
    public int score; 
    public boolean charak = false;
    public boolean charag = false;
    public boolean charae = false;
    public boolean requiem = false;
    public boolean kingcrimson=false;
    public boolean pause = false;
    public boolean win= false;
    public boolean lose = false;
    int xi,xf,yi,yf;
    
    //define as propriedades da janela e gera o tile-background
    public janela() {
        try{
        setIconImage(new ImageIcon("eric-final1.png").getImage());}
        catch(Exception e){}
        this.addMouseListener(this);
        setSize(521,521);
        setTitle("2048");
        
        addKeyListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        //gera os quadrados do fundo
        t[0] = new tile_background(61,71);
        for(int i=1;i<16;i++){
            t[i] = new tile_background();
            this.t[i].x = i%4 * 100 + 61;
            this.t[i].y =  (int)i/4 * 100 + 71;
            }
        this.initialize();
        //auxilia no teste de merge
        this.change = this.num;
    }
   
    public void paint(Graphics g){
        //printa a tela de vitória
        if(win){
            this.win(g);
        }
        else{
            //printa a tela de derrota
            if(lose){
                this.lose(g);
            }
            else{
                //primeiro easter egg, aonde cria varias telas e reenicia o jogo
                if(requiem){
                this.gold_experience_requiem(g);
                try{Thread.sleep(20);}catch(Exception e){}
                requiem = false;
                }
                //segundo easter egg, aonde o jogo vai direto para o final
                if(kingcrimson){
                this.king_crimson(g);
                kingcrimson=false;
                repaint();
                }
                this.draw_background(g);
                //desenha as animações
                for(int i=0;i<this.q.length;i++){
                    try{
                
                        if(q[i].merging){
                            score = score+q[i].valor;
                            q[i].animate_merge(g);
                   
                            }
                    else
                            if(q[i].block_collided)
                                q[i].animate_collision(g);
                            this.q[i].block_collided=false;
                            this.q[i].merging = false;
                
                            q[i].draw(g);
                        }
           
                        catch(Exception e){}
                        try{Thread.sleep(5);}catch(Exception e){}
        
                }
                //redesenha o jogo após a animação
                this.draw_background(g);                
                for(int i=0;i<16;i++){
                    try{
                        q[i].draw(g);
                    }catch(Exception e){}
                    g.setColor(Color.BLACK);
                    g.drawString("Score: " + Integer.toString(this.score),350 ,45 );
       
                    }
            }
        }
        
        
}
    //função responsavel pelo movimento e pelas easter eggs
    public void Update(int dir){
        int i;
        switch(dir){
            //movimenta as peças para cima
            case 1:
                if(!pause){
                charak = false;
                charag=false;
                charae=false;
                for(i = 0;i<this.num;i++){
                    q[i].moved = false;
                    this.change = this.q[i].slide(0, q,this.num);
                    if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i = 0;i<this.num;i++){
                    this.change = this.q[i].slide(0, q,this.num);
                    if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i = 0;i<this.num;i++){
                    this.change = this.q[i].slide(0, q,this.num);
                    if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                }
                break;
                
            //movimenta as peças para a esquerda   
            case 2:
                if(!pause){
                charak = false;
                charag=false;
                charae=false;
                for(i = 0; i<this.num;i++){
                    q[i].moved = false;
                    this.change = this.q[i].slide(1, q,this.num);
                    if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                    }
                }
                for(i = 0; i<this.num;i++){
                        this.change = this.q[i].slide(1, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i = 0; i<this.num;i++){
                        this.change = this.q[i].slide(1, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }}
                break;
            
            //movimenta as peças para a direita
            case 3:
                if(!pause){
                charak = false;
                charag=false;
                charae=false;
                for(i=0;i<this.num;i++){
                    q[i].moved = false;
                    this.change = this.q[i].slide(2, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i=0;i<this.num;i++){
                    this.change = this.q[i].slide(2, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i=0;i<this.num;i++){
                    this.change = this.q[i].slide(2, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                }
                break;
                
            //movimenta as peças para baixo    
            case 4:
                if(!pause){
                charak = false;
                charag=false;
                charae=false;
                for(i=0;i<this.num;i++){
                    q[i].moved = false;
                    this.change = this.q[i].slide(3, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i=0;i<this.num;i++){
                    this.change = this.q[i].slide(3, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
                for(i=0;i<this.num;i++){
                    this.change = this.q[i].slide(3, q,this.num);
                        if(this.change < this.num){
                        i=0;
                        this.num = this.change;
                        }
                }
               
               
                }
                break;
                
                //faz o inicio da easter egg, setando uma flag para o proximo input
                case 5:
                    if(!pause){
                    charak = true;
                    }
                    break;
                
                //verifica se a flag charak foi ativa, assim iniciando o easter egg "king crimson"
                case 6:
                    if(!pause){
                    if(charak){
                        charak = false;
                        kingcrimson=true;
                    }
                    }
                break;
                //seta algumas flags como falsas e testa se as flags charag e charae sao verdadeiras assim iniciando o easter egg "Gold Experience Requiem"
                case 7:
                    charak= false;
                    pause = false;
                    win = false;
                    lose = false;
                    if(charag && charae){
                        requiem = true;
                        charag=false;
                        charae=false;
                    }
                    this.initialize();
                    break;
                //seta a flag charak como falsa e a flag charag como true
                case 8:
                    charak= false;
                    charag=true;
                    break;
                //seta a flag charak como falsa e a flag charae como true
                case 9:
                    charak= false;
                    charae=true;
                    break;
        }
        //verifica se o input nao é nenhuma flag
        if(dir != 5 && dir != 6 && dir != 7 && dir != 8 && dir != 9){
        try{
            //checa vitória e ativa as flags nescessarias
            for(i=0;i<q.length;i++)
                if(q[i].valor == 2048){
                    win=true;
                    pause = true;
                            }}
            catch(Exception e){}
        //checa derrota e ativa as flags nescessarias
        if(num == 16){
            if(!this.possible_moves()){
                lose = true;
                pause = true;
                repaint();
            }
        }
        try{
        for(i=0; i<q.length;i++){
            if(q[i].moved || q[i].merging){
                generate_block(num);
                num+=1;
                break;
            }
        }
        }
        catch(Exception e){}}
        repaint();
       
    }
      
    //inicializa os blocos; o score em 0 e gera 2 blocos 
    public void initialize(){
        q = new quadro[17];
        this.score = 0;
        for(int j = 0;j<2;j++){
        generate_block(j);
        }
        this.num = 2;
        return;
    }
   
    //gera um bloco em uma posição aleatoria
    public void generate_block(int j){
        int contcoord = 0;
        int[] coord = new int [32];
        for(int i = 0;i<t.length;i++)
            //verifica para cada tile background, se não tem nenhum bloco em cima 
            if(t[i].isopen(this.q)){
                //gera e insere em um vetor todas as coordenadas possiveis para inserir o bloco
                coord[2*contcoord]= t[i].x;
                coord[(2*contcoord)+1] = t[i].y;
                contcoord++;
            }
        //gera a coordenada aonde o bloco será alocado
        int a = (int)(Math.random() * contcoord);
        //seta o proximo bloco como 2 ou 4, dependendo da porcentagem de chance
        double b = (Math.random() * 100);
        int v;
        if(b<20)v=4;
        else v=2;
        //seta o bloco de tamanho aleatorio na posição alocada previamente
        this.q[j] = new quadro(coord[2*a],coord[2*a+1],v);
    }
   
    //desenha a linha de border, desenha o fundo e desenha cada um dos quadradinhos azuis claro
    public void draw_background(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(40, 50, 421, 421);
        g.setColor(Color.decode("#8EB0E6"));
        g.fillRect(41, 51, 420, 420);
        for (int i=0;i<16;i++){
            g.setColor(Color.decode("#ADD8E6"));
            g.fillRect(this.t[i].x, this.t[i].y, 80, 80);
        }
    }
    
    //coloca na tela a imagem de easter egg do king crimson, e após isso, seta dois blocos nos valores de 1024 um do lado do outro
    public void king_crimson(Graphics g){
        try{
        //coloca imagen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);
        Image image = toolkit.getImage("kingcrimson.jpg");
        tracker.addImage(image, 0);
        try{tracker.waitForAll();}catch(Exception e){System.exit(1);}
        g.drawImage(image,0,0,image.getWidth(this),image.getHeight(this), this);
        try{Thread.sleep(50);}catch(Exception e){}}catch(Exception e){}
        //seta os blocos de 1024
        q = new quadro[17];
        q[0] = new quadro(61,71,1024);
        q[1] = new quadro();
        q[1].x = 161;
        q[1].y = 71;
        q[1].valor = 1024;
        q[1].generate_color();
        this.num =2;
    }
    
    //abre diversas janelas no jogo e as fecha, após isso reseta o jogo
    public void gold_experience_requiem(Graphics g){
        int i;
        
        Frame[] f = new Frame[200];
        //gera os diversos frames
        for(i=0;i<100;i++){
            f[i]=new Frame();
            f[i].setSize(400, 400);
            f[i].setLocation(14*i, 4*i);
            f[i].setTitle("Wha_");
        }
        //coloca a imagem em cada um deles e os faz ficar viziveis
        for (i=0;i<100;i++){
            try{Thread.sleep(20);}catch(Exception e){}
            f[i].setVisible(true);
            try{Toolkit toolkit = Toolkit.getDefaultToolkit();
            MediaTracker tracker = new MediaTracker(f[i]);
            Image image = toolkit.getImage("diavolo.jpeg");
            tracker.addImage(image, 0);
            try{tracker.waitForAll();}catch(Exception e){System.exit(1);}
             Graphics g2 = f[i].getGraphics();
             g2.drawImage(image,0,0, f[i]);}
            catch(Exception e){}
        }
        //apaga todas as imagens e limpa esse vetor
        for (i=99;i>=0;i--){
        f[i].setVisible(false);
        }
        f = null;
        
    }
    
    //imprime a mensagem de vitoria
    public void win(Graphics g){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);
        Image image = toolkit.getImage("eric-final1.png");
        tracker.addImage(image, 0);
        try{tracker.waitForAll();}catch(Exception e){System.exit(1);}
        g.drawImage(image,100,100,image.getWidth(this),image.getHeight(this), this);
        Font stringFont = new Font("arial" ,Font.PLAIN, 42 );
        g.setFont(stringFont);
        g.drawString("You Win", 170, 260);
        stringFont = new Font("arial",Font.PLAIN,16);
        g.setFont(stringFont);
        g.drawString("Press r to restart", 180, 300);
    }
    
    //testa se existe algum movimento possivel, retornando true se tiver e false se nao tiver
    public boolean possible_moves(){
        int i;
        try{
            for(i = 0;i<q.length;i++){
                if(q[i].possible_move(q))
                    return true;
       
            } 
        }catch(Exception e){}
        return false;
    }
    //imprime a mensagem de derrota 
    public void lose(Graphics g){
        Font stringFont = new Font("arial" ,Font.PLAIN, 42 );
        g.setFont(stringFont);
        g.drawString("You lose", 170, 260);
        stringFont = new Font("arial",Font.PLAIN,16);
        g.setFont(stringFont);
        g.drawString("Press r to restart", 180, 300);
        g.drawString("Type \"kc\" to go straight to the last move",120,330);
    }
    
    
    public void keyPressed(KeyEvent e){
        
    }
    //reedireciona as entradas do teclado para os movimentos e para os easter eggs
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_W : 
            case KeyEvent.VK_UP:
                this.Update(1);
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                this.Update(2);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                this.Update(3);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                this.Update(4);
                break;
            case KeyEvent.VK_K:
                this.Update(5);
                break;
            case KeyEvent.VK_C:
                this.Update(6);
                break;
            case KeyEvent.VK_R:
                this.Update(7);
                break;
            case KeyEvent.VK_G:
                this.Update(8);
                break;
            case KeyEvent.VK_E:
                this.Update(9);
                break;
        }
    }
    
    public void keyTyped(KeyEvent e){
    
    }
    
    public void mouseExited(MouseEvent e){
        
    }
    
    public void mouseEntered(MouseEvent e){}
    
    //pega as posições em X e Y iniciais do mouse 
    public void mousePressed (MouseEvent e){
        this.xi = e.getX();
        this.yi = e.getY();
    }
    //pega as posições em X e Y finais do mouse e chama a função de arrasto do mouse
    public void mouseReleased(MouseEvent e){
        this.xf = e.getX();
        this.yf = e.getY();
        this.mousedragged();
    }
    
    public void mouseClicked(MouseEvent e){
    }
    
   
    //compara a diferença entre as posições iniciais e finais de X e Y, 
    //e calcula a direção, levando para o movimento adequado 
    public void mousedragged(){
                int dx = this.xf - this.xi;
                int dy = this.yf - this.yi;
                if(Math.abs(dx) > Math.abs(dy))
                    if(dx > 0)
                        this.Update(3);
                    else
                        this.Update(2);
                    else
                        if(dy>0)
                            this.Update(4);
                        else
                            this.Update(1);
                        
}}

//serve como molde para o quadro
abstract class Tile {
    int x,y,valor;
    abstract boolean collision(quadro[] q, int k, int num);
    abstract int slide(int x,quadro[]q,int num);
   
   
}


//quadro é o bloco ou a peça que esta sendo trabalhada
class quadro extends Tile {
    int x,y,valor;
    boolean merging;
    int num;
    Color c;
    boolean moved = false;
    boolean block_collided = false;
    
    public quadro(int x, int y,int valor) {
        this.x = x;
        this.y = y;
        this.valor=valor;
        this.merging = false;
        this.generate_color();
    }

    public quadro() {
        this.merging = false;
    }
   
    //de acordo com a direção verifica se há colisão entre os blocos
    //e se houver, verifica se eles podem se juntar(mergir)
    public boolean collision(quadro[] q,int k, int num){
        for(int i=0;i<this.num;i++){
            switch (k){
                case 0:
                    if(this.y == q[i].y +100 && this.x == q[i].x){
                        if(this.merging == false && this.valor == q[i].valor && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                       
                        return true;}
                    break;
                case 1:
                    if(this.x == q[i].x +100 && this.y == q[i].y){
                        if(this.valor == q[i].valor && !this.merging && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                        return true;}
                    break;
                   
                case 2:
                    if(this.x+100 == q[i].x && this.y == q[i].y){
                        if(this.valor == q[i].valor && !this.merging && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                        return true;}
                    break;
                case 3:
                    if(this.y+100 == q[i].y && this.x == q[i].x){
                        if(this.valor == q[i].valor && !this.merging && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                        return true;}
                    break;
           
            }
        }
        return false;}
                     
   
    //de acordo com a direção, movimenta todos os blocos 
    //naquela direção, até que haja uma colisão entre blocos ou se chegar na border
    public int slide(int x,quadro[] q,int num){
        this.num = num;
        switch(x){
            case 0:
                while(this.y>71 && !this.collision(q,0,this.num)){
                    this.y = this.y - 100;
                    this.moved = true;
                }
                return this.num;
            case 1:
                while(this.x>61 && !this.collision(q,1,this.num)){
                    this.x = this.x - 100;
                    this.moved = true;
                }
               
                return this.num;
            case 2:
                while(this.x<361&& !this.collision(q,2,this.num)){
                    this.x = this.x + 100;
                    this.moved = true;
                }
               
                return this.num;
            case 3:
                while(this.y<371 && !this.collision(q,3,this.num)){
                    this.y = this.y + 100;
                    this.moved = true;
                }
               
                return this.num;
               
        }
        return num;
    }
    //faz a união entre dois quadros
    public void merge(quadro[] q,int i,int num){
        this.valor = 2*this.valor;
        this.merging = true;
        for(;i<num;i++)
            q[i] = q[i+1];
        this.num --;
        this.generate_color();
        
    }
   
    //desenha os quadros
    public void draw(Graphics g){
       
        g.setColor(c);
        g.fillRect(this.x, this.y, 80, 80);
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, 80, 80);
        if(this.valor == 2 || this.valor == 4)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.WHITE);
        g.drawString("" + this.valor, this.x+40, this.y +40);
    }
   
    //gera as cores para os quadros
    public void generate_color(){
        switch(this.valor){
            case 2:
                this.c = Color.decode("#eee4da");
                break;
            case 4:
                this.c = Color.decode("#ede0c8");
                break;
            case 8:
                this.c = Color.decode("#f2b179");
                break;
            case 16:
                this.c = Color.decode("#f59563");
                break;
            case 32:
                this.c = Color.decode("#f67c5f");
                break;
            case 64:
                this.c = Color.decode("#f65e3b");
                break;
            case 128:
                this.c = Color.decode("#edcf72");
                break;
            case 256:
                this.c = Color.decode("#edcc61");
                break;
            case 512:
                this.c = Color.decode("#edc850");
                break;
            case 1024:
                this.c = Color.decode("#edc53f");
                break;
            case 2048:
                this.c = Color.decode("#edc22e");
                break;
       
       
        }
    }
   
    //realiza a animacao entre dois blocos juntando
    public void animate_merge(Graphics g){
        int k = 0;
        for(k=0;k<1000;k++){
            g.setColor(c);
            g.fillRect(this.x-5*k/500, this.y-5*k/500, 80 + 10*k/500, 80 + 10*k/500);
        }
        
       
    }
    
    //realiza a animação entre dois blocos colidindo
    public void animate_collision(Graphics g){
        int k = 0;
        for(k=k;k<250;k++){
            g.setColor(c);
            g.fillRect(this.x-10*k/250,this.y-10*k/250,80,80);
            g.setColor(Color.BLACK);
            g.drawRect(this.x-10*k/250,this.y-10*k/250,80,80);
            k++;
            g.setColor(c);
            g.fillRect(this.x+10*k/250,this.y+10*k/250,80,80);
            g.setColor(Color.BLACK);
            g.drawRect(this.x+10*k/250,this.y+10*k/250,80,80);
        }
    }
    
    //verifica se existe um movimento possivel 
    public boolean possible_move(quadro[] q){
        int i;
        try{
            for(i=0;i<q.length;i++){
                if(     (q[i].x == this.x && q[i].y == this.y+100 && q[i].valor == this.valor)||
                        (q[i].x == this.x && q[i].y == this.y-100 && q[i].valor == this.valor)||
                        (q[i].x == this.x-100 && q[i].y == this.y && q[i].valor == this.valor)||
                        (q[i].x == this.x+100 && q[i].y == this.y && q[i].valor == this.valor))
                    return true;
            }
        }catch(Exception e){}
        return false;
    }
}


class tile_background {
    public int x,y;
    //gera a posição dos blocos azul-claros
    public tile_background(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public tile_background() {
    }
    //verifica se é posivel colocar um bloco em cima do tile que está na posição(X,Y)   
    public boolean isopen(quadro[] q){
        try{
        for (int i=0;i<q.length;i++){
            if (q[i].x == this.x && q[i].y==this.y)
                return false;
        }
        }
        catch(Exception e){}
        return true;
    }  
}