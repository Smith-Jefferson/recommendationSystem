package recommendation.util.split;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import Recommendtion.bean.Item;
import Recommendtion.bean.Tag;

public class CalculateUtils {
	public static double cosineSim(Entry<Item, ArrayList<Tag>> item_tags1,Entry<Item, ArrayList<Tag>> item_tags2){
		if(item_tags1!=null && item_tags2!=null){
			Item item1=item_tags1.getKey();
			Item item2=item_tags2.getKey();
			if(item_tags1==item_tags2 || item1.equals(item2))
				return 1;
			else{
				ArrayList<Tag> tagCount1=item_tags1.getValue();
				ArrayList<Tag> tagCount2=item_tags2.getValue();
				int ret=0;
				int index=0;
				int ni=0;int nj=0;
				for(Tag tag1:tagCount1){
					Tag tag2=tagCount2.get(index);
					if(tag1.getCount()!=0 && tag2.getCount()!=0){
						ret +=tag1.getCount() * tag2.getCount();
						ni+=Math.pow(tag1.getCount(), 2);
						nj+=Math.pow(tag2.getCount(), 2);
					}
					++index;
				}
				double sim=ret/Math.sqrt(ni*nj);
				return	sim;			
			}
		}
		
		return 0.00;
	}
	

	/**
	 * ≤‚ ‘∑Ω∑®
	 * @param arags
	 */
	public static void main(String[] arags){
		
	}

}
