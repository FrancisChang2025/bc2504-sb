package com.bootcamp.demo.bc_forum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// PK, FK, column definition (VARCHAR(100), NUMERIC(10,2))
// service call comments 

@AllArgsConstructor
@Getter
@Entity
@Table(name = "comments")
@Builder
@NoArgsConstructor
public class CommentEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  @Column(length = 500)
  private String body;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private PostEntity postEntity;
}