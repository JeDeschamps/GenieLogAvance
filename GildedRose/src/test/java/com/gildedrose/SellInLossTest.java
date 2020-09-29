package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;


class SellInLossTest {
  /* Test de degradation du SellIn */
  @Test
  void agedBrieSellInUpgrade() {
    final Item[] items = new Item[] {new Item("Aged Brie", 5, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getSellIn(), is(4));
  }

  @Test
  void elixirSellInUpgrade() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 7) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getSellIn(), is(4));
  }

  @Test
  void dexterityVestSellInUpgrade() {
    final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getSellIn(), is(9));
  }

  @Test
  void backStagePassSellInUpgrade() {
    final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getSellIn(), is(14));
  }

  @Test
  void sulfurasSellInDoesntChange() {
    final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getSellIn(), is(0));
  }

}
