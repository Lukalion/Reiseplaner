import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {



  // Anfang Attribute
  public JLabel Ueberschrift = new JLabel();
  private JLabel Email = new JLabel();
  private JLabel Passwort = new JLabel();
  private JTextField Emailtextfeld = new JTextField();
  private JPasswordField Passworttextfeld = new JPasswordField();
  private JButton Anmelden = new JButton();
  private JButton regestrieren = new JButton();
  private DemoJavaMySQL datenbank;
  private JLabel regEmail = new JLabel();
  private JLabel regPasswort = new JLabel();
  private JLabel regPasswort1 = new JLabel();
  private JLabel regVorname = new JLabel();
  private JLabel regNachname = new JLabel();
  private JTextField regEmailText = new JTextField();
  private JPasswordField regPasswortText = new JPasswordField();
  private JPasswordField regPasswortText1 = new JPasswordField();
  private JTextField regVornameText = new JTextField();
  private JTextField regNachnameText = new JTextField();
  private JLabel regOeffentlich = new JLabel();
  private JCheckBox regOeffentlichCheck = new JCheckBox();
  private JButton regButton = new JButton();
  private JLabel bvEmail = new JLabel();
  private JLabel passwortZk = new JLabel();
  private JLabel passwortNi = new JLabel();
  private JLabel vornameE = new JLabel();
  private JLabel nachnameE = new JLabel();
  private JButton zurReg = new JButton();
  private JLabel anmeldenFalsch = new JLabel();
  private JButton seitenleisteButton = new JButton();
  private JButton einstellungsButton = new JButton();
  private JButton seitenleisteZurButton = new JButton();
  private JLabel seitenmenuStreifen = new JLabel();
  private JButton profilButton = new JButton();
  private JButton abmeldenButton = new JButton();
  private JTextField suchenText = new JTextField();
  private JButton suchenButton = new JButton();
  private JButton startseiteButton = new JButton();
  private JButton freundelisteButton = new JButton();
  private Nutzer nutzer;
  private JLabel profilEmail = new JLabel();
  private JLabel profilVorname = new JLabel();
  private JLabel profilNachname = new JLabel();
  private JLabel profilOeffentlich = new JLabel();
  private JCheckBox profilOeffentlichCB = new JCheckBox();
  private EmailSend emailsender = new EmailSend();
  private String bestaetigungscode = "";
  private JLabel emailregcode = new JLabel();
  private JTextField emailregcodeText = new JTextField();
  private JLabel emailregcodeE = new JLabel();
  private JButton bestaetigenreg = new JButton();
  private JLabel emailregtext = new JLabel();
  private String email = "";
  private String passwort = "";
  private String passwort1 = "";
  private String vorname = "";
  private String nachname = "";
  private boolean oeffentlich1;
  private JComboBox<String> freundeComboBox = new JComboBox<String>();
  private DefaultComboBoxModel<String> freundeComboBoxModel = new DefaultComboBoxModel<String>();
  private JButton freundebAuswahlen = new JButton();
  private int[] freundeArKID;
  private JLabel freundEmail = new JLabel();
  private JLabel freundVorname = new JLabel();
  private JLabel freundNachname = new JLabel();
  private JLabel freundOeffentlich = new JLabel();
  private JCheckBox freundOeffentlichCB = new JCheckBox();
  
  
  // Ende Attribute
  
  public GUI() { 
    super();
    //threadtest t = new threadtest(this);
    // Frame-Initialisierung
    datenbank = new DemoJavaMySQL();
    
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 900; 
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Reiseplaner");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    Ueberschrift.setBounds(375, 0, 200, 40);
    Ueberschrift.setText("Reiseplaner");
    Ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
    Ueberschrift.setHorizontalTextPosition(SwingConstants.CENTER);
    Ueberschrift.setFont(new Font("Dialog", Font.BOLD, 26));
    cp.add(Ueberschrift);
    emailregtext.setBounds(43, 184, 767, 25);
    emailregtext.setText("Bitte überprüfen sie ihr Postfach. E-Mail:   ");
    emailregtext.setForeground(Color.BLACK);
    emailregtext.setVisible(false);
    emailregtext.setFont(new Font("Dialog", Font.BOLD, 16));
    emailregtext.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(emailregtext);
    Email.setBounds(280, 160, 83, 33);
    Email.setText("E-Mail:");
    Email.setHorizontalAlignment(SwingConstants.RIGHT);
    Email.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(Email);
    Passwort.setBounds(280, 200, 83, 33);
    Passwort.setText("Passwort:");
    Passwort.setFont(new Font("Dialog", Font.BOLD, 16));
    Passwort.setHorizontalAlignment(SwingConstants.RIGHT);
    cp.add(Passwort);
    Emailtextfeld.setBounds(368, 160, 185, 33);
    Emailtextfeld.setVisible(true);
    cp.add(Emailtextfeld);
    Passworttextfeld.setBounds(368, 200, 185, 33);
    cp.add(Passworttextfeld);
    Anmelden.setBounds(464, 248, 89, 25);
    Anmelden.setText("Anmelden");
    Anmelden.setMargin(new Insets(2, 2, 2, 2));
    Anmelden.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Anmelden_ActionPerformed(evt);
      }
    });
    cp.add(Anmelden);
    regestrieren.setBounds(368, 248, 89, 25);
    regestrieren.setText("Registrieren");
    regestrieren.setMargin(new Insets(2, 2, 2, 2));
    regestrieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        regestrieren_ActionPerformed(evt);
      }
    });
    cp.add(regestrieren);
    regEmail.setBounds(168, 96, 180, 33);
    regEmail.setText("E-Mail:");
    regEmail.setHorizontalAlignment(SwingConstants.RIGHT);
    regEmail.setHorizontalTextPosition(SwingConstants.CENTER);
    regEmail.setFont(new Font("Dialog", Font.BOLD, 16));
    regEmail.setVisible(false);
    cp.add(regEmail);
    regPasswort.setBounds(168, 136, 180, 33);
    regPasswort.setText("Passwort:");
    regPasswort.setFont(new Font("Dialog", Font.BOLD, 16));
    regPasswort.setHorizontalAlignment(SwingConstants.RIGHT);
    regPasswort.setHorizontalTextPosition(SwingConstants.CENTER);
    regPasswort.setVisible(false);
    cp.add(regPasswort);
    regPasswort1.setBounds(168, 176, 180, 33);
    regPasswort1.setText("Passwort wiederholen:");
    regPasswort1.setFont(new Font("Dialog", Font.BOLD, 16));
    regPasswort1.setHorizontalAlignment(SwingConstants.RIGHT);
    regPasswort1.setHorizontalTextPosition(SwingConstants.CENTER);
    regPasswort1.setVisible(false);
    cp.add(regPasswort1);
    regVorname.setBounds(168, 216, 180, 33);
    regVorname.setText("Vorname:");
    regVorname.setFont(new Font("Dialog", Font.BOLD, 16));
    regVorname.setHorizontalAlignment(SwingConstants.RIGHT);
    regVorname.setHorizontalTextPosition(SwingConstants.CENTER);
    regVorname.setVisible(false);
    cp.add(regVorname);
    emailregcode.setBounds(40, 216, 308, 33);
    emailregcode.setText("Bestätigungscode:");
    emailregcode.setFont(new Font("Dialog", Font.BOLD, 16));
    emailregcode.setHorizontalAlignment(SwingConstants.RIGHT);
    emailregcode.setHorizontalTextPosition(SwingConstants.CENTER);
    emailregcode.setVisible(false);
    cp.add(emailregcode);
    regNachname.setBounds(168, 256, 180, 33);
    regNachname.setText("Nachname:");
    regNachname.setFont(new Font("Dialog", Font.BOLD, 16));
    regNachname.setHorizontalAlignment(SwingConstants.RIGHT);
    regNachname.setHorizontalTextPosition(SwingConstants.CENTER);
    regNachname.setVisible(false);
    cp.add(regNachname);
    regEmailText.setBounds(360, 96, 177, 33);
    regEmailText.setVisible(false);
    cp.add(regEmailText);
    regPasswortText.setBounds(360, 136, 177, 33);
    regPasswortText.setVisible(false);
    cp.add(regPasswortText);
    regPasswortText1.setBounds(360, 176, 177, 33);
    regPasswortText1.setVisible(false);
    cp.add(regPasswortText1);
    regVornameText.setBounds(360, 216, 177, 33);
    regVornameText.setVisible(false);
    cp.add(regVornameText);
    emailregcodeText.setBounds(360, 216, 177, 33);
    emailregcodeText.setVisible(false);
    cp.add(emailregcodeText);
    regNachnameText.setBounds(360, 256, 177, 33);
    regNachnameText.setVisible(false);
    cp.add(regNachnameText);
    regOeffentlich.setBounds(168, 296, 180, 33);
    regOeffentlich.setText("Öffentlich:");
    regOeffentlich.setFont(new Font("Dialog", Font.BOLD, 16));
    regOeffentlich.setHorizontalAlignment(SwingConstants.RIGHT);
    regOeffentlich.setHorizontalTextPosition(SwingConstants.CENTER);
    regOeffentlich.setVisible(false);
    cp.add(regOeffentlich);
    regOeffentlichCheck.setBounds(360, 296, 25, 33);
    regOeffentlichCheck.setText("");
    regOeffentlichCheck.setOpaque(false);
    regOeffentlichCheck.setVisible(false);
    cp.add(regOeffentlichCheck);
    regButton.setBounds(360, 352, 177, 49);
    regButton.setText("Registrieren");
    regButton.setMargin(new Insets(2, 2, 2, 2));
    regButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        regButton_ActionPerformed(evt);
      }
    });
    regButton.setFont(new Font("Dialog", Font.BOLD, 16));
    regButton.setVisible(false);
    cp.add(regButton);
    bvEmail.setBounds(544, 96, 171, 33);
    bvEmail.setText("E-Mail bereits vorhanden!");
    bvEmail.setVisible(false);
    bvEmail.setFont(new Font("Dialog", Font.BOLD, 12));
    bvEmail.setForeground(Color.RED);
    cp.add(bvEmail);
    passwortZk.setBounds(544, 136, 171, 33);
    passwortZk.setText("Passwort zu kurz!");
    passwortZk.setForeground(Color.RED);
    passwortZk.setVisible(false);
    cp.add(passwortZk);
    passwortNi.setBounds(544, 176, 171, 33);
    passwortNi.setText("Passwort nicht identisch!");
    passwortNi.setForeground(Color.RED);
    passwortNi.setVisible(false);
    cp.add(passwortNi);
    vornameE.setBounds(544, 216, 171, 33);
    vornameE.setText("Bitte Vornamen eingeben");
    vornameE.setForeground(Color.RED);
    vornameE.setVisible(false);
    cp.add(vornameE);
    nachnameE.setBounds(544, 256, 171, 33);
    nachnameE.setText("Bitte Nachnamen eingeben");
    nachnameE.setForeground(Color.RED);
    nachnameE.setVisible(false);
    cp.add(nachnameE);
    emailregcodeE.setBounds(544, 216, 171, 33);
    emailregcodeE.setText("Falscher Bestätigungscode!");
    emailregcodeE.setForeground(Color.RED);
    emailregcodeE.setVisible(false);
    cp.add(emailregcodeE);
    zurReg.setBounds(24, 24, 89, 41);
    zurReg.setText("Zurück");
    zurReg.setMargin(new Insets(2, 2, 2, 2));
    zurReg.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        zurReg_ActionPerformed(evt);
      }
    });
    zurReg.setVisible(false);
    zurReg.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(zurReg);
    anmeldenFalsch.setBounds(580, 178, 171, 33);
    anmeldenFalsch.setText("E-Mail oder Passwort falsch!");
    anmeldenFalsch.setForeground(Color.RED);
    anmeldenFalsch.setVisible(false);
    cp.add(anmeldenFalsch);
    bestaetigenreg.setBounds(360, 264, 177, 41);
    bestaetigenreg.setText("Bestätigen");
    bestaetigenreg.setMargin(new Insets(2, 2, 2, 2));
    bestaetigenreg.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bestaetigenreg_ActionPerformed(evt);
      }
    });
    bestaetigenreg.setVisible(false);
    bestaetigenreg.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(bestaetigenreg);
    this.profilButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.abmeldenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.Anmelden.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.profilButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.regButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.regestrieren.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.seitenleisteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.seitenleisteZurButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.zurReg.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.suchenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.regOeffentlichCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.bestaetigenreg.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.einstellungsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
   
    Image img =new ImageIcon(this.getClass().getResource("Zahnrad.jpg")).getImage();
    
    
    
    seitenleisteButton.setBounds(8, 8, 33, 33);
    seitenleisteButton.setText(">");
    seitenleisteButton.setMargin(new Insets(2, 2, 2, 2));
    seitenleisteButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        seitenleisteButton_ActionPerformed(evt);
      }
    });
    seitenleisteButton.setFont(new Font("Dialog", Font.BOLD, 18));
    seitenleisteButton.setVisible(false);
    cp.add(seitenleisteButton);
    this.einstellungsButton.setBounds(8, 45, 33, 33);
    einstellungsButton.setText("");
    einstellungsButton.setMargin(new Insets(2, 2, 2, 2));
    einstellungsButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        einstellungsButton_ActionPerformed(evt);
      }
    });
    einstellungsButton.setFont(new Font("Dialog", Font.BOLD, 18));
    einstellungsButton.setVisible(false);
    einstellungsButton.setIcon(new ImageIcon(img));
    cp.add(einstellungsButton);
    seitenleisteZurButton.setBounds(152, 8, 33, 33);
    seitenleisteZurButton.setText("<");
    seitenleisteZurButton.setMargin(new Insets(2, 2, 2, 2));
    seitenleisteZurButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        seitenleisteZurButton_ActionPerformed(evt);
      }
    });
    seitenleisteZurButton.setFont(new Font("Dialog", Font.BOLD, 18));
    seitenleisteZurButton.setVisible(false);
    cp.add(seitenleisteZurButton);
    seitenmenuStreifen.setBounds(136, -16, 2, 600);
    seitenmenuStreifen.setText("");
    seitenmenuStreifen.setBackground(new Color(0xC0C0C0));
    seitenmenuStreifen.setOpaque(true);
    seitenmenuStreifen.setVisible(false);
    cp.add(seitenmenuStreifen);
    profilButton.setBounds(0, 464, 137, 49);
    profilButton.setText("Profil");
    profilButton.setMargin(new Insets(2, 2, 2, 2));
    profilButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        profilButton_ActionPerformed(evt);
      }
    });
    profilButton.setHorizontalTextPosition(SwingConstants.CENTER);
    profilButton.setFont(new Font("Dialog", Font.BOLD, 16));
    profilButton.setBorderPainted(true);
    profilButton.setVisible(false);
    cp.add(profilButton);
    abmeldenButton.setBounds(0, 512, 137, 49);
    abmeldenButton.setText("Abmelden");
    abmeldenButton.setMargin(new Insets(2, 2, 2, 2));
    abmeldenButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        abmeldenButton_ActionPerformed(evt);
      }
    });
    abmeldenButton.setFont(new Font("Dialog", Font.BOLD, 16));
    abmeldenButton.setHorizontalTextPosition(SwingConstants.CENTER);
    abmeldenButton.setVisible(false);
    abmeldenButton.setBackground(Color.RED);
    cp.add(abmeldenButton);
    suchenText.setBounds(624, 8, 177, 25);
    cp.add(suchenText);
    suchenButton.setBounds(808, 8, 65, 25);
    suchenButton.setText("Suchen");
    suchenButton.setMargin(new Insets(2, 2, 2, 2));
    suchenButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        suchenButton_ActionPerformed(evt);
      }
    });
    suchenButton.setVisible(false);
    suchenButton.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(suchenButton);
    this.suchenText.setVisible(false);
    startseiteButton.setBounds(0, 0, 137, 49);
    startseiteButton.setText("Startseite");
    startseiteButton.setMargin(new Insets(2, 2, 2, 2));
    startseiteButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        startseiteButton_ActionPerformed(evt);
      }
    });
    startseiteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    startseiteButton.setFont(new Font("Dialog", Font.BOLD, 16));
    startseiteButton.setHorizontalTextPosition(SwingConstants.CENTER);
    startseiteButton.setVisible(false);
    cp.add(startseiteButton);
    freundelisteButton.setBounds(0, 49, 137, 49);
    freundelisteButton.setText("Freunde");
    freundelisteButton.setMargin(new Insets(2, 2, 2, 2));
    freundelisteButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        freundelisteButton_ActionPerformed(evt);
      }
    });
    freundelisteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    freundelisteButton.setFont(new Font("Dialog", Font.BOLD, 16));
    freundelisteButton.setHorizontalTextPosition(SwingConstants.CENTER);
    freundelisteButton.setVisible(false);
    cp.add(freundelisteButton);
    profilEmail.setBounds(184, 72, 347, 33);
    profilEmail.setText("");
    profilEmail.setFont(new Font("Dialog", Font.BOLD, 16));
    profilEmail.setVisible(false);
    cp.add(profilEmail);
    profilVorname.setBounds(184, 120, 347, 33);
    profilVorname.setText("");
    profilVorname.setFont(new Font("Dialog", Font.BOLD, 16));
    profilVorname.setVisible(false);
    cp.add(profilVorname);
    profilNachname.setBounds(184, 168, 347, 33);
    profilNachname.setText("");
    profilNachname.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(profilNachname);
    profilOeffentlich.setBounds(184, 216, 83, 33);
    profilOeffentlich.setText("Öffentlich:");
    profilOeffentlich.setFont(new Font("Dialog", Font.BOLD, 16));
    profilOeffentlich.setVisible(false);
    cp.add(profilOeffentlich);
    profilOeffentlichCB.setBounds(272, 216, 25, 33);
    profilOeffentlichCB.setText("");
    profilOeffentlichCB.setOpaque(false);
    profilOeffentlichCB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(profilOeffentlichCB);
    this.profilOeffentlichCB.setVisible(false);
    
    
    freundebAuswahlen.setBounds(584, 80, 129, 41);
    freundebAuswahlen.setText("Auswählen");
    freundebAuswahlen.setMargin(new Insets(2, 2, 2, 2));
    freundebAuswahlen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        freundebAuswahlen_ActionPerformed(evt);
      }
    });
    freundebAuswahlen.setVisible(false);
    freundebAuswahlen.setCursor(new Cursor(Cursor.HAND_CURSOR));
    freundebAuswahlen.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(freundebAuswahlen);
    freundeComboBox.setModel(freundeComboBoxModel);
    freundeComboBox.setBounds(224, 80, 345, 41);
    freundeComboBox.setVisible(false);
    freundeComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    freundeComboBox.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(freundeComboBox);
    freundEmail.setBounds(184, 168, 347, 33);
    freundEmail.setText("");
    freundEmail.setFont(new Font("Dialog", Font.BOLD, 16));
    freundEmail.setVisible(false);
    cp.add(freundEmail);
    freundVorname.setBounds(184, 216, 347, 33);
    freundVorname.setText("");
    freundVorname.setFont(new Font("Dialog", Font.BOLD, 16));
    freundVorname.setVisible(false);
    cp.add(freundVorname);
    freundNachname.setBounds(184, 264, 347, 33);
    freundNachname.setText("");
    freundNachname.setFont(new Font("Dialog", Font.BOLD, 16));
    freundNachname.setVisible(false);
    cp.add(freundNachname);
    freundOeffentlich.setBounds(184, 312, 83, 33);
    freundOeffentlich.setText("Öffentlich:");
    freundOeffentlich.setFont(new Font("Dialog", Font.BOLD, 16));
    freundOeffentlich.setVisible(false);
    cp.add(freundOeffentlich);
    freundOeffentlichCB.setBounds(272, 312, 25, 33);
    freundOeffentlichCB.setText("");
    freundOeffentlichCB.setOpaque(false);
    freundOeffentlichCB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    freundOeffentlichCB.setEnabled(false);
    freundOeffentlichCB.setVisible(false);
    cp.add(freundOeffentlichCB);
    
    // Ende Komponenten-------------------------------------------------------------------------
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  
  
  
  public void Anmelden_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    anmeldenFalsch.setVisible(false); 
    String email = Emailtextfeld.getText();
    String passw = Passworttextfeld.getText();
    int x = 0;
  try {
  this.datenbank.sbefehl("SELECT count(EMail) FROM kunde WHERE EMail = '"+email+"' and passwort = '"+passw+"'");
  this.datenbank.resultSet.first();
  x= this.datenbank.resultSet.getInt(1);
  
  }
  catch(Exception e){
  }
  if(x == 1) {
    anmeldenFalsch.setVisible(false);
    this.Email.setVisible(false);
      this.Passwort.setVisible(false);
      this.Emailtextfeld.setVisible(false);
      this.Passworttextfeld.setVisible(false);
      this.Anmelden.setVisible(false);
      this.regestrieren.setVisible(false);
      this.seitenleisteButton.setVisible(true);
      this.suchenText.setVisible(true);
      this.suchenButton.setVisible(true);
      this.einstellungsButton.setVisible(true);
      this.einstellungsButton.setLocation(8, 45);
      
      try {
        
      this.datenbank.sbefehl("select KID from kunde where EMail = '" + email + "'" ); 
      this.datenbank.resultSet.first();
    x= this.datenbank.resultSet.getInt(1);
    this.datenbank.sbefehl("select öffentlich from kunde where EMail = '" + email + "'" );  
    this.datenbank.resultSet.first();
    int o = this.datenbank.resultSet.getInt(1);
    this.nutzer = new Nutzer(x,email, o);
    this.datenbank.sbefehl("select Vorname from kunde where EMail = '" + email + "'" ); 
    this.datenbank.resultSet.first();
    String vorname = this.datenbank.resultSet.getString(1);
    this.nutzer.vorname = vorname;
    this.datenbank.sbefehl("select Nachname from kunde where EMail = '" + email + "'" );  
    this.datenbank.resultSet.first();
    String nachname = this.datenbank.resultSet.getString(1);
    this.nutzer.nachname = nachname;
      }
      catch(Exception e) {
        
      }
      
  }
  else {
    anmeldenFalsch.setVisible(true);  
  }
   
  } // end of Anmelden_ActionPerformed

  public void regestrieren_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    anmeldenFalsch.setVisible(false);
  this.Passworttextfeld.setText("");
  this.Emailtextfeld.setText("");
    this.Email.setVisible(false);
    this.Passwort.setVisible(false);
    this.Emailtextfeld.setVisible(false);
    this.Passworttextfeld.setVisible(false);
    this.Anmelden.setVisible(false);
    this.regestrieren.setVisible(false);
    this.regButton.setVisible(true);
    this.regEmail.setVisible(true);
    this.regEmailText.setVisible(true);
    this.regPasswort.setVisible(true);
    this.regPasswort1.setVisible(true);
    this.regPasswortText.setVisible(true);
    this.regPasswortText1.setVisible(true);
    this.regVorname.setVisible(true);
    this.regVornameText.setVisible(true);
    this.regNachname.setVisible(true);
    this.regNachnameText.setVisible(true);
    this.regOeffentlich.setVisible(true);
    this.regOeffentlichCheck.setVisible(true);
    zurReg.setVisible(true);
    
    
  } // end of regestrieren_ActionPerformed
  
  public void regButton_ActionPerformed(ActionEvent evt)  {
    
      // TODO hier Quelltext einfügen
    anmeldenFalsch.setVisible(false);
    this.bvEmail.setVisible(false);
    this.passwortZk.setVisible(false);
    this.passwortNi.setVisible(false);
    this.vornameE.setVisible(false);
    this.nachnameE.setVisible(false);
    this.email = this.regEmailText.getText();
    this.passwort = this.regPasswortText.getText();
    this.passwort1 = this.regPasswortText1.getText();
    this.vorname = this.regVornameText.getText();
    this.nachname = this.regNachnameText.getText();
    this.oeffentlich1 = this.regOeffentlichCheck.isSelected();
    int oeffentlich;
    if(oeffentlich1) {
      oeffentlich = 1;
    }
    else {
      oeffentlich = 0;
    }
    int pmail = 0;
    try {
    this.datenbank.sbefehl("SELECT count(EMail) FROM kunde WHERE EMail = '"+email+"'");
    this.datenbank.resultSet.first();
    pmail= this.datenbank.resultSet.getInt(1);
    }
    catch(Exception e){
    }
    if(email.length() != 0) {
    if(pmail == 0) {
    if(passwort.length() > 4) {
      if(passwort.equals(passwort1)) {
        if(vorname.length() != 0) {
          if(nachname.length() != 0) {
      /*try {
      
      this.datenbank.sbefehl("select max(KID) FROM kunde");
      this.datenbank.resultSet.first();
      int max= this.datenbank.resultSet.getInt(1);
      max++;
    
      //this.datenbank.ibefehl("insert into kunde values(" + max +",'" + vorname + "','" + nachname+"',"+oeffentlich+",'"+email+"','"+passwort+"',0)");
      //this.datenbank.closeDB();
      }
      catch(Exception e) {
      e.printStackTrace();  
      }*/
            this.bestaetigungscode = this.emailsender.sendEmail(this.regEmailText.getText());
            System.out.println(this.bestaetigungscode);
            boolean canconnect = this.emailsender.canconnect;
            if(canconnect) {
      this.regButton.setVisible(false);
        this.regEmail.setVisible(false);
        this.regEmailText.setVisible(false);
        this.regPasswort.setVisible(false);
        this.regPasswort1.setVisible(false);
        this.regPasswortText.setVisible(false);
        this.regPasswortText1.setVisible(false);
        this.regVorname.setVisible(false);
        this.emailregcode.setVisible(true);
        this.emailregcodeText.setVisible(true);
        this.bestaetigenreg.setVisible(true);
        this.regVornameText.setVisible(false);
        this.regNachname.setVisible(false);
        this.regNachnameText.setVisible(false);
        this.regOeffentlich.setVisible(false);
        this.regOeffentlichCheck.setVisible(false);
        
        this.emailregtext.setText(this.emailregtext.getText() + this.email);
        this.emailregtext.setVisible(true);
            }
            else {
              this.bvEmail.setText("E-Mail nicht vorhanden!");
              this.bvEmail.setVisible(true);  
            }
        
          
       
      
      //int max= this.datenbank.resultSet.getInt(1);
      
      //max++; 
      //this.regEmail.setText("test1");
      //this.datenbank.ibefehl("insert into kunde values(" + max +",'" + vorname + "','" + nachname+"',"+oeffentlich+",'"+email+"','"+passwort+"',0)");
          }
          else {
            this.nachnameE.setVisible(true);
          }
          }
        else {
          this.vornameE.setVisible(true); 
        }
        
        }
      else {
        this.passwortNi.setVisible(true); 
      }
      
    }
    else {
      this.passwortZk.setVisible(true);
      
    }
    }
    else {
      this.bvEmail.setText("E-Mail bereits vorhanden!");
      this.bvEmail.setVisible(true);  
    }
  }
  else {
    this.bvEmail.setText("E-Mail eingeben!");
    this.bvEmail.setVisible(true);  
    
  }
    
} // end of regButton_ActionPerformed

  public void zurReg_ActionPerformed(ActionEvent evt) {
      // TODO hier Quelltext einfügen
    this.regButton.setVisible(false);
      this.regEmail.setVisible(false);
      this.regEmailText.setVisible(false);
      this.regPasswort.setVisible(false);
      this.regPasswort1.setVisible(false);
      this.regPasswortText.setVisible(false);
      this.regPasswortText1.setVisible(false);
      this.regVorname.setVisible(false);
      this.regVornameText.setVisible(false);
      this.regNachname.setVisible(false);
      this.regNachnameText.setVisible(false);
      this.regOeffentlich.setVisible(false);
      this.regOeffentlichCheck.setVisible(false);
      zurReg.setVisible(false);
      this.Email.setVisible(true);
      this.Passwort.setVisible(true);
      this.Emailtextfeld.setVisible(true);
      this.Passworttextfeld.setVisible(true);
      this.Anmelden.setVisible(true);
      this.regestrieren.setVisible(true);
      this.bvEmail.setVisible(false);
      this.passwortZk.setVisible(false);
      this.passwortNi.setVisible(false);
      this.vornameE.setVisible(false);
      this.nachnameE.setVisible(false);
      this.regEmailText.setText("");
      this.regPasswortText.setText("");
      this.regPasswortText1.setText("");
      this.regVornameText.setText("");
      this.regNachnameText.setText("");
      this.regOeffentlichCheck.setSelected(false);
      this.emailregcodeE.setText("Falscher Bestätigungscode!");
      this.emailregcode.setVisible(false);
      this.emailregcodeE.setVisible(false);
      this.emailregcodeText.setVisible(false);
      this.emailregtext.setVisible(false);
      this.bestaetigenreg.setVisible(false);
    
    }// end of zurReg_ActionPerformed

public void seitenleisteButton_ActionPerformed(ActionEvent evt) {
      // TODO hier Quelltext einfügen
  this.seitenleisteButton.setVisible(false);
  this.einstellungsButton.setVisible(true);
  this.einstellungsButton.setLocation(152, 45);
  this.seitenleisteZurButton.setVisible(true);
  this.seitenmenuStreifen.setVisible(true);
  this.profilButton.setVisible(true);
  this.abmeldenButton.setVisible(true);
  this.startseiteButton.setVisible(true);
  this.freundelisteButton.setVisible(true);
    } // end of seitenleisteButton_ActionPerformed

public void seitenleisteZurButton_ActionPerformed(ActionEvent evt) {
      // TODO hier Quelltext einfügen
  this.seitenleisteButton.setVisible(true);
  this.einstellungsButton.setVisible(true);
  this.seitenleisteZurButton.setVisible(false);
  this.einstellungsButton.setLocation(8, 45);
  this.seitenmenuStreifen.setVisible(false);
  this.profilButton.setVisible(false);
  this.abmeldenButton.setVisible(false);
  this.startseiteButton.setVisible(false);
  this.freundelisteButton.setVisible(true);
  this.freundelisteButton.setVisible(false);
    } // end of seitenleisteZurButton_ActionPerformed

public void profilButton_ActionPerformed(ActionEvent evt) {
      // TODO hier Quelltext einfügen
  this.Ueberschrift.setText("Profil");
  this.seitenleisteButton.setVisible(true);
  this.einstellungsButton.setVisible(true);
  this.einstellungsButton.setLocation(8, 45);
  this.seitenleisteZurButton.setVisible(false);
  this.seitenmenuStreifen.setVisible(false);
  this.profilButton.setVisible(false);
  this.abmeldenButton.setVisible(false);
  this.startseiteButton.setVisible(true);
  this.startseiteButton.setVisible(false);
  this.freundelisteButton.setVisible(false);
  this.freundEmail.setVisible(false);
  this.freundVorname.setVisible(false);
  this.freundNachname.setVisible(false);
  this.freundOeffentlich.setVisible(false);
  this.freundOeffentlichCB.setVisible(false);
  try {
  this.freundeComboBox.setSelectedIndex(0);
  }
  catch(Exception e){
    
  }
  this.profilEmail.setVisible(true);
  this.profilVorname.setVisible(true);
  this.profilNachname.setVisible(true);
  this.profilEmail.setText("E-Mail: " + this.nutzer.email);
  this.profilVorname.setText("Vorname: " + this.nutzer.vorname);
  this.profilNachname.setText("Nachname: " + this.nutzer.nachname);
  this.profilOeffentlichCB.setVisible(true);
  this.profilOeffentlich.setVisible(true);
  this.freundebAuswahlen.setVisible(false);
  this.freundeComboBox.setVisible(false);
  boolean b = false;
  if(this.nutzer.oeffentlich == 1) {
    b = true;
  }
  this.profilOeffentlichCB.setSelected(b);
    } // end of profilButton_ActionPerformed

public void profilBeenden() {
  boolean b = this.profilOeffentlichCB.isSelected();
  int bi = 0;
  if(b) {
    bi = 1;
  }
  this.nutzer.oeffentlich = bi;
  System.out.println(b);
  System.out.println(bi);
  try {
    this.datenbank.update("update kunde set öffentlich = "+ bi +" where EMail ='"+this.nutzer.email+"'");
  }
  catch(Exception e){
    
  }
}

public void abmeldenButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  this.Anmelden.setVisible(true);
  this.freundebAuswahlen.setVisible(false);
  this.freundeComboBox.setVisible(false);
  this.Email.setVisible(true);
  this.Emailtextfeld.setVisible(true);
  this.Passwort.setVisible(true);
  this.Passworttextfeld.setVisible(true);
  this.regestrieren.setVisible(true);
  this.seitenleisteButton.setVisible(false);
  this.seitenleisteZurButton.setVisible(false);
  this.seitenmenuStreifen.setVisible(false);
  this.profilButton.setVisible(false);
  this.abmeldenButton.setVisible(false);
  einstellungsButton.setVisible(false);
  this.Emailtextfeld.setText("");
  this.Passworttextfeld.setText("");
  this.suchenText.setVisible(false);
  this.suchenButton.setVisible(false);
  this.suchenText.setText("");
  this.startseiteButton.setVisible(false);
  this.freundelisteButton.setVisible(false);
  this.freundEmail.setVisible(false);
  this.freundVorname.setVisible(false);
  this.freundNachname.setVisible(false);
  this.freundOeffentlich.setVisible(false);
  this.freundOeffentlichCB.setVisible(false);
  try {
    this.freundeComboBox.setSelectedIndex(0);
    }
    catch(Exception e){
      
    }
  this.Ueberschrift.setText("Reiseplaner");
  this.profilBeenden();
  this.nutzer = null;
  this.profilEmail.setVisible(false);
  this.profilVorname.setVisible(false);
  this.profilNachname.setVisible(false);
  this.profilOeffentlichCB.setVisible(false);
  this.profilOeffentlich.setVisible(false);
  this.freundeComboBox.removeAllItems();
  
  ;
  
  } // end of abmeldenButton_ActionPerformed
  
public void suchenButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of suchenButton_ActionPerformed

public void startseiteButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  
  this.Ueberschrift.setText("Reiseplaner");
  this.seitenleisteButton.setVisible(true);
  this.einstellungsButton.setVisible(true);
  this.einstellungsButton.setLocation(8, 45);
  this.seitenleisteZurButton.setVisible(false);
  this.seitenmenuStreifen.setVisible(false);
  this.profilButton.setVisible(false);
  this.abmeldenButton.setVisible(false);
  this.startseiteButton.setVisible(false);
  this.profilEmail.setVisible(false);
  this.profilVorname.setVisible(false);
  this.profilNachname.setVisible(false);
  this.profilOeffentlichCB.setVisible(false);
  this.profilOeffentlich.setVisible(false);
  this.freundelisteButton.setVisible(false);
  this.freundebAuswahlen.setVisible(false);
  this.freundeComboBox.setVisible(false);
  this.freundEmail.setVisible(false);
  this.freundVorname.setVisible(false);
  this.freundNachname.setVisible(false);
  this.freundOeffentlich.setVisible(false);
  this.freundOeffentlichCB.setVisible(false);
  try {
    this.freundeComboBox.setSelectedIndex(0);
    }
    catch(Exception e){
      
    }
  this.profilBeenden();
  } // end of startseiteButton_ActionPerformed

public void freundelisteButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  
  this.Ueberschrift.setText("Freunde");
  this.seitenleisteButton.setVisible(true);
  this.einstellungsButton.setVisible(true);
  this.einstellungsButton.setLocation(8, 45);
  this.seitenleisteZurButton.setVisible(false);
  this.seitenmenuStreifen.setVisible(false);
  this.profilButton.setVisible(false);
  this.abmeldenButton.setVisible(false);
  this.startseiteButton.setVisible(false);
  this.profilEmail.setVisible(false);
  this.profilVorname.setVisible(false);
  this.profilNachname.setVisible(false);
  this.profilOeffentlichCB.setVisible(false);
  this.profilOeffentlich.setVisible(false);
  this.freundelisteButton.setVisible(false);
  this.freundebAuswahlen.setVisible(true);
  this.freundeComboBox.setVisible(true);
  this.profilBeenden();
  int fa = 0;
  if(this.freundeComboBox.getItemCount() == 0) {
  try {
    
    this.datenbank.sbefehl("SELECT count(KID) FROM kundekunde WHERE KID = '"+ this.nutzer.ID +"' or KID2 = '"+this.nutzer.ID+"'");
    this.datenbank.resultSet.first();
    fa = this.datenbank.resultSet.getInt(1);
    
  }
  catch(Exception e) {
    
  }
  
  String[] freundeAr = new String [fa + 1];
  this.freundeArKID = new int[fa +1];
  
  try {
    
    
    this.datenbank.sbefehl("SELECT k.KID, Vorname, nachname from kunde as k, kundekunde as kk where kk.KID = " + this.nutzer.ID + " and kk.KID2 = k.KID OR kk.KID2 = " + this.nutzer.ID + " and kk.KID = k.KID");
    this.datenbank.resultSet.first();
    this.freundeComboBox.addItem("Freunde Auswählen");
    
    for(int i = 1; i <= fa; i++) {
      this.freundeArKID[i] = this.datenbank.resultSet.getInt(1);
      freundeAr[i] = this.datenbank.resultSet.getString(2) + " " + this.datenbank.resultSet.getString(3);
      this.datenbank.resultSet.next();
      this.freundeComboBox.addItem(freundeAr[i]);
    }
    
  }
  catch(Exception e){
    
  }
  
  
  } 
  } // end of freundelisteButton_ActionPerformed

public void bestaetigenreg_ActionPerformed(ActionEvent evt)  {
    System.out.println(this.bestaetigungscode);
    int max = 0;
    if(this.emailregcodeText.getText().equals(this.bestaetigungscode)) {
      try {
        
        this.datenbank.sbefehl("select max(KID) FROM kunde");
        this.datenbank.resultSet.first();
        max= this.datenbank.resultSet.getInt(1);
        max++;
      
        this.datenbank.ibefehl("insert into kunde values(" + max +",'" + this.vorname + "','" + this.nachname+"',"+this.oeffentlich1+",'"+this.email+"','"+this.passwort+"')");
        
        }
        catch(Exception e) {
        e.printStackTrace();  
        } 
      this.emailregcodeE.setText("Erfolgreich registriert");
      this.emailregcodeE.setVisible(true);
      int o = 0;
      if(this.oeffentlich1) {
        o = 1;
      }
      
      this.nutzer = new Nutzer(max, this.email, o);
      this.nutzer.vorname = this.vorname;
      this.nutzer.nachname = this.nachname;
      this.emailregcodeText.setText("");
      this.regButton.setVisible(false);
        this.regEmail.setVisible(false);
        this.regEmailText.setVisible(false);
        this.regPasswort.setVisible(false);
        this.regPasswort1.setVisible(false);
        this.regPasswortText.setVisible(false);
        this.regPasswortText1.setVisible(false);
        this.regVorname.setVisible(false);
        this.regVornameText.setVisible(false);
        this.regNachname.setVisible(false);
        this.regNachnameText.setVisible(false);
        this.regOeffentlich.setVisible(false);
        this.regOeffentlichCheck.setVisible(false);
        zurReg.setVisible(false);
        this.Email.setVisible(false);
        this.Passwort.setVisible(false);
        this.Emailtextfeld.setVisible(false);
        this.Passworttextfeld.setVisible(false);
        this.Anmelden.setVisible(false);
        this.regestrieren.setVisible(false);
        this.bvEmail.setVisible(false);
        this.passwortZk.setVisible(false);
        this.passwortNi.setVisible(false);
        this.vornameE.setVisible(false);
        this.nachnameE.setVisible(false);
        this.regEmailText.setText("");
        this.regPasswortText.setText("");
        this.regPasswortText1.setText("");
        this.regVornameText.setText("");
        this.regNachnameText.setText("");
        this.regOeffentlichCheck.setSelected(false);
        emailregcodeE.setText("Falscher Bestätigungscode!");
        this.emailregcode.setVisible(false);
        this.emailregcodeE.setVisible(false);
        this.emailregcodeText.setVisible(false);
        this.emailregtext.setVisible(false);
        this.bestaetigenreg.setVisible(false);
        this.seitenleisteButton.setVisible(true);
        this.einstellungsButton.setVisible(true);
        this.einstellungsButton.setLocation(8, 45);
        this.suchenText.setVisible(true);
        this.suchenButton.setVisible(true);
    }
    
    else {
      this.emailregcodeE.setVisible(true);
    }

}

public void freundebAuswahlen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    int auswahl = this.freundeComboBox.getSelectedIndex();
    if(auswahl != 0) {
    try {
      this.datenbank.sbefehl("SELECT Vorname, Nachname, EMail, öffentlich from kunde where KID = " + this.freundeArKID[auswahl] );
    this.datenbank.resultSet.first();
    String vornamefr = this.datenbank.resultSet.getString(1);
    String nachnamefr = this.datenbank.resultSet.getString(2);
    String emailfr = this.datenbank.resultSet.getString(3);
    int oefr = this.datenbank.resultSet.getInt(4);
    boolean b = false;
    if(oefr == 1) {
      b = true;
    }
    this.freundEmail.setVisible(true);
    this.freundVorname.setVisible(true);
    this.freundNachname.setVisible(true);
    this.freundOeffentlich.setVisible(true);
    this.freundOeffentlichCB.setVisible(true);
    this.freundEmail.setText("E-Mail: " + emailfr);
    this.freundNachname.setText("Nachname: " + nachnamefr);
    this.freundVorname.setText("Vorname: " + vornamefr);
    this.freundOeffentlichCB.setSelected(b);
    }
    catch(Exception e) {
      
    }
    }
    else {
      this.freundEmail.setVisible(false);
    this.freundVorname.setVisible(false);
    this.freundNachname.setVisible(false);
    this.freundOeffentlich.setVisible(false);
    this.freundOeffentlichCB.setVisible(false);
    
    }
      
  } // end of freundebAuswahlen_ActionPerformed

public void einstellungsButton_ActionPerformed(ActionEvent evt) {
  this.Ueberschrift.setText("Einstellungen");
  this.seitenleisteButton.setVisible(true);
  this.einstellungsButton.setVisible(true);
  this.einstellungsButton.setLocation(8, 45);
  this.seitenleisteZurButton.setVisible(false);
  this.seitenmenuStreifen.setVisible(false);
  this.profilButton.setVisible(false);
  this.abmeldenButton.setVisible(false);
  this.startseiteButton.setVisible(false);
  this.profilEmail.setVisible(false);
  this.profilVorname.setVisible(false);
  this.profilNachname.setVisible(false);
  this.profilOeffentlichCB.setVisible(false);
  this.profilOeffentlich.setVisible(false);
  this.freundelisteButton.setVisible(false);
  this.freundebAuswahlen.setVisible(false);
  this.freundeComboBox.setVisible(false);
  this.freundEmail.setVisible(false);
  this.freundVorname.setVisible(false);
  this.freundNachname.setVisible(false);
  this.freundOeffentlich.setVisible(false);
  this.freundOeffentlichCB.setVisible(false);
  try {
    this.freundeComboBox.setSelectedIndex(0);
    }
    catch(Exception e){
      
    }
  this.profilBeenden();
  
  
}

  // Ende Methoden
// end of class GUI
/*
  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
     new GUI();
  } */

}
