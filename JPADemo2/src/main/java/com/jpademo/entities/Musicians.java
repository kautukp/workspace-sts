/**
 * 
 */
package com.jpademo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "MUSICIANS")
public class Musicians {

	@Id
	@Column(name = "MUSICIAN_ID")
	private Integer musicianID;

	@Column(name = "MUSICIAN_NAME")
	private String name;

	/**
	 * 
	 */
	public Musicians() {
		super();
	}

	public Musicians(Integer musicianID, String name) {
		super();
		this.musicianID = musicianID;
		this.name = name;
	}

	public Integer getMusicianID() {
		return musicianID;
	}

	public void setMusicianID(Integer musicianID) {
		this.musicianID = musicianID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Musicians [musicianID=" + musicianID + ", name=" + name + "]";
	}

}
