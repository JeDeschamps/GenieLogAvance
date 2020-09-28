package com.gildedrose;

import com.gildedrose.Item;

public class DexterityVestBehavior implements Behavior {
    private final int MIN_QUALITY = 0;


    public void updateItemQuality(Item it){ 
        if (it.getQuality() > MIN_QUALITY)
        {
            it.setQuality(it.getQuality() - 1);
            if(it.getQuality() > MIN_QUALITY && isExpired(it))
                it.setQuality(it.getQuality() - 1);
        }
    }
}
