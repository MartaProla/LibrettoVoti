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
		if(lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)))==false);
			System.out.println("Errore nell'inserimento di Economia");
		
		System.out.println(this.lib) ; // stampaggio del libretto
		
		System.out.println(this.lib.stampaVotiUguali(28)) ;
		
		System.out.println(this.lib.estraiVotiUguali(28)) ;
		String nomeCorso="Analisi II";
		Voto votoAnalisi=lib.cercaVoto(nomeCorso);
		System.out.println("Il voto di Analisi "+nomeCorso+" è "+votoAnalisi.getVoto());
		Voto votoMancante= lib.cercaVoto("Fisica II");
		System.out.println("Il voto di Fisica II è "+votoMancante);
		
		
		Voto v3=new Voto("Economia",24,LocalDate.now());
		Voto v4=new Voto("Economia",25, LocalDate.now());
		System.out.println("Economia con 24 e' duplicato:"+lib.cercaVoto(v3)+" / conflitto: "+lib.cercaConflitto(v3) );
		System.out.println("Economia con 25 e' duplicato:"+lib.cercaVoto(v4)+" / conflitto: "+lib.cercaConflitto(v4)+"\n" );
		
		// 7. migliora libretto
		Libretto migliorato=lib.creaLibrettoMigliorato();
		System.out.println("Miglioramento del libretto");
		System.out.println(this.lib);
		System.out.println(migliorato);
		
		//8. Stampa in ordine alfabetico
		
		Libretto alfabetico=new Libretto(lib);
		alfabetico.LibrettoInOrdineAlfabetico();
		System.out.println(alfabetico);
		
		//8. stampa in ordine di voto
		Libretto votiDecrescenti=new Libretto(lib);
		votiDecrescenti.LibrettoInOrdineDiVotoDecrescente();
		System.out.println(votiDecrescenti);
		//9. elimina voti inferiori al 24
		lib.add(new Voto("Chimica",19,LocalDate.now()));
		lib.LibrettoInOrdineAlfabetico();
		System.out.println(lib);
		lib.librettoSenzaVoto(24);
		System.out.println(lib);
		
		
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto() ;
		test.run();
	}

}
