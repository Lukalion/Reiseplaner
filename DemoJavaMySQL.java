import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Ansprechen einer MySQL-Datenbank aus einer Java-Anwendung
 * auf Basis der XAMPP-portable Version der HEMS
 * MySQL muss vor dem Programmlauf gestartet werden
 * dbname ist der Name der Datenbank, hier "test", 
 * alle Abfragen in den Beispielen beziehen sich auf die Tabelle "tperson" 
 * TODO SQL-Statements sollten an die Methoden �bergeben werden, nicht hard-codiert sein
 * @author Oppel
 */
public class DemoJavaMySQL {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  public ResultSet resultSet = null;
  private String stmt;
  
  private String dbname = "reiseplaner";     // <-- anpassen
  
  public DemoJavaMySQL() {
    
    /*
    // Verbindung zur Datenbank aufnehmen
    if (!this.connectToDB(dbname)) {
     System.out.println("Verbindung zur Datenbank \"" + dbname + "\" nicht möglich.");
     System.exit(1);
    } 
    System.out.println("Verbindung zur Datenbank \"" + dbname + "\" aufgenommen.");
    
    // Ausf?hren verschiedener SQL-Anweisungen
    System.out.println("\nAlle Informationen der Tabelle \"verlag\":");
    this.select("select max(KID) FROM kunde");
    this.outputResultSet(resultSet);  // Method to output result set
    /*
    System.out.println("\nEine Person mit Namen \"Becker\" einf?gen:");
    this.insert("insert into tperson (name) values ('Becker')");  
    
    // alle Personen auslesen, um zu sehen, ob insert geklappt hat
    this.select("select * from tperson");
    this.writeResultSet(resultSet);  // Method to output result set
    
    System.out.println("\nEinen Satz \"Becker\" in \"Mauer\" ?ndern:");
    this.update("update tperson set name = 'Mauer' where name ='Becker'");
    this.select("select * from tperson");
    this.writeResultSet(resultSet);
    
      System.out.println("\nAlle Personen, deren Namen mit \"M\" beginnt:");
    this.selectP("SELECT * from tperson where name like 'M%'");
    this.writeResultSet(resultSet);
    
    System.out.println("\nDen Satz \"Mauer\" l?schen:");
    this.delete("delete from tperson where name = 'Mauer'");
    this.select("select * from tperson");
    this.writeResultSet(resultSet);
    
    System.out.println("\nMan kann auch die Metadaten eines Ergebnisses ermitteln:");
    this.writeMetaData(resultSet);
    
    // Am Ende muss die Datenbank geschlossen werden 
    this.closeDB(); */
    
  }
  
  public void sbefehl(String b) throws Exception {
    
    if (!this.connectToDB(dbname)) {
       System.out.println("Verbindung zur Datenbank \"" + dbname + "\" nicht möglich.");
       System.exit(1);
      } 
      System.out.println("Verbindung zur Datenbank \"" + dbname + "\" aufgenommen.");
      
      // Ausf?hren verschiedener SQL-Anweisungen
     
      this.select(b);
      //this.outputResultSet(resultSet);
      
    
  }
  
public void ibefehl(String b) throws Exception{
    
    if (!this.connectToDB(dbname)) {
       System.out.println("Verbindung zur Datenbank \"" + dbname + "\" nicht möglich.");
       System.exit(1);
      } 
      System.out.println("Verbindung zur Datenbank \"" + dbname + "\" aufgenommen.");
      
      // Ausf?hren verschiedener SQL-Anweisungen
     
      this.insert(b);
      
     
    
  }

  /**
   * nimmt Verbindung zur Datenbank �ber den jdbc-Treiber auf
   * @param dbname Name der Datenbank
   * @return true wenn Verbindung aufgenommen wurde, andernfalls false
   * @throws Exception
   */
  public boolean connectToDB(String dbname) throws Exception{
    boolean connected = false;
      try {
        // load the MySQL driver, each DBMS has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB dbname on localhost
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/"+dbname);
        //      + "user=xyz&password=pw");  // only for defined users
        connected = true;
      } catch (Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
      return connected;
  }
        
  /**
   * Ausfuehren eines SELECT-Statements      
   * @throws Exception
   */
  public void select(String stmt) throws Exception{
    try {
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // result set gets the result of the SQL query
      resultSet = statement.executeQuery(stmt);     
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      } 
    }
  
  /**
   * Alternative mit prepared statement, ist performanter bei mehrfacher Ausfuehrung
   */
  public void selectP(String stmt) {
      try {       
        preparedStatement = connect.prepareStatement(stmt);
        resultSet = preparedStatement.executeQuery();
      } catch (Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        } 
      }
  
  /**
   * Ausfuehren eines INSERT-Statements     
   * @throws Exception
   */ 
  public void insert(String stmt) {
    try {
      statement = connect.createStatement();
      statement.executeUpdate(stmt);
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    } 
  }
  
  /**
   * Ausfuehren eines UPDATE-Statements      
   * @throws Exception
   */ 
  public void update(String stmt) {
    try {
      statement = connect.createStatement();
      // result set gets the result of the SQL query
      statement.executeUpdate(stmt);   // <-- anpassen
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    } 
  }
  
  /**
   * Ausfuehren eines DELETE-Statements   
   * @throws Exception
   */ 
  public void delete(String stmt) {
    try {
      statement = connect.createStatement();
      // result set gets the result of the SQL query
      statement.executeUpdate(stmt);   // <-- anpassen
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    } 
  }
      
  /**
   * liest die Metadaten, Tabellen- und alle Spalten-Namen aus dem result-set und zeigt sie an    
   * @param resultSet
   * @throws SQLException
   */
  private void writeMetaData(ResultSet resultSet) throws SQLException {
    // Now get some metadata from the database
    System.out.println("Tabelle: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Spalte " +i  + ": "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  /**
   * zeigt die S�tze des result-sets an
   * @param resultSet
   * @throws SQLException
   */
  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
   for (int i = 1; resultSet.next() i++) {
      resultSet.
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getString(2);
      System.out.println(resultSet.getString(i));
      
    }
  }
  
  public void outputResultSet(ResultSet resultSet) throws SQLException {
   int lang = 0;
   boolean info = true;
   int[] laengen = new int[resultSet.getMetaData().getColumnCount()];
   try {
     resultSet.first();
     resultSet.getString(1);
   }
   catch(Exception e) {
     info = false;
     System.out.print("Erstellte Spalten: ");
   }
  
    for (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++) {
      lang = resultSet.getMetaData().getColumnName(i).length();
      try {
          if (resultSet.getString(i).length() > lang) {
            lang = resultSet.getString(i).length();
          }
          }
          catch(Exception e) {
            if (4 > lang) {
            lang = 4;//resultSet.getString(i).length();
          }
            }
        while(resultSet.next()) {
          try {
          if (resultSet.getString(i).length() > lang) {
            lang = resultSet.getString(i).length();
          }
          }
          catch(Exception e) {
            if (4 > lang) {
            lang = 4;//resultSet.getString(i).length();
          }
            }
        }
        resultSet.first();
        laengen[i-1] = lang;
        
    }
    /*
    for(int i = 0; i < laengen.length; i++) {
      System.out.println(laengen[i]);
    } */
      for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
        System.out.print(resultSet.getMetaData().getColumnName(i));
        for (int j = 0; j < laengen[i-1]+1-resultSet.getMetaData().getColumnName(i).length(); j++) {
            System.out.print(" ");
          }
      }
      if(info == false) {
        System.out.println("\n!Keine Daten gespeichert!");
      }
      else {
        System.out.println(); 
      }
      
      resultSet.first(); 
      if(info == true) {
        
      
      for (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++) {
        System.out.print(resultSet.getString(i));
        try {
        for (int j = 0; j < laengen[i-1]+1-resultSet.getString(i).length(); j++) {
          System.out.print(" ");
        }
        }
        catch(Exception e) {
          for (int j = 0; j < laengen[i-1]+1-4; j++) {
            System.out.print(" ");
          }
        }
      
  }
  System.out.println();
      while(resultSet.next()) {
    for (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++) {
          System.out.print(resultSet.getString(i) );
          try {
          for (int j = 0; j < laengen[i-1]+1-resultSet.getString(i).length(); j++) {
            System.out.print(" ");
          }
          }
          catch(Exception e) {
            for (int j = 0; j < laengen[i-1]+1-4; j++) {
              System.out.print(" ");
            }
          }
        
    }
    System.out.println();
    }
      }  
    }
  

 /**
  * schlie�t die Datenbank
  */
  public void closeDB() throws Exception {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
    System.out.println("Verbindung zur Datenbank \"" + dbname + "\" geschlossen.");
  }
  /*
  public static void main(String[] args) throws Exception {
      new DemoJavaMySQL();
    } */
} 
  