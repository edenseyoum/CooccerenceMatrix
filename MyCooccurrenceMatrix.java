import java.util.*;


public class MyCooccurrenceMatrix implements CooccurrenceMatrix {

    private List<String> kw;
    private Map<String, HashMap<String, Integer>> matrix;// = HashMap<String, HashMap<String, Integer>>();

    public MyCooccurrenceMatrix(List<String> keyword){
	kw = keyword;
	matrix = new HashMap<String, HashMap<String, Integer>>();

	for(String s: keyword){
	    HashMap<String, Integer> inner = new HashMap<String, Integer>();
	    matrix.put(s, inner);
	    for(String t: keyword) {
		inner.put(t, 0);
	    }
	}
    }


    public void update(List<String> context){
	List<String> cntxt = context;
	Set<String> nonDuplicate = new HashSet<String>();
	nonDuplicate.addAll(cntxt);
	cntxt.clear();
	cntxt.addAll(nonDuplicate);


	List<String> c = new ArrayList<String>();
	for(String m: cntxt){
	    if(matrix.containsKey(m))
		c.add(m);
	}

	for(String k: c){
	    for(String l: c){
		//HashMap<String, Integer> innerNow = matrix.get(k);
		//innerNow.put(l, (matrix.get(k).get(l) + 1));
		//matrix.put(k, innerNow);
		int i = matrix.get(k).get(l);
		matrix.get(k).put(l, i+1);
	    }
	}

    }


    public double[] getVector(String keyword){
	double[] d = new double[kw.size()];

	if(!matrix.containsKey(keyword))
	    throw new IllegalArgumentException();

	else
	    for(int i = 0 ; i < kw.size(); i++){
		d[i] = ((double)matrix.get(keyword).get(kw.get(i)))/ (double)matrix.get(keyword).get(keyword);
	    }
	return d;

    }
}

		



	        



 

