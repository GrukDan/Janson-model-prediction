package client.GUI;

import client.Objects.User;

public final class Account {
    private static User account;

    public static User getAccount() {
        return account;
    }
    public static void setAccount(User account) {
        Account.account = account;
    }
}
