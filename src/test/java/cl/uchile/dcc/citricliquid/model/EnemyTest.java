package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.model.enemies.bosses.FlyingCastle;
import cl.uchile.dcc.citricliquid.model.enemies.bosses.ShifuRobot;
import cl.uchile.dcc.citricliquid.model.enemies.bosses.StoreManager;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.Chicken;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.RoboBall;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.Seagull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {
    private Chicken chicken;
    private RoboBall roboball;
    private Seagull seagull;
    private FlyingCastle flyingCastle;
    private ShifuRobot sRobot;
    private StoreManager storeManager;

    @BeforeEach
    public void setUp(){
        chicken = new Chicken();
        roboball = new RoboBall();
        seagull = new Seagull();
        flyingCastle = new FlyingCastle();
        sRobot = new ShifuRobot();
        storeManager = new StoreManager();
    }

    @Test
    public void constructorTest() {
        // Wilds
        final var expectedChicken = new Chicken();
        Assertions.assertEquals(expectedChicken, chicken);
        final var expectedRB = new RoboBall();
        Assertions.assertEquals(expectedRB, roboball);
        final var expectedSeagull = new Seagull();
        Assertions.assertEquals(expectedSeagull, seagull);
        final var o = new Object();
        Assertions.assertNotEquals(chicken, o);
        Assertions.assertEquals(seagull, seagull);
        // Bosses
        final var expectedFC = new FlyingCastle();
        Assertions.assertEquals(expectedFC, flyingCastle);
        final var expectedSR = new ShifuRobot();
        Assertions.assertEquals(expectedSR, sRobot);
        final var expectedSM = new StoreManager();
        Assertions.assertEquals(expectedSM, storeManager);
        final var u = new Object();
        Assertions.assertNotEquals(flyingCastle, u);
        Assertions.assertEquals(sRobot, sRobot);


    }
}
