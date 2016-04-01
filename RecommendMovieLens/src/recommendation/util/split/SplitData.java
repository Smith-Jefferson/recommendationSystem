package recommendation.util.split;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import Recommendtion.bean.Item;
import Recommendtion.bean.User;
public class SplitData {
	public List<HashMap<User,Item>> SpilitData(HashMap<User,Item> Data,int M,int K,long seed){
	
		HashMap<User,Item> test = new LinkedHashMap<>();
		HashMap<User,Item> train = new LinkedHashMap<>();
		Random rand=new Random(seed);
		Iterator<Entry<User, Item>> iterator=Data.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<User,Item> useritem=(Entry<User,Item>) iterator.next();
			if(rand.nextInt(M)==K){
				test.put(useritem.getKey(), useritem.getValue());
			}else
				train.put(useritem.getKey(), useritem.getValue());
		}
		List<HashMap<User,Item>> Temp=new LinkedList<>();
		Temp.add(test);
		Temp.add(train);
		return Temp;
	}

}
