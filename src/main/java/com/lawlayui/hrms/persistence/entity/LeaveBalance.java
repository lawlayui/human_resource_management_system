package com.lawlayui.hrms.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leave_balances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private Integer year;

    @Builder.Default
    @Column(name = "total_quota")
    private Integer totalQuota = 12;

    @Builder.Default
    @Column(name = "used_quota")
    private Integer usedQuota = 0;
}
