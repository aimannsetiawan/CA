package project2;
import java.util.Comparator;

public class comparator implements Comparator<results> {
	
	public int compare(results a, results b) {
       return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
    }

}
