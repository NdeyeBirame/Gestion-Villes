package tp2;

public class TestVille {
	public static void main(String args[]) {
	    
		Ville v1, v2, v3 ;
		v1= new Ville ("Valenciennes");
		v2 = new Ville ("Lille", 232741);
		v3 = new Ville("Orchies");
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println();
    
		Capitale paris, rome;
		paris = new Capitale("Paris", "France");
		rome = new Capitale("Rome", "Italie", 2700000);
		paris.setNbHabitants(2181000);
    
		System.out.println(paris);
		System.out.println(rome);
		System.out.println();
    
		System.out.println("catégorie de la ville de " +
        v1.getNom() + " : " + v1.categorie());
		System.out.println("catégorie de la ville de " +
        v2.getNom() + " : " + v2.categorie());
		System.out.println("catégorie de la ville de " +
        paris.getNom() + " : " + paris.categorie());
		System.out.println();
		
		Autoroutes a1 = new Autoroutes("A1", 130, 2, 225, paris, 12.5);
		Autoroutes a23 = new Autoroutes("A23", 130, 2, 50, v2, 0);
		Routes r1 = new Routes("D549", 90, 29, v3);
		v2.addRoute(a1, false);
		v2.addRoute(r1, true);
		v1.addRoute(a23, false);
		a23 = new Autoroutes("A23", 130, 2, 28, v1, 0);
		v3.addRoute(a23, false);
		
		System.out.println("Liste des routes au départ de Lille et Valenciennes :");
		v2.listerRoutes();
		v1.listerRoutes();
		System.out.println();
		
		System.out.println("Itinéraires (avec au plus une ville étape) entre Lille et Valenciennes :");
		v2.listerItineraires(v1);
		
		
		
		 //test du bonus
		 
		/*Ville v4,v5,v6,v7,v8;
		v4=new Ville("Lyon");
		v5=new Ville("Douai");
		v6=new Ville("Nice");
		v7=new Ville("Marseille");
		v8=new Ville("Toulouse");
		Autoroutes a2 = new Autoroutes("A2", 130, 2, 225, v5, 12.5);
		Autoroutes a3 = new Autoroutes("A3", 130, 2, 225,v7 , 5);
		Autoroutes a4 = new Autoroutes("A4", 130, 2, 225, v4, 7);
		Routes r2 = new Routes("D550", 90, 29, v6);
		Routes r3 = new Routes("D551", 90, 29, v6);
		Routes r4 = new Routes("D552", 90, 29, v8);
		Routes r5 = new Routes("D553", 90, 29, v4);
		
		v5.addRoute(r2, true);     //Douai-Nice
		v5.addRoute(a4, false);    //Douai-Lyon
		v4.addRoute(a3, false);    //Lyon-Marseille
		v7.addRoute(r3,true);      //Marseille-Nice
		v5.addRoute(r4, true);     //Douai-Toulouse
		v6.addRoute(a2, false);    //Nice-Douai
		v8.addRoute(r5, true);     //Toulouse-Lyon
		
		v5.lesItineraires(v6,3);
		System.out.println();
		v5.meilleurTrajet(v6,3);*/
		
    }
}

