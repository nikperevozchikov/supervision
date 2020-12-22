package ru.perevozchikov.supervision.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perevozchikov.supervision.model.*;
import ru.perevozchikov.supervision.service.EventService;
import ru.perevozchikov.supervision.service.OrganizationService;
import ru.perevozchikov.supervision.service.PositionService;
import ru.perevozchikov.supervision.service.SupervisionModeService;
import ru.perevozchikov.supervision.service.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/init")
public class InitController {

    private final PositionService positionService;
    private final EventService eventService;
    private final SupervisionModeService supervisionModeService;
    private final UserService userService;
    private final OrganizationService organizationService;
    private final BCryptPasswordEncoder passwordEncoder;
    private long passport = 3600111111L;

    public InitController(PositionService positionService, EventService eventService, SupervisionModeService supervisionModeService, UserService userService, OrganizationService organizationService, BCryptPasswordEncoder passwordEncoder) {
        this.positionService = positionService;
        this.eventService = eventService;
        this.supervisionModeService = supervisionModeService;
        this.userService = userService;
        this.organizationService = organizationService;
        this.passwordEncoder = passwordEncoder;
    }


    @RequestMapping("/all")
    public void initialize() {
        clearAll();
        initUsers();
    }

    private void clearAll() {
        this.userService.deleteAll();
        this.eventService.deleteAll();
        this.supervisionModeService.deleteAll();
        this.positionService.deleteAll();
        this.organizationService.deleteAll();
    }

    public String getRandomString(List<String> strings) {
        Random random = new Random();
        int size = strings.size();
        return strings.get(random.nextInt(size));
    }

    public <T> T getRandomItem(List<T> items) {
        return items.get(new Random().nextInt(items.size()));
    }

    public String getPassport() {
        return Long.toString(passport++);
    }

    @GetMapping("/users")
    public void initUsers() {
        List<User> users = new ArrayList<>();

        List<String> firstNames = new ArrayList<>(Arrays.asList(
                "Иван", "Игорь", "Михаил", "Александр", "Сергей",
                "Никита"
        ));
        List<String> lastNames = new ArrayList<>(Arrays.asList(
                "Иванов", "Петров", "Кузнецов", "Лялянов", "Тутутов"
        ));
        List<String> middleNames = new ArrayList<>(Arrays.asList(
                "Иванович", "Дмитриевич", "Михайлович", "Викторович",
                "Сергеевич", "Алексеевич", "Антнович", "Никитич"
        ));
        List<Event> events = Stream.of(
                "Анализ информации", "Мониторинг показателей", "Иные мероприятия",
                "Определение актуальности данных", "Проверка режима"
        ).map(name -> {
            Event event = new Event();
            event.setName(name);

            return event;
        }).collect(Collectors.toList());
        eventService.saveList(events);


        List<Position> positions = Stream.of(
                "Старший куратор", "Младший куратор", "Куратор",
                "Руководитель", "Директор"
        ).map(name -> {
            Position position = new Position();
            position.setName(name);

            return position;
        }).collect(Collectors.toList());
        positionService.saveList(positions);


        List<SupervisionMode> supervisionModes = Stream.of(
                "Красный", "Желтый", "Синий",
                "Зеленый", "Оранжевый"
        ).map(name -> {
            SupervisionMode supervisionMode = new SupervisionMode();
            supervisionMode.setName(name);

            return supervisionMode;
        }).collect(Collectors.toList());
        supervisionModeService.saveList(supervisionModes);

        List<String> orgNames = new ArrayList<>(Arrays.asList(
                "МФО Капитал", "Быстроденьги", "Микрозаймы", "Кооператив Озеро", "Кредитплюс",
                "Сельские Накопления"
        ));
        lastNames = new ArrayList<>(Arrays.asList(
                "Иванов", "Петров", "Кузнецов", "Лялянов", "Тутутов"
        ));
//        for (int i = 1; i <= 10; i++) {
//            Organization organization = new Organization();
//           organization.setName(getRandomString(orgNames));
//           organization.setDateFoundation(null);
//           organization.setEmployee(new Employee("Адрес 1", getRandomItem(positions)));
//          organization.setEvent(new Event(getRandomItem(events), null, null, getRandomItem(orgNames)));
//            employee.setRegistrationAddress("Адрес " + i);
////            employee.setBirthday(LocalDate.now());
//            employee.setPosition(getRandomItem(positions));
//            users.add(employee);
//        }


        for (int i = 1; i <= 50; i++) {
            Employee employee = new Employee();
            employee.setPassport(getPassport());
            employee.setPassword(passwordEncoder.encode("123456"));
            employee.setFirstName(getRandomString(firstNames));
            employee.setLastName(getRandomString(lastNames));
            employee.setMiddleName(getRandomString(middleNames));
            employee.setRole(Role.EMPLOYEE);
            employee.setRegistrationAddress("Адрес " + i);
//            employee.setBirthday(LocalDate.now());
            employee.setPosition(getRandomItem(positions));
            users.add(employee);
        }

        firstNames = new ArrayList<>(Arrays.asList(
                "Иван", "Игорь", "Михаил", "Александр", "Сергей",
                "Никита"
        ));
        lastNames = new ArrayList<>(Arrays.asList(
                "Иванов", "Петров", "Кузнецов", "Лялянов", "Тутутов"
        ));
        middleNames = new ArrayList<>(Arrays.asList(
                "Иванович", "Дмитриевич", "Михайлович", "Викторович",
                "Сергеевич", "Алексеевич", "Антнович", "Никитич"
        ));

//        for (int i = 1; i <= 10; i++) {
//            int eventsCount = new Random().nextInt(events.size());
//            List<Event> empEvents = new ArrayList<>(eventsCount);
//            for (int j = 0; j < eventsCount; j++) {
//                Event event = empEvents.get(
//                        new Random().nextInt(empEvents.size())
//                );
//                empEvents.add(event);
//            }
//
//            //
//            //
//        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setPassport(getPassport());
            user.setPassword(passwordEncoder.encode("kakoizheparol"));
            user.setFirstName(getRandomString(firstNames));
            user.setLastName(getRandomString(lastNames));
            user.setMiddleName(getRandomString(middleNames));
            user.setRole(Role.ADMIN);
            users.add(user);
        }
        userService.saveList(users);
    }
}
