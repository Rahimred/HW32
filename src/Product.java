import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {
    private String id;
    private String name;
    private static final Random random = new Random();
    private int price;
    private static final List<String> userId = new ArrayList<>();
    private static final List<String> LIST = List.of("B", "C", "D", "E", "F", "G", "I");

    private static final List<String> userNames = new ArrayList<>();
    private static final List<String> names = List.of("Скителс", "Кока-Кола", "Фанта", "Миринда", "Пепси", "Марс", "Баунти", "Пончики", "Кофе", "Ход-дог", "Семечки", "Печенья");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() {
        id = getRandomId(LIST.get(random.nextInt(LIST.size())));
        name = getRandomName(names.get(random.nextInt(names.size())));
        price = getRandomPrice();
    }

    public static List<Product> makeProduct(int amont) {
        return Stream.generate(Product::new)
                .limit(amont)
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    public String getRandomId(String id) {
        if (userId.contains(id)) {
            return getRandomId(LIST.get(random.nextInt()));
        }
        userId.add(id);
        return id;
    }

    public String getRandomName(String name) {
        if (userNames.contains(name)) {
            return getRandomId(names.get(random.nextInt(names.size())));
        }
        userNames.add(name);
        return name;
    }

    public int getRandomPrice() {
        int randomValue = random.nextInt(251);
        if (randomValue % 5 == 0) {
            return randomValue;
        }
        return getRandomPrice();
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
