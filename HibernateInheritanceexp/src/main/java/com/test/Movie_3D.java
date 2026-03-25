package com.test;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="3D_MOVIE")
//@DiscriminatorValue("3D_MOVIE")
public class Movie_3D extends Movie{
private String director;

public String getDirector() {
	return director;
}

public void setDirector(String director) {
	this.director = director;
}
}
