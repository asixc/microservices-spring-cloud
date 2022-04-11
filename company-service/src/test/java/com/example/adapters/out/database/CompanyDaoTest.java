package com.example.adapters.out.database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CompanyDaoTest {
    @InjectMocks
    private CompanyDao sut;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    void testing() {
        when(companyRepository.findById(any())).thenReturn(Optional.empty());

        var res = this.sut.findById(1L);

        assertNotNull(res);
        assertTrue(res.isEmpty());

    }
}