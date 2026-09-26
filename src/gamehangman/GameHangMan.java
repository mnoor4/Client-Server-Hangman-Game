package gamehangman;

public class GameHangMan {

    public static void main(String[] args) {
  
       // ServerSide server = new ServerSide();
       // server.start();
        //new ServerSide().start();
        Screen1 mainScreen=new Screen1();
        mainScreen.setTitle("HangMan Game");
        mainScreen.setSize(700,550);
        mainScreen.setVisible(true);        
    }
}
