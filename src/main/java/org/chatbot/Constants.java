package org.chatbot;

public enum Constants {
    FIRST("12:00-15:00"),
    SECOND("13:00-16:00"),
    THIRD("14:00-17:00"),
    FOURTH("15:00-18:00"),
    FIFTH("17:00-20:00"),
    SIXTH("18:00-21:00"),
    SEVENTH("19:00-22:00"),
    EIGHTH("07:00-10:00"),
    NINTH("08:00-11:00"),
    TENTH("09:00-12:00"),
    ELEVENTH("10:00-13:00"),
    TWELFTH("11:00-14:00");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
