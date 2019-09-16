/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.annotations.Indexes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author joão.furtado
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIOS")
@Indexes({
    @Index(name = "IDX_TBUSUARIOS_USUARIOS_SENHA", columnNames = {"USUARIOS", "SENHA"})
})
@NamedQueries({
    @NamedQuery(name = "users.findByLogin", query = "FROM Users AS us WHERE us.login = :login AND us.password = :password")
})
@SequenceGenerator(name = "SEQ_TB_USUARIOS", initialValue = 1, allocationSize = 1)
public class Users implements UserDetails {

    private static final long serialVersionUID = -1742365351012379868L;

    @Id
    @GeneratedValue(generator = "SEQ_TB_USUARIOS", strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private Long id;
    @Setter
    @Column(name = "USUARIOS", length = 40)
    private String login;
    @Setter
    @Column(name = "SENHA", length = 40)
    private String password;
    @Setter
    @Getter
    @Column(name = "PERM", length = 1)
    private String perm;
    @Setter
    @Transient
    private List<GrantedAuthority> authority;

    public Users(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
