package com.mrswimmer.memebattle.data.settings;

import com.mrswimmer.memebattle.R;

public interface Settings {
    String SETTINGS_NAME = "icon_settings name";
    String HEADER = "Bearer ";
    String TOKEN_ACCESS = "token_access";
    String TOKEN_REFRESH = "token_refresh";
    String USERNAME = "username";
    String ID = "id";
    String COINS = "coins";

    String[] ARRAY_RULES = new String[]{"Правила для 0", "Правила для 1"};
    int MAIN_ICONS[] = new int[] {R.drawable.icon_settings, R.drawable.icon_help, R.drawable.icon_user, R.drawable.icon_mode, R.drawable.icon_rating, R.drawable.icon_shop};
    String MAIN_NAMES[] = new String[] {"Настройки", "Инфо", "Профиль", "Режимы", "Рейтинг", "Магазин"};
    int GAME_ICONS[] = new int[] {R.drawable.icon_game, R.drawable.icon_rules, R.drawable.icon_user, R.drawable.icon_rating, R.drawable.icon_mode, R.drawable.icon_shop};
    String GAME_NAMES[] = new String[] {"Игра", "Правила", "Профиль", "Рейтинг", "Режимы", "Магазин"};

}
