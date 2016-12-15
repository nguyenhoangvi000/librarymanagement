package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by MyPC on 14/12/2016.
 */
@Entity
@Table(name="callcard")
public class CallCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long callID;

    private Date dateCreate;

    private Date dateEnd;


    public Long getCallID() {
        return callID;
    }

    public void setCallID(Long callID) {
        this.callID = callID;
    }

}
