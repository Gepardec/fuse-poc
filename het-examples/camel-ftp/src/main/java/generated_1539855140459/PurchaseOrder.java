
package generated_1539855140459;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Ellen Adams"/>
 *                         &lt;enumeration value="Tai Yee"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Street">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="123 Maple Street"/>
 *                         &lt;enumeration value="8 Oak Avenue"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="City">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Mill Valley"/>
 *                         &lt;enumeration value="Old Town"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="State">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="CA"/>
 *                         &lt;enumeration value="PA"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Zip">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="10999"/>
 *                         &lt;enumeration value="95819"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DeliveryNotes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Items">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ProductName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Lawnmower"/>
 *                                   &lt;enumeration value="Baby Monitor"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Quantity">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;enumeration value="1"/>
 *                                   &lt;enumeration value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="USPrice">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *                                   &lt;enumeration value="148.95"/>
 *                                   &lt;enumeration value="39.98"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ShipDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="PartNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="PurchaseOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "address",
    "deliveryNotes",
    "items"
})
@XmlRootElement(name = "PurchaseOrder")
public class PurchaseOrder {

    @XmlElement(name = "Address")
    protected List<PurchaseOrder.Address> address;
    @XmlElement(name = "DeliveryNotes", required = true)
    protected String deliveryNotes;
    @XmlElement(name = "Items", required = true)
    protected PurchaseOrder.Items items;
    @XmlAttribute(name = "PurchaseOrderNumber")
    protected String purchaseOrderNumber;
    @XmlAttribute(name = "OrderDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderDate;

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PurchaseOrder.Address }
     * 
     * 
     */
    public List<PurchaseOrder.Address> getAddress() {
        if (address == null) {
            address = new ArrayList<PurchaseOrder.Address>();
        }
        return this.address;
    }

    /**
     * Gets the value of the deliveryNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    /**
     * Sets the value of the deliveryNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryNotes(String value) {
        this.deliveryNotes = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrder.Items }
     *     
     */
    public PurchaseOrder.Items getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrder.Items }
     *     
     */
    public void setItems(PurchaseOrder.Items value) {
        this.items = value;
    }

    /**
     * Gets the value of the purchaseOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    /**
     * Sets the value of the purchaseOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseOrderNumber(String value) {
        this.purchaseOrderNumber = value;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

    public void setAddress(List<PurchaseOrder.Address> address) {
        this.address = address;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Name">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Ellen Adams"/>
     *               &lt;enumeration value="Tai Yee"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Street">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="123 Maple Street"/>
     *               &lt;enumeration value="8 Oak Avenue"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="City">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Mill Valley"/>
     *               &lt;enumeration value="Old Town"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="State">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="CA"/>
     *               &lt;enumeration value="PA"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Zip">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="10999"/>
     *               &lt;enumeration value="95819"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "street",
        "city",
        "state",
        "zip",
        "country"
    })
    public static class Address {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Street", required = true)
        protected String street;
        @XmlElement(name = "City", required = true)
        protected String city;
        @XmlElement(name = "State", required = true)
        protected String state;
        @XmlElement(name = "Zip", required = true)
        protected String zip;
        @XmlElement(name = "Country", required = true)
        protected String country;
        @XmlAttribute(name = "Type")
        protected String type;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the street property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStreet() {
            return street;
        }

        /**
         * Sets the value of the street property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStreet(String value) {
            this.street = value;
        }

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCity() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCity(String value) {
            this.city = value;
        }

        /**
         * Gets the value of the state property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setState(String value) {
            this.state = value;
        }

        /**
         * Gets the value of the zip property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZip() {
            return zip;
        }

        /**
         * Sets the value of the zip property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZip(String value) {
            this.zip = value;
        }

        /**
         * Gets the value of the country property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountry(String value) {
            this.country = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ProductName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Lawnmower"/>
     *                         &lt;enumeration value="Baby Monitor"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Quantity">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                         &lt;enumeration value="1"/>
     *                         &lt;enumeration value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="USPrice">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
     *                         &lt;enumeration value="148.95"/>
     *                         &lt;enumeration value="39.98"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ShipDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="PartNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class Items {

        @XmlElement(name = "Item")
        protected List<PurchaseOrder.Items.Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PurchaseOrder.Items.Item }
         * 
         * 
         */
        public List<PurchaseOrder.Items.Item> getItem() {
            if (item == null) {
                item = new ArrayList<PurchaseOrder.Items.Item>();
            }
            return this.item;
        }

        public void setItem(List<PurchaseOrder.Items.Item> item) {
            this.item = item;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="ProductName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Lawnmower"/>
         *               &lt;enumeration value="Baby Monitor"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Quantity">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
         *               &lt;enumeration value="1"/>
         *               &lt;enumeration value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="USPrice">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
         *               &lt;enumeration value="148.95"/>
         *               &lt;enumeration value="39.98"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ShipDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="PartNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "productName",
            "quantity",
            "usPrice",
            "comment",
            "shipDate"
        })
        public static class Item {

            @XmlElement(name = "ProductName", required = true)
            protected String productName;
            @XmlElement(name = "Quantity")
            protected byte quantity;
            @XmlElement(name = "USPrice")
            protected float usPrice;
            @XmlElement(name = "Comment")
            protected String comment;
            @XmlElement(name = "ShipDate")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar shipDate;
            @XmlAttribute(name = "PartNumber")
            protected String partNumber;

            /**
             * Gets the value of the productName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProductName() {
                return productName;
            }

            /**
             * Sets the value of the productName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProductName(String value) {
                this.productName = value;
            }

            /**
             * Gets the value of the quantity property.
             * 
             */
            public byte getQuantity() {
                return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             */
            public void setQuantity(byte value) {
                this.quantity = value;
            }

            /**
             * Gets the value of the usPrice property.
             * 
             */
            public float getUSPrice() {
                return usPrice;
            }

            /**
             * Sets the value of the usPrice property.
             * 
             */
            public void setUSPrice(float value) {
                this.usPrice = value;
            }

            /**
             * Gets the value of the comment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getComment() {
                return comment;
            }

            /**
             * Sets the value of the comment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setComment(String value) {
                this.comment = value;
            }

            /**
             * Gets the value of the shipDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getShipDate() {
                return shipDate;
            }

            /**
             * Sets the value of the shipDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setShipDate(XMLGregorianCalendar value) {
                this.shipDate = value;
            }

            /**
             * Gets the value of the partNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPartNumber() {
                return partNumber;
            }

            /**
             * Sets the value of the partNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPartNumber(String value) {
                this.partNumber = value;
            }

        }

    }

}
