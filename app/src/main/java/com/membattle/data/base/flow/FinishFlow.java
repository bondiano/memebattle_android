package com.membattle.data.base.flow;

import ru.terrakok.cicerone.commands.Command;

public class FinishFlow implements Command {
    Object transitionData;
    public FinishFlow(Object transitionData) {
        this.transitionData = transitionData;
    }
}
