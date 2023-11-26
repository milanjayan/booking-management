package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class City extends BaseModel {
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres = new ArrayList<>();
}
