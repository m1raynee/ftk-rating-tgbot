package com.m1raynee.db.enums;

public enum RatingEntryType {
    ATTENDANCE("ATT", "Посещение занятия", 200),
    DOT("DOT", "Объяснение слова на разминке", 10),
    ACTIVITY_WIN("DOT-WIN", "Победа в активности", 50),
    REPRIMAND("REPR", "Замечание", -100),
    BONUS("BONUS", "Бонусные баллы", 0),
    BIRTHDAY_ATTENDANCE("ATT-BDAY", "Посещение в день рождения", 500),
    COMPETITIONS_INTERNAL("C-INT", "Внутренние соревнования", 0),
    COMPETITIONS_TOWN("C-TOWN", "Городские соревнования", 1000),
    COMPETITIONS_REGIONAL("C-REG", "Областные соревнования", 1500),
    COMPETITIONS_NATIONAL("C-NAT", "Всероссийские соревнования", 2000),
    COMPETITIONS_INTERNATIONAL("C-INTL", "Международные соревнования", 2500),
    HIKE("HIKE", "Участие в походе", 1000),
    HIKE_SMALL("HIKE-SM", "Небольшой поход", 500),
    MEDIA_CONTRIBUTION("MEDIA-CB", "Участие в работе редакции", 500),
    MEDIA_ARTICLE("MEDIA-AT", "Статья в газету", 200),
    MEDIA_PHOTOS("MEDIA-PH", "Фотографии для газеты", 300);

    private final String code;
    private final String description;
    private final int defaultPoints;

    RatingEntryType(String code, String description, int defaultPoints) {
        this.code = code;
        this.description = description;
        this.defaultPoints = defaultPoints;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getDefaultPoints() {
        return defaultPoints;
    }

    public static RatingEntryType fromCode(String code) {
        for (RatingEntryType type : RatingEntryType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown RatingEntryType code: " + code);
    }
}
