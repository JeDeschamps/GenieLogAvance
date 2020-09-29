package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gildedrose.behavior.*;

import static org.hamcrest.Matchers.*;


class ConjuredTest {
  /* Tests comportements du conjured */
  private transient String conjuredBackstagePass = "Conjured Backstage passes to a TAFKAL80ETC concert";
  private transient String conjuredDexterityVest = "Conjured +5 Dexterity Vest";
  private transient String conjuredSulfuras = "Conjured Sulfuras, Hand of Ragnaros";

  @Test
  void conjuredDexterityVestQualityUpgrade() {
    final Item[] items = new Item[] {new Item(conjuredDexterityVest, 5, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(18));
  }

  @Test
  void conjuredDexterityVestQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(conjuredDexterityVest, -5, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(16));
  }
  @Test
  void conjuredSulfurasQualityUpgrade() {
    final Item[] items = new Item[] {new Item(conjuredSulfuras, 5, 80)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(80));
  }

  @Test
  void conjuredSulfurasQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(conjuredSulfuras, -5, 80)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(80));
  }

  @Test
  void conjuredElixirQualityUpgrade() {
    final Item[] items = new Item[] {new Item("Conjured Elixir of the Mongoose", 5, 7) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(5));
  }

  @Test
  void conjuredAgedBrieQualityUpgrade() {
    final Item[] items = new Item[] {new Item("Conjured Aged Brie", 2, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(2));
  }

  @Test
  void conjuredBackstagePassQualityUpgradeSellInAbove10() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 15, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(22));
  }

  @Test
  void conjuredBackstagePassQualityUpgradeSellInUnder10Above5() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 10, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(24));
  }

  @Test
  void conjuredBackstagePassQualityUpgradeSellInUnder5Above0() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 1, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(26));
  }
  @Test
  void conjuredBackstagePassQualityUpgradeSellInUnder5Above0CapsAt50() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 1, 46) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }
}
