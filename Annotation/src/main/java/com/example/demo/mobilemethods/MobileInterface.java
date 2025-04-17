package com.example.demo.mobilemethods;

import org.springframework.stereotype.Component;

@Component
public class MobileInterface {

	
	public String getMobile() {
		//System.out.println("iphone 16promax");
		return "iphone 16promax";
	}
	public String getMobileInformation() {
		System.out.println("iPhone 16 Pro Max: The latest iPhone model from Apple, featuring advanced camera capabilities and a powerful A18 Pro chip.");
		return "iPhone 16 Pro Max: The latest iPhone model from Apple, featuring advanced camera capabilities and a powerful A18 Pro chip.";
		
	}
	public String postInformation(int price , String model) {
		return" iCloud makes moving your settings, photos, apps and documents to a new device seamless. Just sign in to iCloud when you set up your new device, access your previous device’s iCloud backup and you’ll be ready to go in minutes. ";
		
	}
	public String deleteInfo() {
	return  "delete previous mobile data ";
	}
	public String putInformation() {
		return "Rigth now iphone 20 pro max ";
	}
}
