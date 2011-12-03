package db;

import java.util.*;

public class Task extends DbObject {
    protected String name;
    protected String description;
    protected User assignee;
    protected TaskStatus status;
    protected Date deadline;
    protected TaskKind kind;
    protected Date createdAt;
    protected Date updatedAt;
    protected List<TimeEntry> timeEntries;
    protected List<Comment<Task>> comments;
    protected List<Attachment<Task>> attachments;
    protected int estimatedTime;
    protected Project project;
    protected Milestone milestone;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
        // this.project.addTask(this);
    }

    public Milestone getMilestone(){
        return this.milestone;
    }

    public Boolean hasMilestone(){
        return (this.milestone != null);
    }

    public void setMilestone(Milestone milestone){
        if(this.milestone != milestone){
            if(this.milestone != null){
                this.milestone.removeTask(this);
                this.milestone.save();
            }
            this.milestone = milestone;
            this.save();
            if(this.milestone != null){
                this.milestone.addTask(this);
                this.milestone.save();
            }
        }
    }

    public Task(){
        super();
    }

    public Task(int id){
        this();
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskKind getKind() {
        return kind;
    }

    public void setKind(TaskKind kind) {
        this.kind = kind;
    }

    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    public void setTimeEntries(List<TimeEntry> timeEntries) {
        this.timeEntries = timeEntries;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }


    public static Collection<Task> all(){
        return Database.odb.getObjects(Task.class);
    }
}
