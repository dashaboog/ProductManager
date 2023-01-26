package ru.netology.domain;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = product;
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }

    public void removeById(int id) {
                if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return items;
            }
        }
        return null;
    }
}
