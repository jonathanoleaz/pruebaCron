package com.mx.notificaciones.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class AppUtils {
	public String generaUuid() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
	}
}
