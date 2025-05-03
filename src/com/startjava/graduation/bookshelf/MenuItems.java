package com.startjava.graduation.bookshelf;

public enum MenuItems {
    ADD_BOOK(1, "Добавить книгу"),
    REMOVE_BOOK(2, "Удалить книгу"),
    FIND_BOOK(3, "Найти книгу"),
    CLEAR_SHELF(4, "Очистить шкаф"),
    EXIT(5, "Выход");

    private final int itemNumber;
    private final String description;

    MenuItems(int itemNumber, String description) {
        this.itemNumber = itemNumber;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public static MenuItems getByItemNumber(int itemNumber) {
        for (MenuItems item : values()) {
            if (item.getItemNumber() == itemNumber) {
                return item;
            }
        }
        throw new IllegalArgumentException("Неверное значение меню (" + itemNumber + ")");
    }
}
