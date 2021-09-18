/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      TickerWrapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:52:26
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de 'TickerWrapper'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class TickerWrapper {

    /*
     * Atributos de la clase.
     */
    private String symbol;
    private String priceChange;
    private String priceChangePercent;
    private String weightedAvgPrice;
    private String prevClosePrice;
    private String lastPrice;
    private String lastQty;
    private String bidPrice;
    private String bidQty;
    private String askPrice;
    private String askQty;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String volume;
    private String quoteVolume;
    private long openTime;
    private long closeTime;
    private long firstId;
    private long lastId;
    private long count;

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>symbol</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSymbol() {
        return symbol;
    }
    /**
     * <p>Setter for the field <code>symbol</code>.</p>
     *
     * @param symbol a {@link java.lang.String} object.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    /**
     * <p>Getter for the field <code>priceChange</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPriceChange() {
        return priceChange;
    }
    /**
     * <p>Setter for the field <code>priceChange</code>.</p>
     *
     * @param priceChange a {@link java.lang.String} object.
     */
    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }
    /**
     * <p>Getter for the field <code>priceChangePercent</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPriceChangePercent() {
        return priceChangePercent;
    }
    /**
     * <p>Setter for the field <code>priceChangePercent</code>.</p>
     *
     * @param priceChangePercent a {@link java.lang.String} object.
     */
    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }
    /**
     * <p>Getter for the field <code>weightedAvgPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getWeightedAvgPrice() {
        return weightedAvgPrice;
    }
    /**
     * <p>Setter for the field <code>weightedAvgPrice</code>.</p>
     *
     * @param weightedAvgPrice a {@link java.lang.String} object.
     */
    public void setWeightedAvgPrice(String weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
    }
    /**
     * <p>Getter for the field <code>prevClosePrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPrevClosePrice() {
        return prevClosePrice;
    }
    /**
     * <p>Setter for the field <code>prevClosePrice</code>.</p>
     *
     * @param prevClosePrice a {@link java.lang.String} object.
     */
    public void setPrevClosePrice(String prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }
    /**
     * <p>Getter for the field <code>lastPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastPrice() {
        return lastPrice;
    }
    /**
     * <p>Setter for the field <code>lastPrice</code>.</p>
     *
     * @param lastPrice a {@link java.lang.String} object.
     */
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }
    /**
     * <p>Getter for the field <code>lastQty</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastQty() {
        return lastQty;
    }
    /**
     * <p>Setter for the field <code>lastQty</code>.</p>
     *
     * @param lastQty a {@link java.lang.String} object.
     */
    public void setLastQty(String lastQty) {
        this.lastQty = lastQty;
    }
    /**
     * <p>Getter for the field <code>bidPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBidPrice() {
        return bidPrice;
    }
    /**
     * <p>Setter for the field <code>bidPrice</code>.</p>
     *
     * @param bidPrice a {@link java.lang.String} object.
     */
    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }
    /**
     * <p>Getter for the field <code>bidQty</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBidQty() {
        return bidQty;
    }
    /**
     * <p>Setter for the field <code>bidQty</code>.</p>
     *
     * @param bidQty a {@link java.lang.String} object.
     */
    public void setBidQty(String bidQty) {
        this.bidQty = bidQty;
    }
    /**
     * <p>Getter for the field <code>askPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAskPrice() {
        return askPrice;
    }
    /**
     * <p>Setter for the field <code>askPrice</code>.</p>
     *
     * @param askPrice a {@link java.lang.String} object.
     */
    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }
    /**
     * <p>Getter for the field <code>askQty</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAskQty() {
        return askQty;
    }
    /**
     * <p>Setter for the field <code>askQty</code>.</p>
     *
     * @param askQty a {@link java.lang.String} object.
     */
    public void setAskQty(String askQty) {
        this.askQty = askQty;
    }
    /**
     * <p>Getter for the field <code>openPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getOpenPrice() {
        return openPrice;
    }
    /**
     * <p>Setter for the field <code>openPrice</code>.</p>
     *
     * @param openPrice a {@link java.lang.String} object.
     */
    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }
    /**
     * <p>Getter for the field <code>highPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHighPrice() {
        return highPrice;
    }
    /**
     * <p>Setter for the field <code>highPrice</code>.</p>
     *
     * @param highPrice a {@link java.lang.String} object.
     */
    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }
    /**
     * <p>Getter for the field <code>lowPrice</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLowPrice() {
        return lowPrice;
    }
    /**
     * <p>Setter for the field <code>lowPrice</code>.</p>
     *
     * @param lowPrice a {@link java.lang.String} object.
     */
    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }
    /**
     * <p>Getter for the field <code>volume</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getVolume() {
        return volume;
    }
    /**
     * <p>Setter for the field <code>volume</code>.</p>
     *
     * @param volume a {@link java.lang.String} object.
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }
    /**
     * <p>Getter for the field <code>quoteVolume</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getQuoteVolume() {
        return quoteVolume;
    }
    /**
     * <p>Setter for the field <code>quoteVolume</code>.</p>
     *
     * @param quoteVolume a {@link java.lang.String} object.
     */
    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }
    /**
     * <p>Getter for the field <code>openTime</code>.</p>
     *
     * @return a long.
     */
    public long getOpenTime() {
        return openTime;
    }
    /**
     * <p>Setter for the field <code>openTime</code>.</p>
     *
     * @param openTime a long.
     */
    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }
    /**
     * <p>Getter for the field <code>closeTime</code>.</p>
     *
     * @return a long.
     */
    public long getCloseTime() {
        return closeTime;
    }
    /**
     * <p>Setter for the field <code>closeTime</code>.</p>
     *
     * @param closeTime a long.
     */
    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
    }
    /**
     * <p>Getter for the field <code>firstId</code>.</p>
     *
     * @return a long.
     */
    public long getFirstId() {
        return firstId;
    }
    /**
     * <p>Setter for the field <code>firstId</code>.</p>
     *
     * @param firstId a long.
     */
    public void setFirstId(long firstId) {
        this.firstId = firstId;
    }
    /**
     * <p>Getter for the field <code>lastId</code>.</p>
     *
     * @return a long.
     */
    public long getLastId() {
        return lastId;
    }
    /**
     * <p>Setter for the field <code>lastId</code>.</p>
     *
     * @param lastId a long.
     */
    public void setLastId(long lastId) {
        this.lastId = lastId;
    }
    /**
     * <p>Getter for the field <code>count</code>.</p>
     *
     * @return a long.
     */
    public long getCount() {
        return count;
    }
    /**
     * <p>Setter for the field <code>count</code>.</p>
     *
     * @param count a long.
     */
    public void setCount(long count) {
        this.count = count;
    }

}
