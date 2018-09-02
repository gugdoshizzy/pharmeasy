package com.pharmeasy.model.impl;

import java.util.Date;

public class Pharmasict
	extends Person {

	private String degree;
	private Date licenseExpiryDate;
	
	private Pharmasict(PharmasictBuilder pharmasictBuilder) {
		super(pharmasictBuilder);
		this.degree = pharmasictBuilder.degree;
		this.licenseExpiryDate = pharmasictBuilder.licenseExpiryDate;
	}

	public String getDegree() {
		return degree;
	}

	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	@Override
	public String toString() {
		return "Pharmasict [degree=" + degree + ", licenseExpiryDate=" + licenseExpiryDate
				+ ", id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address + "]";
	}

	public static class PharmasictBuilder 
		extends PersonBuilder<PharmasictBuilder> {
		
		private String degree;
		private Date licenseExpiryDate;
		
		public PharmasictBuilder() {
			super();
		}
		
		public PharmasictBuilder(Pharmasict pharmasict) {
			super(pharmasict);
			this.degree = pharmasict.degree;
			this.licenseExpiryDate = pharmasict.licenseExpiryDate;
		}
		
		public PharmasictBuilder addDegree(String degree) {
			this.degree = degree;
			return self();
		}
		
		public PharmasictBuilder addLicenseExpiryDate(Date date) {
			this.licenseExpiryDate = date;
			return self();
		}
		
		protected PharmasictBuilder self() {
			return (PharmasictBuilder) this;
		}
		
		public Pharmasict build() {
			Pharmasict pharmasict = new Pharmasict(this);
			return pharmasict;
		}
	}
}