package zalando;

import java.util.Calendar;

/**
 * Interfejs promocji.
 */
public interface wPromocji {    

    /**
     * Zwraca aktywność promocji.
     * @return true jeśli promocja jest włączona, false jeśli promocja jest wyłączona.
     */
    public boolean getWPromocji();

    /**
     * Ustawia aktywność promocji.
     * @param wPromocji true jeśli promocja jest włączona, false jeśli promocja jest wyłączona.
     */
    public void setWPromocji(boolean wPromocji);
    
    /**
     * Zwraca wysokość rabatu.
     * @return wysokość rabatu.
     */
    public float getRabat();

    /**
     * Ustawia wysokość rabatu.
     * @param rabat wysokość rabatu.
     */
    public void setRabat(float rabat);
    
    /**
     * Zwraca cenę po rabacie, lub -1 jeśli promocja jest wyłączona
     * lub jeśli promocja nie obowiązuje czasowo.
     * @return cena po rabacie, lub -1 jeśli promocja jest wyłączona
     * lub jeśli promocja nie obowiązuje czasowo.
     */
    public float getCenaPromocyjna();

    /**
     * Ustawia cenę po rabacie.
     * @param cenaPromocyjna cena po rabacie.
     */
    public void setCenaPromocyjna(float cenaPromocyjna);
    
    /**
     * Zwraca datę rozpoczęcia promocji.
     * @return data rozpoczęcia promocji.
     */
    public Calendar getPoczatekPromocji();

    /**
     * Ustawia datę rozpoczęcia promocji.
     * @param poczatekPromocji data rozpoczęcia promocji.
     */
    public void setPoczatekPromocji(Calendar poczatekPromocji);
    
    /**
     * Zwraca datę końca promocji.
     * @return data końca promocji.
     */
    public Calendar getKoniecPromocji();

    /**
     * Ustawia datę końca promocji.
     * @param koniecPromocji data końca promocji.
     */
    public void setKoniecPromocji(Calendar koniecPromocji);
}
