import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {
    Game repo = new Game();

    Player player1 = new Player(1, "Artur", 1);

    Player player2 = new Player(2, "Igor", 5);

    Player player3 = new Player(3, "Gosha", 8);

    Player player4 = new Player(4, "Aisen", 4);

    Player player5 = new Player(5, "Vasiliy", 1);

    @Test
    public void roundTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);

        int expected = 2;
        int actual = repo.round("Igor", "Gosha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Danya", "Borya");
        });
    }

    @Test
    public void wrongStrengthTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);

        int expected = 0;
        int actual = repo.findPlayerStrength("Danya");
    }

    @Test
    public void wrongSecondNameTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Artur", "Borya");
        });
    }

    @Test
    public void firstIsStrongerTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);

        int expected = 1;
        int actual = repo.round("Gosha", "Artur");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void makeThemEqualTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);

        int expected = 0;
        int actual = repo.round("Vasiliy", "Artur");

        Assertions.assertEquals(expected, actual);
    }

}
