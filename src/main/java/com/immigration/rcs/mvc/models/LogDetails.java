package com.immigration.rcs.mvc.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static com.immigration.rcs.utils.Constants.DB_SCHEMA;


@Getter
@Setter
@Entity
@Table(schema = DB_SCHEMA)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Can be SINGLE_TABLE or TABLE_PER_CLASS too
public abstract class LogDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String payload;

    @Column(columnDefinition = "TEXT")
    private String description;
}