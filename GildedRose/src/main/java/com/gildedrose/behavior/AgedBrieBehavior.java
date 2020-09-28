package com.gildedrose;

import com.gildedrose.Item;

public class AgedBrieBehavior implements Behavior {
    private final int MAX_QUALITY = 50;


    public void updateItemQuality(Item it){ 
        if (it.getQuality() < MAX_QUALITY)
        {
            it.setQuality(it.getQuality() + 1);
            if(it.getQuality() < MAX_QUALITY && isExpired(it))
                it.setQuality(it.getQuality() + 1);
        }
    }
}