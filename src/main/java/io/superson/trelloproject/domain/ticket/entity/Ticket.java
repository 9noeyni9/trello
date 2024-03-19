package io.superson.trelloproject.domain.ticket.entity;

import io.superson.trelloproject.domain.common.entity.Timestamped;
import io.superson.trelloproject.global.util.Color;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import io.superson.trelloproject.domain.board.entity.Board;
import io.superson.trelloproject.domain.common.entity.Timestamped;
import io.superson.trelloproject.domain.status.entity.Status;
import io.superson.trelloproject.global.util.Color;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tb_ticket")
public class Ticket extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(nullable = false)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Color color;
    private String description;
    private LocalDateTime deadline;

    @OneToMany(mappedBy = "ticket", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Assignee> assignees = new ArrayList<>();

    @Column
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(nullable = false)
    private String description;

    @Column
    private Timestamp deadline;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "ticket", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Assignee> assignees = new ArrayList<>();
}
