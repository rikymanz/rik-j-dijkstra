
import java.util.LinkedList;
import java.util.HashMap;

public class Node {
    // nome del nodo
    private String nome;
    
    // linked list con il percorso minore per arrivare al nodo
    private LinkedList<Node> percorsoMigliore = new LinkedList<>();
    
    // distanza calcolata dell'origine (all'inizio è infinito)
    private Integer distanzaOrigine = Integer.MAX_VALUE;
    
    // nodi adiacenti coppia nodo, distanza dal nodo (intero)
    HashMap<Node, Integer> nodiAdiacenti = new HashMap<>();

    public void collegaNodo(Node nodo, int valore) {
    	nodiAdiacenti.put(nodo, valore);
    }
 
    public Node(String nome) {
        this.nome = nome;
    }
    
    public int getDistanzaOrigine() {
    	return this.distanzaOrigine;
    }
    
    public void setDistanzaOrigine( int valore ){
    	this.distanzaOrigine = valore;
    }
    
    public HashMap<Node, Integer> getNodiAdiacenti(){
    	return this.nodiAdiacenti;
    }
    
    public LinkedList<Node> getPercorsoMigliore(){
    	return this.percorsoMigliore;
    }
    
    public void setPercorsoMigliore( LinkedList<Node> percorsoMigliore ) {
    	this.percorsoMigliore = percorsoMigliore;
    }
    
    public void setNome( String nome ) {
    	this.nome = nome;
    }

    public String getNome() {
    	return this.nome;
    }
    
    @Override  
    public String toString() {
    	return "Nome:" + this.nome + "\n" +
    			"Distanza origine: " + this.distanzaOrigine + "\n"
    			;	
    }
    
}