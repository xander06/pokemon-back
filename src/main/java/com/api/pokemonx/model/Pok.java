package com.api.pokemonx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "pokemon")
@EntityListeners(AuditingEntityListener.class)
public class Pok {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "pokemon_name")
	private String name;
	@Column(name = "pokemon_peso")
	private String pok_peso;
	@Column(name = "pokemon_altura")
	private String pok_altura;
	@Column(name = "descripcion")
	private String desc;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_categoria")
	private Categoria categoria;
	
	@Column(name="logo")
	private String logo;
	
	public Pok () {}
	
	
	public Pok(Long id, String name, String pok_peso, String pok_altura, String desc, Categoria categoria, String logo) {
		this.id = id;
		this.name = name;
		this.pok_peso = pok_peso;
		this.pok_altura = pok_altura;
		this.desc = desc;
		this.categoria = categoria;
		this.logo =logo;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getPok_peso() {
		return pok_peso;
	}
	public void setPok_peso(String pok_peso) {
		this.pok_peso = pok_peso;
	}
	public String getPok_altura() {
		return pok_altura;
	}
	public void setPok_altura(String pok_altura) {
		this.pok_altura = pok_altura;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Pok [id=" + id + ", name=" + name + ", pok_peso=" + pok_peso + ", pok_altura=" + pok_altura + ", desc="
				+ desc + ", categoria=]";
	}
		
	
}
