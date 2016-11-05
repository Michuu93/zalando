package zalando;

/**
 * Klasa produktów "Koszula Elegancka".
 */
public class Elegancka extends Koszula {
    private int kolnierzyk;
    private Krawat krawat;
    
    /**
     * Rodzaj dodatku do koszuli.
     */
    public enum Krawat{
        Brak, Krawat, Muszka
    }
    
    /**
     * Konstruktor bezargumentowy.
     */
    public Elegancka() {
        super();
    }

    /**
     * Konstruktor koszuli eleganckiej.
     * @param nazwa Nazwa koszuli eleganckiej.
     * @param cena Cena koszuli eleganckiej.
     * @param plec Płeć dla jakiej przeznaczona jest koszula elegancka.
     * @param kolnierzyk Rozmiar kołnierzyka koszuli eleganckiej.
     * @param krawat Dodatek do koszuli eleganckiej.
     * @param kolor Kolor koszuli eleganckiej.
     * @param marka Marka koszuli eleganckiej.
     * @param material Materiał z jakiego wykonana jest koszula elegancka.
     * @param rozmiar Rozmiar koszuli eleganckiej.
     */
    public Elegancka(String nazwa, float cena, Plec plec, int kolnierzyk, Krawat krawat, Kolor kolor, Marka marka, Material material, RozmiarKoszuli rozmiar) {
        super(nazwa, cena, plec, kolor, marka, material, rozmiar);
        this.kolnierzyk = kolnierzyk;
        this.krawat = krawat;
    }

//Gettery i Settery    
    /** 
     * Zwraca rozmiar kołnierzyka koszuli eleganckiej.
     * @return rozmiar kołnierzyka koszuli eleganckiej.
     */
    public int getKolnierzyk() {
        return kolnierzyk;
    }
    
    /**
     * Ustawia rozmiar kołnierzyka koszuli eleganckiej.
     * @param kolnierzyk rozmiar kołnierzyka koszuli eleganckiej.
     */
    public void setKolnierzyk(int kolnierzyk) {
        this.kolnierzyk = kolnierzyk;
    }
    
    /**
     * Zwraca dodatek do koszuli eleganckiej.
     * @return dodatek do koszuli eleganckiej.
     */
    public Krawat getKrawat() {
        return krawat;
    }
    
    /**
     * Ustawia dodatek do koszuli eleganckiej.
     * @param krawat dodatek do koszuli eleganckiej.
     */
    public void setKrawat(Krawat krawat) {
        this.krawat = krawat;
    }
}
