package com.immigration.rcs.mvc.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static com.immigration.rcs.utils.Constants.DB_SCHEMA;


@Data
@Entity
@Table(name = "Logs", schema = DB_SCHEMA, indexes = {
        // Composite index for timestamp-based queries (most common case)
        @Index(name = "idx_logs_created_at_desc", columnList = "createdAt DESC"),

        // Composite index for status + timestamp queries
        @Index(name = "idx_logs_status_created_at", columnList = "status, createdAt DESC"),

        // Composite index for source + timestamp queries
        @Index(name = "idx_logs_source_created_at", columnList = "source, createdAt DESC"),

        @Index(name = "idx_logs_source_id_created_at", columnList = "sourceId, createdAt DESC"),

        // Composite index for status + source + timestamp queries
        @Index(name = "idx_logs_status_source_created_at", columnList = "status, source, createdAt DESC"),

        // Composite index for status + source + timestamp queries
        @Index(name = "idx_logs_source_id_source_created_at", columnList = "sourceId, source, createdAt DESC"),

        // Composite index for status + source + timestamp queries
        @Index(name = "idx_logs_source_id_status_created_at", columnList = "sourceId, status, createdAt DESC"),

        @Index(name = "idx_logs_source_id_status_source_created",
                columnList = "sourceId, status, source, createdAt DESC"),

        // Index for sourceId queries (if these are high cardinality)
        @Index(name = "idx_logs_source_id", columnList = "sourceId"),
        // Composite index for sourceId + timestamp queries
})
@Inheritance(strategy = InheritanceType.JOINED) // Can be SINGLE_TABLE or TABLE_PER_CLASS too
public abstract class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sourceId;
    @Convert(converter = SourceConverter.class)
    private Enumerations.Source source;
    @Convert(converter = StatusConverter.class)
    private Enumerations.Status status;
    @CreationTimestamp
    private Timestamp createdAt;
}

