package com.example.attendanceandfacultymanagement.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassSchedule 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String dayOfWeek;
	    private LocalTime endTime;
	    private LocalTime startTime;
	    
	    @ManyToOne
	    @JoinColumn(name="classroom_id")
	    private Classroom classroom;
	    
	    @ManyToOne
	    @JoinColumn(name="subject_id")
	    private Subject subject;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDayOfWeek() {
			return dayOfWeek;
		}

		public void setDayOfWeek(String dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}

		public LocalTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalTime endTime) {
			this.endTime = endTime;
		}

		public LocalTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalTime startTime) {
			this.startTime = startTime;
		}

		public Classroom getClassroom() {
			return classroom;
		}

		public void setClassroom(Classroom classroom) {
			this.classroom = classroom;
		}

		public Subject getSubject() {
			return subject;
		}

		public void setSubject(Subject subject) {
			this.subject = subject;
		}

		@Override
		public String toString() {
			return "ClassSchedule [id=" + id + ", dayOfWeek=" + dayOfWeek + ", endTime=" + endTime + ", startTime="
					+ startTime + ", classroom=" + classroom + ", subject=" + subject + "]";
		}
	    
	    
}
