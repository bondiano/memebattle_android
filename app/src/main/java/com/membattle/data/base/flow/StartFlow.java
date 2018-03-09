package com.membattle.data.base.flow;

import ru.terrakok.cicerone.commands.Command;

public class StartFlow implements Command {
    String screenKey;
    Object transitionData;
    public StartFlow(String screenKey, Object transitionData) {
        this.screenKey = screenKey;
        this.transitionData = transitionData;
    }
}
