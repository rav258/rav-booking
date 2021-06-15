package com.rav.infrastructure.web.email;

public interface EmailSender {
    void send (String to, String email);
}
