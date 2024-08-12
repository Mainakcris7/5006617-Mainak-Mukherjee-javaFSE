package com.exercise.employee.service;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mainak Mukherjee");
    }

}
