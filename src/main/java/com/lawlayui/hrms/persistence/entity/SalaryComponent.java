package com.lawlayui.hrms.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "salary_components")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SalaryComponentType type;

    @Builder.Default
    @Column(name = "is_percentage")
    private Boolean isPercentage = false;

    @Builder.Default
    @Column(name = "default_value", precision = 12, scale = 2)
    private BigDecimal defaultValue = BigDecimal.ZERO;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "salaryComponent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeSalary> employeeSalaries;
}
