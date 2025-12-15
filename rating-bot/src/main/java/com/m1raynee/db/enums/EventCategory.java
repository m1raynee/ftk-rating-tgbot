package com.m1raynee.db.enums;

public enum EventCategory {
    LESSON_UNKNOWN("L-UNK", "Неизвестное занятие"),
    LESSON_UNCATEGORIZED("L-UNCAT", "Занятие без категории"),
    LESSON_ROBOTICS("L-ROBOT", "Робототехника - занятие"),
    LESSON_ELECTRONICS("L-ELECTR", "Электроника - занятие"),
    LESSON_HANDCRAFT("L-HANDCR", "Рукоделие - занятие"),
    LESSON_INTELLECT("L-INTELL", "Интеллект - занятие"),
    LESSON_ARCHITECTURE("L-ARCITE", "Архитектура - занятие"),
    GAMES("GAMES", "Игры и конкурсы"),
    MEDIA("MEDIA", "Газета, сайт клуба, группа ВК"),
    HIKES("HIKES", "Походы и экскурсии"),
    COMPETITIONS_INTERNAL("C-INT", "Внутренние соревнования"),
    COMPETITIONS_TOWN("C-TOWN", "Городские соревнования"),
    COMPETITIONS_WIDE("C-WIDE", "Обастные, всероссийские, международные соревнования");

    private final String code;
    private final String description;

    EventCategory(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static EventCategory fromCode(String code) {
        for (EventCategory category : EventCategory.values()) {
            if (category.getCode().equals(code)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown EventCategory code: " + code);
    }
}
