package com.example.trip.Data;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorldClass {

    private ArrayList<Town> towns = new ArrayList<>();
    private static WorldClass sInstance;

//    private Place addPlace(String namePlace, int category) {
//        String info = "This info will be updated";
//        Place place = new Place(namePlace, category, info);
//        return place;
//    }

    public ArrayList<Town> getTowns(){
        return this.towns;
    }
//
//    private void addTown(String nameTown, String country, int numOfPlaces, ArrayList<Place> places) {
//
//        Town town = new Town(nameTown, country, numOfPlaces);
//
//        town.addPlaces(places);
//
//        towns.add(town);
//    }
//
//    private void addAll() {
//
//        ArrayList<Place> places = new ArrayList<>();
//
//        places.add(addPlace("The Red Square", 0));
//        places.add(addPlace("Novodevichy Convent", 666));
//        places.add(addPlace("Planetarium", 6));
//        places.add(addPlace("Peredelkino", 666));
//
//        addTown("Moscow", "Russia", places.size(), places);
//
//        ArrayList<Place> placest = new ArrayList<>();
//
//        placest.add(addPlace("Sydney jopera", 5));
//        placest.add(addPlace("Sydney port", 3));
//        placest.add(addPlace("Sydney aquarium", 6));
//        placest.add(addPlace("Purnululu National park", 2));
//
//        addTown("Sydney", "Australia", places.size(), placest);
//
//
//    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        //здесь мы можем использовать разделитель, например: "\\A", "\\Z" или "\\z"
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }

    private void readJson() throws IOException {
        String fileName = "/data/data/com.example.trip/files/places.json";

//        String jsonString = readUsingScanner(fileName);

        String jsonString = "[{\"ObjectName\": \"\uFEFFКрасная полщадь\",\"ObjectCategory\": \"Достопримечательности\",\"ObjectCountry\": \"Россия\",\"ObjectTown\": \"Москва\",\"ObjectInformation\": \"Кра́сная пло́щадь — главная площадь Москвы, расположена между Московским Кремлём (к западу) и Китай-городом (на восток). Выходит к берегу Москвы-реки через пологий Васильевский спуск. Площадь тянется вдоль северо-восточной стены Кремля, от Кремлёвского проезда и проезда Воскресенские Ворота до Васильевского спуска, выходящего к Кремлёвской набережной. На восток от Красной площади отходят Никольская улица, Ильинка и Варварка. Вдоль западной стороны площади расположен Московский Кремль, вдоль восточной — Верхние торговые ряды и Средние торговые ряды. Входит в единый ансамбль с Московским Кремлём, однако исторически является частью Китай-города[1][2][3][4][5][6]. На Красной площади расположены Лобное место, памятник Минину и Пожарскому, Мавзолей Владимира Ленина, некрополь у Кремлёвской стены. В северной части площади находятся Исторический музей и Казанский собор, в южной — Покровский собор. Архитектурный ансамбль находится под охраной ЮНЕСКО как памятник Всемирного наследия[1][7][8]. Площадь издревле служила местом торга, где много веков подряд возводились временные и постоянные торговые ряды. В советское время на площади проходили военные парады и демонстрации, после распада СССР она стала использоваться для общественных мероприятий и концертов[9][10][11][12][13][14]. Общая длина — 330 метров, ширина — 75 метров, площадь — 24 750 м². Вымощена брусчаткой из крымского габбро-диабаза[1][15][16][17].\",\"ObjectCoordinates\": \"55.45.15 37.37.12\"},{\"ObjectName\": \"Храм Ваислия Блаженного\",\"ObjectCategory\": \"Религиозные\",\"ObjectCountry\": \"Россия\",\"ObjectTown\": \"Москва\",\"ObjectInformation\": \"Собоор Покрова Пресвятой Богородицы, что на Рву (Покровский собо́р, Покрова на Рву, разговорное — собор (храм) Василия Блаженного) — православный храм на Красной площади в Москве, памятник русской архитектуры. Строительство собора велось с 1555 по 1561 год[1][2]. Собор объединяет одиннадцать церквей (приделов), часть из которых освящена в честь святых, дни памяти которых пришлись на решающие бои за Казань[3]. Центральная церковь сооружена в честь Покрова Богородицы, вокруг которой группируются отдельные церкви в честь: Святой Троицы, Входа Господня в Иерусалим, Николы Великорецкого, Трёх Патриархов: Александра, Иоанна и Павла Нового, Григория Армянского, Киприана и Иустины, Александра Свирского и Варлаама Хутынского, размещённые на одном основании-подклете, а также придел в честь Василия Блаженного[4][5], по имени которого храм получил второе, более известное название, и церковь Иоанна Блаженного, вновь открытая после длительного запустения в ноябре 2018 года[6]. В названии собора упомянут ров, проходивший вдоль Кремлёвской стены и служивший оборонительным укреплением (Алевизов ров), его глубина была около 13 метров, а ширина — около 36 метров[7][8]. Собор входит в российский список объектов Всемирного наследия ЮНЕСКО и является филиалом Государственного исторического музея[9].\",\"ObjectCoordinates\": \"55.45.09 37.37.23\"},{\"ObjectName\": \"Лондонский глаз\",\"ObjectCategory\": \"Развлечения\",\"ObjectCountry\": \"Англия\",\"ObjectTown\": \"Лондон\",\"ObjectInformation\": \"Лондонский глаз (англ. London Eye) — колесо обозрения в Лондоне, расположенное в районе Ламбет на южном берегу Темзы. Крупнейшее в Европе и одно из крупнейших в мире. Открыто в марте 2000 г. С высоты 135 метров (приблизительно 45 этажей) при солнечной погоде открывается вид практически на весь Лондон и его окрестности на расстоянии до 40 километров. Это колесо обозрения — семейный проект супругов-архитекторов Дэвида Маркса и Джулии Барфилд. Воплощение проекта в жизнь заняло шесть лет.\",\"ObjectCoordinates\": \"51.30.12 -0.07.11\"},{\"ObjectName\": \"Биг-Бен\",\"ObjectCategory\": \"Достопримечательности\",\"ObjectCountry\": \"Англия\",\"ObjectTown\": \"Лондон\",\"ObjectInformation\": \"Биг-Бен (англ. Big Ben) — популярное туристическое название часовой башни Вестминстерского дворца. Официальное название башни с 2012 года — Башня Елизаветы (англ. Elizabeth Tower)[1]. Изначально «Биг-Бен» являлось названием самого большого из шести колоколов, однако часто это название расширительно относят и к часам, и к самой часовой башне в целом[2]. На момент отливки Биг-Бен был самым большим и тяжёлым колоколом Соединённого Королевства. Его вес при этом составлял 13,7 тонны. В 1881 году уступил первенство колоколу Большой Пол (17 тонн).\",\"ObjectCoordinates\": \"51.30.03 -0.07.28\"},{\"ObjectName\": \"Сиднейский оперный театр\",\"ObjectCategory\": \"Опера и балет\",\"ObjectCountry\": \"Австралия\",\"ObjectTown\": \"Сидней\",\"ObjectInformation\": \"Сиднейский оперный театр (англ. Sydney Opera House) — музыкальный театр в Сиднее, одно из наиболее известных и легко узнаваемых зданий мира, являющееся символом крупнейшего города Австралии и одной из главных достопримечательностей континента — парусообразные оболочки, образующие крышу, делают это здание непохожим ни на одно другое в мире. Открыт 20 октября 1973 года королевой Австралии Елизаветой II. Оперный театр признан одним из выдающихся сооружений современной архитектуры в мире и с 1973 года является, наряду с мостом Харбор-Бридж, визитной карточкой Сиднея. 28 июня 2007 года театр внесён ЮНЕСКО в список объектов Всемирного наследия[2].\",\"ObjectCoordinates\": \"-33.51.25 151.12.54\"},{\"ObjectName\": \"Галлерея Фиррари\",\"ObjectCategory\": \"Музеи\",\"ObjectCountry\": \"Италия\",\"ObjectTown\": \"Маранело\",\"ObjectInformation\": \"Галерея Феррари — это музей, посвященный автомобилям и истории знаменитой компании Феррари. Музей был открыт в 1990 году, в 2004 году было добавлено новое крыло. В коллекции музея не только автомобили, также экспонируются призы, фотографии и другие исторические ценности итальянской марки и автоспорта, представлены технологические инновации. Галерея Феррари находится в 300 метрах от фабрики Феррари в родном городе Феррари — Маранелло. Расположен по адресу: 43, Via Dino Ferrari — 41053 Maranello (MO). Площадь музея — 2500 м², ежегодно здесь бывает около 200 000 посетителей[2]. Музей разделён на тематические экспозиции: зал Славы Формулы-1, где выставлены машины, побеждавшие с 1999 по 2008 годы, первая модель Ferrari 125 S, созданная в 1947 году, реконструированный офис Энцо Феррари, одноместные модели, бокс авто с панелью управления, мастерская отца Энцо и выставка двигателей[3][4].\",\"ObjectCoordinates\": \"44.31.47 10.51.43\"}] ";

        System.out.println("program started");
        Gson g = new Gson();
        Place[] listall = g.fromJson(jsonString, Place[].class);
        List<String> towns = new ArrayList<String>();
        ArrayList<Town> townslist = new ArrayList<Town>();

        for (Place place : listall){
            String townname = place.ObjectTown;
            if (towns.indexOf(townname) != -1){
                for (Town town : townslist){
                    if (townname.equals(town.getName())){
                        town.addPlace(place);
                        System.out.println("yohooo");
                    }
                }
            }else{
                towns.add(townname);
                Town town = new Town(place.ObjectTown, place.ObjectCountry);
                town.addPlace(place);
                townslist.add(town);
            }
        }

        this.towns = townslist;

    }

    public WorldClass() throws IOException {
        this.readJson();
    }

    public static WorldClass getInstance() throws IOException {
        if (sInstance == null) {
            synchronized (WorldClass.class) {
                if (sInstance == null) {
                    sInstance = new WorldClass();
                }
            }
        }return sInstance;
    }
}
