package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib ; // è accessibile da tutti i metodi del test.
	
	private void run() {
		this.lib = new Libretto() ; //crea libretto vuoto
		
		Voto v1 = new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15)) ;
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28)) ;

		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib) ; // stampaggio del libretto
		
		System.out.println(this.lib.stampaVotiUguali(28)) ;
		
		System.out.println(this.lib.estraiVotiUguali(28)) ;
		
		System.out.println(this.lib.cercaVoto("Analisi II"));
		System.out.println(this.lib.cercaVoto("Analisi III"));
		Voto v3=new Voto("Economia",25,LocalDate.of(2020,02, 14));
		lib.add(v3);
		if(this.lib.cercaVoto(v3)==true) {
			System.out.println("Voto presente nel libretto \n");
		}else {
			System.out.println("Voto presente nel libretto \n");
		}
		if(this.lib.cercaConflitto(v3)==true) {
			System.out.println("ATTENZIONE, siamo in presenza di un conflitto \n ");
		}else {
			System.out.println("Non ci sono conflitti \n");
		}
		System.out.println(this.lib) ;
		System.out.println(this.lib.LibrettoInOrdineAlfabetico());
		System.out.println(this.lib.LibrettoInOrdineDiVotoDecrescente());
		System.out.println(this.lib.librettoSenzaVoto(24));
		System.out.println(this.lib.librettoMigliorato());
		
		
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto() ;
		test.run();
	}

}
