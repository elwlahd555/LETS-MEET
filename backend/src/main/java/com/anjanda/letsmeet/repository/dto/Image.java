package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {
	private int imageId;
	private String imagePath;
	private String imageOriginName;
	private String imageSystemName;
	private int imageSize;
	private String imageType;
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(int imageId, String imagePath, String imageOriginName, String imageSystemName, int imageSize,
			String imageType) {
		super();
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.imageOriginName = imageOriginName;
		this.imageSystemName = imageSystemName;
		this.imageSize = imageSize;
		this.imageType = imageType;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageOriginName() {
		return imageOriginName;
	}
	public void setImageOriginName(String imageOriginName) {
		this.imageOriginName = imageOriginName;
	}
	public String getImageSystemName() {
		return imageSystemName;
	}
	public void setImageSystemName(String imageSystemName) {
		this.imageSystemName = imageSystemName;
	}
	public int getImageSize() {
		return imageSize;
	}
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imagePath=" + imagePath + ", imageOriginName=" + imageOriginName
				+ ", imageSystemName=" + imageSystemName + ", imageSize=" + imageSize + ", imageType=" + imageType
				+ "]";
	}
	
	
}   
