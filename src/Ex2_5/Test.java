package Ex2_5;

public class Test {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "John Doe", 'm');
        Customer customer2 = new Customer(2, "Jane Smith", 'f');
        Account account1 = new Account(101, customer1, 500.0);
        Account account2 = new Account(102, customer2, 1000.0);

        System.out.println(account1);
        System.out.println(account2);

        account1.deposit(200.0);
        System.out.println("After deposit: " + account1);

        account1.withdraw(100.0);
        System.out.println("After withdrawal: " + account1);

        account1.withdraw(700.0);  // Sẽ in ra thông báo lỗi
    }
}
