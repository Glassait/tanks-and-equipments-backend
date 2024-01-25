package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.abstracts.information.Information;
import com.glassait.equipment_tanks.services.InformationService;
import com.glassait.equipment_tanks.services.WotService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InformationControllerTest {

    @Mock
    private InformationService informationService;

    @Mock
    private WotService wotService;

    private InformationController informationController;

    @BeforeEach
    void setUp() {
        informationController = new InformationController(informationService, wotService);
    }

    @Test
    void getInformation_withValidAccessToken_shouldReturnLastInformation() {
        // given
        String accessToken = "valid_access_token";
        Information expectedInformation = new Information();
        when(wotService.checkAccessToken(accessToken)).thenReturn(true);
        when(informationService.getLastInformation()).thenReturn(expectedInformation);

        // when
        ResponseEntity<Information> responseEntity = informationController.getInformation(accessToken);

        // then
        verify(wotService, times(1)).checkAccessToken(accessToken);
        verify(informationService, times(1)).getLastInformation();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedInformation, responseEntity.getBody());
    }

    @Test
    void getInformation_withInvalidAccessToken_shouldReturnUnauthorized() {
        // given
        String accessToken = "invalid_access_token";
        when(wotService.checkAccessToken(accessToken)).thenReturn(false);

        // when
        ResponseEntity<Information> responseEntity = informationController.getInformation(accessToken);

        // then
        verify(wotService, times(1)).checkAccessToken(accessToken);
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
