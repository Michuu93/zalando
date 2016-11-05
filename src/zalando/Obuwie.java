package zalando;

import java.util.Calendar;

/**
 * Klasa produktów "Obuwie".
 */
public class Obuwie extends Produkt implements wPromocji{
    private int rozmiar;
    private Obcas obcas;
    private boolean wPromocji;
    private float rabat;
    private float cenaPromocyjna;
    private Calendar poczatekPromocji;
    private Calendar koniecPromocji;
 
    /**
     * Rodzaje obcasów.
     */
    public enum Obcas {
        Brak, Szpilki, Koturny, Słupki
    }
    
    /**
     * Konstruktor bezargumentowy.
     */
    public Obuwie(){
        super();
    }

    /**
     * Konstruktor obuwia.
     * @param nazwa Nazwa obuwia.
     * @param cena Cena obuwia.
     * @param plec Płeć dla jakiej przeznaczone jest obuwie.
     * @param rozmiar Rozmiar obuwia.
     * @param obcas Rodzaj posiadanego obcasu.
     * @param kolor Kolor obuwia.
     * @param marka Marka obuwia.
     * @param material Materiał z jakiego wykonane jest obuwie.
     */
    public Obuwie(String nazwa, float cena, Plec plec, int rozmiar, Obcas obcas, Kolor kolor, Marka marka, Material material) {
        super(nazwa, cena, plec, kolor, marka, material);
        this.rozmiar = rozmiar;
        this.obcas = obcas;        
    }
    
//Gettery i Settery
    /**
     * Zwraca rozmiar obuwia.
     * @return rozmiar obuwia.
     */
    public int getRozmiar() {
        return rozmiar;
    }

    /**
     * Ustawia rozmiar obuwia.
     * @param rozmiar rozmiar obuwia.
     */
    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    /**
     * Zwraca rodzaj posiadanego obcasu.
     * @return rodzaj posiadanego obcasu.
     */
    public Obcas getObcas() {
        return obcas;
    }

    /**
     * Ustawia rodzaj posiadanego obcasu.
     * @param obcas rodzaj posiadanego obcasu.
     */
    public void setObcas(Obcas obcas) {
        this.obcas = obcas;
    }
    
    /**
     * Zwraca aktywność promocji.
     * @return true jeśli promocja jest włączona, false jeśli promocja jest wyłączona.
     */
    @Override
    public boolean getWPromocji() {
       return wPromocji; 
    }

    /**
     * Ustawia aktywność promocji.
     * @param wPromocji true jeśli promocja jest włączona, false jeśli promocja jest wyłączona.
     */
    @Override
    public void setWPromocji(boolean wPromocji) {
        this.wPromocji = wPromocji;
    }

    /**
     * Zwraca wysokość rabatu.
     * @return wysokość rabatu.
     */
    @Override
    public float getRabat() {
        return rabat;        
    }

    /**
     * Ustawia wysokość rabatu.
     * @param rabat wysokość rabatu.
     */
    @Override
    public void setRabat(float rabat) {
        this.rabat = rabat;
    }
    
    /**
     * Zwraca cenę po rabacie, lub -1 jeśli promocja jest wyłączona
     * lub jeśli promocja nie obowiązuje czasowo.
     * @return cena po rabacie, lub -1 jeśli promocja jest wyłączona
     * lub jeśli promocja nie obowiązuje czasowo.
     */
    @Override
    public float getCenaPromocyjna() {        
        Calendar dzis = Calendar.getInstance();
        if ( (wPromocji == true) && ( (( dzis.before(koniecPromocji)) && (dzis.after(poczatekPromocji))) ) ){
            return cenaPromocyjna;  
        }
        return -1;
    }

    /**
     * Ustawia cenę po rabacie.
     * @param cenaPromocyjna cena po rabacie.
     */
    @Override
    public void setCenaPromocyjna(float cenaPromocyjna) {
        this.cenaPromocyjna = cenaPromocyjna;
    }
    
    /**
     * Zwraca datę rozpoczęcia promocji.
     * @return data rozpoczęcia promocji.
     */
    @Override
    public Calendar getPoczatekPromocji() { 
        
        return poczatekPromocji;
    }

    /**
     * Ustawia datę rozpoczęcia promocji.
     * @param poczatekPromocji data rozpoczęcia promocji.
     */
    @Override
    public void setPoczatekPromocji(Calendar poczatekPromocji) {        
       this.poczatekPromocji = poczatekPromocji;        
    }

    /**
     * Zwraca datę końca promocji.
     * @return data końca promocji.
     */
    @Override
    public Calendar getKoniecPromocji() {
       return koniecPromocji;
    }

    /**
     * Ustawia datę końca promocji.
     * @param koniecPromocji data końca promocji.
     */
    @Override
    public void setKoniecPromocji(Calendar koniecPromocji) {
        this.koniecPromocji = koniecPromocji;
    }  
}