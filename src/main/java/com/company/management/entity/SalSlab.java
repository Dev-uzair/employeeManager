package com.company.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salaryslab")
public class SalSlab {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slab_id")
	private Integer slabId;
	@Column(name = "HRA")
	private int HRA;
	@Column(name = "DA")
	private int DA;
	@Column(name = "TA")
	private int TA;
	@Column(name = "PF")
	private int PF;

	public SalSlab() {

	}

	public SalSlab(int slabId, int hRA, int dA, int tA, int pF) {
		super();
		this.slabId = slabId;
		HRA = hRA;
		DA = dA;
		TA = tA;
		PF = pF;
	}

}
