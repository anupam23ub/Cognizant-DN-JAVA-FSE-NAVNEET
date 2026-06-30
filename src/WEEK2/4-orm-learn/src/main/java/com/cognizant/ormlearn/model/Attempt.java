package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

/**
 * Quiz attempt by a user (Doc 3 / Hands-on 3). One attempt has many
 * attempt_question rows.
 */
@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private QuizUser user;

    @Column(name = "at_date")
    private Date date;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "aq_at_id")
    private List<AttemptQuestion> attemptQuestions;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public QuizUser getUser() { return user; }
    public void setUser(QuizUser user) { this.user = user; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public List<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setAttemptQuestions(List<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }

    @Override
    public String toString() {
        return "Attempt [id=" + id + ", user=" + user + ", date=" + date + "]";
    }
}
