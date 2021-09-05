/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
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
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getPriceChange() {
        return priceChange;
    }
    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }
    public String getPriceChangePercent() {
        return priceChangePercent;
    }
    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }
    public String getWeightedAvgPrice() {
        return weightedAvgPrice;
    }
    public void setWeightedAvgPrice(String weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
    }
    public String getPrevClosePrice() {
        return prevClosePrice;
    }
    public void setPrevClosePrice(String prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }
    public String getLastPrice() {
        return lastPrice;
    }
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }
    public String getLastQty() {
        return lastQty;
    }
    public void setLastQty(String lastQty) {
        this.lastQty = lastQty;
    }
    public String getBidPrice() {
        return bidPrice;
    }
    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }
    public String getBidQty() {
        return bidQty;
    }
    public void setBidQty(String bidQty) {
        this.bidQty = bidQty;
    }
    public String getAskPrice() {
        return askPrice;
    }
    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }
    public String getAskQty() {
        return askQty;
    }
    public void setAskQty(String askQty) {
        this.askQty = askQty;
    }
    public String getOpenPrice() {
        return openPrice;
    }
    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }
    public String getHighPrice() {
        return highPrice;
    }
    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }
    public String getLowPrice() {
        return lowPrice;
    }
    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getQuoteVolume() {
        return quoteVolume;
    }
    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }
    public long getOpenTime() {
        return openTime;
    }
    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }
    public long getCloseTime() {
        return closeTime;
    }
    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
    }
    public long getFirstId() {
        return firstId;
    }
    public void setFirstId(long firstId) {
        this.firstId = firstId;
    }
    public long getLastId() {
        return lastId;
    }
    public void setLastId(long lastId) {
        this.lastId = lastId;
    }
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }

}
