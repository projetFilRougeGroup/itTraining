package com.training.enums;

public enum City {
	Paris, Bordeaux, Rennes, Marseilles, Lyon, Rouen, Lille, Nantes, Toulouse, Strasbourg, Distance;
	
	public String toLowerCase (City city) {
		String lowercase=city.toString().toLowerCase();
	return 	lowercase;
	}
	
}
