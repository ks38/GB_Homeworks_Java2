package ru.knyazevvb.networkchat.Server;

    public interface AuthService {
    String getNickByLoginAndPassword(String login, String password);
}
