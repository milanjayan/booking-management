package com.scaler.bookingmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class User extends BaseModel {
    private String userName;
    private String password;
}
