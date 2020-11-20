package com.byx.domain;

public class Book
{
    private int id;
    private int categoryId;
    private String name;
    private String author;
    private String description;
    private String updateTime;
    private int wordCount;
    private int likeCount;
    private int dislikeCount;
    private int heat;
    private double score;

    public Book() {}

    public Book(int id, int categoryId, String name, String author, String description, String updateTime, int wordCount, int likeCount, int dislikeCount)
    {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.updateTime = updateTime;
        this.wordCount = wordCount;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    public int getWordCount()
    {
        return wordCount;
    }

    public void setWordCount(int wordCount)
    {
        this.wordCount = wordCount;
    }

    public int getLikeCount()
    {
        return likeCount;
    }

    public void setLikeCount(int likeCount)
    {
        this.likeCount = likeCount;
    }

    public int getDislikeCount()
    {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount)
    {
        this.dislikeCount = dislikeCount;
    }

    public int getHeat()
    {
        return heat;
    }

    public void setHeat(int heat)
    {
        this.heat = heat;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }
}
