package br.com.fiap.hybridflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_workstation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code; // e.g., "A-101"

    private boolean hasMonitor;

    private boolean isSilentZone;
}
