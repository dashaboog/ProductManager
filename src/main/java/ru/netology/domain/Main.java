package ru.netology.domain;

public class Main {
    public static void main(String[] args) {
    ProductRepository repo = new ProductRepository();

        repo.removeById(100);
}
}