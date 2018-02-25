package com.mrswimmer.membattle.data.api.req;


public class Secret {
    String token_refresh, garbage="garbage";

    public Secret(String token_refresh) {
        this.token_refresh = token_refresh;
    }

    public String getToken_refresh() {
        return token_refresh;
    }

    public void setToken_refresh(String token_refresh) {
        this.token_refresh = token_refresh;
    }
}
