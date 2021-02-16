package com.glovo.ttglovo.securityManagement.email;

public interface EmailSender {
    void send(String to, String email);
}