//Implementation of Minimum Spanning Tree
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * @author swapnil
 *
 */
public class MST {
    

    static int PrimMST(Graph g)
    {
        for(Vertex v:g){
        	v.parent=null;
        	v.seen=false;
        }
    	Vertex src=g.verts.get(1);
    	src.seen=true;
    	int wmst=0;
    	BinaryHeap<Edge> q=new BinaryHeap<>(g.numberOfEdges);
        for(Edge e:g.verts.get(1).Adj){
            q.add(e);    	
        }
        
        while(q.size()>0){
        Edge e=q.remove();	
        if(e.From.seen&&e.To.seen) continue;
        Vertex v;
        if(e.From.seen==true){
        	v=e.To;
        }else{
        	v=e.From;
        }                   //u.seen ==true
                            //unseen 
       
        wmst+=e.Weight;
        v.seen=true;
        for(Edge f:v.Adj){
        	Vertex w=f.otherEnd(v);
              if(!w.seen){
            	  q.add(f);
              }
        }	
        	
        	
        }
                         

        return wmst;
    }

    public static void main(String[] args) throws FileNotFoundException 
    {
    	File f1 = new File("D:/EcNeon/SP0PQ/input.txt");
    	Timer timer = new Timer();
        
		Scanner sc = new Scanner(f1);
		Graph g = Graph.readGraph(sc, false);
		timer.start();
		          	int weight=PrimMST(g);
    System.out.println("Weight of Graph "+weight);
    timer.end();
    System.out.println(timer);
    }
}
