import java.util.Scanner;

public class ContactAccountingSystem {
    static Scanner scanner = new Scanner(System.in);


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
                    getContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("До свидания! ");
                default:
                    System.out.println("Укажите верный пункт меню от 1 до 5");
                    break;
            }
        }while(choice != 5);

    }

    public static void addContact(){

        if(counter <= maxValue) {
            System.out.println("Введите имя");// Считывание данных от пользователя
            String name = scanner.nextLine();

            //Проверка на корректный ввод имени
            if(!name.isEmpty()){
                names[counter] = name;
            }else {
                System.out.println("Вы ввели пустую строку!");
                return;
            }

            System.out.println("Введите номер телефона");

            String phoneNumber = scanner.nextLine();

            if(!phoneNumber.isEmpty()){
                phoneNumbers[counter] = phoneNumber;
            }else {
                System.out.println("Вы ввели пустую строку");
            }



            if(!phoneNumber.isEmpty() && !name.isEmpty()){
                System.out.println("Контакт успешно добавлен! ");
                counter++;
            }

        }else{
            System.out.println("Память переполнена, для добавления нужно удалить один из контактов!");
        }

    }

    // Метод получения всех контактов
    public static void getContacts() {
        System.out.println("Список контактов");
        for (int i = 0; i < maxValue; i++) {
            if(names[i] != null){
                System.out.println(i+1 + ". Имя: " + names[i] + " Номер телефона: " + phoneNumbers[i]);
            }
        }
    }

    //Метод поиска контакта
    public static void searchContact(){
        System.out.println("Введите имя для поиска");
        String searchName = scanner.nextLine();
        int flag = 0; // Создаем флаг, для условия if если контакт не найден

        for (int i = 0; i <maxValue; i++){
            if(names[i] != null && names[i].equalsIgnoreCase(searchName)){
                System.out.println("Имя: " + names[i] + " Номер телефона: " + phoneNumbers[i]);
                flag++;
            }

        }
        if(flag == 0){
            System.out.println("Контакт с таким именем не найден!");
        }
    }
    // Метод для удаления контакта
    public static void deleteContact(){
        getContacts();


        System.out.print("Введите имя контакта, который хотите удалить: ");
        String contact = scanner.nextLine();
        int flag = 0;

        for(int i = 0; i < maxValue; i++){
            if(names[i] != null && names[i].equalsIgnoreCase(contact)){ //поиск по массиву элемента, который нужно удалить
                for(int j = i; j < maxValue - 1; j++){
                    names[j] = names[j+1];              //смещение влево
                    phoneNumbers[j] = phoneNumbers[j+1];

                    flag++;
                    if(flag > 0){
                        //обнуление
                        names[maxValue-1]= null;
                        phoneNumbers[maxValue-1]= null;
                        counter--;
                    }
                }
                System.out.println("Контакт успешно удален!");
            }
        }

        if(flag == 0){
            System.out.println("Контакт с таким именем не найден!");
        }

    }


}

