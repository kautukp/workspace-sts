/**
 * 
 */
package com.jpademo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author User
 *
 */
@Entity
@Table(name = "CD")
public class CD {

	@Id
	@Column(name = "CD_ID")
	private Integer cdID;

	@Column(name = "CD_TITLE")
	private String title;

	@Column(name = "CD_DESC")
	private String description;

	@Column(name = "CD_COST")
	private Double unitCost;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private Musicians musicians;

	/**
	 * 
	 */
	public CD() {
		super();
	}

	public CD(Integer cdID, String title, String description, Double unitCost, Musicians musicians) {
		super();
		this.cdID = cdID;
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.musicians = musicians;
	}

	/**
	 * @return the cdID
	 */
	public Integer getCdID() {
		return cdID;
	}

	/**
	 * @param cdID the cdID to set
	 */
	public void setCdID(Integer cdID) {
		this.cdID = cdID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the unitCost
	 */
	public Double getUnitCost() {
		return unitCost;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * @return the musicians
	 */
	public Musicians getMusicians() {
		return musicians;
	}

	/**
	 * @param musicians the musicians to set
	 */
	public void setMusicians(Musicians musicians) {
		this.musicians = musicians;
	}

	@Override
	public String toString() {
		return "CD [cdID=" + cdID + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost
				+ ", musicians=" + musicians + "]";
	}

}
