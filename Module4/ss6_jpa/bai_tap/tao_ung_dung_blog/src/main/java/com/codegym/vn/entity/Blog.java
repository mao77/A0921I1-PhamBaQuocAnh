package com.codegym.vn.entity;

import javax.persistence.*;

@Entity
public class Blog {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "book_id")
   private long id;
   @Column(name = "book_name")
   private String name;
   @Column(name = "book_content")
   private String content;
   @Column(name = "book_author")
   private String author;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;

   public Blog() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }
}
