import java.util.Scanner;

public class ContactAccountingSystem {
    static Scanner scanner = new Scanner(System.in);
    static boolean running = true; // Создание булевой перемнной для цикла while

    static int maxValue = 10; // Создание переменной,устанавливающая максимальное значение для массиво
    static int counter = 0; // Создание переменной, для счетчика кол-ва пользователей

    static String [] names = new String[maxValue]; // Создание массива для хранения имен
    static String [] phoneNumbers = new String[maxValue]; // Создание массива для хранения номеров телефонов


    public static void main(String[] args) {
        int choice;

        do{
            // Реализация меню
            System.out.println("Пункт меню                 Описание");
            System.out.println("1. Добавить контакт        Позволяет добавить новый контакт в систему");
            System.out.println("2. Просмотреть контакты    Отображает список все сохраненных контактов");
            System.out.println("3. Найти контакт           Ищет контакт по имени и выводит его номер");
            System.out.println("4. Удалить контакт         Удаляет контакт по имени из системы");
            System.out.println("5. Выйти                   Завершает работу приложения");

            System.out.println("Выберите пункт меню  - ");
            //Считывание выбора пользователя
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addContact();
                    break;
                case 2:


            }
        }while(choice != 5);

    }

    public static void addContact(){

        if(counter <= maxValue) {
            System.out.println("Введите имя");// Считывание данных от пользователя
            String name = scanner.nextLine();
            System.out.println("Введите номер телефона");
            String phoneNumber = scanner.nextLine();
            names[counter] = name;
            phoneNumbers[counter] = phoneNumber;
            counter++;
        }else{
            System.out.println("Память переполнена, для добавления нужно удалить один из контактов!");
        }

    }



}

