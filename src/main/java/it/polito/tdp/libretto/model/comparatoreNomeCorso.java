package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class comparatoreNomeCorso implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Voto v1=(Voto)o1;
		Voto v2=(Voto)o2;
		return v1.getCorso().compareTo(v2.getCorso());
	}

}
