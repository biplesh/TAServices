package org.japit.comp.labour.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="product_key")

public class ProductKeyModel implements Serializable {
	


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CustomSeq")
	@GenericGenerator(name = "CustomSeq",
    strategy = "org.japit.comp.labour.utility.TableNameSequenceGenerator",
    parameters = {
			@Parameter(name = "sequence", value = "product_key_id_seq")
    })
	@Column(name="id")
	private int id;

	@Column(name="product_key")
	private String key;

	@Column(name="used_st")
	private int used_st;

	@Column(name="activation_date")
	private Date activation_date;

}
