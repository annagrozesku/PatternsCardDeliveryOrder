package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
//
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        String[] city = new String[]{
                "Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Нальчик", "Элиста", "Черкесск", "Петрозаводск",
                "Сыктывкар", "Симферополь", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный",
                "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток",
                "Ставрополь", "Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград",
                "Вологда", "Воронеж", "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск",
                "Санкт-Петербург", "Липецк", "Магадан", "Мурманск", "Нижний Новгород", "Великий Новгород", "Ноаосибирск",
                "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск",
                "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Ярославль", "Москва",
                "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард"};

        Faker faker = new Faker(new Locale(locale));
        return city[faker.number().numberBetween(0, city.length - 1)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static String generateWrongPhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().cellPhone();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
