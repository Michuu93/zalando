package zalando;

/**
 * Abstrakcyjna klasa produktów.
 */
public abstract class Produkt {  
    private String nazwa;
    private float cena;      
    private Plec plec;   
    private Kolor kolor;
    private Marka marka;
    private Material material;
    
    /**
     * Rodzaje płci dla jakiej przeznaczony jest produkt.
     */
    public enum Plec {
        Męska, Żeńska, Unisex
    }

    /**
     * Dostępne kolory produktów.
     */
    public enum Kolor {
        Czarny, Biały, Szary, Niebieski, Zielony, Czerwony, Żółty, Inny      
    }

    /**
     * Dostępne marki produktów.
     */
    public enum Marka {
        Adidas, Converse, Diesel, Fila, Lee, Mustang, Nike, Puma, Reebok, Steel, Wrangler
    }

    /**
     * Dostępne materiał z jakich wykonane są produkty.
     */
    public enum Material {
        Jeans, Flanela, Materiał, Skóra, EkoSkóra, Inny
    }  

    /**
     * Konstruktor bezargumentowy.
     */
    public Produkt(){ }
            
    /**
     * Konstruktor produktów.
     * @param nazwa Nazwa produktu.
     * @param cena Cena produktu.
     * @param plec Płeć dla jakiej przeznaczony jest produkt.
     * @param kolor Kolor produktu.
     * @param marka Marka produktu.
     * @param material Materiał z jakiego wykonany jest produkt.
     */
    public Produkt(String nazwa, float cena, Plec plec, Kolor kolor, Marka marka, Material material) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.plec = plec;
        this.kolor = kolor;
        this.marka = marka;
        this.material = material; 
    }   
    
//Gettery i Settery
    /**
     * Zwraca nazwę produktu.
     * @return nazwa produktu.
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Zwraca cenę produktu.
     * @return cena produktu.
     */
    public float getCena() {
        return cena;
    }

    /**
     * Ustawia nazwę produktu.
     * @param nazwa nazwa produktu.
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Ustawia cenę produktu.
     * @param cena cena produktu.
     */
    public void setCena(float cena) {
        this.cena = cena;
    }

    /**
     * Ustawia kolor produktu.
     * @param kolor kolor produktu.
     */
    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

    /**
     * Ustawia markę produktu.
     * @param marka marka produktu.
     */
    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    /**
     * Ustawia materiał z jakiego wykonany jest produkt.
     * @param material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Zwraca kolor produktu.
     * @return kolor produktu.
     */
    public Kolor getKolor() {
        return kolor;
    }

    /**
     * Zwraca markę produktu.
     * @return marka produktu.
     */
    public Marka getMarka() {
        return marka;
    }

    /**
     * Zwraca materiał z jakiego wykonany jest produkt.
     * @return materiał z jakiego wykonany jest produkt.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Ustawia płeć dla jakiej przeznaczony jest produkt.
     * @param plec płeć dla jakiej przeznaczony jest produkt.
     */
    public void setPlec(Plec plec) {
        this.plec = plec;
    }

    /**
     * Zwraca płeć dla jakiej przeznaczony jest produkt.
     * @return płeć dla jakiej przeznaczony jest produkt.
     */
    public Plec getPlec() {
        return plec;
    }
}