package com.fit.model;

/**
*
* @author Marko
*/
public enum Program {
	
BODYBUILDING,
KICKBOXING,
CROSSFIT,
PILATES;
	
	public static boolean contains(String value) {
		for(Program p:Program.values()) {
			if(p.name().equals(value)){
				return true;
			}
		}
		
	return false;
}
}