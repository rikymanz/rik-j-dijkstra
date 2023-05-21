import java.util.HashSet;

public class Graph {
	// Lista di nodi, le info dei collegamenti sono valori interni ai nodi
    private HashSet<Node> listaNodi = new HashSet<>();
    
    public void inserisciNodo( Node nodo ) {
    	listaNodi.add( nodo );
    }

}