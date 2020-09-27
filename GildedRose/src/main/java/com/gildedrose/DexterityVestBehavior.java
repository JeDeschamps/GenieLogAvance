package com.gildedrose;

import com.gildedrose.Item;

public class DexterityVestBehavior implements Behavior {
    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;


    public void updateItemQuality(Item it){ 
        if (it.quality > MIN_QUALITY)
        {
            it.quality = it.quality - 1;
            if(it.quality > MIN_QUALITY && isExpired(it))
                it.quality = it.quality - 1;
        }
    }
}
