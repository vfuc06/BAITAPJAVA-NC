package Ex2_2;

public class Test {
    public static void main(String[] args) {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        Author paulTan = new Author("Paul Tan", "paul@somewhere.com", 'm');

        Author[] authors = {ahTeck, paulTan};

        Book dummyBook = new Book("Java for dummies", authors, 19.95, 99);
        System.out.println(dummyBook);

        dummyBook.setPrice(29.95);
        dummyBook.setQty(28);
        System.out.println("name is: " + dummyBook.getName());
        System.out.println("price is: " + dummyBook.getPrice());
        System.out.println("qty is: " + dummyBook.getQty());
        System.out.println("Author names: " + dummyBook.getAuthorNames());

        Author johnDoe = new Author("John Doe", "john@domain.com", 'm');
        Author janeDoe = new Author("Jane Doe", "jane@domain.com", 'f');
        Author[] newAuthors = {johnDoe, janeDoe};

        Book anotherBook = new Book("Advanced Java", newAuthors, 39.95);
        System.out.println(anotherBook);
    }
}
