package com.evergrande.hdtms.model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@Configurable
@ComponentScan(basePackages = "")
public class App 
{
    @Bean
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
