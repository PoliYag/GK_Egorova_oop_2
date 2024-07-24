import java.util.LinkedList;
import java.util.Queue;

// Интерфейс QueueBehaviour
interface QueueBehaviour {
    void addCustomer(Customer customer); // Добавить клиента в очередь
    Customer removeCustomer(); // Удалить клиента из очереди
}

// Интерфейс MarketBehaviour
interface MarketBehaviour {
    void processOrders(); // Обработать заказы
}

// Класс Customer
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

 
    public String toString() {
        return name;
    }
}

// Класс Market, который реализует поведение очереди и рынка
class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Customer> customerQueue;

    public Market() {
        this.customerQueue = new LinkedList<>();
    }

   
    public void addCustomer(Customer customer) {
        customerQueue.offer(customer); // Добавляет клиента в очередь
        System.out.println(customer + " добавлен в очередь.");
    }


    public Customer removeCustomer() {
        Customer removedCustomer = customerQueue.poll(); // Удаляет клиента из очереди
        if (removedCustomer != null) {
            System.out.println(removedCustomer + " удален из очереди.");
        } else {
            System.out.println("Очередь пуста.");
        }
        return removedCustomer;
    }

    
    public void processOrders() {
        if (!customerQueue.isEmpty()) {
            Customer customer = removeCustomer(); // Удалить клиента из очереди
            System.out.println("Обработка заказа для: " + customer);
            // Здесь вы можете добавить логику обработки заказа
        } else {
            System.out.println("Нет клиентов для обработки заказов.");
        }
    }

    // Метод для проверки текущего состояния очереди
    public void currentQueueState() {
        System.out.println("Текущая очередь: " + customerQueue);
    }
}

// Класс Main для демонстрации работы класса Market
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        // Создаем клиентов
        Customer customer1 = new Customer("Иван");
        Customer customer2 = new Customer("Ольга");
        Customer customer3 = new Customer("Сергей");

        // Добавляем клиентов в очередь
        market.addCustomer(customer1);
        market.addCustomer(customer2);
        market.addCustomer(customer3);

        // Проверяем текущее состояние очереди
        market.currentQueueState();

        // Обрабатываем заказы
        market.processOrders();
        market.processOrders();

        // Проверяем состояние очереди
        market.currentQueueState();
    }
}
