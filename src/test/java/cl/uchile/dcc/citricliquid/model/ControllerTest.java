package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.controller.GameController;
import cl.uchile.dcc.citricliquid.controller.phases.*;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.TransitionException;
import cl.uchile.dcc.citricliquid.model.board.panels.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import cl.uchile.dcc.citricliquid.model.enemies.BossUnit;
import cl.uchile.dcc.citricliquid.model.enemies.WildUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ControllerTest {

    private GameController controller;
    private List<Player> players;
    private HomePanel HP1;
    private HomePanel HP2;
    private HomePanel HP3;
    private HomePanel HP4;
    private Player P1;
    private Player P2;
    private Player P3;
    private Player P4;
    private BossUnit boss;
    private BossPanel BP;
    private WildUnit wild;

    private NeutralPanel NP1;
    private NeutralPanel NP2;
    private NeutralPanel NP3;
    private NeutralPanel NP4;


    @BeforeEach
    public void setUp(){
        controller= new GameController();
        P1 = controller.generatePlayer( "one", 1, 2, 3, 4);
        P2 = controller.generatePlayer( "two", 1, 2, 3, 4);
        P3 = controller.generatePlayer( "three", 1, 30, 3, 4);
        P4 = controller.generatePlayer( "four", 1, 2, 3, 4);
        controller.addPlayer(P1);
        controller.addPlayer(P2);
        controller.addPlayer(P3);
        controller.addPlayer(P4);

        controller.addBonusPanel(2);
        controller.addDrawPanel(3);
        controller.addDropPanel(4);
        controller.addEncounterPanel(5);

        NP1 = controller.addNeutralPanel(6);
        NP2 = controller.addNeutralPanel(7);
        NP3 = controller.addNeutralPanel(8);
        NP4 = controller.addNeutralPanel(9);

        BP = controller.addBossPanel(6);
        boss = controller.createRandomBoss();
        controller.setBossToPanels(boss, BP);

        HP1 = controller.addHomePanel(7);
        HP2 = controller.addHomePanel(8);
        HP3 = controller.addHomePanel(9);
        HP4 = controller.addHomePanel(10);
        controller.setHomePanel(P1,HP1);
        controller.setHomePanel(P2,HP2);
        controller.setHomePanel(P3,HP3);
        controller.setHomePanel(P4,HP4);
    }

    @Test
    public void initiatingTest() {
        assertTrue(HP1.getPlayers().contains(P1));
        assertTrue(HP2.getPlayers().contains(P2));
        assertTrue(HP3.getPlayers().contains(P3));
        assertTrue(HP4.getPlayers().contains(P4));
        assertFalse(HP1.getPlayers().contains(P2));

        assertTrue(controller.getPlayers().contains(P1));
        assertTrue(controller.getPlayers().contains(P2));
        assertTrue(controller.getPlayers().contains(P3));
        assertTrue(controller.getPlayers().contains(P4));
    }

    @RepeatedTest(20)
    public void enemyTest(){
        boss = controller.createRandomBoss();
        controller.setBossToPanels(boss, BP);
        assertEquals(BP.getBoss(), boss);
        wild = controller.createRandomWild();
    }

    @Test
    public void panelsSimpleMethodsTest(){
        controller.setNextPanel(NP1, NP2);
        controller.setNextPanel(NP2, NP3);
        controller.setNextPanel(NP2, NP4);
        controller.setNextPanel(NP3, NP1);
        assertTrue(controller.getNextPanels(NP1).contains(NP2));
        assertTrue(controller.getNextPanels(NP2).contains(NP3));
        assertTrue(controller.getNextPanels(NP2).contains(NP4));
        assertTrue(controller.getNextPanels(NP3).contains(NP1));
        assertFalse(controller.getNextPanels(NP1).contains(NP3));
        assertTrue(controller.getPanels().contains(NP1));
        assertTrue(controller.getPanels().contains(NP2));
        assertTrue(controller.getPanels().contains(NP3));
        assertTrue(controller.getPanels().contains(NP4));

        controller.setPlayerPanel(P1, NP1);
        assertFalse(HP1.getPlayers().contains(P1));
        assertTrue(NP1.getPlayers().contains(P1));
    }

    @Test
    public void SimpleMovingTEST() throws ActionException {
        controller.setNextPanel(NP1, NP2);
        NP1.setUp(NP2);
        controller.setNextPanel(NP2, NP3);
        controller.setNextPanel(NP2, NP4);
        NP2.setUp(NP3);
        NP2.setRight(NP4);
        controller.setNextPanel(NP3, NP1);
        NP3.setUp(NP1);
        controller.setOwner(P1);
        controller.tryToGoUp();
        controller.tryToGoDown();
        controller.tryToGoRight();
        controller.tryToLeft();
        controller.move();
    }


    @Test
    public void actionsTest() throws ActionException {
        controller.tryToEndTurn();
        controller.setOwner(P1);
        assertEquals("StartTurnPhase", controller.getPhase());
        controller.fighterDefend(P1, 15);
        assertTrue(P1.isKO());
        controller.fighterDodge(P2, 15);
        assertTrue(P2.isKO());
    }


}
