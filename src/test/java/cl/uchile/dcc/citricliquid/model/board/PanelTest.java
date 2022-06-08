package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.panels.*;
import cl.uchile.dcc.citricliquid.model.enemies.bosses.StoreManager;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.Chicken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
class PanelTest {
  private final static String PLAYER_NAME = "Suguri";
  private final static int BASE_HP = 4;
  private final static int BASE_ATK = 1;
  private final static int BASE_DEF = -1;
  private final static int BASE_EVD = 2;
  private HomePanel testHomePanel;
  private NeutralPanel testNeutralPanel;
  private BonusPanel testBonusPanel;
  private DrawPanel testDrawPanel;
  private DropPanel testDropPanel;
  private EncounterPanel testEncounterPanel;
  private BossPanel testBossPanel;
  private Player suguri;
  private StoreManager storeManager;
  private Chicken chicken;
  private long testSeed;

  @BeforeEach
  public void setUp() {
    suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    storeManager = new StoreManager();
    chicken = new Chicken();
    testBonusPanel = new BonusPanel();
    testBossPanel = new BossPanel(storeManager);
    testDrawPanel = new DrawPanel();
    testDropPanel = new DropPanel();
    testEncounterPanel = new EncounterPanel();
    testHomePanel = new HomePanel(suguri);
    testNeutralPanel = new NeutralPanel();
    testSeed = new Random().nextLong();
  }

  @Test
  public void constructorTest() {
    assertEquals(testBonusPanel, testBonusPanel);
    assertEquals(testBossPanel, testBossPanel);
    assertEquals(testDrawPanel, testDrawPanel);
    assertEquals(testDropPanel, testDropPanel);
    assertEquals(testEncounterPanel, testEncounterPanel);
    assertEquals(testHomePanel, testHomePanel);
    assertEquals(testNeutralPanel, testNeutralPanel);
  }

  @Test
    public void nextPanelTest() {
      assertTrue(testNeutralPanel.getNextPanels().isEmpty());
      final var expectedPanel1 = new NeutralPanel();
      final var expectedPanel2 = new NeutralPanel();

      testNeutralPanel.addNextPanel(expectedPanel1);
      assertEquals(1, testNeutralPanel.getNextPanels().size());

      testNeutralPanel.addNextPanel(expectedPanel2);
      assertEquals(2, testNeutralPanel.getNextPanels().size());

      testNeutralPanel.addNextPanel(expectedPanel2);
      assertEquals(2, testNeutralPanel.getNextPanels().size());

      assertEquals(Set.of(expectedPanel1, expectedPanel2),
                   testNeutralPanel.getNextPanels());
    }

  @Test
  public void homePanelTest() {
    assertEquals(suguri, testHomePanel.getOwner());
    // To norma 2.
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.increaseStarsBy(10);
    testHomePanel.activate(suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    assertEquals(2, suguri.getNormaLevel());
    // To norma 3.
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.increaseStarsBy(20);
    testHomePanel.activate(suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    assertEquals(3, suguri.getNormaLevel());
    // To norma 4.
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.increaseStarsBy(40);
    testHomePanel.activate(suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    assertEquals(4, suguri.getNormaLevel());
    // To norma 5.
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.increaseStarsBy(50);
    testHomePanel.activate(suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    assertEquals(5, suguri.getNormaLevel());
    // To norma 6.
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.increaseStarsBy(80);
    testHomePanel.activate(suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    assertEquals(6, suguri.getNormaLevel());
    // Recover 1 HP.
    suguri.setCurrentHp(1);
    testHomePanel.activate(suguri);
    assertEquals(2, suguri.getCurrentHp());
  }

  @Test
  public void neutralPanelTest() {
    final var expectedSuguri = suguri.copy();
    testNeutralPanel.activate(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  // region : Consistency tests
  @RepeatedTest(100)
  public void bonusPanelConsistencyTest() {
    int expectedStars = 0;
    assertEquals(expectedStars, suguri.getStars());
    final var testRandom = new Random(testSeed);
    suguri.setSeed(testSeed);
    for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
      final int roll = testRandom.nextInt(6) + 1;
      testBonusPanel.activate(suguri);
      expectedStars += roll * Math.min(3, normaLvl);
      assertEquals(expectedStars, suguri.getStars(),
                   "Test failed with seed: " + testSeed);
      suguri.normaClear();
    }
  }

  @RepeatedTest(100)
  public void dropPanelConsistencyTest() {
    int expectedStars = 30;
    suguri.increaseStarsBy(30);
    assertEquals(expectedStars, suguri.getStars());
    final var testRandom = new Random(testSeed);
    suguri.setSeed(testSeed);
    for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
      final int roll = testRandom.nextInt(6) + 1;
      testDropPanel.activate(suguri);
      expectedStars = Math.max(expectedStars - roll * normaLvl, 0);
      assertEquals(expectedStars, suguri.getStars(),
                   "Test failed with seed: " + testSeed);
      suguri.normaClear();
    }
  }

  @Test
  public void BossTest() {
    assertEquals(storeManager, testBossPanel.getBoss());
    final var expectedSuguri = suguri.copy();
    testBossPanel.activate(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  @Test
  public void DrawTest() {
    final var expectedSuguri = suguri.copy();
    testDrawPanel.activate(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  @Test
  public void EncounterTest() {
    testEncounterPanel.setWildUnit(chicken);
    final var expectedSuguri = suguri.copy();
    testEncounterPanel.activate(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  // endregion
}