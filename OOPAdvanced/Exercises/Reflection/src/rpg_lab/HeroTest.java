package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private Hero hero;

    private Weapon weapon;

    private Target target;

    @Before
    public void setUp() throws Exception {
        this.weapon = Mockito.mock(Axe.class);
        this.target = Mockito.mock(Dummy.class);
    }

    @Test
    public void getName() {
        this.hero = new Hero("Pesho", this.weapon);
    }

    @Test
    public void getExperience() {
    }

    @Test
    public void getWeapon() {
    }

    @Test
    public void attack() {
    }
}