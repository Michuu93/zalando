package zalando;

/**
 * Abstrakcyjna klasa produktów typu "Koszula".
 */
public abstract class Koszula extends Produkt {  
    private RozmiarKoszuli rozmiar;
    
    /**
     * Rozmiary koszul.
     */
    public enum RozmiarKoszuli {
        XS, S, M, L, XL, XXL
    }

    /**
     * Konstruktor bezargumentowy.
     */
    public Koszula() {
        super();
    }
    
    /**
     * Konstruktor koszul.
     * @param nazwa Nazwa koszuli.
     * @param cena Cena koszuli.
     * @param plec Płeć dla jakiej przeznaczona jest koszula.
     * @param kolor Kolor koszuli.
     * @param marka Marka koszuli.
     * @param material Materiał z jakiego wykonana jest koszula.
     * @param rozmiar Rozmiar koszuli.
     */
    public Koszula(String nazwa, float cena, Plec plec, Kolor kolor, Marka marka, Material material, RozmiarKoszuli rozmiar) {
        super(nazwa, cena, plec, kolor, marka, material);  
        this.rozmiar = rozmiar;
    }  

    /**
     * Ustawia rozmiar koszuli.
     * @param rozmiar rozmiar koszuli.
     */
    public void setRozmiar(RozmiarKoszuli rozmiar) {
        this.rozmiar = rozmiar;
    }

    /**
     * Zwraca rozmiar koszuli.
     * @return rozmiar koszuli.
     */
    public RozmiarKoszuli getRozmiar() {
        return rozmiar;
    }
}