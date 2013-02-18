import java.util.Arrays;
//import java.util.Collections;

public class OrderCompare {

	int aux;
	
	public int[] orderCompare(int a[], String comp){
		
		if(comp.equals("inc")) {
			
			if(a[1] == -1) return a;
			
			else if(a[2] == -1){
				int aux = Math.min(a[0], a[1]);
				a[1] = Math.max(a[0], a[1]);
				a[0] = aux;
			}
			else{
				Arrays.sort(a);
			}
		} 
		
		else {
			
			if(a[1] == -1) return a;
			
			else if(a[2] == -1){
				int aux = Math.max(a[0], a[1]);
				a[1] = Math.min(a[0], a[1]);
				a[0] = aux;
			}
			else{
				//Arrays.sort(a, Collections.reverseOrder());
				Arrays.sort(a);
			
				aux = a[0];						//mirror the array
				a[0] = a[2];					//Collections.reverseOrder doesn't work on primitives
				a[2] = aux;
				
			}
		}
		
		return a;
	}
}
