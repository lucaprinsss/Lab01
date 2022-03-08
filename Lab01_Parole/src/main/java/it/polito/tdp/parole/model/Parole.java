package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Parole {
	
		private TreeMap<String,String> mappaParole;
		
	public Parole() {
		mappaParole=new TreeMap<String,String>();
	}
	
	public void addParola(String p) {
		mappaParole.put(p,p);
	}
	
	public List<String> getElenco() {
		Collection<String> col=new LinkedList<String>(mappaParole.values());
		return (List)col;
	}
	
	public void reset() {
		mappaParole.clear();
	}
	
	public void removeParola(String p) {
		mappaParole.remove(p);
	}

}
