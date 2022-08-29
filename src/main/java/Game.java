public class Game {
    private Player[] players = new Player[0];

    public void register(Player player) {
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
    }

    public int round(String playerName1, String playerName2) {
        if (findPlayer(playerName1) == null) {
            throw new NotRegisteredException("Игрок с именем: " + playerName1 + " не найден");
        }
        if (findPlayer(playerName2) == null) {
            throw new NotRegisteredException("Игрок с именем: " + playerName2 + " не найден");
        }
        return compare(findPlayerStrength(playerName1), findPlayerStrength(playerName2));
    }

    public Player[] findPlayer(String name) {
        Player[] result = new Player[0];
        for (Player data : getPlayers()) {
            if (matches(data.getName(), name)) {
                Player[] replacer = new Player[result.length + 1];
                replacer[replacer.length - 1] = data;
                result = replacer;
                return result;
            }
        }
        return null;
    }

    public int findPlayerStrength(String name) {
        for (Player data : getPlayers()) {
            if (matches(data.getName(), name)) {
                int numbers = data.getStrength();
                return numbers;
            }
        }
        return 0;
    }

    private boolean matches(String id, String id1) {
        if (id == id1) {
            return true;
        } else {
            return false;
        }
    }

    public int compare(int o1, int o2) {
        if (o1 < o2) {
            return 2;
        } else if (o1 > o2) {
            return 1;
        } else {
            return 0;
        }
    }

    public Player[] getPlayers() {
        return players;
    }
}
