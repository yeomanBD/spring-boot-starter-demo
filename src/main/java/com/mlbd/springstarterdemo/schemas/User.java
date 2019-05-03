package com.mlbd.springstarterdemo.schemas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import com.mlbd.springstarterdemo.commons.enums.Label;

import lombok.Data;

@Entity
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 2523844132897482398L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String name;

	@NotBlank
	private String designation;

	private Label label;

	@Nullable
	private String systemName;
}
