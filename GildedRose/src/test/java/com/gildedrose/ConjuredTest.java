package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gildedrose.behavior.*;

import static org.hamcrest.Matchers.*;

/**
 * Cette classe va effectuer les tests du comportement de degradation de qualite des items conjured quels qu'ils soient.
 * Tests effectues :
 * - Degradation de qualite de conjured dexterity vest
 * - Degradation de qualite de conjured dexterity vest perime
 * - Degradation de qualite de conjured sulfuras
 * - Degradation de qualite de conjured sulfuras expire
 * - Degradation de qualite de conjured elixir
 * - Augmentation de qualite de conjured aged brie
 * - Augmentation de qualite de conjured backstage pass dans les 3 cas
 * - Augmentation de qualite d'un item conjured ne depasse pas la limite de 50
 */

class ConjuredTest {
  private transient String conjuredBackstagePass = "Conjured Backstage passes to a TAFKAL80ETC concert";
  private transient String conjuredDexterityVest = "Conjured +5 Dexterity Vest";
  private transient String conjuredSulfuras = "Conjured Sulfuras, Hand of Ragnaros";

  @Test
  void conjuredDexterityVestQualityUpgrade() {
    final Item[] items = new Item[] {new Item(conjuredDexterityVest, 5, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(18));
  }

  @Test
  void conjuredDexterityVestQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(conjuredDexterityVest, -5, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(16));
  }
  @Test
  void conjuredSulfurasQualityUpgrade() {
    final Item[] items = new Item[] {new Item(conjuredSulfuras, 5, 80)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(80));
  }

  @Test
  void conjuredSulfurasQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(conjuredSulfuras, -5, 80)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(80));
  }

  @Test
  void conjuredElixirQualityUpgrade() {
    final Item[] items = new Item[] {new Item("Conjured Elixir of the Mongoose", 5, 7) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(5));
  }

  @Test
  void conjuredAgedBrieQualityUpgrade() {
    final Item[] items = new Item[] {new Item("Conjured Aged Brie", 2, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(2));
  }

  @Test
  void conjuredBackstagePassQualityUpgradeSellInAbove10() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 15, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(22));
  }

  @Test
  void conjuredBackstagePassQualityUpgradeSellInUnder10Above5() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 10, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(24));
  }

  @Test
  void conjuredBackstagePassQualityUpgradeSellInUnder5Above0() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 1, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(26));
  }
  @Test
  void conjuredBackstagePassQualityUpgradeSellInUnder5Above0CapsAt50() {
    final Item[] items = new Item[] {new Item(conjuredBackstagePass, 1, 46) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(50));
  }
}
