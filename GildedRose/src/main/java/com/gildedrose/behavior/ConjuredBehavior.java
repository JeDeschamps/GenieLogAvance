package com.gildedrose;

import com.gildedrose.BehaviorFactory;
import com.gildedrose.Item;


public class ConjuredBehavior implements Behavior {
    private Behavior normalItemBehavior;

    public void updateItemQuality(Item it){ 
        String str = it.name.replace("Conjured ","");
        it.name = str;
        Behavior normalBehavior = BehaviorFactory.getItemBehavior(it);
        normalBehavior.updateItemQuality(it);
        normalBehavior.updateItemQuality(it);
        it.name = "Conjured " + it.name;
    }
}
