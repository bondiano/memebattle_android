package com.membattle.data.base.flow;

import ru.terrakok.cicerone.Router;

public class FlowRouter extends Router {
    void startFlow(String flowKey, Object data) {
        executeCommand(new StartFlow(flowKey, data));
    }

    void finishFlow(Object data) {
        executeCommand(new FinishFlow(data));
    }

    void cancelFlow() {
        finishChain();
    }
}
