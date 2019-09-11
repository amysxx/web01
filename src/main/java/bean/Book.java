package bean;

/**
 * @author amy
 * @date 2019/9/9 0:04
 */
public class Book {
    private String name;
    private String author;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
    }

}