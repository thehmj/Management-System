import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.lang.*;

class a {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/iiitv_management_system",
                    "root", "himanshu");
            Statement stmt = con.createStatement();

            JFrame f1 = new JFrame();
            Color cd = new Color(0,206,209);
            f1.getContentPane().setBackground(cd);
            ImageIcon icon = new ImageIcon("../DBMS/iiitv.png");
            f1.setIconImage(icon.getImage());
            JLabel l1 = new JLabel("Indian Institute of Information Technology Vadodara");
            l1.setBounds(100,20,1200,60);
            l1.setFont(new Font("Verdana", Font.PLAIN, 40));
            JLabel ll = new JLabel();
            ImageIcon icon1 =  new ImageIcon("../DBMS/abc.png");
            ll.setBounds(30,20,50,50);
            ll.setIcon(icon1);

            JButton b1 = new JButton("Department");
            JButton b2 = new JButton("Courses");
            JButton b3 = new JButton("Student");
            JButton b4 = new JButton("Enroll_Courses");
            JButton b5 = new JButton("Theory_Courses");
            JButton b6 = new JButton("Lab_Courses");
            JButton b7 = new JButton("Faculty");
            JButton b8 = new JButton("TA");
            b1.setBounds(300, 150, 200, 40);
            b2.setBounds(300, 220, 200, 40);
            b3.setBounds(300, 290, 200, 40);
            b4.setBounds(300, 360, 200, 40);
            b5.setBounds(550, 150, 200, 40);
            b6.setBounds(550, 220, 200, 40);
            b7.setBounds(550, 290, 200, 40);
            b8.setBounds(550, 360, 200, 40);
            f1.add(b1);
            f1.add(b2);
            f1.add(b3);
            f1.add(b4);
            f1.add(b5);
            f1.add(b6);
            f1.add(b7);
            f1.add(b8);
            f1.add(l1);
            f1.add(ll);
            f1.setSize(1200,800);
            f1.setLayout(null);
            f1.setVisible(true);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f10 = new JFrame();
                    Color cde = new Color(0,206,209);
                    f10.getContentPane().setBackground(cde);

                    f10.setSize(1000,1000);
                    f10.setLayout(null);

                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                        JLabel x = new JLabel("Department");
                        x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                        f10.add(x);
                        f10.add(b11);
                        f10.add(b12);
                        f10.add(b13);
                        f10.add(b14);
                        f10.setVisible(true);

                        b11.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    ResultSet rs1 = stmt.executeQuery("Select * From Department");
                                    ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                    int c1 = rsMetaData1.getColumnCount();
                                    String[][] data1 = new String[300][c1];
                                    String[] columns1 = new String[c1];
                                    for (int a = 0; a < c1; a++) {
                                        columns1[a] = rsMetaData1.getColumnName(a+1);
                                    }
                                    ResultSet cd = stmt.executeQuery("Select * From Department");
                                    int j1 = 0;
                                    while (cd.next()) {
                                        for (int i = 0; i < c1; i++) {
                                            data1[j1][i] = cd.getString(i + 1);
                                        }
                                        j1++;
                                    }
                                    DefaultTableModel model1 = new DefaultTableModel(data1,
                                            columns1);
                                    JTable table1 = new JTable(model1);
                                    table1.setShowGrid(false);
                                    table1.setShowVerticalLines(true);
                                   table1.setPreferredScrollableViewportSize(new Dimension(300,300));
                                    JScrollPane pane1 = new JScrollPane(table1);
                                    JFrame f3 = new JFrame();

                                    f3.getContentPane().setBackground(Color.white);
                                    JPanel panel1 = new JPanel();
                                    panel1.add(pane1);
                                    f3.add(panel1);
                                    f3.setSize(350, 300);
                                    f3.setVisible(true);
//                                    f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                }
                                catch(Exception e1){
                                    System.out.println(e1);
                                }
                            }
                        });
                        b12.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    ResultSet rs1 = stmt.executeQuery("Select * From Department");
                                    ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                    int c1 = rsMetaData1.getColumnCount();
                                    String[] columns1 = new String[c1];
                                    for (int a = 0; a < c1; a++) {
                                        columns1[a] = rsMetaData1.getColumnName(a+1);
                                    }
                                    JFrame f6 =new JFrame();
                                    f6.getContentPane().setBackground(cd);
                                    JLabel[] lx1 = new JLabel[c1];
                                    JTextField[] tff1 = new JTextField[c1];
                                    JButton sub1 = new JButton("Submit");
                                    for(int i=0;i<c1;i++){
                                        lx1[i]= new JLabel();
                                        tff1[i] = new JTextField();
                                        lx1[i].setText(columns1[i]);
                                        lx1[i].setBounds(100,(i+1)*100,200,40);
                                        tff1[i].setBounds(200,(i+1)*100,200,40);
                                        f6.add(lx1[i]);
                                        f6.add(tff1[i]);
                                    }
                                    sub1.setBounds(100,(c1+1)*100,200,40);
                                    f6.setSize(700, 500);
                                    f6.setVisible(false);
                                    f6.setLayout(null);
                                    f6.add(sub1);
//                                    f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    f6.setVisible(true);
                                    String[] ar1 = new String[c1];
                                    sub1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            for(int i=0;i<c1;i++){
                                                ar1[i]=tff1[i].getText();
                                            }
                                            String k= "";
                                            for(int i=0;i<c1;i++){
                                                ar1[i]="'"+ar1[i]+"'";
                                                k = k + ar1[i] + ",";
                                            }
                                            k = k.substring(0,(k.length() - 1));

                                            try {
                                                stmt.executeUpdate("Insert into Department values("
                                                        + k + ")");
                                                JOptionPane.showMessageDialog(f6,"Value inserted");
                                            }
                                            catch(Exception e2)
                                            {
                                                System.out.println(e2);
                                            }
                                        }
                                    });
                                }
                                catch(Exception e1){
                                    System.out.println(e1);
                                }
                            }
                        });
                        b13.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    ResultSet rs1 = stmt.executeQuery("Select * From Department");
                                    ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                    int c1 = rsMetaData1.getColumnCount();
                                    String[] columns1 = new String[c1];
                                    for (int a = 0; a < c1; a++) {
                                        columns1[a] = rsMetaData1.getColumnName(a+1);
                                    }
                                    JFrame f8 = new JFrame();
                                    f8.getContentPane().setBackground(cd);
                                    JLabel l1 = new JLabel();
                                    l1.setText(columns1[0]);
                                    l1.setBounds(100, 100, 200, 40);
                                    JTextField t = new JTextField();
                                    t.setBounds(200, 100, 200, 40);
                                    JButton sub = new JButton("Submit");
                                    sub.setBounds(150,200,200,40);

                                    f8.setVisible(true);
                                    f8.setSize(500,500);
                                    f8.setLayout(null);
                                    f8.add(l1);
                                    f8.add(t);
                                    f8.add(sub);
                                    sub.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try{
                                                String l = t.getText();
                                                l = "'" + l + "'";
                                                stmt.executeUpdate("Delete From Department where " + columns1[0] + " = " + l);
                                                JOptionPane.showMessageDialog(f8,"Value deleted ");

                                            }
                                            catch(Exception e2){
                                                System.out.println(e2);
                                            }
                                        }
                                    });


                                }
                                catch(Exception e1){
                                    System.out.println(e1);
                                }
                            }
                        });
                        b14.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    ResultSet rs1 = stmt.executeQuery("Select * From Department");
                                    ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                    int c1 = rsMetaData1.getColumnCount();
                                    String[] columns1 = new String[c1];
                                    for (int a = 0; a < c1; a++) {
                                        columns1[a] = rsMetaData1.getColumnName(a+1);
                                    }
                                    JFrame f9 = new JFrame();
                                    f9.getContentPane().setBackground(cd);
                                    JLabel l3= new JLabel();
                                    l3.setText(columns1[0]);
                                    l3.setBounds(100, 100, 200, 40);
                                    JTextField t1 = new JTextField();
                                    t1.setBounds(200, 100, 200, 40);
                                    JLabel l4= new JLabel("Column name");
                                    l4.setBounds(100, 150, 200, 40);
                                    JTextField t2 = new JTextField();
                                    t2.setBounds(200, 150, 200, 40);
                                    JLabel l5= new JLabel("Enter value");
                                    l5.setBounds(100, 200, 200, 40);
                                    JTextField t3 = new JTextField();
                                    t3.setBounds(200, 200, 200, 40);
                                    JButton sub2 = new JButton("Submit");
                                    sub2.setBounds(100, 250, 200, 40);
                                    f9.setSize(1000,1000);
                                    f9.setVisible(true);
                                    f9.setLayout(null);
                                    f9.add(l3);
                                    f9.add(l4);
                                    f9.add(l5);
                                    f9.add(t1);
                                    f9.add(t2);
                                    f9.add(t3);
                                    f9.add(sub2);

                                    sub2.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try{
                                                String y = t3.getText();
                                                y = "'" + y + "'";
                                                String m = t2.getText();
                                                String p = t1.getText();
                                                p = "'" + p + "'";
                                                stmt.executeUpdate("Update Department Set " + m + " = " + y + " where " + columns1[0] + " = " + p);
                                                JOptionPane.showMessageDialog(f9,"Value Updated ");
                                            }
                                            catch (Exception e3){
                                                System.out.println(e3);
                                            }
                                        }
                                    });
                                }
                                catch(Exception e1)
                                {
                                    System.out.println(e1);
                                }
                            }
                        });

                }
            });
            b2.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("Courses");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From Courses");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;
                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                table1.setPreferredScrollableViewportSize(new Dimension(700,500));
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(750, 500);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*100,200,40);
                                    tff1[i].setBounds(200,(i+1)*100,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                sub1.setBounds(100,(c1+1)*100,200,40);
                                f6.setSize(700, 500);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into Courses values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[0]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From Courses where " + columns1[0] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[0]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update Courses Set " + m + " = " + y + " where " + columns1[0] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });
            b3.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("Students");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Students");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From Students");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;
                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                table1.setPreferredScrollableViewportSize(new Dimension(1100,700));
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(1150, 700);
                                table1.setRowHeight(30);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Students");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*50,200,40);
                                    tff1[i].setBounds(300,(i+1)*50,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                lx1[5].setText(columns1[5]+"(yyyy-mm-dd)");
                                sub1.setBounds(150,(c1+1)*55,200,40);
                                f6.setSize(1000, 1000);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into Students values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Students");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[2]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From Students where " + columns1[2] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Students");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[2]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update Students Set " + m + " = " + y + " where " + columns1[2] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });
            b4.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("Enroll courses");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Enroll_Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From Enroll_Courses");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;
                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                table1.setPreferredScrollableViewportSize(new Dimension(400,700));
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(450, 700);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Enroll_Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*100,200,40);
                                    tff1[i].setBounds(200,(i+1)*100,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                sub1.setBounds(100,(c1+1)*100,200,40);
                                f6.setSize(700, 500);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into Enroll_Courses values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Enroll_Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[0]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From Enroll_Courses where " + columns1[0] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Enroll_Courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[0]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update Enroll_Courses Set " + m + " = " + y + " where " + columns1[0] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });
            b5.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("Theory Courses");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Theory_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From Theory_courses");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;
                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                table1.setPreferredScrollableViewportSize(new Dimension(700,500));
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(750, 500);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Theory_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*100,200,40);
                                    tff1[i].setBounds(200,(i+1)*100,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                sub1.setBounds(100,(c1+1)*100,200,40);
                                f6.setSize(700, 500);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into Theory_courses values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Theory_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[0]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From Theory_courses where " + columns1[2] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Theory_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[0]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update Theory_courses Set " + m + " = " + y + " where " + columns1[2] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });
            b6.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("Lab Courses");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Lab_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From Lab_courses");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;
                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                table1.setPreferredScrollableViewportSize(new Dimension(700,500));
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(750, 500);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Lab_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*100,200,40);
                                    tff1[i].setBounds(200,(i+1)*100,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                sub1.setBounds(100,(c1+1)*100,200,40);
                                f6.setSize(700, 500);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into Lab_courses values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Lab_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[0]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From Lab_courses where " + columns1[0] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Lab_courses");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[0]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update Lab_courses Set " + m + " = " + y + " where " + columns1[0] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });
            b7.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("Faculty");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Faculty");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From Faculty");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;

                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                table1.setPreferredScrollableViewportSize(new Dimension(700,500));
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(750, 500);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Faculty");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*100,200,40);
                                    tff1[i].setBounds(200,(i+1)*100,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                sub1.setBounds(100,(c1+1)*100,200,40);
                                f6.setSize(700, 500);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into Faculty values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted ");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Faculty");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[2]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From Faculty where " + columns1[2] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted  ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From Faculty");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[2]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update Faculty Set " + m + " = " + y + " where " + columns1[2] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });
            b8.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f10 = new JFrame();
                    f10.getContentPane().setBackground(cd);
                    f10.setSize(1000,1000);
                    f10.setLayout(null);
                    JButton b11 = new JButton("Show data");
                    JButton b12 = new JButton("Add data");
                    JButton b13 = new JButton("Delete data");
                    JButton b14 = new JButton("Update data");
                    b11.setBounds(330, 150, 200, 40);
                    b12.setBounds(330, 220, 200, 40);
                    b13.setBounds(330, 290, 200, 40);
                    b14.setBounds(330, 360, 200, 40);
                    JLabel x = new JLabel("TA");
                    x.setBounds(330, 100, 200, 40);
                    x.setFont(new Font("Verdana", Font.PLAIN, 25));
                    f10.add(x);
                    f10.add(b11);
                    f10.add(b12);
                    f10.add(b13);
                    f10.add(b14);
                    f10.setVisible(true);

                    b11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From TA");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[][] data1 = new String[300][c1];
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                ResultSet cd = stmt.executeQuery("Select * From TA");
                                int j1 = 0;
                                while (cd.next()) {
                                    for (int i = 0; i < c1; i++) {
                                        data1[j1][i] = cd.getString(i + 1);
                                    }
                                    j1++;
                                }
                                DefaultTableModel model1 = new DefaultTableModel(data1,
                                        columns1);
                                JTable table1 = new JTable(model1);
                                table1.setShowGrid(false);
                                table1.setShowVerticalLines(true);
                                JScrollPane pane1 = new JScrollPane(table1);
                                JFrame f3 = new JFrame();
                                table1.setPreferredScrollableViewportSize(new Dimension(700,500));
//                                Color cde = new Color(0,206,209);
                                f3.getContentPane().setBackground(Color.white);
                                JPanel panel1 = new JPanel();
                                panel1.add(pane1);
                                f3.add(panel1);
                                f3.setSize(750, 500);
                                f3.setVisible(true);
//                                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From TA");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f6 =new JFrame();
                                f6.getContentPane().setBackground(cd);
                                JLabel[] lx1 = new JLabel[c1];
                                JTextField[] tff1 = new JTextField[c1];
                                JButton sub1 = new JButton("Submit");
                                for(int i=0;i<c1;i++){
                                    lx1[i]= new JLabel();
                                    tff1[i] = new JTextField();
                                    lx1[i].setText(columns1[i]);
                                    lx1[i].setBounds(100,(i+1)*100,200,40);
                                    tff1[i].setBounds(200,(i+1)*100,200,40);
                                    f6.add(lx1[i]);
                                    f6.add(tff1[i]);
                                }
                                sub1.setBounds(100,(c1+1)*100,200,40);
                                f6.setSize(700, 500);
                                f6.setVisible(false);
                                f6.setLayout(null);
                                f6.add(sub1);
//                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                                String[] ar1 = new String[c1];
                                sub1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for(int i=0;i<c1;i++){
                                            ar1[i]=tff1[i].getText();
                                        }
                                        String k= "";
                                        for(int i=0;i<c1;i++){
                                            ar1[i]="'"+ar1[i]+"'";
                                            k = k + ar1[i] + ",";
                                        }
                                        k = k.substring(0,(k.length() - 1));

                                        try {
                                            stmt.executeUpdate("Insert into TA values("
                                                    + k + ")");
                                            JOptionPane.showMessageDialog(f6,"Value inserted");
                                        }
                                        catch(Exception e2)
                                        {
                                            System.out.println(e2);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From TA");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f8 = new JFrame();
                                f8.getContentPane().setBackground(cd);
                                JLabel l1 = new JLabel();
                                l1.setText(columns1[0]);
                                l1.setBounds(100, 100, 200, 40);
                                JTextField t = new JTextField();
                                t.setBounds(200, 100, 200, 40);
                                JButton sub = new JButton("Submit");
                                sub.setBounds(150,200,200,40);

                                f8.setVisible(true);
                                f8.setSize(500,500);
                                f8.setLayout(null);
                                f8.add(l1);
                                f8.add(t);
                                f8.add(sub);
                                sub.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String l = t.getText();
                                            l = "'" + l + "'";
                                            stmt.executeUpdate("Delete From TA where " + columns1[0] + " = " + l);
                                            JOptionPane.showMessageDialog(f8,"Value deleted ");

                                        }
                                        catch(Exception e2){
                                            System.out.println(e2);
                                        }
                                    }
                                });


                            }
                            catch(Exception e1){
                                System.out.println(e1);
                            }
                        }
                    });
                    b14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ResultSet rs1 = stmt.executeQuery("Select * From TA");
                                ResultSetMetaData rsMetaData1 = rs1.getMetaData();
                                int c1 = rsMetaData1.getColumnCount();
                                String[] columns1 = new String[c1];
                                for (int a = 0; a < c1; a++) {
                                    columns1[a] = rsMetaData1.getColumnName(a+1);
                                }
                                JFrame f9 = new JFrame();
                                f9.getContentPane().setBackground(cd);
                                JLabel l3= new JLabel();
                                l3.setText(columns1[0]);
                                l3.setBounds(100, 100, 200, 40);
                                JTextField t1 = new JTextField();
                                t1.setBounds(200, 100, 200, 40);
                                JLabel l4= new JLabel("Column name");
                                l4.setBounds(100, 150, 200, 40);
                                JTextField t2 = new JTextField();
                                t2.setBounds(200, 150, 200, 40);
                                JLabel l5= new JLabel("Enter value");
                                l5.setBounds(100, 200, 200, 40);
                                JTextField t3 = new JTextField();
                                t3.setBounds(200, 200, 200, 40);
                                JButton sub2 = new JButton("Submit");
                                sub2.setBounds(100, 250, 200, 40);
                                f9.setSize(1000,1000);
                                f9.setVisible(true);
                                f9.setLayout(null);
                                f9.add(l3);
                                f9.add(l4);
                                f9.add(l5);
                                f9.add(t1);
                                f9.add(t2);
                                f9.add(t3);
                                f9.add(sub2);

                                sub2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try{
                                            String y = t3.getText();
                                            y = "'" + y + "'";
                                            String m = t2.getText();
                                            String p = t1.getText();
                                            p = "'" + p + "'";
                                            stmt.executeUpdate("Update TA Set " + m + " = " + y + " where " + columns1[0] + " = " + p);
                                            JOptionPane.showMessageDialog(f9,"Value Updated ");
                                        }
                                        catch (Exception e3){
                                            System.out.println(e3);
                                        }
                                    }
                                });
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e1);
                            }
                        }
                    });

                }
            });


            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

