package elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class is used to create the 'map' of our program, called 'Graph'. It
 * contains nodes and tracks. By creating a Graph value, the map is created,
 * which makes it possible to lighten the 'Main.java'.
 * 
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 *
 */

public class Main {

        public static void main(String[] args) {

                /** Map creation**/

                Graph graph = new Graph();

                /** Creation of stations to facilitate their use **/

                Station Clervaux = graph.getVertexes().get(0);
                Station Vianden = graph.getVertexes().get(1);
                Station Dierkich = graph.getVertexes().get(2);
                Station Erpeldange = graph.getVertexes().get(3);
                Station Berdorf = graph.getVertexes().get(4);
                Station Grevenmacher = graph.getVertexes().get(5);
                Station LuxVille = graph.getVertexes().get(6);
                Station Bous = graph.getVertexes().get(7);
                Station Petange = graph.getVertexes().get(8);
                Station Belval = graph.getVertexes().get(9);
                Station Dudelange = graph.getVertexes().get(10);

                /**
                // **********************************
                // Unidirectionnal rails test (Multi-Threading Synchronized)
                // **********************************
                 **/

/**/
                Pod pod1 = new Pod(Clervaux, "pod 1", graph);
                Pod pod2 = new Pod(Clervaux, "pod 2", graph);

                // Clervaux
                Passenger Hugo = new Passenger(Clervaux, Erpeldange, "Hugo");
                Passenger Gilles = new Passenger(Clervaux, Erpeldange, "Gilles");
                Passenger Thomas = new Passenger(Clervaux, Erpeldange, "Thomas");
                Passenger Rayan = new Passenger(Clervaux, Erpeldange, "Roger");
                Passenger Jean = new Passenger(Clervaux, Erpeldange, "Jean");


                Clervaux.getPassengerList().add(Hugo);
                Clervaux.getPassengerList().add(Gilles);
                Clervaux.getPassengerList().add(Thomas);
                Clervaux.getPassengerList().add(Rayan);
                Clervaux.getPassengerList().add(Jean);

                Clervaux.getPodList().add(pod1);
                Clervaux.getPodList().add(pod2);

                /** Start() command for stations must be called in order to launch the whole process.
                 * Its equivalent to saying that the station is now "openned to passenger" **/

                Clervaux.start();
        
        
                

                /**
                // **********************************
                // Bidirectional rails test (Multi-Threading Synchronized)
                // **********************************
                **/
/*

                Pod pod1 = new Pod(Clervaux, "pod 1", graph);
                Pod pod2 = new Pod(Erpeldange, "pod 2", graph);

                Passenger Hugo = new Passenger(Clervaux, Erpeldange, "Hugo");
                Passenger Gilles = new Passenger(Erpeldange, Clervaux, "Gilles");

                Clervaux.getPassengerList().add(Hugo);
                Erpeldange.getPassengerList().add(Gilles);

                Clervaux.getPodList().add(pod1);
                Erpeldange.getPodList().add(pod2);

                Clervaux.start();
                Erpeldange.start();
       
        
        */

            /**
		// **********************************
		// Pod Query test
		// **********************************
             **/

/*	
 
  	// No train in Luxembourg City, because the station will ask one of the 3
		// stations to send it one.
		Pod pod3 = new Pod(Bous, "pod 3", graph);
		Pod pod4 = new Pod(Belval, "pod 4", graph);
		Pod pod5 = new Pod(Erpeldange, "pod 5", graph);

		Passenger Hugo = new Passenger(LuxVille, Clervaux, "Hugo");
		Passenger Gilles = new Passenger(LuxVille, Clervaux, "Gilles");

		LuxVille.getPassengerList().add(Hugo);
		LuxVille.getPassengerList().add(Gilles);

		Bous.getPodList().add(pod3);
		Belval.getPodList().add(pod4);
		Erpeldange.getPodList().add(pod5);

		LuxVille.start();
		

*/
                /**
		// **********************************
		// Threads loop --> To check if the pods make multiple trips
		// **********************************
                 **/
		
/*		
 
		Pod pod1 = new Pod(LuxVille, "pod1", graph);
		Pod pod2 = new Pod(LuxVille, "pod2", graph);
	
		
		Passenger Nourdine = new Passenger(LuxVille, Clervaux, "Nourdine");
		Passenger Mohammed = new Passenger(LuxVille, Clervaux, "Mohammed");
		Passenger Yassine = new Passenger(LuxVille, Clervaux, "Yassine");
		Passenger Daoud = new Passenger(LuxVille, Clervaux, "Daoud");
		Passenger Adam = new Passenger(LuxVille, Clervaux, "Adam");
		
		LuxVille.getPassengerList().add(Nourdine);
		LuxVille.getPassengerList().add(Mohammed);
		LuxVille.getPassengerList().add(Yassine);
		LuxVille.getPassengerList().add(Daoud);
		LuxVille.getPassengerList().add(Adam);
		
		LuxVille.getPodList().add(pod1);
		LuxVille.getPodList().add(pod2);
		
		Pod pod3 = new Pod(Clervaux, "pod3", graph);
		
		Passenger Samy = new Passenger(Clervaux, Erpeldange, "Samy");
		Passenger Rafik = new Passenger(Clervaux, Erpeldange, "Rafik");
		Passenger Amir = new Passenger(Clervaux, Erpeldange, "Amir");
		Passenger Leila = new Passenger(Clervaux, Erpeldange, "Leila");
		Passenger Dalila = new Passenger(Clervaux, Erpeldange, "Dalila");
		
		Clervaux.getPassengerList().add(Samy);
		Clervaux.getPassengerList().add(Rafik);
		Clervaux.getPassengerList().add(Amir);
		Clervaux.getPassengerList().add(Leila);
		Clervaux.getPassengerList().add(Dalila);
		
		Clervaux.getPodList().add(pod3);
		
		Passenger Soraya = new Passenger(Dierkich, Berdorf, "Soraya");
		
		Dierkich.getPassengerList().add(Soraya);
		
		
		Clervaux.start();
		LuxVille.start();
		Dierkich.start();
		
		
*/
		/**
		// **********************************
		// BIG TEST
		// **********************************

		// With this big final test, you can see that all the above implementations fit together nicely. 
		// Query pods () work, synchronization too. As long as there are clients, the pods continue their work.
		// The test is finished, when all the clients of the map have reached their destination

         There is some possible errors that can show up that wont impact the whole process at all.
         they result of small conflicts between threads and we didn't want to try-catch them
         **/
/*

		Pod pod1 = new Pod(Clervaux, "Pod 1", graph);
		Pod pod2 = new Pod(Vianden, "Pod 2", graph);
		Pod pod21 = new Pod(Vianden, "Pod 21", graph);
        Pod pod3 = new Pod(Dierkich, "Pod 3", graph);
        Pod pod4 = new Pod(Erpeldange, "Pod 4", graph);
        Pod pod5 = new Pod(Berdorf, "Pod 5", graph);
        Pod pod6 = new Pod(Grevenmacher, "Pod 6", graph);
        Pod pod7 = new Pod(LuxVille, "Pod 7", graph);
        Pod pod71 = new Pod(LuxVille, "Pod 71", graph);
        Pod pod72 = new Pod(LuxVille, "Pod 72", graph);
        Pod pod8 = new Pod(Bous, "Pod 8", graph);
        Pod pod9 = new Pod(Petange, "Pod 9", graph);
        Pod pod91 = new Pod(Petange, "Pod 91", graph);
        Pod pod10 = new Pod(Belval, "Pod 10", graph);
        Pod pod101 = new Pod(Belval, "Pod 101", graph);
        Pod pod11 = new Pod(Dudelange, "Pod 11", graph);
        Pod pod111 = new Pod(Dudelange, "Pod 111", graph);
        
        // Passenger creation    
        
        // Clervaux
        Passenger Hugo = new Passenger(Clervaux, LuxVille, "Hugo");
        Passenger Gilles = new Passenger(Clervaux, LuxVille, "Gilles");
        Passenger Thomas = new Passenger(Clervaux, Berdorf, "Thomas");
        Passenger Rayan = new Passenger(Clervaux, Erpeldange, "Roger");
        Passenger Jean = new Passenger(Clervaux, Belval, "Jean");
        
        // Vianden
        
        Passenger Marko = new Passenger(Vianden, Grevenmacher, "Marko");
        Passenger Jason = new Passenger(Vianden, Dudelange, "Jason");
        Passenger Lionel = new Passenger(Vianden, Petange, "Lionel");
        
     // Dierkich
        Passenger Alain = new Passenger(Dierkich, Belval, "Alain");
        Passenger Kabir = new Passenger(Dierkich, Belval, "Kabir");
        Passenger Joao = new Passenger(Dierkich, Belval, "Joao");
        Passenger Amani = new Passenger(Dierkich, Belval, "Amani");
        Passenger Louis = new Passenger(Dierkich, Belval, "Louis");
        Passenger Farzan = new Passenger(Dierkich, Belval, "Farzan");
        Passenger James = new Passenger(Dierkich, Clervaux, "James");
        Passenger Celine = new Passenger(Dierkich, Clervaux, "Celine");


     // Erpeldange
        Passenger Milad = new Passenger(Erpeldange, Bous, "Milad");
        Passenger Joshua = new Passenger(Erpeldange, Bous, "Joshua");
        
        // Berdorf
        Passenger Tamara = new Passenger(Berdorf, Vianden, "Tamara");
        
        //Grevenmacher
        Passenger Hellen = new Passenger(Grevenmacher, Dudelange, "Hellen");
        Passenger Alexandre = new Passenger(Grevenmacher, Dudelange, "Alexandre");
        Passenger Filipe = new Passenger(Grevenmacher, Petange, "Filipe");
        Passenger Victor = new Passenger(Grevenmacher, Petange, "Victor");
        Passenger Paulo = new Passenger(Grevenmacher, Petange, "Paulo");

        //Luxembourg-ville
        Passenger Gabriela = new Passenger(LuxVille, Grevenmacher, "Gabriela");
        Passenger Guillaume = new Passenger(LuxVille, Grevenmacher, "Guillaume");
        Passenger Yannick = new Passenger(LuxVille, Petange, "Yannick");
        Passenger David = new Passenger(LuxVille, Petange, "David");
        Passenger Joachim = new Passenger(LuxVille, Petange, "Joachim");
        Passenger Samuel = new Passenger(LuxVille, Dudelange, "Samuel");
        Passenger Josh = new Passenger(LuxVille, Bous, "Josh");
        Passenger Emanuel = new Passenger(LuxVille, Clervaux, "Emanuel");
        Passenger Loris = new Passenger(LuxVille, Clervaux, "Loris");
        Passenger Nick = new Passenger(LuxVille, Erpeldange, "Nick");
        Passenger Catalina = new Passenger(LuxVille, Erpeldange, "Catalina");
        Passenger Joey = new Passenger(LuxVille, Bous, "Joey");
        Passenger Mohamad = new Passenger(LuxVille, Vianden, "Mohamad");
        Passenger Ashkan = new Passenger(LuxVille, Vianden, "Ashkan");
        Passenger Tom = new Passenger(LuxVille, Dudelange, "Tom");
        Passenger Alexis = new Passenger(LuxVille, Dudelange, "Alexis");
        Passenger Enes = new Passenger(LuxVille, Dudelange, "Enes");
        Passenger Corentin = new Passenger(LuxVille, Dudelange, "Corentin");
        Passenger Remy = new Passenger(LuxVille, Dudelange, "Remy");
        Passenger Manon = new Passenger(LuxVille, Belval, "Manon");
        Passenger Angelique = new Passenger(LuxVille, Belval, "Angelique");
        Passenger Magali = new Passenger(LuxVille,  Belval, "Magali");
        
        // Bous

        Passenger Jacques = new Passenger(Bous, LuxVille, "Jacques");

        // Petange
        Passenger Lena = new Passenger(Petange, Dierkich, "Lena");
        Passenger Kenza = new Passenger(Petange, Dierkich, "Kenza");
        Passenger Sarah = new Passenger(Petange, Dudelange, "Sarah");
        Passenger Laure = new Passenger(Petange, Dudelange, "Laure");
        Passenger Hajar = new Passenger(Petange, Dudelange, "Hajar");
        Passenger Chahinez = new Passenger(Petange, Dudelange, "Chahinez");
        Passenger Juliette = new Passenger(Petange, Dudelange, "Juliette");
        Passenger Marie = new Passenger(Petange, Belval, "Marie");
        Passenger Victoire = new Passenger(Petange, Belval, "Victoire");
        Passenger Ines = new Passenger(Petange,  Belval, "Ines");
        
        // Belval
        Passenger Adam = new Passenger(Belval, LuxVille, "Adam");
        Passenger Daoud = new Passenger(Belval, LuxVille, "Daoud");
        Passenger Maxence = new Passenger(Belval, LuxVille, "Maxence");
        Passenger Adina = new Passenger(Belval, Dierkich, "Adina");
        Passenger Caroline = new Passenger(Belval, Dierkich, "Caroline");
        Passenger Sara = new Passenger(Belval, Dierkich, "Sara");
        Passenger Steeve = new Passenger(Belval, Erpeldange, "Steeve");
        Passenger Maud = new Passenger(Belval, Berdorf, "Maud");
        Passenger Claude = new Passenger(Belval, Bous, "Claude");
        Passenger Candice = new Passenger(Belval,  Berdorf, "Candice");
        Passenger Anaelle = new Passenger(Belval, LuxVille, "Anaelle");
        Passenger Jade = new Passenger(Belval, LuxVille, "Jade");
        Passenger Ambre = new Passenger(Belval, LuxVille, "Ambre");
        Passenger Hicham = new Passenger(Belval, LuxVille, "Hicham");
        Passenger Azedine = new Passenger(Belval, LuxVille, "Azedine");
        
        // Dudelange
        Passenger Benjamin = new Passenger(Dudelange, Belval, "Benjamin");
        Passenger Quentin = new Passenger(Dudelange, Belval, "Quentin");
        Passenger Loic = new Passenger(Dudelange, Belval, "Loic");
        Passenger Keylian = new Passenger(Dudelange, Grevenmacher, "Keylian");
        Passenger Camille = new Passenger(Dudelange,  Grevenmacher, "Camille");
        Passenger Oriane = new Passenger(Dudelange, Grevenmacher, "Oriane");
        Passenger Fiona = new Passenger(Dudelange, Petange, "Fiona");
        Passenger Lauryne = new Passenger(Dudelange, LuxVille, "Lauryne");
        Passenger Lise = new Passenger(Dudelange, Petange, "Lise");
        Passenger Arthur = new Passenger(Dudelange, Petange, "Arthur");
        
     // Addition of passengers in their respective station
        Clervaux.getPassengerList().add(Hugo);
        Clervaux.getPassengerList().add(Gilles);
        Clervaux.getPassengerList().add(Thomas);
        Clervaux.getPassengerList().add(Rayan);
        Clervaux.getPassengerList().add(Jean);
        
        Vianden.getPassengerList().add(Marko);
        Vianden.getPassengerList().add(Jason);
        Vianden.getPassengerList().add(Lionel);
        
        Dierkich.getPassengerList().add(Alain);
        Dierkich.getPassengerList().add(Kabir);
        Dierkich.getPassengerList().add(Joao);
        Dierkich.getPassengerList().add(Amani);
        Dierkich.getPassengerList().add(Louis);
        Dierkich.getPassengerList().add(Farzan);
        Dierkich.getPassengerList().add(James);
        Dierkich.getPassengerList().add(Celine);
        
        Erpeldange.getPassengerList().add(Milad);
        Erpeldange.getPassengerList().add(Joshua);
        
        Berdorf.getPassengerList().add(Tamara);
        
        Grevenmacher.getPassengerList().add(Hellen);
        Grevenmacher.getPassengerList().add(Alexandre);
        Grevenmacher.getPassengerList().add(Filipe);
        Grevenmacher.getPassengerList().add(Victor);
        Grevenmacher.getPassengerList().add(Paulo);
        
        LuxVille.getPassengerList().add(Gabriela);
        LuxVille.getPassengerList().add(Guillaume);
        LuxVille.getPassengerList().add(Yannick);
        LuxVille.getPassengerList().add(David);
        LuxVille.getPassengerList().add(Joachim);
        LuxVille.getPassengerList().add(Samuel);
        LuxVille.getPassengerList().add(Josh);
        LuxVille.getPassengerList().add(Emanuel);
        LuxVille.getPassengerList().add(Loris);
        LuxVille.getPassengerList().add(Nick);
        LuxVille.getPassengerList().add(Catalina);
        LuxVille.getPassengerList().add(Joey);
        LuxVille.getPassengerList().add(Mohamad);
        LuxVille.getPassengerList().add(Ashkan);
        LuxVille.getPassengerList().add(Tom);
        LuxVille.getPassengerList().add(Alexis);
        LuxVille.getPassengerList().add(Enes);
        LuxVille.getPassengerList().add(Corentin);
        LuxVille.getPassengerList().add(Remy);
        LuxVille.getPassengerList().add(Manon);
        LuxVille.getPassengerList().add(Angelique);
        LuxVille.getPassengerList().add(Magali);
        
        Bous.getPassengerList().add(Jacques);
        
        Petange.getPassengerList().add(Lena);
        Petange.getPassengerList().add(Kenza);
        Petange.getPassengerList().add(Sarah);
        Petange.getPassengerList().add(Laure);
        Petange.getPassengerList().add(Hajar);
        Petange.getPassengerList().add(Chahinez);
        Petange.getPassengerList().add(Juliette);
        Petange.getPassengerList().add(Marie);
        Petange.getPassengerList().add(Victoire);
        Petange.getPassengerList().add(Ines);
        
        Belval.getPassengerList().add(Adam);
        Belval.getPassengerList().add(Daoud);
        Belval.getPassengerList().add(Maxence);
        Belval.getPassengerList().add(Adina);
        Belval.getPassengerList().add(Caroline);
        Belval.getPassengerList().add(Sara);
        Belval.getPassengerList().add(Steeve);
        Belval.getPassengerList().add(Maud);
        Belval.getPassengerList().add(Claude);
        Belval.getPassengerList().add(Candice);
        Belval.getPassengerList().add(Anaelle);
        Belval.getPassengerList().add(Jade);
        Belval.getPassengerList().add(Ambre);
        Belval.getPassengerList().add(Hicham);
        Belval.getPassengerList().add(Azedine);
        
        Dudelange.getPassengerList().add(Benjamin);
        Dudelange.getPassengerList().add(Quentin);
        Dudelange.getPassengerList().add(Loic);
        Dudelange.getPassengerList().add(Keylian);
        Dudelange.getPassengerList().add(Camille);
        Dudelange.getPassengerList().add(Oriane);
        Dudelange.getPassengerList().add(Fiona);
        Dudelange.getPassengerList().add(Lauryne);
        Dudelange.getPassengerList().add(Lise);
        Dudelange.getPassengerList().add(Arthur);
        
        // Addition of pods in their station at the start of the simulation 
        Clervaux.getPodList().add(pod1);  
        Vianden.getPodList().add(pod2);
        Vianden.getPodList().add(pod21);
        Dierkich.getPodList().add(pod3);
        Erpeldange.getPodList().add(pod4);  
        Berdorf.getPodList().add(pod5);  
        Grevenmacher.getPodList().add(pod6);  
        LuxVille.getPodList().add(pod7); 
        LuxVille.getPodList().add(pod71);  
        LuxVille.getPodList().add(pod72);  
        Bous.getPodList().add(pod8);  
        Petange.getPodList().add(pod9);  
        Petange.getPodList().add(pod91);  
        Belval.getPodList().add(pod10);
        Belval.getPodList().add(pod101);
        Dudelange.getPodList().add(pod11);  
        Dudelange.getPodList().add(pod111); 

    // Start() of Threads
        Clervaux.start();
        Vianden.start();
        Dierkich.start();
        Erpeldange.start();
        Berdorf.start();
        Grevenmacher.start();
        LuxVille.start();
        Bous.start();
        Petange.start();
        Belval.start();
        Dudelange.start();

*/

	}
}
