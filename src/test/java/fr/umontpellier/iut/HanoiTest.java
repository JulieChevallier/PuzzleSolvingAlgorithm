package fr.umontpellier.iut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HanoiTest {
    Hanoi hanoi = new Hanoi(5);
    /*
    @Test
    public void test_hanoi_estGagnant_true(){
        hanoi.setTour3(hanoi.getTour1());
        hanoi.setTour1(hanoi.getTour2());
        assertTrue(hanoi.estGagnant());
    }

    @Test
    public void test_hanoi_estGagnant_false(){
        hanoi.setTour3(hanoi.getTour1());
        hanoi.setTour2(hanoi.getTour3());
        assertFalse(hanoi.estGagnant());
    }
    */
}