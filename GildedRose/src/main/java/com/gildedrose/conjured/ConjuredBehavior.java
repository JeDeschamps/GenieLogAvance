package com.gildedrose;

import com.gildedrose.BehaviorFactory;
import com.gildedrose.Item;


public class ConjuredBehavior implements Behavior {

    public void updateItemQuality(Item it){ 
        String str = it.getName().replace("Conjured ","");
        it.setName(str);
        Behavior normalBehavior = BehaviorFactory.getItemBehavior(it);
        normalBehavior.updateItemQuality(it);
        normalBehavior.updateItemQuality(it);
        it.setName("Conjured " + it.getName());
    }
}
