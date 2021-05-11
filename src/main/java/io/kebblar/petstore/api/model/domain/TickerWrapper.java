/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TickerWrapper.java
 * Tipo:        clase
 * AUTOR:       Ulises A. Lopez (UAL)
 * Fecha:       Martes 4 de Mayo de 2021 (08_59)
 *
 * Historia:    .
 *              20210504_0859 Actualización de éste POJO
 *              20210511_0837 Actualización de licencia
 *
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de 'TickerWrapper'.
 * 
 * @author ulopezu
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class TickerWrapper {
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

	/**
	 * Getter para symbol.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Setter para symbol.
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Getter para priceChange.
	 */
	public String getPriceChange() {
		return priceChange;
	}

	/**
	 * Setter para priceChange.
	 */
	public void setPriceChange(String priceChange) {
		this.priceChange = priceChange;
	}

	/**
	 * Getter para priceChangePercent.
	 */
	public String getPriceChangePercent() {
		return priceChangePercent;
	}

	/**
	 * Setter para priceChangePercent.
	 */
	public void setPriceChangePercent(String priceChangePercent) {
		this.priceChangePercent = priceChangePercent;
	}

	/**
	 * Getter para weightedAvgPrice.
	 */
	public String getWeightedAvgPrice() {
		return weightedAvgPrice;
	}

	/**
	 * Setter para weightedAvgPrice.
	 */
	public void setWeightedAvgPrice(String weightedAvgPrice) {
		this.weightedAvgPrice = weightedAvgPrice;
	}

	/**
	 * Getter para prevClosePrice.
	 */
	public String getPrevClosePrice() {
		return prevClosePrice;
	}

	/**
	 * Setter para prevClosePrice.
	 */
	public void setPrevClosePrice(String prevClosePrice) {
		this.prevClosePrice = prevClosePrice;
	}

	/**
	 * Getter para lastPrice.
	 */
	public String getLastPrice() {
		return lastPrice;
	}

	/**
	 * Setter para lastPrice.
	 */
	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	/**
	 * Getter para lastQty.
	 */
	public String getLastQty() {
		return lastQty;
	}

	/**
	 * Setter para lastQty.
	 */
	public void setLastQty(String lastQty) {
		this.lastQty = lastQty;
	}

	/**
	 * Getter para bidPrice.
	 */
	public String getBidPrice() {
		return bidPrice;
	}

	/**
	 * Setter para bidPrice.
	 */
	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	/**
	 * Getter para bidQty.
	 */
	public String getBidQty() {
		return bidQty;
	}

	/**
	 * Setter para bidQty.
	 */
	public void setBidQty(String bidQty) {
		this.bidQty = bidQty;
	}

	/**
	 * Getter para askPrice.
	 */
	public String getAskPrice() {
		return askPrice;
	}

	/**
	 * Setter para askPrice.
	 */
	public void setAskPrice(String askPrice) {
		this.askPrice = askPrice;
	}

	/**
	 * Getter para askQty.
	 */
	public String getAskQty() {
		return askQty;
	}

	/**
	 * Setter para askQty.
	 */
	public void setAskQty(String askQty) {
		this.askQty = askQty;
	}

	/**
	 * Getter para openPrice.
	 */
	public String getOpenPrice() {
		return openPrice;
	}

	/**
	 * Setter para openPrice.
	 */
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}

	/**
	 * Getter para highPrice.
	 */
	public String getHighPrice() {
		return highPrice;
	}

	/**
	 * Setter para highPrice.
	 */
	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}

	/**
	 * Getter para lowPrice.
	 */
	public String getLowPrice() {
		return lowPrice;
	}

	/**
	 * Setter para lowPrice.
	 */
	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	/**
	 * Getter para volume.
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * Setter para volume.
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * Getter para quoteVolume.
	 */
	public String getQuoteVolume() {
		return quoteVolume;
	}

	/**
	 * Setter para quoteVolume.
	 */
	public void setQuoteVolume(String quoteVolume) {
		this.quoteVolume = quoteVolume;
	}

	/**
	 * Getter para openTime.
	 */
	public long getOpenTime() {
		return openTime;
	}

	/**
	 * Setter para openTime.
	 */
	public void setOpenTime(long openTime) {
		this.openTime = openTime;
	}

	/**
	 * Getter para closeTime.
	 */
	public long getCloseTime() {
		return closeTime;
	}

	/**
	 * Setter para closeTime.
	 */
	public void setCloseTime(long closeTime) {
		this.closeTime = closeTime;
	}

	/**
	 * Getter para firstId.
	 */
	public long getFirstId() {
		return firstId;
	}

	/**
	 * Setter para firstId.
	 */
	public void setFirstId(long firstId) {
		this.firstId = firstId;
	}

	/**
	 * Getter para lastId.
	 */
	public long getLastId() {
		return lastId;
	}

	/**
	 * Setter para lastId.
	 */
	public void setLastId(long lastId) {
		this.lastId = lastId;
	}

	/**
	 * Getter para count.
	 */
	public long getCount() {
		return count;
	}

	/**
	 * Setter para count.
	 */
	public void setCount(long count) {
		this.count = count;
	}

}
