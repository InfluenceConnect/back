package com.senac.influenceconnect.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bcrypt {

    private final PasswordEncoder passwordEncoder;

    public Bcrypt() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Hash a senha usando o algoritmo bcrypt.
     *
     * @param rawPassword A senha em texto plano.
     * @return A senha hasheada.
     */
    public String hashPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Verifica se a senha em texto plano corresponde à senha hasheada.
     *
     * @param rawPassword A senha em texto plano.
     * @param encodedPassword A senha hasheada.
     * @return true se as senhas corresponderem, false caso contrário.
     */
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
