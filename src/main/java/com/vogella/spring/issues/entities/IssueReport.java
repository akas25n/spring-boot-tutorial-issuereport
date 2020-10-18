package com.vogella.spring.issues.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "issues")
public class IssueReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String url;
    private String description;
    private boolean markedAsPrivate;
    private boolean updates;
    private boolean done;
    private Date created;
    private Date updated;
}
