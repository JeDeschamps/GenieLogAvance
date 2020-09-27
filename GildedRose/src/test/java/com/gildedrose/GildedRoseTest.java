package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
    
    /* Tests de bonne degradation de la qualite pour chaque items */
    @Test
    void DexterityVestQualityUpgrade() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(19));
    }

    @Test
    void ElixirQualityUpgrade() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(6));
    }

    @Test
    void QualityUpgradeWhenNegativeQualityHasNoEffect() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, -5) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(-5));
    }
    @Test
    void AgedBrieQualityUpgrade() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(1));
    }
    
    @Test
    void SulfurasQualityDoesntChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }

    @Test
    void BackstagePassQualityUpgradeSellInAbove10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(21));
    }

    @Test
    void BackstagePassQualityUpgradeSellInUnder10Above5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(22));
    }

    @Test
    void BackstagePassQualityUpgradeSellInUnder5Above0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(23));
    }

    @Test
    void BackstagePassQualityDropsToZeroWhenExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void DexterityVestQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(18));
    }

    @Test
    void ElixirQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(5));
    }

    @Test
    void AgedBrieQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(2));
    }
    
    @Test
    void SulfurasQualityDoesntChangeWhenExpired() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(80));
    }

    /* Test de degradation du SellIn */
    @Test
    void AgedBrieSellInUpgrade() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(4));
    }

    @Test
    void ElixirSellInUpgrade() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(4));
    }
    
    @Test
    void DexterityVestSellInUpgrade() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(9));
    }

    @Test
    void BackStagePassSellInUpgrade() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(14));
    }

    @Test
    void SulfurasSellInDoesntChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(0));
    }

    /* Qualite ne passe pas en dessous de 0 quand l'item n'est pas perime */
    @Test
    void DexterityVestQualityDoesntDropUnder0() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void ElixirQualityDoesntDropUnder0() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void BackStagePassQualityDoesntDropUnder0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void BackStagePassQualityEquals0WhenExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -2, -10) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    /* Qualite ne depasse pas les 50 quand l'item n'est pas perime */

    @Test
    void AgedBrieQualityDoesntGoAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }

    @Test
    void AgedBrieQualityIncrementsWhenQualityUnder0() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, -2) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(-1));
    }

    @Test
    void BackStagePassQualityDoesntGoAbove50WhenSellInAbove10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }

    @Test
    void BackStagePassQualityDoesntGoAbove50WhenSellInUnder10Above5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }

    @Test
    void BackStagePassQualityDoesntGoAbove50WhenSellInUnder5Above0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }
    
    /* Qualite ne passe pas en dessous de 0 quand l'item est perime */
    @Test
    void DexterityVestQualityDoesntDropUnder0WhenExpired() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 1) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void ElixirQualityDoesntDropUnder0WhenExpired() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, 1)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }


    /* Qualite ne depasse pas les 50 quand l'item est perime */

    @Test
    void AgedBrieQualityDoesntGoAbove50WhenExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }
    @Test
    void Try() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) };
        BackstagePassBehavior test = new BackstagePassBehavior();
        test.updateItemQuality(items[0]);
        assertThat(items[0].quality, is(12));
    }

    @Test
    void TrySellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0) };
        BackstagePassBehavior test = new BackstagePassBehavior();
        test.updateItemSellIn(items[0]);
        assertThat(items[0].sellIn, is(2));
    }
}

