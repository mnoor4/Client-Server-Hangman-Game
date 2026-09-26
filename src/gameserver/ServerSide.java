package gameserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;



public class ServerSide {
public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
    
       ServerSocket sersocket = new ServerSocket(1342);
        System.out.println("Server has started");
        Socket s = sersocket.accept();
        System.out.println("Socket created");
        Scanner in = new Scanner(s.getInputStream());
        String receivedMsg = in.next();
        System.out.println("category received = " + receivedMsg);
       
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/game";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);
        System.out.println("connection established");
        String query = "Select Data from datatable where Categories Like ?";
        PreparedStatement prestat =  con.prepareCall(query);
        prestat.setString(1,receivedMsg);
        ResultSet pResult=prestat.executeQuery(); 
        String requiredword[] = new String[100];
        int size=0;
        while(pResult.next())
        {
          requiredword[size++]= pResult.getString("Data"); 
          //System.out.println( requiredword );
        }
        Random generate =new Random();
        int  index = generate.nextInt(size);
      
        InputStream is;
        is = s.getInputStream();
        InputStreamReader isr= new InputStreamReader(is);
	BufferedReader br=new BufferedReader (isr);
        OutputStream os=s.getOutputStream();
	PrintWriter pw=new PrintWriter(os, true);
        String message = requiredword[index];
        String wordMessage= message.toLowerCase();
	System.out.println(wordMessage);
        pw.println(message);
       s.close();
     }    
}
