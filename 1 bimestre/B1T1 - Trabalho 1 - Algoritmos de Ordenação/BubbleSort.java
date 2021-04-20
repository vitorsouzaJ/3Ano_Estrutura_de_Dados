package Sort;

import java.util.Comparator;
import java.util.List;

public class BubbleSort<T> implements Sort<T> {
	
	@Override
	
	public void sort(List<T> list, Comparator<T> comparator){
		for(int i = 0;i< list.size(); i ++) {
			for(int j = 0; j < list.size(); j ++) {
				if(comparator.compare(list.get(i), list.get(j)) > 0 ) {
					T temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
					
				}
			}
		}
		
		
	}

}
