import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

public class ExceptionTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    private Book book1 = new Book(3457874, "Над пропастью во ржи", 700, "Джером Сэлинджер");
    private Book book2 = new Book(643847394, "Пролетая над гнездом кукушки", 1_000, "Кен Кизи");
    private Book book3 = new Book(6789876, "Властелин колец", 1_500, "Дж. Р. Р. Толкин");
    private Book book4 = new Book(97747844, "Проблема строительства социалистических городов", 650, "Н.Милютин");
    private Book book5 = new Book(647474848, "Гарри Поттер", 980, "Дж. Роулинг");
    private Smartphone phone1 = new Smartphone(7484944, "Iphone", 100_000, "Apple");
    private Smartphone phone2 = new Smartphone(9282902, "Kl2000", 95_000, "Samsung");
    private Smartphone phone3 = new Smartphone(8774892, "ZX6483", 50_000, "Xiaomi");
    private Smartphone phone4 = new Smartphone(99763528, "NX300", 60_000, "Nokia");
    private Smartphone phone5 = new Smartphone(64748303, "IPoc", 30_000, "Poco");

    @BeforeEach
    public void prepare() {
        manager.addAllItems(book1);
        manager.addAllItems(book2);
        manager.addAllItems(book3);
        manager.addAllItems(book4);
        manager.addAllItems(book5);
        manager.addAllItems(phone1);
        manager.addAllItems(phone2);
        manager.addAllItems(phone3);
        manager.addAllItems(phone4);
        manager.addAllItems(phone5);
    }

    @Test
    void shouldRemoveById() {
        repo.removeById(64748303);

        Product[] expected = {book1, book2, book3, book4, book5, phone1, phone2, phone3, phone4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowException() {
        Assertions.assertThrows(NotFoundException.class, () -> {repo.removeById(64747484);});
    }
}
