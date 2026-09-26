/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehangman;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Maryam
 */
public class Board extends javax.swing.JFrame {

    String category;
    String userName;
    static char[] guessWord;
    String correctWord;
    String incompWord; 
    Integer val1=null;
    Integer val2=null;
    Integer val3=null;
    Integer val4=null;
    Integer miss;
    int wrongGuess=0;
   int Score=0;
    public Board(String name,String cat,String word) {
        //connect to database and get highestscore(missing)****
        userName=name;
        category=cat;
        correctWord=word;
        System.out.print("board="+userName);
        int size=correctWord.length();
        guessWord=new char[size];
        for(int i=0;i<size;i++)
        {
            guessWord[i]=correctWord.charAt(i);
        }
        System.out.println(guessWord);
        Random gen=new Random();
        do{
         miss=gen.nextInt(size);
        }while(miss==0|| miss>4);//missing letters cant be 0 or more than 4
        for(int i=0;i<miss;i++)
        {
          int x=gen.nextInt(size);
          guessWord[x]='_';
          if (val1==null)
              val1=x;
          else if(val2==null)
              val2=x;
          else if(val3==null)
              val3=x;
          else if(val4==null)
              val4=x;
        }
        System.out.println("board");
        System.out.println(guessWord);
        incompWord=String.copyValueOf(guessWord);
        System.out.println(incompWord);
        //restoring actual word in array
        for(int i=0;i<size;i++)
        {
            guessWord[i]=correctWord.charAt(i);
        }
        System.out.println(guessWord);
        initComponents();
        guessword.setText(incompWord.trim());
        String val=String.valueOf(Score);
        score.setText(val);
        figure1.setVisible(false);
        figure2.setVisible(false);
        figure3.setVisible(false);
        figure4.setVisible(false);
        figure5.setVisible(false);
        figure6.setVisible(false);
        figure7.setVisible(false);
        
        
        //score
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/game";
            String user="root";
            String password="";
            Connection con=DriverManager.getConnection(url,user,password);
            System.out.println("connection established");
            String query="SELECT max(Scores) as res from scoretable;";
            Statement stat=con.createStatement();
            ResultSet result=stat.executeQuery(query);
            System.out.println("query");
            int value;
            String high=" ";
            if(result.next())
            {
                value=result.getInt(1);
                high =String.valueOf(value);
            }
            System.out.println(high);
            
            String queryName="SELECT userName from scoretable where Scores=?";
            PreparedStatement pStat=con.prepareCall(queryName);
            pStat.setString(1, high);
            ResultSet resultName=pStat.executeQuery();
            String nameS=" ";
            if(resultName.next())
            {
                
                 nameS=resultName.getString("userName");
                 System.out.println(nameS);
            }
          
            highscore.setText(high);
           highName.setText(nameS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    void checkAlpha(char charachter)
    {
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        if(val1!=null)
        {
            if(guessWord[val1]==charachter)
            {
                arr[val1]=charachter;
                word=String.copyValueOf(arr);
                guessword.setText(word);
                String temp=score.getText().trim();
                int currentScore=Integer.valueOf(temp);
                currentScore++;
                temp=String.valueOf(currentScore);
                score.setText(temp);
                val1=null;
            }
        }
        if(val2!=null)
        {
            if(guessWord[val2]==charachter)
            {
                arr[val2]=charachter;
                word=String.copyValueOf(arr);
                guessword.setText(word);
                String temp=score.getText().trim();
                int currentScore=Integer.valueOf(temp);
                currentScore++;
                temp=String.valueOf(currentScore);
                score.setText(temp);
                val2=null;
            }
        }
        if(val3!=null)
        {
            if(guessWord[val3]==charachter)
            {
                arr[val3]=charachter;
                word=String.copyValueOf(arr);
                guessword.setText(word);
                String temp=score.getText().trim();
                int currentScore=Integer.valueOf(temp);
                currentScore++;
                temp=String.valueOf(currentScore);
                score.setText(temp);
                val3=null;
            }
        }
        if(val4!=null)
        {
            if(guessWord[val4]==charachter)
            {
                arr[val4]=charachter;
                word=String.copyValueOf(arr);
                guessword.setText(word);
                String temp=score.getText().trim();
                int currentScore=Integer.valueOf(temp);
                currentScore++;
                temp=String.valueOf(currentScore);
                score.setText(temp);
                val4=null;
            }
        }
        
    }
    void winCall()
    {
        System.out.println("win");
            String val=score.getText().trim();
            System.out.println("board:"+userName);
            WinScreen win=new WinScreen(userName,val);
            win.setTitle("HangMan Game");
            win.setSize(700,550);
            win.setVisible(true);
            this.dispose();
    }
    
    void incorrectCheck(char character,int wrongW)
    {
        int incorrect=0;
        if(val1!=null)
        {
            if(guessWord[val1]!=character)
            {
                incorrect++;
            }
        }
        if(val2!=null)
        {
            if(guessWord[val2]!=character)
            {
                incorrect++;
            }
        }
        if(val3!=null)
        {
            if(guessWord[val3]!=character)
            {
                incorrect++;
            }
        }
        if(val4!=null)
        {
            if(guessWord[val4]!=character)
            {
                incorrect++;
            }
        }
        if(incorrect==wrongW)
        {

            wrongGuess++;
            System.out.println("incorrect");
            switch (wrongGuess) {
                case 1:
                    figure1.setVisible(true);
                    break;
                case 2:
                    figure1.setVisible(false);
                    figure2.setVisible(true);
                    break;
                case 3:
                    figure1.setVisible(false);
                    figure2.setVisible(false);
                    figure3.setVisible(true);
                    break;
                case 4:
                    figure1.setVisible(false);
                    figure2.setVisible(false);
                    figure3.setVisible(false);
                    figure4.setVisible(true);
                    break;
                case 5:
                    figure1.setVisible(false);
                    figure2.setVisible(false);
                    figure3.setVisible(false);
                    figure4.setVisible(false);
                    figure5.setVisible(true);
                    break;
                case 6:
                    figure1.setVisible(false);
                    figure2.setVisible(false);
                    figure3.setVisible(false);
                    figure4.setVisible(false);
                    figure5.setVisible(false);
                    figure6.setVisible(true);
                    //lose screen
                    System.out.println("lost");
                    String val=score.getText().trim();
                    int num=Integer.parseInt(val);
                    LoseScreen lose= new LoseScreen(num,userName);
                    lose.setSize(710,550);
                    lose.setTitle("HangMan Game");
                    lose.setVisible(true);
                    this.dispose();
                    break;
                default:
                    break;
            }
        }
    }
    private Board() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        highscoreLabel = new javax.swing.JLabel();
        highName = new javax.swing.JTextField();
        highscore = new javax.swing.JTextField();
        keys = new javax.swing.JPanel();
        a = new javax.swing.JButton();
        b = new javax.swing.JButton();
        c = new javax.swing.JButton();
        d = new javax.swing.JButton();
        e = new javax.swing.JButton();
        f = new javax.swing.JButton();
        g = new javax.swing.JButton();
        h = new javax.swing.JButton();
        i = new javax.swing.JButton();
        j = new javax.swing.JButton();
        k = new javax.swing.JButton();
        l = new javax.swing.JButton();
        m = new javax.swing.JButton();
        n = new javax.swing.JButton();
        o = new javax.swing.JButton();
        p = new javax.swing.JButton();
        q = new javax.swing.JButton();
        r = new javax.swing.JButton();
        s = new javax.swing.JButton();
        t = new javax.swing.JButton();
        u = new javax.swing.JButton();
        v = new javax.swing.JButton();
        w = new javax.swing.JButton();
        x = new javax.swing.JButton();
        y = new javax.swing.JButton();
        z = new javax.swing.JButton();
        guessword = new javax.swing.JTextField();
        hint = new javax.swing.JButton();
        hintField = new javax.swing.JTextField();
        scoreLabel = new javax.swing.JLabel();
        score = new javax.swing.JTextField();
        figure1 = new javax.swing.JLabel();
        figure2 = new javax.swing.JLabel();
        figure3 = new javax.swing.JLabel();
        figure4 = new javax.swing.JLabel();
        figure5 = new javax.swing.JLabel();
        figure6 = new javax.swing.JLabel();
        figure7 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 102, 0));
        title.setText("       HANG MAN");
        getContentPane().add(title);
        title.setBounds(170, 0, 360, 70);

        username.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        username.setForeground(new java.awt.Color(102, 51, 0));
        username.setText("USERNAME");
        getContentPane().add(username);
        username.setBounds(500, 30, 80, 30);

        highscoreLabel.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        highscoreLabel.setForeground(new java.awt.Color(102, 51, 0));
        highscoreLabel.setText("HIGHEST SCORE");
        getContentPane().add(highscoreLabel);
        highscoreLabel.setBounds(470, 70, 120, 30);

        highName.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        highName.setForeground(new java.awt.Color(0, 102, 0));
        highName.setText("name");
        highName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highNameActionPerformed(evt);
            }
        });
        getContentPane().add(highName);
        highName.setBounds(590, 30, 90, 30);

        highscore.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        highscore.setForeground(new java.awt.Color(51, 153, 0));
        highscore.setText("0");
        highscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highscoreActionPerformed(evt);
            }
        });
        getContentPane().add(highscore);
        highscore.setBounds(590, 70, 50, 26);

        keys.setOpaque(false);
        keys.setLayout(null);

        a.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        a.setForeground(new java.awt.Color(255, 102, 102));
        a.setText("A");
        a.setContentAreaFilled(false);
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        keys.add(a);
        a.setBounds(10, 20, 60, 50);

        b.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        b.setForeground(new java.awt.Color(255, 102, 102));
        b.setText("B");
        b.setContentAreaFilled(false);
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        keys.add(b);
        b.setBounds(80, 20, 60, 50);

        c.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        c.setForeground(new java.awt.Color(255, 102, 102));
        c.setText("C");
        c.setContentAreaFilled(false);
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        keys.add(c);
        c.setBounds(150, 20, 60, 50);

        d.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        d.setForeground(new java.awt.Color(255, 102, 102));
        d.setText("D");
        d.setContentAreaFilled(false);
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });
        keys.add(d);
        d.setBounds(220, 20, 60, 50);

        e.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        e.setForeground(new java.awt.Color(255, 102, 102));
        e.setText("E");
        e.setContentAreaFilled(false);
        e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eActionPerformed(evt);
            }
        });
        keys.add(e);
        e.setBounds(290, 20, 60, 50);

        f.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        f.setForeground(new java.awt.Color(255, 102, 102));
        f.setText("F");
        f.setContentAreaFilled(false);
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });
        keys.add(f);
        f.setBounds(10, 80, 60, 50);

        g.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        g.setForeground(new java.awt.Color(255, 102, 102));
        g.setText("G");
        g.setContentAreaFilled(false);
        g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gActionPerformed(evt);
            }
        });
        keys.add(g);
        g.setBounds(80, 80, 60, 50);

        h.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        h.setForeground(new java.awt.Color(255, 102, 102));
        h.setText("H");
        h.setContentAreaFilled(false);
        h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hActionPerformed(evt);
            }
        });
        keys.add(h);
        h.setBounds(150, 80, 60, 50);

        i.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        i.setForeground(new java.awt.Color(255, 102, 102));
        i.setText("I");
        i.setContentAreaFilled(false);
        i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iActionPerformed(evt);
            }
        });
        keys.add(i);
        i.setBounds(220, 80, 60, 50);

        j.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        j.setForeground(new java.awt.Color(255, 102, 102));
        j.setText("J");
        j.setContentAreaFilled(false);
        j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActionPerformed(evt);
            }
        });
        keys.add(j);
        j.setBounds(290, 80, 60, 50);

        k.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        k.setForeground(new java.awt.Color(255, 102, 102));
        k.setText("K");
        k.setContentAreaFilled(false);
        k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kActionPerformed(evt);
            }
        });
        keys.add(k);
        k.setBounds(10, 140, 60, 50);

        l.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        l.setForeground(new java.awt.Color(255, 102, 102));
        l.setText("L");
        l.setContentAreaFilled(false);
        l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lActionPerformed(evt);
            }
        });
        keys.add(l);
        l.setBounds(80, 140, 60, 50);

        m.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        m.setForeground(new java.awt.Color(255, 102, 102));
        m.setText("M");
        m.setContentAreaFilled(false);
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });
        keys.add(m);
        m.setBounds(150, 140, 60, 50);

        n.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        n.setForeground(new java.awt.Color(255, 102, 102));
        n.setText("N");
        n.setContentAreaFilled(false);
        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });
        keys.add(n);
        n.setBounds(220, 140, 60, 50);

        o.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        o.setForeground(new java.awt.Color(255, 102, 102));
        o.setText("O");
        o.setContentAreaFilled(false);
        o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oActionPerformed(evt);
            }
        });
        keys.add(o);
        o.setBounds(290, 140, 60, 50);

        p.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        p.setForeground(new java.awt.Color(255, 102, 102));
        p.setText("P");
        p.setContentAreaFilled(false);
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        keys.add(p);
        p.setBounds(10, 200, 60, 50);

        q.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        q.setForeground(new java.awt.Color(255, 102, 102));
        q.setText("Q");
        q.setContentAreaFilled(false);
        q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qActionPerformed(evt);
            }
        });
        keys.add(q);
        q.setBounds(80, 200, 60, 50);

        r.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        r.setForeground(new java.awt.Color(255, 102, 102));
        r.setText("R");
        r.setContentAreaFilled(false);
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });
        keys.add(r);
        r.setBounds(150, 200, 60, 50);

        s.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        s.setForeground(new java.awt.Color(255, 102, 102));
        s.setText("S");
        s.setContentAreaFilled(false);
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });
        keys.add(s);
        s.setBounds(220, 200, 60, 50);

        t.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        t.setForeground(new java.awt.Color(255, 102, 102));
        t.setText("T");
        t.setContentAreaFilled(false);
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });
        keys.add(t);
        t.setBounds(290, 200, 60, 50);

        u.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        u.setForeground(new java.awt.Color(255, 102, 102));
        u.setText("U");
        u.setContentAreaFilled(false);
        u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uActionPerformed(evt);
            }
        });
        keys.add(u);
        u.setBounds(10, 260, 60, 50);

        v.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        v.setForeground(new java.awt.Color(255, 102, 102));
        v.setText("V");
        v.setContentAreaFilled(false);
        v.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vActionPerformed(evt);
            }
        });
        keys.add(v);
        v.setBounds(80, 260, 60, 50);

        w.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        w.setForeground(new java.awt.Color(255, 102, 102));
        w.setText("W");
        w.setContentAreaFilled(false);
        w.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wActionPerformed(evt);
            }
        });
        keys.add(w);
        w.setBounds(150, 260, 60, 50);

        x.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        x.setForeground(new java.awt.Color(255, 102, 102));
        x.setText("X");
        x.setContentAreaFilled(false);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });
        keys.add(x);
        x.setBounds(220, 260, 60, 50);

        y.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        y.setForeground(new java.awt.Color(255, 102, 102));
        y.setText("Y");
        y.setContentAreaFilled(false);
        y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yActionPerformed(evt);
            }
        });
        keys.add(y);
        y.setBounds(290, 260, 60, 50);

        z.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        z.setForeground(new java.awt.Color(255, 102, 102));
        z.setText("Z");
        z.setContentAreaFilled(false);
        z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zActionPerformed(evt);
            }
        });
        keys.add(z);
        z.setBounds(10, 320, 60, 50);

        guessword.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        guessword.setForeground(new java.awt.Color(255, 51, 51));
        guessword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        guessword.setText("GU--S W-RD");
        guessword.setBorder(null);
        guessword.setOpaque(false);
        guessword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guesswordActionPerformed(evt);
            }
        });
        keys.add(guessword);
        guessword.setBounds(10, 380, 220, 50);

        hint.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        hint.setForeground(new java.awt.Color(153, 102, 0));
        hint.setText("Hint");
        hint.setContentAreaFilled(false);
        hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintActionPerformed(evt);
            }
        });
        keys.add(hint);
        hint.setBounds(210, 380, 80, 40);

        hintField.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        hintField.setForeground(new java.awt.Color(0, 102, 0));
        hintField.setText("hint");
        keys.add(hintField);
        hintField.setBounds(290, 380, 60, 30);

        getContentPane().add(keys);
        keys.setBounds(30, 80, 390, 440);

        scoreLabel.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(0, 51, 51));
        scoreLabel.setText("SCORE");
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(450, 440, 100, 50);

        score.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        score.setForeground(new java.awt.Color(51, 153, 0));
        score.setText("0");
        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });
        getContentPane().add(score);
        score.setBounds(550, 450, 70, 36);

        figure1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man0.png"))); // NOI18N
        figure1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure1);
        figure1.setBounds(420, 120, 230, 310);

        figure2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man1.png"))); // NOI18N
        figure2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure2AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure2);
        figure2.setBounds(420, 120, 230, 310);

        figure3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man2.png"))); // NOI18N
        figure3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure3AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure3);
        figure3.setBounds(420, 120, 230, 310);

        figure4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man3.png"))); // NOI18N
        figure4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure4AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure4);
        figure4.setBounds(420, 120, 230, 310);

        figure5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man5.png"))); // NOI18N
        figure5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure5AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure5);
        figure5.setBounds(420, 120, 230, 310);

        figure6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man5.png"))); // NOI18N
        figure6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure6AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure6);
        figure6.setBounds(420, 120, 230, 310);

        figure7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man0.png"))); // NOI18N
        figure7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                figure7AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(figure7);
        figure7.setBounds(420, 120, 230, 310);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/34320wide.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 700, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void highscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highscoreActionPerformed
        
        
    }//GEN-LAST:event_highscoreActionPerformed

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreActionPerformed

    private void highNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highNameActionPerformed

    private void guesswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guesswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guesswordActionPerformed

    private void zActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('z');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
        if(val1==null && val2==null && val3==null && val4==null)
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('z',wrong);
        }
    }//GEN-LAST:event_zActionPerformed

    private void yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('y');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
        if(val1==null && val2==null && val3==null && val4==null)
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('y',wrong);
        }
    }//GEN-LAST:event_yActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        // TODO add your handling code here:
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('x');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
        if(val1==null && val2==null && val3==null && val4==null)
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('x',wrong);
        }
    }//GEN-LAST:event_xActionPerformed

    private void wActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wActionPerformed
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('w');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
        if(val1==null && val2==null && val3==null && val4==null)
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('w',wrong);
        }
    }//GEN-LAST:event_wActionPerformed

    private void vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('v');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('v',wrong);
        }
    }//GEN-LAST:event_vActionPerformed

    private void uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uActionPerformed
        // TODO add your handling code here:
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('u');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('u',wrong);
        }
    }//GEN-LAST:event_uActionPerformed

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('t');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('t',wrong);
        }
    }//GEN-LAST:event_tActionPerformed

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('s');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('s',wrong);
        }
    }//GEN-LAST:event_sActionPerformed

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('r');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('r',wrong);
        }
    }//GEN-LAST:event_rActionPerformed

    private void qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('q');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('q',wrong);
        }
    }//GEN-LAST:event_qActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('p');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('p',wrong);
        }
    }//GEN-LAST:event_pActionPerformed

    private void oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('o');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess
            this.incorrectCheck('o',wrong);
        }
    }//GEN-LAST:event_oActionPerformed

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('n');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('n',wrong);
        }
    }//GEN-LAST:event_nActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('m');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('m',wrong);
        }
    }//GEN-LAST:event_mActionPerformed

    private void lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('l');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('l',wrong);
        }
    }//GEN-LAST:event_lActionPerformed

    private void kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('k');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('k',wrong);
        }
    }//GEN-LAST:event_kActionPerformed

    private void jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('j');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('j',wrong);
        }
    }//GEN-LAST:event_jActionPerformed

    private void iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('i');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('i',wrong);
        }
    }//GEN-LAST:event_iActionPerformed

    private void hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hActionPerformed
        // TODO add your handling code here:
      String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('h');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('h',wrong);
        }
    }//GEN-LAST:event_hActionPerformed

    private void gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gActionPerformed
        // TODO add your handling code here:
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('g');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('g',wrong);
        }
    }//GEN-LAST:event_gActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('f');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('f',wrong);
        }
    }//GEN-LAST:event_fActionPerformed

    private void eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('e');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('e',wrong);
        }
    }//GEN-LAST:event_eActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
       String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('d');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('d',wrong);
        }
    }//GEN-LAST:event_dActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('c');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('c',wrong);
        }
    }//GEN-LAST:event_cActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('b');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('b',wrong);
        }
    }//GEN-LAST:event_bActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
        String word=guessword.getText().trim();
        int size=word.length();
        char[] arr=new char[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=word.charAt(i);
        }
        this.checkAlpha('a');
        //remaining guess check
        int wrong=0;
        for(int i=0;i<correctWord.length();i++)
        {
            if(arr[i]=='_')
                wrong++;
        }
      if(val1==null && val2==null && val3==null && val4==null)        
        {
           //win call
           this.winCall();
        }
        else{
            //wrong guess 
            this.incorrectCheck('a',wrong);
        }
       
    }//GEN-LAST:event_aActionPerformed

    private void hintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintActionPerformed
        // TODO add your handling code here:
        if(val4!=null)
        {
           char variable = guessWord[val4];
           String v1=String.valueOf(variable);
           hintField.setText(v1);
        }
        else if(val3!=null)
            {
           char variable = guessWord[val3];
           String v1=String.valueOf(variable);
           hintField.setText(v1);
        }
        else if(val2!=null)
            {
           char variable = guessWord[val2];
           String v1=String.valueOf(variable);
           hintField.setText(v1);
        }
        else if(val1!=null)
            {
           char variable = guessWord[val1];
           String v1=String.valueOf(variable);
           hintField.setText(v1);
        }
    }//GEN-LAST:event_hintActionPerformed

    private void figure6AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure6AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure6AncestorMoved

    private void figure5AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure5AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure5AncestorMoved

    private void figure4AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure4AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure4AncestorMoved

    private void figure3AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure3AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure3AncestorMoved

    private void figure2AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure2AncestorMoved

    private void figure1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure1AncestorMoved

    private void figure7AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_figure7AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_figure7AncestorMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JLabel background;
    private javax.swing.JButton c;
    private javax.swing.JButton d;
    private javax.swing.JButton e;
    private javax.swing.JButton f;
    private javax.swing.JLabel figure1;
    private javax.swing.JLabel figure2;
    private javax.swing.JLabel figure3;
    private javax.swing.JLabel figure4;
    private javax.swing.JLabel figure5;
    private javax.swing.JLabel figure6;
    private javax.swing.JLabel figure7;
    private javax.swing.JButton g;
    private javax.swing.JTextField guessword;
    private javax.swing.JButton h;
    private javax.swing.JTextField highName;
    private javax.swing.JTextField highscore;
    private javax.swing.JLabel highscoreLabel;
    private javax.swing.JButton hint;
    private javax.swing.JTextField hintField;
    private javax.swing.JButton i;
    private javax.swing.JButton j;
    private javax.swing.JButton k;
    private javax.swing.JPanel keys;
    private javax.swing.JButton l;
    private javax.swing.JButton m;
    private javax.swing.JButton n;
    private javax.swing.JButton o;
    private javax.swing.JButton p;
    private javax.swing.JButton q;
    private javax.swing.JButton r;
    private javax.swing.JButton s;
    private javax.swing.JTextField score;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton t;
    private javax.swing.JLabel title;
    private javax.swing.JButton u;
    private javax.swing.JLabel username;
    private javax.swing.JButton v;
    private javax.swing.JButton w;
    private javax.swing.JButton x;
    private javax.swing.JButton y;
    private javax.swing.JButton z;
    // End of variables declaration//GEN-END:variables
}
