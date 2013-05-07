package com.models;

import java.util.ArrayList;

import com.commons.gameObject;
import com.parts.gameAnimatedPart;
import com.parts.gameSpritePart;

public abstract class gameWarrior extends gameObject{

	public gameAnimatedPart body;
	public String name;
    public ArrayList<gameAnimatedPart> parts = new ArrayList<gameAnimatedPart>(); 
		
}
