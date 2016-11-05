package zalando;

/**
 * Klasa produktów "Kurtka".
 */
public class Kurtka extends Produkt {  
    private RozmiarKurtki rozmiar;
    private Zapiecie zapiecie;
    private RodzajKurtki rodzajKurtki;
    
    /**
     * Rozmiary kurtek.
     */
    public enum RozmiarKurtki {
        XS, S, M, L, XL, XXL
    }    

    /**
     * Typy zapięć kurtek.
     */
    public enum Zapiecie {
        Zamek, Rzep, Guziki
    }

    /**
     * Rodzaje kurtek.
     */
    public enum RodzajKurtki {
        Letnia, Jesienna, Zimowa, Wiosenna
    }
    
    /**
     * Konstruktor bezargumentowy kurtki.
     */
    public Kurtka() {
        super();
    }
    
    /**
     * Konstruktor kurtki.
     * @param nazwa Nazwa kurtki.
     * @param cena Cena kurtki.
     * @param plec Płeć dla jakiej przeznaczona jest kurtka.
     * @param kolor Kolor kurtki.
     * @param marka Marka kurtki.
     * @param material Materiał z jakiego wykonana jest kurtka.
     * @param rozmiar Rozmiar kurtki.
     * @param zapiecie Typ zapięcia kurtki.
     * @param rodzajKurtki Pora roku dla której przeznaczona jest kurtka.
     */
    public Kurtka(String nazwa, float cena, Plec plec, Kolor kolor, Marka marka, Material material, RozmiarKurtki rozmiar, Zapiecie zapiecie, RodzajKurtki rodzajKurtki) {
        super(nazwa, cena, plec, kolor, marka, material);   
        this.rozmiar = rozmiar;
        this.zapiecie = zapiecie;
        this.rodzajKurtki = rodzajKurtki;               
    }

    /**
     * Zwraca rozmiar kurtki.
     * @return rozmiar kurtki.
     */
    public RozmiarKurtki getRozmiar() {
        return rozmiar;
    }

    /**
     * Zwraca typ zapięcia kurtki.
     * @return typ zapięcia kurtki.
     */
    public Zapiecie getZapiecie() {
        return zapiecie;
    }

    /**
     * Zwraca porę roku dla jakiej przeznaczona jest kurtka.
     * @return pora roku dla jakiej przeznaczona jest kurtka.
     */
    public RodzajKurtki getRodzajKurtki() {
        return rodzajKurtki;
    }

    /**
     * Ustawia rozmiar kurtki.
     * @param rozmiar rozmiar kurtki.
     */
    public void setRozmiar(RozmiarKurtki rozmiar) {
        this.rozmiar = rozmiar;
    }

    /**
     * Ustawia typ zapięcia kurtki.
     * @param zapiecie typ zapięcia kurtki.
     */
    public void setZapiecie(Zapiecie zapiecie) {
        this.zapiecie = zapiecie;
    }

    /**
     * Ustawia porę roku dla jakiej przeznaczona jest kurtka.
     * @param rodzaj_kurtki pora roku dla jakiej przeznaczona jest kurtka.
     */
    public void setRodzajKurtki(RodzajKurtki rodzaj_kurtki) {
        this.rodzajKurtki = rodzaj_kurtki;
    }
            
}