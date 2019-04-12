
package com.example.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="TBLPRODUCT")
public class productModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long PRODUCT_ID;
	
	
    @Column(name = "PRODUCT_COMPANY")
    private String PRODUCT_COMPANY ;

    @Column(name = "PRODUCT_PRICE")
    private long PRODUCT_PRICE;

    @Column(name = "PRODUCT_NAME")
    private String PRODUCT_NAME;
   
   
	@Column(name="ISACTIVE")
	private String ISACTIVE;
    
    @JsonIgnore
	@JoinColumn(name = "MODIFIED_BY")
	private String MODIFIED_BY;
    
    @JsonIgnore
	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;
    
    @JsonIgnore
	@Column(name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	/**
	 * @return the pRODUCT_ID
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	/**
	 * @param pRODUCT_ID the pRODUCT_ID to set
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	/**
	 * @return the pRODUCT_QUANTRITY
	 */
	public String getPRODUCT_COMPANY() {
		return PRODUCT_COMPANY;
	}

	/**
	 * @param pRODUCT_QUANTRITY the pRODUCT_QUANTRITY to set
	 */
	public void setPRODUCT_COMPANY(String pRODUCT_COMPANY) {
		PRODUCT_COMPANY = pRODUCT_COMPANY;
	}

	/**
	 * @return the pRICE
	 */
	public long getPRICE() {
		return PRODUCT_PRICE;
	}

	/**
	 * @param pRICE the pRICE to set
	 */
	public void setPRICE(long pRICE) {
		PRODUCT_PRICE = pRICE;
	}

	/**
	 * @return the pROCUCT_CODE
	 */
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	/**
	 * @param pROCUCT_CODE the pROCUCT_CODE to set
	 */
	public void setPRODUCT_NAME(String pROCUCT_name) {
		PRODUCT_NAME = pROCUCT_name;
	}

	/**
	 * @return the iSACTIVE
	 */
	public String getISACTIVE() {
		return ISACTIVE;
	}

	/**
	 * @param iSACTIVE the iSACTIVE to set
	 */
	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	/**
	 * @return the mODIFIED_BY
	 */
	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	/**
	 * @param string the mODIFIED_BY to set
	 */
	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	/**
	 * @return the mODIFIED_WHEN
	 */
	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	/**
	 * @param mODIFIED_WHEN the mODIFIED_WHEN to set
	 */
	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	/**
	 * @return the mODIFIED_WORKSTATION
	 */
	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	/**
	 * @param mODIFIED_WORKSTATION the mODIFIED_WORKSTATION to set
	 */
	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}

	

}