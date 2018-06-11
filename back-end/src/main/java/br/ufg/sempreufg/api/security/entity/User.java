package br.ufg.sempreufg.api.security.entity;

import br.ufg.sempreufg.api.security.enums.ProfileEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "public")
public class User extends AbstractPersistable<Long> {

	@Id
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name="email" ,unique = true)
	@NotBlank(message = "Email requerido")
	@Email(message = "Email invalido")
	private String email;

	@Column(name = "password")
	@NotBlank(message = "Senha requerida")
	@Size(min = 6)
	private String password;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	private ProfileEnum profile;

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	public User() {
		this(null);
	}

	public User(Long id) {
		this.setId(id);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
