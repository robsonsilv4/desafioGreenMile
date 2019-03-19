package com.robson.desafiogreenmile.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WorkedHours implements Serializable {

  private static final long serialVersionUID = -192174945664887574L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Column(unique = true, nullable = false)
  private LocalDate date;

  @Column(nullable = false)
  @JsonFormat(pattern = "HH:mm")
  private LocalTime initialTime;

  @Column(nullable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
  private LocalTime finalTime;

  private Long workedHours;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;
}
