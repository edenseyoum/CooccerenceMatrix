/*import java.util.*;


public class MyCooccurrenceMatrix2 implements CooccurrenceMatrix {

    private List<String> kw;
    private Map<String, HashMap<Integer, Double>> matrix;// = HashMap<String, HashMap<String, Integer>>();
    private HashMap<String, Integer> denom;

    public MyCooccurrenceMatrix2(List<String> keyword){
	kw = keyword;
	denom = new HashMap<String, Integer>();
	matrix = new HashMap<String, HashMap<Integer, Double>>();
        HashMap<Integer, Double> inner = new HashMap<Integer, Double>();
	for(String s: keyword){
	    for(String t: keyword) {
		inner.put(0, 0.0);
	    }
	    matrix.put(s, inner);
	    denom.put(s, 0);
	}
    }


    public void update(List<String> context){
	//int denom = 0;
	for(String s: context){
	    if(matrix.containsKey(s)){
		//denom = denom + 1;
		denom.put(s, (denom.get(s)+1));
		for(int i= context.indexOf(s); i < context.size(); i++){
		    if(matrix.containsKey(context.get(i))){
			HashMap<Integer, Double> innerNow = matrix.get(s);
			//since I am not keeping track of the numerator, I will retrive it by multiplying the denomenator with the previous result, stored in matrix.
			int nom = matrix.get(s).get(context.get(i)) + 1;
			double result = nom/denom.get(s);
			//System.out.println( ((denom.get(s) * matrix.get(s).get(context.get(i)))+ 1 )/denom.get(s));
			innerNow.put(nom, result);
			//matrix.get(s).put(t, result);
			matrix.put(s, innerNow);
		    }
		}
	    }
	}

    }


    public double[] getVector(String keyword){
	double[] d = new double[kw.size()];
	if(!matrix.containsKey(keyword))
	    throw new IllegalArgumentException();
	else
	    //double[] d;
	for(int i = 0; i < kw.size(); i++){
	    d[i] = matrix.get(keyword).get(kw.get(i));
	}
	return d;

    }
}
*/