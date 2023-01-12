package com.mahedi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Image;
    private String bookName;
    private String bookAuthor;
    private String description;
    private String quantity;
    private String price;

    public Library() {
    }

    public Library(long id,String Image, String bookName, String bookAuthor, String description, String quantity, String price) {
        this.id = id;
        this.Image = Image;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", Image='" + Image + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
