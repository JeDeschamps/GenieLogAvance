package com.gildedrose;

import com.gildedrose.Item;

public class BackstagePassBehavior implements Behavior {
    private final int MIN_QUALITY = 0;
    private final int MAX_QUALITY = 50;
    private final int DAYS_REMAINING_10 = 10;
    private final int DAYS_REMAINING_5 = 5;
    private final int NORMAL_UPGRADE = 1;
    private final int UPGRADE_DAYS_UNDER_10 = 2;
    private final int UPGRADE_DAYS_UNDER_5 = 3;


    public void updateItemQuality(Item it){ 
        int increase = (it.getSellIn() <= DAYS_REMAINING_10 ? (it.getSellIn() <= DAYS_REMAINING_5 ? UPGRADE_DAYS_UNDER_5 : UPGRADE_DAYS_UNDER_10) : NORMAL_UPGRADE);
        if (isExpired(it)){
            it.setQuality(0);
        }
        else {
            int tmp = (it.getQuality() + increase) > MAX_QUALITY ? 50 : it.getQuality() + increase;
            it.setQuality(tmp);
        }
    }
}
