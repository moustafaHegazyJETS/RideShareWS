/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ridesharingprows;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TECHNOLOGY CITY
 */
@Entity
@Table(name = "driver_car_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DriverCarInfo.findAll", query = "SELECT d FROM DriverCarInfo d")
    , @NamedQuery(name = "DriverCarInfo.findByDriveCarID", query = "SELECT d FROM DriverCarInfo d WHERE d.driveCarID = :driveCarID")
    , @NamedQuery(name = "DriverCarInfo.findByOwnername", query = "SELECT d FROM DriverCarInfo d WHERE d.ownername = :ownername")
    , @NamedQuery(name = "DriverCarInfo.findByDriverLicenseNum", query = "SELECT d FROM DriverCarInfo d WHERE d.driverLicenseNum = :driverLicenseNum")
    , @NamedQuery(name = "DriverCarInfo.findByOwnerAddress", query = "SELECT d FROM DriverCarInfo d WHERE d.ownerAddress = :ownerAddress")
    , @NamedQuery(name = "DriverCarInfo.findByLicenseEndDate", query = "SELECT d FROM DriverCarInfo d WHERE d.licenseEndDate = :licenseEndDate")
    , @NamedQuery(name = "DriverCarInfo.findByCarBrand", query = "SELECT d FROM DriverCarInfo d WHERE d.carBrand = :carBrand")
    , @NamedQuery(name = "DriverCarInfo.findByCarModel", query = "SELECT d FROM DriverCarInfo d WHERE d.carModel = :carModel")
    , @NamedQuery(name = "DriverCarInfo.findByCarYear", query = "SELECT d FROM DriverCarInfo d WHERE d.carYear = :carYear")
    , @NamedQuery(name = "DriverCarInfo.findByCarCC", query = "SELECT d FROM DriverCarInfo d WHERE d.carCC = :carCC")
    , @NamedQuery(name = "DriverCarInfo.findByCarColor", query = "SELECT d FROM DriverCarInfo d WHERE d.carColor = :carColor")
    , @NamedQuery(name = "DriverCarInfo.findByNationalidPhoto", query = "SELECT d FROM DriverCarInfo d WHERE d.nationalidPhoto = :nationalidPhoto")
    , @NamedQuery(name = "DriverCarInfo.findByLicenseIdPhoto", query = "SELECT d FROM DriverCarInfo d WHERE d.licenseIdPhoto = :licenseIdPhoto")
    , @NamedQuery(name = "DriverCarInfo.findByStatus", query = "SELECT d FROM DriverCarInfo d WHERE d.status = :status")})
public class DriverCarInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "driveCarID")
    private Integer driveCarID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Owner_name")
    private String ownername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "driver_license_num")
    private String driverLicenseNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Owner_Address")
    private String ownerAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "license_EndDate")
    @Temporal(TemporalType.DATE)
    private Date licenseEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Car_Brand")
    private String carBrand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "car_Model")
    private String carModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Car_Year")
    private int carYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Car_CC")
    private int carCC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Car_Color")
    private String carColor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "National_id_Photo")
    private String nationalidPhoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "license_id_photo")
    private String licenseIdPhoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "UserId", referencedColumnName = "idUser")
    @OneToOne(optional = false)
    private User userId;

    public DriverCarInfo() {
    }

    public DriverCarInfo(Integer driveCarID) {
        this.driveCarID = driveCarID;
    }

    public DriverCarInfo(Integer driveCarID, String ownername, String driverLicenseNum, String ownerAddress, Date licenseEndDate, String carBrand, String carModel, int carYear, int carCC, String carColor, String nationalidPhoto, String licenseIdPhoto, String status) {
        this.driveCarID = driveCarID;
        this.ownername = ownername;
        this.driverLicenseNum = driverLicenseNum;
        this.ownerAddress = ownerAddress;
        this.licenseEndDate = licenseEndDate;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carCC = carCC;
        this.carColor = carColor;
        this.nationalidPhoto = nationalidPhoto;
        this.licenseIdPhoto = licenseIdPhoto;
        this.status = status;
    }

    public Integer getDriveCarID() {
        return driveCarID;
    }

    public void setDriveCarID(Integer driveCarID) {
        this.driveCarID = driveCarID;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getDriverLicenseNum() {
        return driverLicenseNum;
    }

    public void setDriverLicenseNum(String driverLicenseNum) {
        this.driverLicenseNum = driverLicenseNum;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public Date getLicenseEndDate() {
        return licenseEndDate;
    }

    public void setLicenseEndDate(Date licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public int getCarCC() {
        return carCC;
    }

    public void setCarCC(int carCC) {
        this.carCC = carCC;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getNationalidPhoto() {
        return nationalidPhoto;
    }

    public void setNationalidPhoto(String nationalidPhoto) {
        this.nationalidPhoto = nationalidPhoto;
    }

    public String getLicenseIdPhoto() {
        return licenseIdPhoto;
    }

    public void setLicenseIdPhoto(String licenseIdPhoto) {
        this.licenseIdPhoto = licenseIdPhoto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driveCarID != null ? driveCarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriverCarInfo)) {
            return false;
        }
        DriverCarInfo other = (DriverCarInfo) object;
        if ((this.driveCarID == null && other.driveCarID != null) || (this.driveCarID != null && !this.driveCarID.equals(other.driveCarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.DriverCarInfo[ driveCarID=" + driveCarID + " ]";
    }
    
}