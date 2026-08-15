package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The option selected by the user for an attempted question
 * (Doc 3 / Hands-on 3). ao_selected indicates whether the user picked it.
 */
@Entity
@Table(name = "attempt_option")
public class AttemptOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Options option;

    @Column(name = "ao_selected")
    private boolean selected;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Options getOption() { return option; }
    public void setOption(Options option) { this.option = option; }

    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }
}
