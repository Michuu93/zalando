package zalando;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import com.sun.glass.events.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * Klasa implementująca dodawanie i edytowanie produktów.
 */
public class Dodaj extends javax.swing.JFrame {
    /**
     * Tryb okna.
     */
    public enum Tryb {
        DODAWANIE, EDYTOWANIE
    }
    private int id;
    private Tryb tryb;
    private Produkt p;
    
    private Promocja oknoPromocja;
    private Calendar poczatekPromocji;
    private Calendar koniecPromocji;
    private boolean wPromocji;
    private float cena;
    private float rabat; 
    private float cenaPromocyjna; 

    private Border defaultBorder;
    
    /**
     * Konstrukor okna dla Obuwia.
     * @param ID wygenerowanerowane ID produktu.
     * @param o obiekt Obuwie.
     * @param tryb tryb okna.
     */
    public Dodaj(int ID, Obuwie o, Tryb tryb){
        this(ID, tryb);        
        this.p = o;
        jLabel1.setText("Obas:"); 
        jLabel2.setVisible(false);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Obuwie.Obcas.values()));
        jTextField1.setVisible(true);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        rozmiarComboBox.setVisible(false);
        jComboBox2.setVisible(false); 
        promocjaButton.setVisible(true);             
        if (tryb.equals(tryb.DODAWANIE)) setTitle("Dodaj obuwie");             
        else if (tryb.equals(tryb.EDYTOWANIE)){
            setTitle("Edytuj obuwie");
            wczytajCechyObuwie((Obuwie) p);
        }
    }
    
    /**
     * Konstruktor okna dla Spodni.
     * @param ID wygenerowanerowane ID produktu.
     * @param s obiekt Spodnie.
     * @param tryb tryb okna.
     */
    public Dodaj(int ID, Spodnie s, Tryb tryb){
        this(ID, tryb);
        this.p = s;
        jLabel1.setText("Długość:");
        jLabel2.setVisible(false);
        rozmiarComboBox.setVisible(false);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBox2.setVisible(false);
        promocjaButton.setVisible(true);            
        if (tryb.equals(tryb.DODAWANIE)) setTitle("Dodaj spodnie");             
        else if (tryb.equals(tryb.EDYTOWANIE)){
            setTitle("Edytuj spodnie");
            wczytajCechySpodnie((Spodnie) p);     
        }        
    }
    
    /**
     * Konstruktor okna dla T-Shirta.
     * @param ID wygenerowanerowane ID produktu.
     * @param t obiekt Tshirt.
     * @param tryb tryb okna.
     */
    public Dodaj(int ID, Tshirt t, Tryb tryb){
        this(ID, tryb);
        this.p = t;
        rozmiarComboBox.setModel(new javax.swing.DefaultComboBoxModel(Tshirt.RozmiarKoszuli.values()));    
        jLabel1.setVisible(false);                             
        jLabel2.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBox2.setVisible(false);   
        promocjaButton.setVisible(false);               
        if (tryb.equals(tryb.DODAWANIE)) setTitle("Dodaj T-shirt");             
        else if (tryb.equals(tryb.EDYTOWANIE)){
            setTitle("Edytuj T-shirt");
            wczytajCechyTshirt((Tshirt) p);     
        }
    }
    
    /**
     * Konstruktor okna dla koszuli Eleganckiej.
     * @param ID wygenerowanerowane ID produktu.
     * @param e obiekt Elegancka.
     * @param tryb tryb okna.
     */
    public Dodaj(int ID, Elegancka e, Tryb tryb){
        this(ID, tryb);
        this.p = e;
        rozmiarComboBox.setModel(new javax.swing.DefaultComboBoxModel(Koszula.RozmiarKoszuli.values()));
        jLabel1.setText("Krawat:");
        jLabel2.setText("Kołnierzyk:");  
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Elegancka.Krawat.values()));
        jComboBox2.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(true);
        promocjaButton.setVisible(false);
        if (tryb.equals(tryb.DODAWANIE)) setTitle("Dodaj koszulę");             
        else if (tryb.equals(tryb.EDYTOWANIE)){
            setTitle("Edytuj koszulę");
            wczytajCechyElegancka((Elegancka) p); 
        }         
    }
    
    /**
     * Konstruktor okna dla Kurtki.
     * @param ID wygenerowanerowane ID produktu.
     * @param k obiekt Kurtka.
     * @param tryb tryb okna.
     */
    public Dodaj(int ID, Kurtka k, Tryb tryb){
        this(ID, tryb);
        this.p = k;
        jLabel1.setText("Zapięcie:");                
        jLabel2.setText("Rodzaj:");   
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Kurtka.Zapiecie.values())); 
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(Kurtka.RodzajKurtki.values()));                
        rozmiarComboBox.setModel(new javax.swing.DefaultComboBoxModel(Kurtka.RozmiarKurtki.values()));  
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        promocjaButton.setVisible(false);                
        if (tryb.equals(tryb.DODAWANIE)) setTitle("Dodaj kurtkę");             
        else if (tryb.equals(tryb.EDYTOWANIE)){
            setTitle("Edytuj kurtkę");
            wczytajCechyKurtka((Kurtka) p);
        } 
    }    

    /**
     * Konstruktor okna wspólny dla wszystkich produktów.
     * @param ID wygenerowanerowane ID produktu.
     * @param tryb tryb okna.
     */
    public Dodaj(int ID, Tryb tryb) {
        this.id = ID;
        this.tryb = tryb; 
        this.poczatekPromocji = Calendar.getInstance();
        this.koniecPromocji = Calendar.getInstance();
        this.wPromocji = false;
        this.rabat = (float) 0.10;
        this.cenaPromocyjna = cena - (cena * rabat/100);
        
        initComponents();        
        setVisible(true);
      
        idField.setText(Integer.toString(id));        
        usunZdjecieButton.setVisible(false);
        defaultBorder = nazwaField.getBorder();
    }
    
    /**
     * Wspólna metoda dodawania produktu.
     */
    private void dodajProdukt(){  
        String nazwa = nazwaField.getText();
        cena = Float.parseFloat(cenaField.getText()); 
        cena = zaokraglijCene(cena);

        Produkt.Plec plec = (Produkt.Plec) plecComboBox.getSelectedItem();
        Produkt.Kolor kolor = (Produkt.Kolor) kolorComboBox.getSelectedItem();
        Produkt.Marka marka = (Produkt.Marka) markaComboBox.getSelectedItem();
        Produkt.Material material = (Produkt.Material) materialComboBox.getSelectedItem();
        
        if (p instanceof Obuwie) dodajObuwie(nazwa, plec, kolor, marka, material);
        if (p instanceof Spodnie) dodajSpodnie(nazwa, plec, kolor, marka, material);
        if (p instanceof Tshirt) dodajTshirt(nazwa, plec, kolor, marka, material);
        if (p instanceof Elegancka) dodajElegancka(nazwa, plec, kolor, marka, material);
        if (p instanceof Kurtka) dodajKurtka(nazwa, plec, kolor, marka, material);                 
    }

    /**
     * Metoda dodawania produktu Kurtka.
     * @param nazwa nazwa kurtki.
     * @param plec płeć dla jakiej rpzeznaczona ejst kurtka.
     * @param kolor kolor kurtki.
     * @param marka marka kurtki.
     * @param material materiał z jakiego wykonana ejst kurtka.
     */
    private void dodajKurtka(String nazwa, Produkt.Plec plec, Produkt.Kolor kolor, Produkt.Marka marka, Produkt.Material material) {
        Kurtka.RozmiarKurtki rozmiarKurtki = (Kurtka.RozmiarKurtki) rozmiarComboBox.getSelectedItem();
        Kurtka.Zapiecie zapiecie = (Kurtka.Zapiecie) jComboBox1.getSelectedItem();
        Kurtka.RodzajKurtki rodzajKurtki = (Kurtka.RodzajKurtki) jComboBox2.getSelectedItem();
        Kurtka k = new Kurtka(nazwa, cena, plec, kolor, marka, material, rozmiarKurtki, zapiecie, rodzajKurtki);
        Zalando.dodajProdukt(id, k);
        Zalando.dodajWiersz(id, "Kurtka", nazwa, cena, -1);
    }

    /**
     * Metoda dodawania produktu koszula Elegancka.
     * @param nazwa nazwa koszuli.
     * @param plec płeć dla jakiej przeznaczona jest koszula.
     * @param kolor kolor koszuli.
     * @param marka marka koszuli.
     * @param material materiał z jakiego wykonana jest koszula.
     */
    private void dodajElegancka(String nazwa, Produkt.Plec plec, Produkt.Kolor kolor, Produkt.Marka marka, Produkt.Material material) {
        Koszula.RozmiarKoszuli rozmiarKoszuli;
        rozmiarKoszuli = (Koszula.RozmiarKoszuli) rozmiarComboBox.getSelectedItem();
        int kolnierzyk =  Integer.parseInt(jTextField3.getText());
        Elegancka.Krawat krawat = (Elegancka.Krawat) jComboBox1.getSelectedItem();
        Elegancka e = new Elegancka(nazwa, cena, plec, kolnierzyk, krawat, kolor, marka, material, rozmiarKoszuli);
        Zalando.dodajProdukt(id, e);
        Zalando.dodajWiersz(id, "Koszula", nazwa, cena, -1);
    }

    /**
     * Metoda dodawania produktu Tshirt.
     * @param nazwa nazwa t-Shirta.
     * @param plec płeć dla jakiej przeznaczony jest t-Shirt.
     * @param kolor kolor t-Shirta.
     * @param marka marka t-Shirta.
     * @param material materiał z jakiego wykonany jest t-Shirt.
     */
    private void dodajTshirt(String nazwa, Produkt.Plec plec, Produkt.Kolor kolor, Produkt.Marka marka, Produkt.Material material) {
        Koszula.RozmiarKoszuli rozmiarKoszuli;
        rozmiarKoszuli = (Tshirt.RozmiarKoszuli) rozmiarComboBox.getSelectedItem();
        Tshirt t = new Tshirt(nazwa, cena, plec, kolor, marka, material, rozmiarKoszuli);
        Zalando.dodajProdukt(id, t);
        Zalando.dodajWiersz(id, "T-shirt", nazwa, cena, -1);
    }

    /**
     * Metoda dodawania produktu Spodnie.
     * @param nazwa nazwa spodni.
     * @param plec płeć dla jakiej przeznaczone są spodnie.
     * @param kolor kolor spodni.
     * @param marka marka spodni.
     * @param material materiał z jakiego wykonane są spodnie.
     */
    private void dodajSpodnie(String nazwa, Produkt.Plec plec, Produkt.Kolor kolor, Produkt.Marka marka, Produkt.Material material) {
        int rozmiar;
        rozmiar =  Integer.parseInt(jTextField1.getText());
        int dlugosc =  Integer.parseInt(jTextField2.getText());
        Spodnie s = new Spodnie(nazwa, cena, plec, rozmiar, dlugosc, kolor, marka, material);
        Zalando.dodajProdukt(id, s);
        s.setPoczatekPromocji(poczatekPromocji);
        s.setKoniecPromocji(koniecPromocji);
        s.setWPromocji(wPromocji);
        s.setRabat(rabat);
        s.setCenaPromocyjna(cenaPromocyjna);
        Zalando.dodajWiersz(id, "Spodnie", nazwa, cena, cenaPromocyjna);
    }

    /**
     * Metoda dodawania produktu Obuwie.
     * @param nazwa obuwia.
     * @param plec dla jakiej przeznaczone jest obuwie.
     * @param kolor kolor obuwia.
     * @param marka marka obuwia.
     * @param material materiał z jakiego wykonane jest obuwie.
     */
    private void dodajObuwie(String nazwa, Produkt.Plec plec, Produkt.Kolor kolor, Produkt.Marka marka, Produkt.Material material) {
        int rozmiar;
        rozmiar =  Integer.parseInt(jTextField1.getText());
        Obuwie.Obcas obcas = (Obuwie.Obcas) jComboBox1.getSelectedItem();
        Obuwie o = new Obuwie(nazwa, cena, plec, rozmiar, obcas, kolor, marka, material);
        Zalando.dodajProdukt(id, o);
        o.setPoczatekPromocji(poczatekPromocji);
        o.setKoniecPromocji(koniecPromocji);
        o.setWPromocji(wPromocji);
        o.setRabat(rabat);
        o.setCenaPromocyjna(cenaPromocyjna);
        Zalando.dodajWiersz(id, "Obuwie", nazwa, cena, cenaPromocyjna);
    }
    
    /**
     * Metoda wczytuje cechy produktu Obuwie.
     * @param o obiekt Obuwie.
     */
    private void wczytajCechyObuwie(Obuwie o){
        wczytajCechy(o);
        jTextField1.setText(Integer.toString(o.getRozmiar())); 
        jComboBox1.setSelectedItem(o.getObcas());                 
        poczatekPromocji = o.getPoczatekPromocji();
        koniecPromocji = o.getKoniecPromocji();
        wPromocji = o.getWPromocji();
        rabat = o.getRabat();
        cenaPromocyjna = o.getCenaPromocyjna();
    }
    
    /**
     * Metoda wczytuje cechy produktu Spodnie.
     * @param s obiekt Spodnie.
     */
    private void wczytajCechySpodnie(Spodnie s){
        wczytajCechy(s);
        jTextField1.setText(Integer.toString(s.getRozmiar()));
        jTextField2.setText(Integer.toString(s.getDlugosc())); 
        poczatekPromocji = s.getPoczatekPromocji();
        koniecPromocji = s.getKoniecPromocji();
        wPromocji = s.getWPromocji();
        rabat = s.getRabat();
        cenaPromocyjna = s.getCenaPromocyjna();
    }
    
    /**
     * Metoda wczytuje cechy produktu Tshirt.
     * @param t obiekt Tshirt.
     */
    private void wczytajCechyTshirt(Tshirt t){
        wczytajCechy(t);
        rozmiarComboBox.setSelectedItem(t.getRozmiar());
    }
    
    /**
     * Metoda wczytuje cechy produktu koszula Elegancka.
     * @param e obiekt Elegancka.
     */
    private void wczytajCechyElegancka(Elegancka e){
        wczytajCechy(e);
        rozmiarComboBox.setSelectedItem(e.getRozmiar());
        jTextField3.setText(Integer.toString(e.getKolnierzyk()));
        jComboBox1.setSelectedItem(e.getKrawat());
    }
    
    /**
     * Metoda wczytuje cechy produktu Kurtka.
     * @param k obiekt Kurtka.
     */
    private void wczytajCechyKurtka(Kurtka k){
        wczytajCechy(k);
        rozmiarComboBox.setSelectedItem(k.getRozmiar());
        jComboBox1.setSelectedItem(k.getZapiecie());
        jComboBox2.setSelectedItem(k.getRodzajKurtki());
    }
    
    /**
     * Wspólna metoda wczytywania cech produktu.
     */
    private void wczytajCechy(Produkt p){
        nazwaField.setText( p.getNazwa() );
        cena = p.getCena();        
        cenaField.setText(Float.toString(cena));
        cenaPromocyjna = cena - (cena * rabat/100);
        plecComboBox.setSelectedItem( p.getPlec() );
        kolorComboBox.setSelectedItem(p.getKolor());
        markaComboBox.setSelectedItem(p.getMarka());
        materialComboBox.setSelectedItem(p.getMaterial());
        
        //Wczytanie zdjęcia
        String sciezka = new File("").getAbsolutePath()+"/temp/"+id+".jpg";
        File file = new File(sciezka);        
        if (file.exists()){ 
            File imgFile = file;
            wyswietlZdjecie(imgFile);
            usunZdjecieButton.setVisible(true);
        }
    }
    
    /**
     * Wspólna metoda zapisywania zmian w edytowanym produkcie.
     */
    private void edytujProdukt(){    
        String nazwa = nazwaField.getText();
        cena = Float.parseFloat(cenaField.getText());
        cena = zaokraglijCene(cena);
        cenaPromocyjna = cena - (cena * rabat);
        cenaPromocyjna = zaokraglijCene(cenaPromocyjna);
        Produkt.Plec plec = (Produkt.Plec) plecComboBox.getSelectedItem();
        Produkt.Kolor kolor = (Produkt.Kolor) kolorComboBox.getSelectedItem();
        Produkt.Marka marka = (Produkt.Marka) markaComboBox.getSelectedItem();
        Produkt.Material material = (Produkt.Material) materialComboBox.getSelectedItem();  
        p = Zalando.getProdukty().get(id);        
        p.setNazwa(nazwa);
        p.setCena(cena);
        p.setPlec(plec);
        p.setKolor(kolor);
        p.setMarka(marka);
        p.setMaterial(material);        
        if (p instanceof Obuwie) edytujObuwie(nazwa, (Obuwie) p);
        if (p instanceof Spodnie) edytujSpodnie(nazwa, (Spodnie) p);
        if (p instanceof Tshirt) edytujTshirt(nazwa, (Tshirt) p);
        if (p instanceof Elegancka) edytujElegancka(nazwa, (Elegancka) p);
        if (p instanceof Kurtka) edytujKurtka(nazwa, (Kurtka) p);      
    }  

    /**
     * Metoda zapisuje zmiany w edytowanym produkcie Kurtka.
     * @param nazwa nazwa edytowanej kurtki.
     * @param k obiekt Kurtka.
     */
    private void edytujKurtka(String nazwa, Kurtka k) {
        k.setRozmiar((Kurtka.RozmiarKurtki) rozmiarComboBox.getSelectedItem());
        k.setZapiecie((Kurtka.Zapiecie) jComboBox1.getSelectedItem());
        k.setRodzajKurtki((Kurtka.RodzajKurtki) jComboBox2.getSelectedItem());
        Zalando.edytujWiersz(id, nazwa, cena, -1);
    }

    /**
     * Metoda zapisuje zmiany w edytowanym produkcie koszula Elegancka.
     * @param nazwa nazwa edytowanej koszuli eleganckiej.
     * @param e obiekt Elegancka.
     */
    private void edytujElegancka(String nazwa, Elegancka e) {
        e.setRozmiar((Koszula.RozmiarKoszuli) rozmiarComboBox.getSelectedItem());
        e.setKolnierzyk(Integer.parseInt(jTextField3.getText()));
        e.setKrawat((Elegancka.Krawat) jComboBox1.getSelectedItem());
        Zalando.edytujWiersz(id, nazwa, cena, -1);
    }

    /**
     * Metoda zapisuje zmiany w edytowanym produkcie Tshirt.
     * @param nazwa nazwa edytowanego t-shirta.
     * @param t obiekt Tshirt.
     */
    private void edytujTshirt(String nazwa, Tshirt t) {
        t.setRozmiar((Koszula.RozmiarKoszuli) rozmiarComboBox.getSelectedItem());
        Zalando.edytujWiersz(id, nazwa, cena, -1);
    }

    /**
     * Metoda zapisuje zmiany w edytowanym produkcie Spodnie.
     * @param nazwa nazwa spodni.
     * @param s obiekt Spodnie.
     */
    private void edytujSpodnie(String nazwa, Spodnie s) {
        s.setRozmiar(Integer.parseInt(jTextField1.getText()));
        s.setDlugosc(Integer.parseInt(jTextField2.getText()));
        s.setPoczatekPromocji(poczatekPromocji);
        s.setKoniecPromocji(koniecPromocji);
        s.setWPromocji(wPromocji);
        s.setRabat(rabat);
        s.setCenaPromocyjna(cenaPromocyjna);
        cenaPromocyjna = s.getCenaPromocyjna();
        Zalando.edytujWiersz(id, nazwa, cena, cenaPromocyjna);
    }

    /**
     * Metoda zapisuje zmiany w edytowanym produkcie Obuwie.
     * @param nazwa nazwa edytowanego obuwia.
     * @param o obiekt Obuwie.
     */
    private void edytujObuwie(String nazwa, Obuwie o) {
        o.setRozmiar(Integer.parseInt(jTextField1.getText()));
        o.setObcas( (Obuwie.Obcas) jComboBox1.getSelectedItem() );
        o.setPoczatekPromocji(poczatekPromocji);
        o.setKoniecPromocji(koniecPromocji);
        o.setWPromocji(wPromocji);
        o.setRabat(rabat);
        o.setCenaPromocyjna(cenaPromocyjna);
        cenaPromocyjna = o.getCenaPromocyjna();
        Zalando.edytujWiersz(id, nazwa, cena, cenaPromocyjna);
    }
    
    /**
     * Metoda zaokrągla cenę typu float do 2 miejsc po przecinku.
     * @param c cena do zaokrąglenia.
     * @return cena zaokrąglona do 2 miejsc po przecinku.
     */
    private static float zaokraglijCene (float c){
        c *= 100;
        c = Math.round(c);
        c /= 100;
        return c;
    }
    
    /**
     * Metoda kopiuje dodane zdjęcie do folderu tymczasowego nadając jako nazwę id produktu.
     * @param imgFile zdjęcie dodane do produktu.
     * @param id id produktu.
     */
    public static void kopiujZdjecie(File imgFile, int id){
        InputStream inStream;
        OutputStream outStream;
        try{
            String path = imgFile.getAbsolutePath();
            File afile = new File(path); 
            String sciezka = new File("").getAbsolutePath()+"/temp/";
            if (!new File(sciezka).exists()){
                new File(sciezka).mkdir();
            }
            File bfile = new File(sciezka+id+".jpg");       
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
            System.out.println("Zdjęcie zostało skopiowane do katalogu: " + bfile.getAbsolutePath());
        } catch(IOException e){
            System.err.println("Błąd kopiowania zdjęcia " + e);
        }
    }
    
    /**
     * Wyświetlenie dodanego zdjęcia po przeskalowaniu do rozmiaru label.
     * @param imgFile zdjęcie dodane do produktu.
     */
    private void wyswietlZdjecie(File imgFile){
        try {                  
                BufferedImage bi = ImageIO.read(imgFile);                 
                ImageIcon imageIcon = new ImageIcon(bi);               
                //Pobranie rozmiarów zdjęcia i imgLabel
                float wysokoscImg = imageIcon.getIconHeight();
                float szerokoscImg = imageIcon.getIconWidth();
                float wysokoscLabel = imgLabel.getHeight();
                float szerokoscLabel = imgLabel.getWidth();  
                //konwersja ImageIcon na Image
                Image image = imageIcon.getImage(); 
                //Skalowanie zdjęcia
                if (wysokoscImg >= szerokoscImg){ //jeżeli zdjęcie pionowe
                    float wspolczynnik = wysokoscImg / wysokoscLabel;
                    float tmpWysokosc = wysokoscLabel;
                    float tmpSzerokosc = szerokoscImg / wspolczynnik;
                    image = image.getScaledInstance((int)tmpSzerokosc, (int)tmpWysokosc, java.awt.Image.SCALE_SMOOTH);
                }
                else if (szerokoscImg > wysokoscImg){ //jeżeli zdjęcie poziome
                    float wspolczynnik = szerokoscImg / szerokoscLabel;
                    float tmpWysokosc = wysokoscImg / wspolczynnik;
                    float tmpSzerokosc = szerokoscLabel;                    
                    image = image.getScaledInstance((int)tmpSzerokosc, (int)tmpWysokosc, java.awt.Image.SCALE_SMOOTH);
                }   
                //Konwersja Image na ImageIcon
                imageIcon = new ImageIcon(image);
                imgLabel.setIcon(imageIcon);               
            } 
            catch (IOException e){ 
                System.err.println("Nie można wczytać zdjęcia!" + e);     
            } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileOpen = new javax.swing.JFileChooser();
        nazwaField = new javax.swing.JTextField();
        nazwaLabel = new javax.swing.JLabel();
        cenaField = new javax.swing.JTextField();
        cenaLabel = new javax.swing.JLabel();
        plecLabel = new javax.swing.JLabel();
        plecComboBox = new javax.swing.JComboBox();
        kolorLabel = new javax.swing.JLabel();
        kolorComboBox = new javax.swing.JComboBox();
        markaLabel = new javax.swing.JLabel();
        markaComboBox = new javax.swing.JComboBox();
        materialLabel = new javax.swing.JLabel();
        materialComboBox = new javax.swing.JComboBox();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        przegladajButton = new javax.swing.JButton();
        zdjecieLabel = new javax.swing.JLabel();
        rozmiarLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rozmiarComboBox = new javax.swing.JComboBox();
        zapiszButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        anulujButton = new javax.swing.JButton();
        usunZdjecieButton = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        promocjaButton = new javax.swing.JButton();

        jFileOpen.setAcceptAllFileFilterUsed(false);
        jFileOpen.setApproveButtonText("Open");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("dodajFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(330, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nazwaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nazwaFieldKeyReleased(evt);
            }
        });
        getContentPane().add(nazwaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 362, -1));

        nazwaLabel.setText("Nazwa:");
        getContentPane().add(nazwaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 44, -1, -1));

        cenaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cenaFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cenaFieldKeyTyped(evt);
            }
        });
        getContentPane().add(cenaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, -1));

        cenaLabel.setText("Cena:");
        getContentPane().add(cenaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 74, -1, -1));

        plecLabel.setText("Płeć:");
        getContentPane().add(plecLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 104, -1, -1));

        plecComboBox.setModel(new javax.swing.DefaultComboBoxModel(Produkt.Plec.values()));
        getContentPane().add(plecComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 100, -1));

        kolorLabel.setText("Kolor:");
        getContentPane().add(kolorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 134, -1, -1));

        kolorComboBox.setModel(new javax.swing.DefaultComboBoxModel(Produkt.Kolor.values()));
        getContentPane().add(kolorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, -1));

        markaLabel.setText("Marka:");
        getContentPane().add(markaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 164, -1, -1));

        markaComboBox.setModel(new javax.swing.DefaultComboBoxModel(Produkt.Marka.values()));
        getContentPane().add(markaComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 100, -1));

        materialLabel.setText("Materiał:");
        getContentPane().add(materialLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 194, -1, -1));

        materialComboBox.setModel(new javax.swing.DefaultComboBoxModel(Produkt.Material.values()));
        getContentPane().add(materialComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, -1));

        idLabel.setText("ID:");
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 15, -1, -1));

        idField.setEditable(false);
        idField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idField.setEnabled(false);
        getContentPane().add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, 80, -1));

        przegladajButton.setText("Przeglądaj");
        przegladajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przegladajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(przegladajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        zdjecieLabel.setText("Zdjęcie:");
        getContentPane().add(zdjecieLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 15, -1, -1));

        rozmiarLabel.setText("Rozmiar:");
        getContentPane().add(rozmiarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 224, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("label1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 254, 60, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("label2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 284, 60, -1));

        getContentPane().add(rozmiarComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 100, -1));

        zapiszButton.setText("Zapisz");
        zapiszButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zapiszButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 100, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Letnia", "Zimowa", "Jesienna" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 100, -1));

        anulujButton.setText("Anuluj");
        anulujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anulujButtonActionPerformed(evt);
            }
        });
        getContentPane().add(anulujButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        usunZdjecieButton.setText("x");
        usunZdjecieButton.setAlignmentY(0.0F);
        usunZdjecieButton.setBorderPainted(false);
        usunZdjecieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunZdjecieButtonActionPerformed(evt);
            }
        });
        getContentPane().add(usunZdjecieButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 278, 40, -1));

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 72, 250, 234));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 100, -1));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 100, -1));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 100, -1));

        promocjaButton.setText("Dodaj promocję");
        promocjaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promocjaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(promocjaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 278, 160, -1));

        setSize(new java.awt.Dimension(463, 353));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void przegladajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przegladajButtonActionPerformed
        // TODO add your handling code here:
        //Wczytywanie obrazka
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG files", "jpg");
        jFileOpen.setCurrentDirectory(new File("."));
        jFileOpen.setFileFilter(filter);
        jFileOpen.setDialogTitle("Wczytaj zdjęcie");    
        
        int odpowiedz = jFileOpen.showOpenDialog(this);
        if (odpowiedz == JFileChooser.APPROVE_OPTION) {
            File imgFile = jFileOpen.getSelectedFile(); 
            kopiujZdjecie(imgFile, id);
            wyswietlZdjecie(imgFile);
            usunZdjecieButton.setVisible(true);
        }     
    }//GEN-LAST:event_przegladajButtonActionPerformed

    private void zapiszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszButtonActionPerformed
        // TODO add your handling code here:        
        //Zapisywanie produktu
        
        //Sprawdzenie czy wypełniono wszystkie pola
        if (nazwaField.getText().equals("") || cenaField.getText().equals("")
                || (jTextField1.isVisible() && jTextField1.getText().equals(""))
                || (jTextField2.isVisible() && jTextField2.getText().equals(""))
                || (jTextField3.isVisible() && jTextField3.getText().equals(""))){            
            Border border =  BorderFactory.createLineBorder(Color.red);
            if (nazwaField.getText().equals("")) nazwaField.setBorder(border);        
            if (cenaField.getText().equals("")) cenaField.setBorder(border);
            if (jTextField1.getText().equals("")) jTextField1.setBorder(border);
            if (jTextField2.getText().equals("")) jTextField2.setBorder(border);
            if (jTextField3.getText().equals("")) jTextField3.setBorder(border);
        }        
        else{
            if (tryb.equals(tryb.DODAWANIE)){
                dodajProdukt();
            } else if (tryb.equals(tryb.EDYTOWANIE)){
                edytujProdukt();
            }        
            this.dispose();
            Zalando.setOknoProduktu(null);
        }
    }//GEN-LAST:event_zapiszButtonActionPerformed

    private void anulujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujButtonActionPerformed
        // TODO add your handling code here:
        //Anulowanie dodawania/edycji
        if (tryb.equals(tryb.DODAWANIE)){
            Zalando.usunID(id);
        }        
        this.dispose(); 
        Zalando.setOknoProduktu(null);
    }//GEN-LAST:event_anulujButtonActionPerformed

    private void cenaFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cenaFieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();        
        //zamiana przecinka na kropke
        if (c == ','){
            evt.setKeyChar('.');
        }        
        //tylko jedna kropka
        if ( (c == '.' || c == ',') && cenaField.getText().contains(".") ){
            evt.consume();
        }        
        //tylko dwie cyfry po kropce
        if (cenaField.getText().contains(".") && (cenaField.getText().length() - cenaField.getText().lastIndexOf(".") >= 3) ){
            evt.consume();
        }        
        //tylko cyfry, kropki, przecinki i delete
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_DELETE) || c == '.' || c == ',')){
            evt.consume();
        }  
    }//GEN-LAST:event_cenaFieldKeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        //Tylko integer
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_DELETE)  )){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        //Tylko integer
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_DELETE)  )){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        //Tylko integer
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_DELETE)  )){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //Anulowanie dodawania/edycji
        if (tryb.equals(tryb.DODAWANIE)){
            Zalando.usunID(id);
        }        
        if (oknoPromocja != null){
            oknoPromocja.dispose();
            setOknoPromocja(null);
        }
        this.dispose();
        Zalando.setOknoProduktu(null);
    }//GEN-LAST:event_formWindowClosing

    private void promocjaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promocjaButtonActionPerformed
        // TODO add your handling code here:
        //Dodawanie i edytowanie promocji
        if (oknoPromocja == null){
            if (cenaField.getText().equals("")){
            Border border = nazwaField.getBorder();
            border =  BorderFactory.createLineBorder(Color.red);                
            if (cenaField.getText().equals("")) cenaField.setBorder(border);            
            } else {
                cena = Float.parseFloat(cenaField.getText());            
                oknoPromocja = new Promocja();
            }  
        }      
    }//GEN-LAST:event_promocjaButtonActionPerformed

    private void nazwaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nazwaFieldKeyReleased
        // TODO add your handling code here:
        nazwaField.setBorder(defaultBorder);
    }//GEN-LAST:event_nazwaFieldKeyReleased

    private void cenaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cenaFieldKeyReleased
        // TODO add your handling code here:
        cenaField.setBorder(defaultBorder);
    }//GEN-LAST:event_cenaFieldKeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        jTextField1.setBorder(defaultBorder);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        jTextField2.setBorder(defaultBorder);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        jTextField3.setBorder(defaultBorder);
    }//GEN-LAST:event_jTextField3KeyReleased

    private void usunZdjecieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunZdjecieButtonActionPerformed
        // TODO add your handling code here:
        //Usuń zdjęcie
        Zalando.usunZdjecie(id);
        imgLabel.setIcon(null);
        usunZdjecieButton.setVisible(false);
    }//GEN-LAST:event_usunZdjecieButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JTextField cenaField;
    private javax.swing.JLabel cenaLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFileChooser jFileOpen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox kolorComboBox;
    private javax.swing.JLabel kolorLabel;
    private javax.swing.JComboBox markaComboBox;
    private javax.swing.JLabel markaLabel;
    private javax.swing.JComboBox materialComboBox;
    private javax.swing.JLabel materialLabel;
    private javax.swing.JTextField nazwaField;
    private javax.swing.JLabel nazwaLabel;
    private javax.swing.JComboBox plecComboBox;
    private javax.swing.JLabel plecLabel;
    private javax.swing.JButton promocjaButton;
    private javax.swing.JButton przegladajButton;
    private javax.swing.JComboBox rozmiarComboBox;
    private javax.swing.JLabel rozmiarLabel;
    private javax.swing.JButton usunZdjecieButton;
    private javax.swing.JButton zapiszButton;
    private javax.swing.JLabel zdjecieLabel;
    // End of variables declaration//GEN-END:variables

    //Gettery i Settery

    /**
     * Zwraca ID produktu otwartego w oknie.
     * @return ID produktu otwartego w oknie.
     */
    public int getId() {
        return id;
    }

    /**
     * Zwraca datę rozpoczęcia promocji produktu otwartego w oknie.
     * @return data rozpoczęcia promocji produktu otwartego w oknie.
     */
    public Calendar getPoczatekPromocji() {
        return poczatekPromocji;
    }

    /**
     * Zwraca datę końca promocji produktu otwartego w oknie.
     * @return data końca promocji produktu otwartego w oknie.
     */
    public Calendar getKoniecPromocji() {
        return koniecPromocji;
    }

    /**
     * Zwraca aktywność promocji produktu otwartego w oknie.
     * @return true jeśli promocja jest włączona, false jeśli promocja jest wyłączona.
     */
    public boolean iswPromocji() {
        return wPromocji;
    }

    /**
     * Zwraca wysokość rabatu produktu otwartego w oknie.
     * @return wysokość rabatu produktu otwartego w oknie.
     */
    public float getRabat() {
        return rabat;
    }

    /**
     * Zwraca cenę produktu otwartego w oknie.
     * @return cena produktu otwartego w oknie.
     */
    public float getCena() {
        return cena;
    }

    /**
     * Zwraca cenę po rabacie produktu otwartego w oknie, 
     * -1 jeśli promocja jest wyłączona
     * lub jeśli promocja nie obowiązuje czasowo.
     * @return cena po rabacie produktu otwartego w oknie, 
     * -1 jeśli promocja jest wyłączona
     * lub jeśli promocja nie obowiązuje czasowo.
     */
    public float getCenaPromocyjna() {
        return cenaPromocyjna;
    }

    /**
     * Ustawia datę początku promocji produktu otwartego w oknie.
     * @param poczatekPromocji data początku promocji produktu otwartego w oknie.
     */
    public void setPoczatekPromocji(Calendar poczatekPromocji) {
        this.poczatekPromocji = poczatekPromocji;
    }

    /**
     * Ustawia datę końca promocji produktu otwartego w oknie.
     * @param koniecPromocji data końca promocji produktu otwartego w oknie.
     */
    public void setKoniecPromocji(Calendar koniecPromocji) {
        this.koniecPromocji = koniecPromocji;
    }

    /**
     * Ustawia aktywność promocji produktu otwartego w oknie.
     * @param wPromocji aktywność promocji produktu otwartego w oknie.
     */
    public void setwPromocji(boolean wPromocji) {
        this.wPromocji = wPromocji;
    }

    /**
     * Ustawia wysokość rabatu produktu otwartego w oknie.
     * @param rabat wysokość rabatu produktu otwartego w oknie.
     */
    public void setRabat(float rabat) {
        this.rabat = rabat;
    }

    /**
     * Ustawia cenę produktu otwartego w oknie.
     * @param cena cena produktu otwartego w oknie.
     */
    public void setCena(float cena) {
        this.cena = cena;
    }

    /**
     * Ustawia cenę po rabacie produktu otwartego w oknie.
     * @param cenaPromocyjna cena po rabacie produktu otwartego w oknie.
     */
    public void setCenaPromocyjna(float cenaPromocyjna) {
        this.cenaPromocyjna = cenaPromocyjna;
    }

    /**
     * Ustawia zmienną referencyjną okna promocji.
     * Wykorzystywane do blokady otwarcia kilkukrotnie okna promocji.
     * Okno promocji utworzy się tylko gdy zmienna referencyjna ma wartość null.
     * @param oknoPromocja zmienna referencyjna na okno promocji.
     */
    public void setOknoPromocja(Promocja oknoPromocja) {
        this.oknoPromocja = oknoPromocja;
    }
}