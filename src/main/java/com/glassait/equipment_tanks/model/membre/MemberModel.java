package com.glassait.equipment_tanks.model.membre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "membres")
public class MemberModel {
    @Id
    @Column(name = "account_id", nullable = false, unique = true, updatable = false)
    private int accountId;

    @Column(name = "role")
    private String role;
}
