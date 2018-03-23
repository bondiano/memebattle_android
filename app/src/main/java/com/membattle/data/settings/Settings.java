package com.membattle.data.settings;

import com.membattle.R;

public interface Settings {
    String SETTINGS_NAME = "icon_settings name";
    String HEADER = "Bearer ";
    String TOKEN_ACCESS = "token_access";
    String TOKEN_REFRESH = "token_refresh";
    String USERNAME = "username";
    String ID = "id";
    String COINS = "coins";
    String TAG = "game";
    String[] ARRAY_RULES = new String[]{"Картинки постоянно появляются на экране, можно заработать MemCoins за активное участие в этом режиме.", "Правила для 1"};
    int MAIN_ICONS[] = new int[] {R.drawable.icon_settings, R.drawable.icon_help, R.drawable.icon_user, R.drawable.icon_mode, R.drawable.icon_rating, R.drawable.icon_shop};
    String MAIN_NAMES[] = new String[] {"Настройки", "Инфо", "Профиль", "Режимы", "Рейтинг", "Магазин"};
    int GAME_ICONS[] = new int[] {R.drawable.icon_game, R.drawable.icon_rules, R.drawable.icon_user, R.drawable.icon_rating, R.drawable.icon_mode, R.drawable.icon_shop};
    String GAME_NAMES[] = new String[] {"Игра", "Правила", "Профиль", "Рейтинг", "Режимы", "Магазин"};
    String CURRENT_MODE = "current mode";

    String API_key = "24b3d77d-265b-4a5b-a032-e2e8931a14c7";
}
