package com.learning.project2.web.test.models.history;


import com.learning.project2.web.test.models.Test;
import com.learning.project2.web.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Table(name="p2_test_history")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date_taken")
    private Instant dateTaken;

    @OneToMany
    @JoinColumn(name = "test_history_id", nullable = false)
    private List<TestHistoryAnswerGiven> answers;


}
