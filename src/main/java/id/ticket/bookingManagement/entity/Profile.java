package id.ticket.bookingManagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import id.ticket.bookingManagement.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_profile")
@EqualsAndHashCode(callSuper = true)
@Data
public class Profile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String fullname;

    @Column(unique = true)
    private String username;

    private String photoProfile;

    private String description;

    @JsonIgnore
    private String verifyToken;

    @JsonIgnore
    private Date expiredVerifyToken;

    @JsonIgnore
    private Integer chance;

    private Boolean verify;

    private Integer totalOrder ;

    private String phoneNumber;
}
