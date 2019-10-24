package desenhar;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.json.JSONObject;
public class server extends janela{

    public server(){
        ServerSocket serv = null;
        
    }
    public void getMsg(janela jogo){
         Scanner s = null;
         String aux = null;
          String aux1 = null;
         JSONObject jsonObject;
         try {
            ServerSocket Servidor = new ServerSocket(80);
            
            while(true){
               //System.out.println(1);
                Socket C = Servidor.accept();
                s = new Scanner(C.getInputStream());
                aux = s.nextLine();
                //System.out.println(s.nextLine());
                 //System.out.println(s.nextLine());
                jsonObject = new JSONObject(aux);
                System.out.println(jsonObject.get("posicao"));
                aux1 = (String) jsonObject.get("posicao");
               
                if(aux1.equals("up")) jogo.Update(1); ;
                 
                if(aux1.equals("down")) jogo.Update(4);
                if(aux1.equals("left")) jogo.Update(2);
                if(aux1.equals("right")) jogo.Update(3);
                
                aux1 = null;
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         catch(Exception e){}
         
         
    }
}
