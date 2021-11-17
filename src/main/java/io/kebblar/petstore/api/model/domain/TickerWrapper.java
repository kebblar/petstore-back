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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((askPrice == null) ? 0 : askPrice.hashCode());
        result = prime * result + ((askQty == null) ? 0 : askQty.hashCode());
        result = prime * result + ((bidPrice == null) ? 0 : bidPrice.hashCode());
        result = prime * result + ((bidQty == null) ? 0 : bidQty.hashCode());
        result = prime * result + (int) (closeTime ^ (closeTime >>> 32));
        result = prime * result + (int) (count ^ (count >>> 32));
        result = prime * result + (int) (firstId ^ (firstId >>> 32));
        result = prime * result + ((highPrice == null) ? 0 : highPrice.hashCode());
        result = prime * result + (int) (lastId ^ (lastId >>> 32));
        result = prime * result + ((lastPrice == null) ? 0 : lastPrice.hashCode());
        result = prime * result + ((lastQty == null) ? 0 : lastQty.hashCode());
        result = prime * result + ((lowPrice == null) ? 0 : lowPrice.hashCode());
        result = prime * result + ((openPrice == null) ? 0 : openPrice.hashCode());
        result = prime * result + (int) (openTime ^ (openTime >>> 32));
        result = prime * result + ((prevClosePrice == null) ? 0 : prevClosePrice.hashCode());
        result = prime * result + ((priceChange == null) ? 0 : priceChange.hashCode());
        result = prime * result + ((priceChangePercent == null) ? 0 : priceChangePercent.hashCode());
        result = prime * result + ((quoteVolume == null) ? 0 : quoteVolume.hashCode());
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        result = prime * result + ((volume == null) ? 0 : volume.hashCode());
        result = prime * result + ((weightedAvgPrice == null) ? 0 : weightedAvgPrice.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TickerWrapper other = (TickerWrapper) obj;
        if (askPrice == null) {
            if (other.askPrice != null)
                return false;
        } else if (!askPrice.equals(other.askPrice))
            return false;
        if (askQty == null) {
            if (other.askQty != null)
                return false;
        } else if (!askQty.equals(other.askQty))
            return false;
        if (bidPrice == null) {
            if (other.bidPrice != null)
                return false;
        } else if (!bidPrice.equals(other.bidPrice))
            return false;
        if (bidQty == null) {
            if (other.bidQty != null)
                return false;
        } else if (!bidQty.equals(other.bidQty))
            return false;
        if (closeTime != other.closeTime)
            return false;
        if (count != other.count)
            return false;
        if (firstId != other.firstId)
            return false;
        if (highPrice == null) {
            if (other.highPrice != null)
                return false;
        } else if (!highPrice.equals(other.highPrice))
            return false;
        if (lastId != other.lastId)
            return false;
        if (lastPrice == null) {
            if (other.lastPrice != null)
                return false;
        } else if (!lastPrice.equals(other.lastPrice))
            return false;
        if (lastQty == null) {
            if (other.lastQty != null)
                return false;
        } else if (!lastQty.equals(other.lastQty))
            return false;
        if (lowPrice == null) {
            if (other.lowPrice != null)
                return false;
        } else if (!lowPrice.equals(other.lowPrice))
            return false;
        if (openPrice == null) {
            if (other.openPrice != null)
                return false;
        } else if (!openPrice.equals(other.openPrice))
            return false;
        if (openTime != other.openTime)
            return false;
        if (prevClosePrice == null) {
            if (other.prevClosePrice != null)
                return false;
        } else if (!prevClosePrice.equals(other.prevClosePrice))
            return false;
        if (priceChange == null) {
            if (other.priceChange != null)
                return false;
        } else if (!priceChange.equals(other.priceChange))
            return false;
        if (priceChangePercent == null) {
            if (other.priceChangePercent != null)
                return false;
        } else if (!priceChangePercent.equals(other.priceChangePercent))
            return false;
        if (quoteVolume == null) {
            if (other.quoteVolume != null)
                return false;
        } else if (!quoteVolume.equals(other.quoteVolume))
            return false;
        if (symbol == null) {
            if (other.symbol != null)
                return false;
        } else if (!symbol.equals(other.symbol))
            return false;
        if (volume == null) {
            if (other.volume != null)
                return false;
        } else if (!volume.equals(other.volume))
            return false;
        if (weightedAvgPrice == null) {
            if (other.weightedAvgPrice != null)
                return false;
        } else if (!weightedAvgPrice.equals(other.weightedAvgPrice))
            return false;
        return true;
    }
    
    public int getHash() {
        return this.hashCode();
    }
    
}
