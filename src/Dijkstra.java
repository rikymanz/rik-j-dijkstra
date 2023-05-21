import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Dijkstra{

    public static Graph runDijkstra(Graph grafo, Node nodoIniziale) {
    	System.out.println("INIZIO CALCOLO ALGORITMO DIJKSTRA");
    	
    	// il nodo iniziale della quale si vuole calcolare la distanza dovrà avere distanza, da se stesso, 0
    	
    	nodoIniziale.setDistanzaOrigine(0);
    	
    	System.out.println( "NODO INIZIALE: " );
    	System.out.println( nodoIniziale );
        // due array, uno con i nodi definitivi e uno con quelli potenziali da calcolare
        HashSet<Node> nodiDefinitivi = new HashSet<>();
        HashSet<Node> nodiPotenziali = new HashSet<>();
        // All'inizio sarà messa l'origine nei nodi potenziali. E' infatti il primo che va calcolato
        nodiPotenziali.add(nodoIniziale);
        
        
        // Finche nodiPotenziali ha un elemento. Quando non ne ha significa che tutti sono calcolati
        while (nodiPotenziali.size() != 0) {
        	System.out.println("NodiPotenziali: \n" + nodiPotenziali);
        	// Viene preso il nodo potenziale da calcolare con distanza potenziale dall'origine minore
            Node nodoPotenziale = getNodoVicino(nodiPotenziali);
            System.out.println( "NODO CON POTENZIALE MINORE" );
            System.out.println( nodoPotenziale );
            // Visto che il nodo poi divenetrà definitivo, viene rimosso dai nodi potenziali
            nodiPotenziali.remove(nodoPotenziale);
            // for, per ogni elemento di adjacentNodes. Vengono quindi presi tutti gli elmenti che sono collegati al nodo, e per ognuno viene fatto un ciclo
            for (Entry < Node, Integer> infoNodoAdiacente: nodoPotenziale.getNodiAdiacenti().entrySet()) {
            	// i-esimo elemento vicino
                Node nodoAdiacente = infoNodoAdiacente.getKey();
                // distanza dal nodo adiacente
                Integer distanzaNodoAdiacente = infoNodoAdiacente.getValue();
                // se il nodo considerato è già nei nodi calcolati (nodiPotenziali) non va considerato
                // se non c'è, si entra nell'if...
                if (!nodiDefinitivi.contains(nodoAdiacente)) {
                	// calcolo della distanza minima dall'origine al nodo i-esimo
                	setDistanzaNodoPotenziale(nodoAdiacente, distanzaNodoAdiacente, nodoPotenziale);
                    // vengono aggiunti i nodi adiacenti ai nodi potenziali
                    nodiPotenziali.add(nodoAdiacente);
                } // fine if
            } // fine for
            
            // il nodo elaborato viene aggiunto ai nodi definitivi
            nodiDefinitivi.add(nodoPotenziale);
        } // fine while
        return grafo;
    } // fine funzione principale di calcolo algotritmo Dijkstra

    // di tutti i nodi potenziali viene preso quello con la distanza potenziale minore
    private static Node getNodoVicino(HashSet< Node > nodiPotenziali) {
        Node nodoVicino = null;
        // infinito
        int distanzaMinore = Integer.MAX_VALUE;
        // for - per ogni nodo potenziale
        for (Node tempNodo: nodiPotenziali) {
        	// distanza potenziale di ogni nodo
            int tempDistanza = tempNodo.getDistanzaOrigine();
            if (tempDistanza < distanzaMinore) {
            	distanzaMinore = tempDistanza;
                nodoVicino = tempNodo;
            }
        } // fine for
        
        //return del nodo che verrà calcolato e successivamente messo come definitivo
        return nodoVicino;
    } // fine metodo

    // calcola la distanza dal nodo e l'origine. Prende in ingresso il nodo potenziale, la distanza dal nodo definitivo e la distanza dall'origine del nodo definitivo
    private static void setDistanzaNodoPotenziale(Node nodoAdiacente,Integer distanzaNodoAdiacente, Node nodoPotenziale) {
    		// distanza già calcolata del nodo definitivo all'origine
            Integer distanzaOrigineNodoPotenziale = nodoPotenziale.getDistanzaOrigine();
            // vengono confrontate la distanza potenziale del nodo potenziale che si sta calcolando, con la distanza dall'origine del nodo definitiovo vicino + la distanza trai due nodi
            // se quest'ultima è minore si entra nell'if.. Questa somma verrà messa al posto della distanza potenziale
            if (distanzaOrigineNodoPotenziale + distanzaNodoAdiacente < nodoAdiacente.getDistanzaOrigine()) {
            	// viene settata la nuova distanza potenziale del nodo
            	nodoAdiacente.setDistanzaOrigine(distanzaOrigineNodoPotenziale + distanzaNodoAdiacente);
                // creazione linked list con il percorso più veloce.
                // significa che se entra nell'if il modo più veloce per arrivare a questi nodo potenziale è quello di passare da nodo sorgente.
                LinkedList<Node> percorsoMigliore = new LinkedList<>(nodoPotenziale.getPercorsoMigliore());
                // aggiunta del nodo potenziale alla linked list
                percorsoMigliore.add(nodoPotenziale);
                nodoAdiacente.setPercorsoMigliore(percorsoMigliore);
            } // fine if
        } // fine metodo di calcolo distanza minima dall'origine al nodo i-esimo
    
}