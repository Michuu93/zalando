package zalando;

import java.util.Calendar;

/**
 * Klasa produktów "Spodnie".
 */
public class Spodnie extends Produkt implements wPromocji{
    private int rozmiar;
    private int dlugosc;
    private boolean wPromocji;
    private float rabat;
    private float cenaPromocyjna;
    private Calendar poczatekPromocji;
    private Calendar koniecPromocji;
    
    /**
     * Konstruktor bezargumentowy.
     */
    public Spodnie() {
        super();
    }

    /**
     * Konstruktor spodni.
     * @param nazwa Nazwa spodni.
     * @param cena Cena spodni.
     * @param plec Płeć dla jakiej przeznaczone są spodnie.
     * @param rozmiar Rozmiar spodni.
     * @param dlugosc Długość nogawek spodni.
     * @param kolor Kolor spodni.
     * @param marka Marka spodni.
     * @param material Materiał z jakiego wykonane są spodnie.
     */
    public Spodnie(String nazwa, float cena, Plec plec, int rozmiar, int dlugosc, Kolor kolor, Marka marka, Material material) {
        super(nazwa, cena, plec, kolor, marka, material);
        this.rozmiar = rozmiar;
        this.dlugosc = dlugosc;
    }

//Gettery i Settery   
    /**
     * Zwraca rozmiar spodni.
     * @return rozmiar spodni.
     */
    public int getRozmiar() {
        return rozmiar;
    }

    /**
     * Zwraca długość nogawek spodni.
     * @return długość nogawek spodni.
     */
    public int getDlugosc() {
        return dlugosc;
    }

    /**
     * Ustawia rozmiar spodni.
     * @param rozmiar rozmiar spodni.
     */
    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    /**
     * Ustawia długość nogawek spodni.
     * @param dlugosc długość nogawek spodni.
     */
    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
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