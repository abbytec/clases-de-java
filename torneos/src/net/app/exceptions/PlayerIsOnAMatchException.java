package net.app.exceptions;

import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;

public class PlayerIsOnAMatchException extends Exception {
    public PlayerIsOnAMatchException(IPlayer player, IMatch match) {
        // TODO Auto-generated method stub
        super("");
    }
}
