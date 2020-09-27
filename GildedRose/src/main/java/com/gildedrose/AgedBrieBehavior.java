package com.gildedrose;

import com.gildedrose.Item;

public class AgedBrieBehavior implements Behavior {
    private final int MAX_QUALITY = 50;


    public void updateItemQuality(Item it){ 
        if (it.quality < MAX_QUALITY)
        {
            it.quality = it.quality + 1;
            if(it.quality < MAX_QUALITY && isExpired(it))
                it.quality = it.quality + 1;
        }
    }
}