package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    public UserRepository getRepository() {
        return repository;
    }

    @Autowired
    private UserRepository repository;

    /**
     * Метод возвращает переданный список пользователей отсортированный по возрасту пользователя
     * @param users список пользователей
     * @return
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает список пользователей старше указаного возраста
     * @param users список пользователей
     * @param age возраст
     * @return
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает средний возраст пользователей из переданного списка
     * @param users
     * @return
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Метод добавляет пользователя в репозиторий
     * @param user пользователь для добавления
     */
    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }
}
