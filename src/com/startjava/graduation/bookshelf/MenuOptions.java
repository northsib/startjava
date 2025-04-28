package com.startjava.graduation.bookshelf;

public enum MenuOptions {
    ADD_BOOK(1, "Добавить книгу"),
    REMOVE_BOOK(2, "Удалить книгу"),
    FIND_BOOK(3, "Найти книгу"),
    DISPLAY_ALL(4, "Показать все книги"),
    SHOW_COUNT(5, "Показать количество книг"),
    CLEAR_SHELF(6, "Очистить шкаф"),
    EXIT(7, "Выход");

    private final int value;
    private final String description;

    MenuOptions(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public static MenuOptions getByValue(int value) {
        for (MenuOptions option : values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Неверное значение меню: " + value);
    }
}
