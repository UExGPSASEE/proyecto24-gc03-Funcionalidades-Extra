package org.openapitools.exceptions;

//Excepción personalizada para el servicio "EtiquetasDBService", la cual se lanza cuando se
//intenta crear/actualizar un contenido y se incumple la integridad referencial en el parámetro 'perteneceA'
public class CustomServiceException extends RuntimeException {
    public CustomServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
