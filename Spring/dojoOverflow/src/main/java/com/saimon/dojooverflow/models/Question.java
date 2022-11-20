package com.saimon.dojooverflow.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String questionText;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	 private List<Answer> answers;
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		name = "tags_questions",
		joinColumns = @JoinColumn(name = "question_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	 private List<Tag> tags = new ArrayList<>();
	 
	 public Question() {
	 }

	public Question(String questionText, List<Answer> answers, List<Tag> tags) {
		this.questionText = questionText;
		this.answers = answers;
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public void setAnswer(Answer answer) {
		this.answers.add(answer);
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(Tag tags) {
		this.tags.add(tags);
	}
	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}