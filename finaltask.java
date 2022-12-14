import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class finaltask {
    public static void main(String[] args) {
        HashSet<class> notebooks = new HashSet<>();
        notebooks.add(new class(0, 250, 16, 14, "Windows10", "black", "Asus"));
        notebooks.add(new class(1, 250, 32, 14, "Windows9", "black", "Asus"));
        notebooks.add(new class(2, 250, 64, 14, "Windows9", "silver", "Asus"));
        notebooks.add(new class(3, 500, 16, 15, "Dos", "black", "Lenovo"));
        notebooks.add(new class(4, 750, 16, 16, "None", "blue", "Acer"));
        notebooks.add(new class(5, 1000, 32, 15, "Windows9", "red", "Sony"));
        notebooks.add(new class(6, 750, 32, 15, "Windows10", "red", "Xiaomi"));
        notebooks.add(new class(7, 750, 64, 15, "Windows10", "white", "Acer"));
        notebooks.add(new class(8, 750, 32, 15, "Windows10", "silver", "Sony"));
        Filter(userRequest(), notebooks);

    }

    public static HashMap<String, String> userRequest() {
        HashMap<String, String> userRequest = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметры для поиска. Параметры, которые не участвуют в поиске,оставьте пустыми:");
        System.out.print("Введите тип ОС:");
        userRequest.put("os_type", scanner.nextLine());
        System.out.print("Введите цвет корпуса:");
        userRequest.put("color", scanner.nextLine());
        System.out.print("Введите производителя:");
        userRequest.put("brand", scanner.nextLine());
        System.out.print("Введите минимальный объем жесткого диска:");
        userRequest.put("hdd_volume", scanner.nextLine());
        System.out.print("Введите минимальный объем оперативной памяти:");
        userRequest.put("ram_volume", scanner.nextLine());
        System.out.print("Введите минимальную диагональ дисплея:");
        userRequest.put("display_size", scanner.nextLine());
        scanner.close();
        return userRequest;
    }

    public static void Filter(HashMap<String, String> userRequest, HashSet<class> catalog) {
        Boolean noResultsFlag=true;
        for (class nb : catalog) {
            if (userRequest.get("brand").equals(nb.getBrand()) || userRequest.get("brand") == "") {
                if (userRequest.get("color").equals(nb.getBrand()) || userRequest.get("color") == "") {
                    if (userRequest.get("os_type").equals(nb.getBrand()) || userRequest.get("os_type") == "") {
                        if (nb.getDisplSize() >= Integer.parseInt(userRequest.get("display_size")) &&
                                (nb.getHDDvolume() >= Integer.parseInt(userRequest.get("hdd_volume"))) &&
                                (nb.getRAMvolume() >= Integer.parseInt(userRequest.get("ram_volume")))) {
                            System.out.println(nb);
                            noResultsFlag=false;
                        }
                    }
                }
            }
           
        }
        if (noResultsFlag){
            System.out.println("По вашему запросу ничего не найдено.");
        }
    }
}