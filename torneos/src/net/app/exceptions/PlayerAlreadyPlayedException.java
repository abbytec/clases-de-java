package net.app.exceptions;

import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;

public class PlayerAlreadyPlayedException extends Exception {
    public PlayerAlreadyPlayedException(IPlayer player, IMatch match) {
        // TODO Auto-generated method stub
        super("");
    }
}
