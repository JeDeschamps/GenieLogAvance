package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;


class GildedRoseTest {
    
    @Test 
    void toStringReturnsString() {
        Item tmp = new Item("+5 Dexterity Vest", 10, 20);
        String str = tmp.toString();
        assertThat(str.getClass(), is(String.class));
    }
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

    /* Test de degradation de qualite quand les items sont expires */
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
    void AgedBrieQualityUpgradeWhenExpiredCapsAt50() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 49) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
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


    /* Tests unitaires pour verifier la bonne instanciation des classes */
    @Test
    void FactoryReturnsBackstagePassBehaviorClass() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(BackstagePassBehavior.class));
    }

    @Test
    void FactoryReturnsAgedBrieBehaviorClass() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50)  };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(AgedBrieBehavior.class));
    }

    @Test
    void FactoryReturnsDexterityVestBehaviorClass() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 50)  };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(DexterityVestBehavior.class));
    }

    @Test
    void FactoryReturnsElixirBehaviorClass() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(ElixirBehavior.class));
    }

    @Test
    void FactoryReturnsSulfuraBehaviorClass() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80), };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(SulfurasBehavior.class));
    }

    @Test
    void FactoryReturnsConjuredBehaviorClass() {
        Item[] items = new Item[] { new Item("Conjured Sulfuras, Hand of Ragnaros", 0, 80) };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(ConjuredBehavior.class));
    }
    @Test
    void BehaviorFactoryClass() {
        BehaviorFactory Factory = new BehaviorFactory();
        assertThat(Factory.getClass(), is(BehaviorFactory.class));
    }

    @Test
    void FactoryReturnsDefaultBehaviorIfItemDoesntExist() {
        Item[] items = new Item[] { new Item("Item doesn't exist", 0, 80), };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(ElixirBehavior.class));
    }

    /* Tests comportements du conjured */
    
    @Test
    void ConjuredDexterityVestQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured +5 Dexterity Vest", 5, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(18));
    }

    @Test
    void ConjuredDexterityVestQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Conjured +5 Dexterity Vest", -5 , 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(16));
    }
    @Test
    void ConjuredSulfurasQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured Sulfuras, Hand of Ragnaros", 5, 80)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(80));
    }

    @Test
    void ConjuredSulfurasQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Conjured Sulfuras, Hand of Ragnaros", -5, 80)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(80));
    }

    @Test
    void ConjuredElixirQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured Elixir of the Mongoose", 5, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(5));
    }

    @Test
    void ConjuredAgedBrieQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured Aged Brie", 2, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(2));
    }

    @Test
    void ConjuredBackstagePassQualityUpgradeSellInAbove10() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(22));
    }

    @Test
    void ConjuredBackstagePassQualityUpgradeSellInUnder10Above5() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(24));
    }

    @Test
    void ConjuredBackstagePassQualityUpgradeSellInUnder5Above0() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 1, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(26));
    }
    @Test
    void ConjuredBackstagePassQualityUpgradeSellInUnder5Above0CapsAt50() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 1, 46) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }

    
}

