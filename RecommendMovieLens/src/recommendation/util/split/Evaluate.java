package recommendation.util.split;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Recommendtion.bean.Item;
import Recommendtion.bean.User;
import recommendation.algorithm.TopN;

public class Evaluate {

	public double Recall(HashMap<User,Item> train,HashMap<User,Item> test, int N){
		int hit=0;
		int all=0;
		TopN top=new TopN();
		Iterator iter=train.entrySet().iterator();
		while(iter.hasNext()){
			TopN strategy1=new TopN();
			Map.Entry<User,Item> item=(Entry<User, Item>) iter.next();
			List rank=strategy1.GetRecommendation(item.getKey(),N);
		}
		return 0;
		
	}
}
