package cnu.moksoriro.domain.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member")
    private String memberName;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @Builder
    public Member(String memberId, String memberName, String password, Collection<Role> roles){
        this.memberId = memberId;
        this.memberName = memberName;
        this.password = password;
        this.roles = roles;
    }
}
