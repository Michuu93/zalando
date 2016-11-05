package zalando;

/**
 * Klasa produktów "Tshirt".
 */
public class Tshirt extends Koszula {

    /**
     * Konstruktor bezargumentowy.
     */
    public Tshirt() {
        super();
    }
    
    /**
     * Konstruktor Tshirtów.
     * @param nazwa Nazwa Tshirta.
     * @param cena Cena Tshirta.
     * @param plec Płeć dla jakiej przeznaczony jest Tshirt.
     * @param kolor Kolor Tshirta.
     * @param marka Marka Tshirta.
     * @param material Materiał z jakiego wykonany jest Tshirt.
     * @param rozmiar Rozmiar Tshirta.
     */
    public Tshirt(String nazwa, float cena, Plec plec, Kolor kolor, Marka marka, Material material, RozmiarKoszuli rozmiar) {
        super(nazwa, cena, plec, kolor, marka, material, rozmiar);
    }

}