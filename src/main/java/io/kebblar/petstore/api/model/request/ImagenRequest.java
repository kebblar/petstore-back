package io.kebblar.petstore.api.model.request;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class ImagenRequest {

	private int id;//Identificador del anuncio
	private MultipartFile[] files;
	
	public ImagenRequest() {
	}
	
	public ImagenRequest(int id, MultipartFile[] files) {
		this.id = id;
		this.files = files;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "ImagenRequest [id=" + id + ", files=" + Arrays.toString(files) + "]";
	}
}
