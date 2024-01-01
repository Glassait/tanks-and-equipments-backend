package com.glassait.equipment_tanks.tasks;

import com.glassait.equipment_tanks.services.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateMemberDBTest {
    @Mock
    private MemberService memberService;

    private UpdateMemberDB updateMemberDB;

    @BeforeEach
    void setUp() {
        updateMemberDB = new UpdateMemberDB(memberService);
    }

    @Test
    void updateMemberInDatabase() {
        updateMemberDB.updateMemberInDatabase();

        verify(memberService, times(1)).updateMembers();
    }
}