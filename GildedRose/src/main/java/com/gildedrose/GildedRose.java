package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item it : this.items) {
            updateQualityForItem(it);
        }
    }
    public void updateQualityForItem(Item it) {
        Behavior itemBehavior = BehaviorFactory.getItemBehavior(it);
        itemBehavior.updateItemQuality(it);
        itemBehavior.updateItemSellIn(it);
    }
}