package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    /**
     * Получение сервиса обработки репозитория пользователей
     * @return
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    /**
     * Создание пользователя, добавление в репозиторий, отправка уведомления
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email электронная почта пользователя
     */
    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.sendNotification("Новый пользователь добавлен в репозиторий");
    }
}
