
public class Test {

	public static void main(String[] args) {
		
		// COSTRUZIONE DEL GRAFO
		Node nodoA = new Node("A");
		Node nodoB = new Node("B");
		Node nodoC = new Node("C");
		Node nodoD = new Node("D"); 
		Node nodoE = new Node("E");
		Node nodoF = new Node("F");
		Node nodoG = new Node("G");
		
		// AGGIUNTA DEI COLLEGAMENTI TRAI NODI
		nodoA.collegaNodo(nodoB, 2);
		nodoA.collegaNodo(nodoE, 8);
		nodoB.collegaNodo(nodoC, 6);
		nodoB.collegaNodo(nodoD, 2);
		nodoC.collegaNodo(nodoG, 5);
		nodoD.collegaNodo(nodoE, 2);
		nodoD.collegaNodo(nodoF, 9);
		nodoE.collegaNodo(nodoF, 3);
		nodoF.collegaNodo(nodoG, 1);

		// aggiunta dei nodi al grafo
		Graph graph = new Graph();
		
		graph.inserisciNodo(nodoA);
		graph.inserisciNodo(nodoB);
		graph.inserisciNodo(nodoC);
		graph.inserisciNodo(nodoD);
		graph.inserisciNodo(nodoE);
		graph.inserisciNodo(nodoF);
		graph.inserisciNodo(nodoG);
		
		// calcolo dell'algoritmo di Dijkstra
		// i valori calcolati saranno direttamente scritti nei nodi
		/*
		 * nodo.distanzaOrigine : sarà il costo del percorso migliore calcolato dal nodo all'origine (quella inserita come parametro in runDijkstra, cioè nodeA)
		 * nodo.percorsoMigliore : è una linked list dei nodi dall'origine fino al nodo stesso. Rappresenta il percorso migliroe
		 * 
		 * */
		
		graph = Dijkstra.runDijkstra(graph, nodoA);
		
		System.out.println( "IL PERCORSO MIGLIORE E'" );
		System.out.println( nodoG.getPercorsoMigliore() );
		System.out.println( "LA DISTANZA MINORE TRA A E G E'" + nodoG.getDistanzaOrigine() );
		
		

		
	}

}
