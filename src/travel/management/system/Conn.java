package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
     Connection c;
     Statement s;

     Conn() {
          try {
               c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "12345");
               s = c.createStatement();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}
