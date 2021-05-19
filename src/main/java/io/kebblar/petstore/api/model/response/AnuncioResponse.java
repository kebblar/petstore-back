package io.kebblar.petstore.api.model.response;

public class AnuncioResponse {

	private int id;
	private String sku;
	
	public AnuncioResponse() {
	}
	
	public AnuncioResponse(int id, String sku) {
		this.id = id;
		this.sku = sku;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
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
		AnuncioResponse other = (AnuncioResponse) obj;
		if (id != other.id)
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
	
	public long getHash() {
        return this.hashCode();
    }
	
	@Override
	public String toString() {
		return "AnuncioResponse [id=" + id + ", sku=" + sku + "]";
	}
	
}
