package spring.models;

import java.awt.Image;

public class MenuItem {
	
	private String name;
	
	private String descroption;
	
	private double price;
	
	private Image image;

	public MenuItem() {
		
	}

	public MenuItem(String name, String descroption, double price, Image image) {
		this.name = name;
		this.descroption = descroption;
		this.price = price;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescroption() {
		return descroption;
	}

	public void setDescroption(String descroption) {
		this.descroption = descroption;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
		

}
