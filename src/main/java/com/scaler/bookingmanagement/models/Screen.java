package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "screens")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Screen extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonBackReference
    private Theatre theatre;
    private String number;
    @OneToMany(mappedBy = "screen")
    @JsonManagedReference
    private List<Seat> seats;
}
